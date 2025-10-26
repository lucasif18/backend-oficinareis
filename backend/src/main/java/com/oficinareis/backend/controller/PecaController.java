package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.Peca;
import com.oficinareis.backend.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
@CrossOrigin(origins = "*") // libera o acesso do frontend
public class PecaController {

    @Autowired
    private PecaRepository pecaRepository;

    // Listar todas as peças
    @GetMapping
    public List<Peca> listarTodas() {
        return pecaRepository.findAll();
    }

    // Buscar peça por ID
    @GetMapping("/{id}")
    public Peca buscarPorId(@PathVariable Long id) {
        return pecaRepository.findById(id).orElse(null);
    }

    // Criar nova peça
    @PostMapping
    public Peca criarPeca(@RequestBody Peca peca) {
        return pecaRepository.save(peca);
    }

    // Atualizar peça existente
    @PutMapping("/{id}")
    public Peca atualizarPeca(@PathVariable Long id, @RequestBody Peca novaPeca) {
        return pecaRepository.findById(id)
                .map(p -> {
                    p.setNome(novaPeca.getNome());
                    p.setTipo(novaPeca.getTipo());
                    p.setPreco(novaPeca.getPreco());
                    p.setQuantidade(novaPeca.getQuantidade());
                    return pecaRepository.save(p);
                })
                .orElse(null);
    }

    // Excluir peça
    @DeleteMapping("/{id}")
    public void deletarPeca(@PathVariable Long id) {
        pecaRepository.deleteById(id);
    }
}
