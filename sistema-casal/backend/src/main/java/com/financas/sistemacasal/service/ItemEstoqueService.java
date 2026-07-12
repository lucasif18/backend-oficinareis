package com.financas.sistemacasal.service;

import com.financas.sistemacasal.dto.ItemEstoqueResponseDTO;
import com.financas.sistemacasal.repository.ItemEstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemEstoqueService {

    private final ItemEstoqueRepository itemEstoqueRepository;

    @Transactional(readOnly = true)
    public List<ItemEstoqueResponseDTO> listarPorCasal(Long casalId) {
        return itemEstoqueRepository.findByCasalId(casalId).stream()
                .map(ItemEstoqueResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
    /*
     * public ItemEstoqueResponseDTO salvar(
     * Long casalId,
     * ItemEstoqueRequestDTO dto){
     * return null;
     * }
     */
}