package com.financas.sistemacasal.dto;

import com.financas.sistemacasal.model.ContaBancaria;
import lombok.Value;
import java.math.BigDecimal;
import com.financas.sistemacasal.model.TipoConta;


@Value
public class ContaBancariaResponseDTO {
    Long id;
    Long usuarioId;
    String tipoConta;
    BigDecimal saldoAtual;
    BancoResponseDTO banco; // Dados do banco aninhados de forma limpa

    public static ContaBancariaResponseDTO fromEntity(ContaBancaria conta) {
        return new ContaBancariaResponseDTO(
            conta.getId(),
            conta.getUsuario().getId(),
            conta.getTipoConta().name(),
            conta.getSaldoAtual(),
            BancoResponseDTO.fromEntity(conta.getBanco())
        );
    }
}