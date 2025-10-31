package com.oficinareis.backend.service;

import com.oficinareis.backend.model.ItemOrdemServico;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de ItemOrdemServico deve oferecer
public interface IItemOrdemServicoService {
    
    // Salva um novo item de ordem de serviço ou atualiza um existente
    ItemOrdemServico save(ItemOrdemServico itemOrdemServico);

    // Busca um item de ordem de serviço pelo seu ID
    Optional<ItemOrdemServico> findById(Long id);

    // Retorna todos os itens de ordem de serviço
    List<ItemOrdemServico> findAll();

    // Deleta um item de ordem de serviço pelo seu ID
    void deleteById(Long id);
}
