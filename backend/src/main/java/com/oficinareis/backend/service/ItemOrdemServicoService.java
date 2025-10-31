package com.oficinareis.backend.service;

import com.oficinareis.backend.model.ItemOrdemServico;
import com.oficinareis.backend.repository.ItemOrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indica que esta classe é um componente de serviço Spring
@Service
public class ItemOrdemServicoService implements IItemOrdemServicoService {

    // Injeção de dependência do repositório para acesso aos dados
    // Foi corrigido o nome do repositório para ItemOrdemServicoRepository
    private final ItemOrdemServicoRepository itemOrdemServicoRepository;

    @Autowired
    public ItemOrdemServicoService(ItemOrdemServicoRepository itemOrdemServicoRepository) {
        this.itemOrdemServicoRepository = itemOrdemServicoRepository;
    }

    /**
     * Salva um novo ItemOrdemServico ou atualiza um existente.
     * @param itemOrdemServico A entidade ItemOrdemServico a ser salva.
     * @return A entidade salva.
     */
    @Override
    public ItemOrdemServico save(ItemOrdemServico itemOrdemServico) {
        return itemOrdemServicoRepository.save(itemOrdemServico);
    }

    /**
     * Busca um ItemOrdemServico pelo ID.
     * @param id O ID do item de ordem de serviço.
     * @return Um Optional contendo o item, se encontrado.
     */
    @Override
    public Optional<ItemOrdemServico> findById(Long id) {
        return itemOrdemServicoRepository.findById(id);
    }

    /**
     * Retorna todos os ItensOrdemServico.
     * @return Uma lista de todos os itens.
     */
    @Override
    public List<ItemOrdemServico> findAll() {
        return itemOrdemServicoRepository.findAll();
    }

    /**
     * Deleta um ItemOrdemServico pelo ID.
     * @param id O ID do item a ser deletado.
     */
    @Override
    public void deleteById(Long id) {
        itemOrdemServicoRepository.deleteById(id);
    }
}