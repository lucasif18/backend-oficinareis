package com.oficinareis.backend.service;

import com.oficinareis.backend.model.Cliente;
import com.oficinareis.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um componente de serviço Spring
@Service
public class ClienteService implements IClienteService {

    // Injeção de dependência do repositório para acesso aos dados
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Salva um novo Cliente ou atualiza um existente.
     * @param cliente A entidade Cliente a ser salva.
     * @return A entidade salva.
     */
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Busca um Cliente pelo ID.
     * @param id O ID do cliente.
     * @return Um Optional contendo o cliente, se encontrado.
     */
    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    /**
     * Retorna todos os Clientes.
     * @return Uma lista de todos os clientes.
     */
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    /**
     * Deleta um Cliente pelo ID.
     * @param id O ID do cliente a ser deletado.
     */
    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}