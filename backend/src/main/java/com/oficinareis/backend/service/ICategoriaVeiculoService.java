package com.oficinareis.backend.service;

import com.oficinareis.backend.model.CategoriaVeiculo;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de CategoriaVeiculo deve oferecer
public interface ICategoriaVeiculoService {
    
    // Salva uma nova categoria de veículo ou atualiza uma existente
    CategoriaVeiculo save(CategoriaVeiculo categoriaVeiculo);

    // Busca uma categoria de veículo pelo seu ID
    Optional<CategoriaVeiculo> findById(Long id);

    // Retorna todas as categorias de veículo
    List<CategoriaVeiculo> findAll();

    // Deleta uma categoria de veículo pelo seu ID
    void deleteById(Long id);
}