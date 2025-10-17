package com.oficinareis.backend.controller; // <-- PACOTE CORRETO

import com.oficinareis.backend.model.Cliente;
import com.oficinareis.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // <-- IMPORTANTE TER ESTA LINHA
import java.util.List;

@RestController // <-- ESSENCIAL!
@RequestMapping("/clientes") // <-- ENDPOINT
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
