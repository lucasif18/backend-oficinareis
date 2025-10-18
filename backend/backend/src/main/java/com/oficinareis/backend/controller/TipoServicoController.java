// TipoServicoController.java
package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.TipoServico;
import com.oficinareis.backend.repository.TipoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tipos-servico")
@CrossOrigin(origins = "*")
public class TipoServicoController {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    // GET /tipos-servico
    @GetMapping
    public List<TipoServico> listarTodos() {
        return tipoServicoRepository.findAll();
    }

    // POST /tipos-servico
    @PostMapping
    public ResponseEntity<TipoServico> criarTipoServico(@RequestBody TipoServico tipo) {
        TipoServico novoTipo = tipoServicoRepository.save(tipo);
        return ResponseEntity.ok(novoTipo);
    }

    // PUT: Atualizar Tipo de Serviço por ID
    @PutMapping("/{id}")
    public ResponseEntity<TipoServico> atualizarTipoServico(@PathVariable Long id, @RequestBody TipoServico novoTipo) {
        return tipoServicoRepository.findById(id)
                .map(tipo -> {
                    tipo.setNome(novoTipo.getNome());
                    return ResponseEntity.ok(tipoServicoRepository.save(tipo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Excluir Tipo de Serviço por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoServico(@PathVariable Long id) {
        if (!tipoServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}