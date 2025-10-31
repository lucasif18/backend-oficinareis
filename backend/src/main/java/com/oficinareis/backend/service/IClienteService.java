package com.oficinareis.backend.service;

import com.oficinareis.backend.model.Cliente;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de Cliente deve oferecer
public interface IClienteService {
    
    // Salva um novo cliente ou atualiza um existente
    Cliente save(Cliente cliente);

    // Busca um cliente pelo seu ID
    Optional<Cliente> findById(Long id);

    // Retorna todos os clientes
    List<Cliente> findAll();

    // Deleta um cliente pelo seu ID
    void deleteById(Long id);
}
