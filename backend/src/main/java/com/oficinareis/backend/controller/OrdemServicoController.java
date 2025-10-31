package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.OrdemServico;
import com.oficinareis.backend.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens-servico")
@CrossOrigin(origins = "*") // Permite acesso de aplicações front-end
public class OrdemServicoController {

    // APENAS injetamos o Service, que contém a lógica de negócio.
    private final OrdemServicoService ordemServicoService;

    @Autowired
    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    // Endpoint para criar uma nova OrdemServico
    // O Service (método save) é responsável por calcular o total, definir data/status inicial e setar a relação do item.
    @PostMapping
    public ResponseEntity<OrdemServico> createOrdemServico(@RequestBody OrdemServico ordemServico) {
        OrdemServico savedOrdemServico = ordemServicoService.save(ordemServico);
        return new ResponseEntity<>(savedOrdemServico, HttpStatus.CREATED);
    }

    // Endpoint para buscar todas as Ordens de Serviço
    @GetMapping
    public ResponseEntity<List<OrdemServico>> getAllOrdensServico() {
        List<OrdemServico> ordens = ordemServicoService.findAll();
        return ResponseEntity.ok(ordens);
    }

    // Endpoint para buscar uma Ordem de Serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> getOrdemServicoById(@PathVariable Long id) {
        Optional<OrdemServico> ordem = ordemServicoService.findById(id);

        return ordem.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar uma Ordem de Serviço existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> updateOrdemServico(@PathVariable Long id, @RequestBody OrdemServico ordemDetails) {
        return ordemServicoService.findById(id)
                .map(ordemExistente -> {
                    // Copia os dados relevantes do corpo da requisição para a entidade existente
                    ordemExistente.setCliente(ordemDetails.getCliente());
                    ordemExistente.setVeiculo(ordemDetails.getVeiculo());
                    ordemExistente.setObservacoes(ordemDetails.getObservacoes());
                    ordemExistente.setValorMaoDeObra(ordemDetails.getValorMaoDeObra());
                    ordemExistente.setItens(ordemDetails.getItens()); // Atualiza os itens
                    
                    // O Service (no método save) fará o recalculo e validações necessárias.
                    OrdemServico updatedOrdemServico = ordemServicoService.save(ordemExistente);
                    return ResponseEntity.ok(updatedOrdemServico);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // ENDPOINT EXCLUSIVO: Atualizar Status da OS
    @PutMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        try {
            // Delega a lógica de status e data de fechamento para o Service
            Optional<OrdemServico> os = ordemServicoService.atualizarStatus(id, novoStatus.trim().replaceAll("\"", ""));
            
            return os.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            // Captura a exceção lançada no Service se o status for inválido
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // Endpoint para deletar uma Ordem de Serviço por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdemServico(@PathVariable Long id) {
        if (ordemServicoService.findById(id).isPresent()) {
            ordemServicoService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}