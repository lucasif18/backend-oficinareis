package com.oficinareis.backend.service;

import com.oficinareis.backend.model.PecaMotor;

import java.util.List;
import java.util.Optional;

// Define o contrato (as operações) que o serviço de PecaMotor deve oferecer
public interface IPecaMotorService {
    
    // Salva uma nova peça de motor ou atualiza uma existente
    PecaMotor save(PecaMotor pecaMotor);

    // Busca uma peça de motor pelo seu ID
    Optional<PecaMotor> findById(Long id);

    // Retorna todas as peças de motor
    List<PecaMotor> findAll();

    // Deleta uma peça de motor pelo seu ID
    void deleteById(Long id);
}
