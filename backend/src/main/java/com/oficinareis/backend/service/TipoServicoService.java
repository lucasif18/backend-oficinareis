package com.oficinareis.backend.service;

import com.oficinareis.backend.model.TipoServico;
import com.oficinareis.backend.repository.TipoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um componente de serviço Spring
@Service
public class TipoServicoService implements ITipoServicoService {

    // Injeção de dependência do repositório para acesso aos dados
    private final TipoServicoRepository tipoServicoRepository;

    @Autowired
    public TipoServicoService(TipoServicoRepository tipoServicoRepository) {
        this.tipoServicoRepository = tipoServicoRepository;
    }

    /**
     * Salva um novo TipoServico ou atualiza um existente.
     * @param tipoServico A entidade TipoServico a ser salva.
     * @return A entidade salva.
     */
    @Override
    public TipoServico save(TipoServico tipoServico) {
        return tipoServicoRepository.save(tipoServico);
    }

    /**
     * Busca um TipoServico pelo ID.
     * @param id O ID do tipo de serviço.
     * @return Um Optional contendo o tipo de serviço, se encontrado.
     */
    @Override
    public Optional<TipoServico> findById(Long id) {
        return tipoServicoRepository.findById(id);
    }

    /**
     * Retorna todos os Tipos de Serviço.
     * @return Uma lista de todos os tipos de serviço.
     */
    @Override
    public List<TipoServico> findAll() {
        return tipoServicoRepository.findAll();
    }

    /**
     * Deleta um TipoServico pelo ID.
     * @param id O ID do tipo de serviço a ser deletado.
     */
    @Override
    public void deleteById(Long id) {
        tipoServicoRepository.deleteById(id);
    }
}