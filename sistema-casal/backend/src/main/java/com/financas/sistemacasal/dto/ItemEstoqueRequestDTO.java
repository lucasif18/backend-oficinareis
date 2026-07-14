package com.financas.sistemacasal.dto;

import java.time.LocalDate;

public class ItemEstoqueRequestDTO {

    private String nome;
    private Integer quantidadeAtual;
    private Integer quantidadeMinima;
    private String unidadeMedida;
    private String categoria;
    private Long casalId;
    private LocalDate dataValidade;
    private LocalDate dataAbertura;
    private Integer diasValidadeAposAberto;

    public ItemEstoqueRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Integer quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Integer getDiasValidadeAposAberto() {
        return diasValidadeAposAberto;
    }

    public void setDiasValidadeAposAberto(Integer diasValidadeAposAberto) {
        this.diasValidadeAposAberto = diasValidadeAposAberto;
    }
}