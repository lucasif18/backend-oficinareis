package com.oficinareis.backend.service;

import com.oficinareis.backend.model.PrecoServico;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de PrecoServico deve oferecer
public interface IPrecoServicoService {
    
    // Salva um novo preço de serviço ou atualiza um existente
    PrecoServico save(PrecoServico precoServico);

    // Busca um preço de serviço pelo seu ID
    Optional<PrecoServico> findById(Long id);

    // Retorna todos os preços de serviço
    List<PrecoServico> findAll();

    // Deleta um preço de serviço pelo seu ID
    void deleteById(Long id);
}