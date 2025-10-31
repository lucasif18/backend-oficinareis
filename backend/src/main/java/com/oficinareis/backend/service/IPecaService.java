package com.oficinareis.backend.service;

import com.oficinareis.backend.model.Peca;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de Peca deve oferecer
public interface IPecaService {
    
    // Salva uma nova peça ou atualiza uma existente
    Peca save(Peca peca);

    // Busca uma peça pelo seu ID
    Optional<Peca> findById(Long id);

    // Retorna todas as peças
    List<Peca> findAll();

    // Deleta uma peça pelo seu ID
    void deleteById(Long id);
}