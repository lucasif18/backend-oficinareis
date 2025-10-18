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
}