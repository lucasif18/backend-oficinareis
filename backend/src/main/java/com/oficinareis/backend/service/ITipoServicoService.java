package com.oficinareis.backend.service;

import com.oficinareis.backend.model.TipoServico;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de TipoServico deve oferecer
public interface ITipoServicoService {
    
    // Salva um novo tipo de serviço ou atualiza um existente
    TipoServico save(TipoServico tipoServico);

    // Busca um tipo de serviço pelo seu ID
    Optional<TipoServico> findById(Long id);

    // Retorna todos os tipos de serviço
    List<TipoServico> findAll();

    // Deleta um tipo de serviço pelo seu ID
    void deleteById(Long id);
}
