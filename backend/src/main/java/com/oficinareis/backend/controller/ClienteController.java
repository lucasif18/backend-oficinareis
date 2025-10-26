// ARQUIVO: ClienteController.java (CRUD COMPLETO)
package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.Cliente;
import com.oficinareis.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // NOVO: Para retornar 404 e 204
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*") // Adicionando CORS para padronizar
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // GET: Listar todos
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Criar
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // PUT: Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente novoCliente) {
        return clienteRepository.findById(id)
                .map(c -> {
                    c.setNome(novoCliente.getNome());
                    c.setTelefone(novoCliente.getTelefone());
                    c.setEndereco(novoCliente.getEndereco());
                    return ResponseEntity.ok(clienteRepository.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Excluir
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}