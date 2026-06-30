package com.financas.sistemacasal.dto;

import com.financas.sistemacasal.model.Banco;
import lombok.Value;

@Value
public class BancoResponseDTO {
    Long id;
    String nome;
    String codigoFebraban;
    String corHex;
    String logoUrl;

    public static BancoResponseDTO fromEntity(Banco banco) {
        return new BancoResponseDTO(
            banco.getId(),
            banco.getNome(),
            banco.getCodigoFebraban(),
            banco.getCorHex(),
            banco.getLogoUrl()
        );
    }
}