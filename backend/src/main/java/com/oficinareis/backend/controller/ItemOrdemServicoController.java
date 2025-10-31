package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.ItemOrdemServico;
import com.oficinareis.backend.service.IItemOrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-ordem-servico")
public class ItemOrdemServicoController {

    // Injeção da dependência da Interface do Serviço (Boa Prática!)
    private final IItemOrdemServicoService itemOrdemServicoService;

    @Autowired
    public ItemOrdemServicoController(IItemOrdemServicoService itemOrdemServicoService) {
        this.itemOrdemServicoService = itemOrdemServicoService;
    }

    // Endpoint para criar um novo ItemOrdemServico
    @PostMapping
    public ResponseEntity<ItemOrdemServico> createItemOrdemServico(@RequestBody ItemOrdemServico itemOrdemServico) {
        // Observação: Lógica de verificação de estoque geralmente ficaria aqui
        ItemOrdemServico savedItem = itemOrdemServicoService.save(itemOrdemServico);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os ItensOrdemServico
    @GetMapping
    public ResponseEntity<List<ItemOrdemServico>> getAllItensOrdemServico() {
        List<ItemOrdemServico> itens = itemOrdemServicoService.findAll();
        return ResponseEntity.ok(itens);
    }

    // Endpoint para buscar um ItemOrdemServico por ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemOrdemServico> getItemOrdemServicoById(@PathVariable Long id) {
        Optional<ItemOrdemServico> item = itemOrdemServicoService.findById(id);
        
        return item.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar um ItemOrdemServico existente
    @PutMapping("/{id}")
    public ResponseEntity<ItemOrdemServico> updateItemOrdemServico(@PathVariable Long id, @RequestBody ItemOrdemServico itemDetails) {
        return itemOrdemServicoService.findById(id)
                .map(itemExistente -> {
                    // Atualiza os campos relevantes.
                    // Em uma aplicação real, você deve gerenciar cuidadosamente
                    // a atualização de relacionamentos (ordemServico e peca)
                    itemExistente.setQuantidade(itemDetails.getQuantidade());
                    itemExistente.setPrecoUnitarioVenda(itemDetails.getPrecoUnitarioVenda());
                    
                    // Nota: Assume-se que ordemServico e peca já foram carregados pelo JPA
                    // e não estão sendo alterados neste momento.

                    ItemOrdemServico updatedItem = itemOrdemServicoService.save(itemExistente);
                    return ResponseEntity.ok(updatedItem);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um ItemOrdemServico por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemOrdemServico(@PathVariable Long id) {
        if (itemOrdemServicoService.findById(id).isPresent()) {
            itemOrdemServicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
