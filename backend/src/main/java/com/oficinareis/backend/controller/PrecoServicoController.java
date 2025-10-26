package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.PrecoServico;
import com.oficinareis.backend.repository.PrecoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/precos-servico")
@CrossOrigin(origins = "*")
public class PrecoServicoController {

    @Autowired
    private PrecoServicoRepository precoServicoRepository;

    // GET: Listar todos os Preços
    @GetMapping
    public List<PrecoServico> listarTodos() {
        return precoServicoRepository.findAll();
    }

    // POST: Criar novo Preço (Ligação Categoria + PecaMotor + TipoServico)
    @PostMapping
    public PrecoServico criarPreco(@RequestBody PrecoServico precoServico) {
        return precoServicoRepository.save(precoServico);
    }

    // GET: Buscar Preço por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrecoServico> buscarPorId(@PathVariable Long id) {
        return precoServicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT: Atualizar Valor do Preço por ID (Normalmente só o valor muda)
    @PutMapping("/{id}")
    public ResponseEntity<PrecoServico> atualizarPreco(@PathVariable Long id,
            @RequestBody PrecoServico novoPrecoServico) {
        return precoServicoRepository.findById(id)
                .map(preco -> {
                    // Aqui focamos em atualizar apenas o valor, mas aceita tudo da requisição
                    preco.setValor(novoPrecoServico.getValor());

                    // Se você quiser permitir a mudança de CATEGORIA, PEÇA, ou TIPO:
                    // preco.setCategoria(novoPrecoServico.getCategoria());
                    // preco.setPecaMotor(novoPrecoServico.getPecaMotor());
                    // preco.setTipoServico(novoPrecoServico.getTipoServico());

                    return ResponseEntity.ok(precoServicoRepository.save(preco));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Excluir Preço por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPreco(@PathVariable Long id) {
        if (!precoServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        precoServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
