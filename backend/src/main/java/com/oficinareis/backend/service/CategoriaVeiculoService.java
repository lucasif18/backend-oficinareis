package com.oficinareis.backend.service;

import com.oficinareis.backend.model.CategoriaVeiculo;
import com.oficinareis.backend.repository.CategoriaVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável por implementar a lógica de negócio para a entidade CategoriaVeiculo.
 * Atua como intermediário entre o Controller e o Repository.
 */
@Service
public class CategoriaVeiculoService implements ICategoriaVeiculoService {

    // Injeção de dependência do repositório para acesso aos dados
    private final CategoriaVeiculoRepository categoriaVeiculoRepository;

    @Autowired
    public CategoriaVeiculoService(CategoriaVeiculoRepository categoriaVeiculoRepository) {
        this.categoriaVeiculoRepository = categoriaVeiculoRepository;
    }

    /**
     * Salva uma nova CategoriaVeiculo ou atualiza uma existente.
     * @param categoriaVeiculo A entidade CategoriaVeiculo a ser salva.
     * @return A entidade salva.
     */
    @Override
    public CategoriaVeiculo save(CategoriaVeiculo categoriaVeiculo) {
        // Lógica de negócio (ex: validações, formatação) pode ser adicionada aqui
        return categoriaVeiculoRepository.save(categoriaVeiculo);
    }

    /**
     * Busca uma CategoriaVeiculo pelo ID.
     * @param id O ID da categoria.
     * @return Um Optional contendo a categoria, se encontrada.
     */
    @Override
    public Optional<CategoriaVeiculo> findById(Long id) {
        return categoriaVeiculoRepository.findById(id);
    }

    /**
     * Retorna todas as CategoriaVeiculo.
     * @return Uma lista de todas as categorias.
     */
    @Override
    public List<CategoriaVeiculo> findAll() {
        return categoriaVeiculoRepository.findAll();
    }

    /**
     * Deleta uma CategoriaVeiculo pelo ID.
     * @param id O ID da categoria a ser deletada.
     */
    @Override
    public void deleteById(Long id) {
        categoriaVeiculoRepository.deleteById(id);
    }
}