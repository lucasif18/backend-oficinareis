package com.oficinareis.backend.service;

import com.oficinareis.backend.model.PrecoServico;
import com.oficinareis.backend.repository.PrecoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um componente de serviço Spring
@Service
public class PrecoServicoService implements IPrecoServicoService {

    // Injeção de dependência do repositório para acesso aos dados
    private final PrecoServicoRepository precoServicoRepository;

    @Autowired
    public PrecoServicoService(PrecoServicoRepository precoServicoRepository) {
        this.precoServicoRepository = precoServicoRepository;
    }

    /**
     * Salva um novo PrecoServico ou atualiza um existente.
     * @param precoServico A entidade PrecoServico a ser salva.
     * @return A entidade salva.
     */
    @Override
    public PrecoServico save(PrecoServico precoServico) {
        return precoServicoRepository.save(precoServico);
    }

    /**
     * Busca um PrecoServico pelo ID.
     * @param id O ID do preço de serviço.
     * @return Um Optional contendo o preço de serviço, se encontrado.
     */
    @Override
    public Optional<PrecoServico> findById(Long id) {
        return precoServicoRepository.findById(id);
    }

    /**
     * Retorna todos os Preços de Serviço.
     * @return Uma lista de todos os preços de serviço.
     */
    @Override
    public List<PrecoServico> findAll() {
        return precoServicoRepository.findAll();
    }

    /**
     * Deleta um PrecoServico pelo ID.
     * @param id O ID do preço de serviço a ser deletado.
     */
    @Override
    public void deleteById(Long id) {
        precoServicoRepository.deleteById(id);
    }
}