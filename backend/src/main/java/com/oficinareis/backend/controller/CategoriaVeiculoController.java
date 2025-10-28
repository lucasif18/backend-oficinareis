package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.CategoriaVeiculo;
import com.oficinareis.backend.repository.CategoriaVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias-veiculo") // Mapeamento correto
@CrossOrigin(origins = "*")
public class CategoriaVeiculoController {

    @Autowired
    private CategoriaVeiculoRepository categoriaVeiculoRepository;

    // GET: Listar todas as Categorias
    @GetMapping
    public List<CategoriaVeiculo> listarTodas() {
        return categoriaVeiculoRepository.findAll();
    }
    
    // GET: Buscar Categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaVeiculo> buscarPorId(@PathVariable Long id) {
        return categoriaVeiculoRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Criar nova Categoria
    @PostMapping
    public CategoriaVeiculo criarCategoria(@RequestBody CategoriaVeiculo categoria) {
        return categoriaVeiculoRepository.save(categoria);
    }

    // PUT: Atualizar Categoria por ID
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaVeiculo> atualizarCategoria(@PathVariable Long id,
            @RequestBody CategoriaVeiculo novaCategoria) {
        return categoriaVeiculoRepository.findById(id)
                .map(categoria -> {
                    categoria.setNome(novaCategoria.getNome());
                    categoria.setDescricao(novaCategoria.getDescricao());
                    return ResponseEntity.ok(categoriaVeiculoRepository.save(categoria));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Excluir Categoria por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        if (!categoriaVeiculoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoriaVeiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
