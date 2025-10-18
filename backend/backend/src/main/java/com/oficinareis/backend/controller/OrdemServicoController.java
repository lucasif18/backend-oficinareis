@PutMa // ARQUIVO: OrdemServicoController.java (CRUD COMPLETO)
package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.ItemOrdemServico;
import com.oficinareis.backend.model.OrdemServico;
import com.oficinareis.backend.model.Status;
import com.oficinareis.backend.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ordens")
@CrossOrigin(origins = "*")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    // GET: Listar todas
    @GetMapping
    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.findAll();
    }

    // NOVO: GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable Long id) {
        return ordemServicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Abrir nova OS (Lógica de cálculo já existente)
    @PostMapping
    public ResponseEntity<OrdemServico> abrirOS(@RequestBody OrdemServico os) {
        double totalPecas = 0.0;
        if (os.getItens() != null) {
            for (ItemOrdemServico item : os.getItens()) {
                item.setOrdemServico(os);
                totalPecas += item.getQuantidade() * item.getPrecoUnitarioVenda();
            }
        }
        double valorMaoDeObra = os.getValorMaoDeObra() != null ? os.getValorMaoDeObra() : 0.0;
        os.setValorTotal(totalPecas + valorMaoDeObra);
        OrdemServico novaOs = ordemServicoRepository.save(os);
        return ResponseEntity.ok(novaOs);
    }

    // NOVO: PUT - Atualizar Status da OS (Exemplo de PUT simplificado)
    @PutMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return ordemServicoRepository.findById(id)
                .map(os -> {
                    try {
                        Status status = Status.valueOf(novoStatus.toUpperCase());
                        os.setStatus(status);

                        // Ajustando a data de fechamento
                        if (status == Status.FINALIZADA || status == Status.CANCELADA) {
                            os.setDataFechamento(LocalDateTime.now());
                        } else {
                            os.setDataFechamento(null);
                        }

                        return ResponseEntity.ok(ordemServicoRepository.save(os));
                    } catch (IllegalArgumentException e) {
                        // Se o status enviado no corpo for inválido
                        // Retornamos um erro 400 Bad Request
                        return ResponseEntity.badRequest()
                                .body("Status inválido. Use ABERTA, EM_ANDAMENTO, FINALIZADA ou CANCELADA.");
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // NOVO: DELETE: Excluir OS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOS(@PathVariable Long id) {
        if (!ordemServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ordemServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}