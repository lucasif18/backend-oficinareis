package com.oficinareis.backend.service;

import com.oficinareis.backend.model.PecaMotor;
import com.oficinareis.backend.repository.PecaMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um componente de serviço Spring
@Service
public class PecaMotorService implements IPecaMotorService {

    // Injeção de dependência do repositório para acesso aos dados
    private final PecaMotorRepository pecaMotorRepository;

    @Autowired
    public PecaMotorService(PecaMotorRepository pecaMotorRepository) {
        this.pecaMotorRepository = pecaMotorRepository;
    }

    /**
     * Salva uma nova PecaMotor ou atualiza uma existente.
     * @param pecaMotor A entidade PecaMotor a ser salva.
     * @return A entidade salva.
     */
    @Override
    public PecaMotor save(PecaMotor pecaMotor) {
        return pecaMotorRepository.save(pecaMotor);
    }

    /**
     * Busca uma PecaMotor pelo ID.
     * @param id O ID da peça de motor.
     * @return Um Optional contendo a peça de motor, se encontrada.
     */
    @Override
    public Optional<PecaMotor> findById(Long id) {
        return pecaMotorRepository.findById(id);
    }

    /**
     * Retorna todas as Peças de Motor.
     * @return Uma lista de todas as peças de motor.
     */
    @Override
    public List<PecaMotor> findAll() {
        return pecaMotorRepository.findAll();
    }

    /**
     * Deleta uma PecaMotor pelo ID.
     * @param id O ID da peça de motor a ser deletada.
     */
    @Override
    public void deleteById(Long id) {
        pecaMotorRepository.deleteById(id);
    }
}