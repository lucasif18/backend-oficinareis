package com.oficinareis.backend.service;

import com.oficinareis.backend.model.OrdemServico;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de OrdemServico deve oferecer
public interface IOrdemServicoService {
    
    // Salva uma nova ordem de serviço ou atualiza uma existente
    OrdemServico save(OrdemServico ordemServico);

    // Busca uma ordem de serviço pelo seu ID
    Optional<OrdemServico> findById(Long id);

    // Retorna todas as ordens de serviço
    List<OrdemServico> findAll();

    // Deleta uma ordem de serviço pelo seu ID
    void deleteById(Long id);
}