package com.financas.sistemacasal.dto;

import com.financas.sistemacasal.model.ContaBancaria;
import java.math.BigDecimal;
import lombok.Value;
import com.financas.sistemacasal.model.TipoConta;

@Value
public class ContaBancariaDTO {
    private Long id;
    private String bancoNome;
    private String bancoCorHex;
    private TipoConta tipoConta;
    private BigDecimal saldoAtual;

    public ContaBancariaDTO(Long id, String bancoNome, String bancoCorHex, String tipoConta, BigDecimal saldoAtual) {
        this.id = id;
        this.bancoNome = bancoNome;
        this.bancoCorHex = bancoCorHex;
        this.tipoConta = tipoConta;
        this.saldoAtual = saldoAtual;
    }

    public static ContaBancariaDTO fromEntity(ContaBancaria conta) {
        return new ContaBancariaDTO(
            conta.getId(),
            conta.getBanco().getNome(),
            conta.getBanco().getCorHex(),
            conta.getTipoConta(),
            conta.getSaldoAtual()
        );
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBancoNome() { return bancoNome; }
    public void setBancoNome(String bancoNome) { this.bancoNome = bancoNome; }

    public String getBancoCorHex() { return bancoCorHex; }
    public void setBancoCorHex(String bancoCorHex) { this.bancoCorHex = bancoCorHex; }

    public String getTipoConta() { return tipoConta; }
    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public BigDecimal getSaldoAtual() { return saldoAtual; }
    public void setSaldoAtual(BigDecimal saldoAtual) { this.saldoAtual = saldoAtual; }
}