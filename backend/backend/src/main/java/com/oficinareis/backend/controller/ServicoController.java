package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.Servico;
import com.oficinareis.backend.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(origins = "*")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    // Listar todos os serviços
    @GetMapping
    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    // Buscar serviço por ID
    @GetMapping("/{id}")
    public Servico buscarPorId(@PathVariable Long id) {
        return servicoRepository.findById(id).orElse(null);
    }

    // Criar novo serviço
    @PostMapping
    public Servico criar(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }

    // Atualizar serviço existente
    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable Long id, @RequestBody Servico novoServico) {
        return servicoRepository.findById(id)
                .map(s -> {
                    s.setNomePeca(novoServico.getNomePeca());
                    s.setTipoServico(novoServico.getTipoServico());
                    s.setCategoria(novoServico.getCategoria());
                    s.setPreco(novoServico.getPreco());
                    return servicoRepository.save(s);
                })
                .orElse(null);
    }

    // Excluir serviço
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        servicoRepository.deleteById(id);
    }
}
