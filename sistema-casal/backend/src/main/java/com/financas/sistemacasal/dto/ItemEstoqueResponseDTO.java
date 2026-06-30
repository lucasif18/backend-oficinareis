package com.financas.sistemacasal.dto;

import com.financas.sistemacasal.model.ItemEstoque;
import com.financas.sistemacasal.model.StatusValidade;
import lombok.Value;
import java.time.LocalDate;

@Value // Gera getters, constructor completo, equals/hashCode e deixa os campos como final
public class ItemEstoqueResponseDTO {
    Long id;
    String nome;
    Integer quantidadeAtual;
    Integer quantidadeMinima;
    String unidadeMedida;
    String categoria;
    boolean abaixoDoMinimo;
    LocalDate dataValidade;
    LocalDate dataAbertura;
    Integer diasValidadeAposAberto;
    StatusValidade statusValidade;

    public static ItemEstoqueResponseDTO fromEntity(ItemEstoque item) {
        return new ItemEstoqueResponseDTO(
            item.getId(),
            item.getNome(),
            item.getQuantidadeAtual(),
            item.getQuantidadeMinima(),
            item.getUnidadeMedida(),
            item.getCategoria(),
            item.isAbaixoDoMinimo(),
            item.getDataValidade(),
            item.getDataAbertura(),
            item.getDiasValidadeAposAberto(),
            item.getStatusValidade()
        );
    }
}