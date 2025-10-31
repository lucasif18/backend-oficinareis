package com.oficinareis.backend.service;

import com.oficinareis.backend.model.Peca;
import com.oficinareis.backend.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um componente de serviço Spring
@Service
public class PecaService implements IPecaService {

    // Injeção de dependência do repositório para acesso aos dados
    private final PecaRepository pecaRepository;

    @Autowired
    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    /**
     * Salva uma nova Peca ou atualiza uma existente.
     * @param peca A entidade Peca a ser salva.
     * @return A entidade salva.
     */
    @Override
    public Peca save(Peca peca) {
        return pecaRepository.save(peca);
    }

    /**
     * Busca uma Peca pelo ID.
     * @param id O ID da peça.
     * @return Um Optional contendo a peça, se encontrada.
     */
    @Override
    public Optional<Peca> findById(Long id) {
        return pecaRepository.findById(id);
    }

    /**
     * Retorna todas as Peças.
     * @return Uma lista de todas as peças.
     */
    @Override
    public List<Peca> findAll() {
        return pecaRepository.findAll();
    }

    /**
     * Deleta uma Peca pelo ID.
     * @param id O ID da peça a ser deletada.
     */
    @Override
    public void deleteById(Long id) {
        pecaRepository.deleteById(id);
    }
}