package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.CategoriaVeiculo;
import com.oficinareis.backend.repository.CategoriaVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaVeiculoRepository categoriaRepository;

    // Listar todas
    @GetMapping
    public List<CategoriaVeiculo> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public CategoriaVeiculo buscarPorId(@PathVariable Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    // Criar nova categoria
    @PostMapping
    public CategoriaVeiculo criar(@RequestBody CategoriaVeiculo categoria) {
        return categoriaRepository.save(categoria);
    }

    // Atualizar categoria
    @PutMapping("/{id}")
    public CategoriaVeiculo atualizar(@PathVariable Long id, @RequestBody CategoriaVeiculo novaCategoria) {
        return categoriaRepository.findById(id)
                .map(c -> {
                    c.setNome(novaCategoria.getNome());
                    c.setDescricao(novaCategoria.getDescricao());
                    return categoriaRepository.save(c);
                })
                .orElse(null);
    }

    // Excluir categoria
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
