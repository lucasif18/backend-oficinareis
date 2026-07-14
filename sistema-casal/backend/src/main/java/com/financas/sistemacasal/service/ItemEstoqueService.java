package com.financas.sistemacasal.service;

import com.financas.sistemacasal.dto.ItemEstoqueResponseDTO;
import com.financas.sistemacasal.dto.ItemEstoqueRequestDTO;
import com.financas.sistemacasal.repository.ItemEstoqueRepository;
import com.financas.sistemacasal.repository.CasalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.financas.sistemacasal.model.ItemEstoque;
import com.financas.sistemacasal.model.Casal;

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
   @Transactional
public ItemEstoqueResponseDTO salvar(ItemEstoqueRequestDTO dto) {

    Casal casal = casalRepository.findById(dto.getCasalId())
            .orElseThrow(() -> new RuntimeException("Casal não encontrado"));

    ItemEstoque item = new ItemEstoque();

    item.setNome(dto.getNome());
    item.setQuantidadeAtual(dto.getQuantidadeAtual());
    item.setQuantidadeMinima(dto.getQuantidadeMinima());
    item.setUnidadeMedida(dto.getUnidadeMedida());
    item.setCategoria(dto.getCategoria());

    item.setDataValidade(dto.getDataValidade());
    item.setDataAbertura(dto.getDataAbertura());
    item.setDiasValidadeAposAberto(dto.getDiasValidadeAposAberto());

    item.setCasal(casal);

    item = itemEstoqueRepository.save(item);

    return ItemEstoqueResponseDTO.fromEntity(item);
    }
}
