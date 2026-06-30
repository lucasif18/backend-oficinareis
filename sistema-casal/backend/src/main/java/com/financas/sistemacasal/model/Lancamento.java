package com.financas.sistemacasal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lancamentos")
@Data
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false, length = 10)
    private String tipo; // 'ENTRADA' ou 'SAIDA'

    @Column(name = "forma_pagamento", nullable = false, length = 20)
    private String formaPagamento; // 'PIX', 'DEBITO', 'CREDITO', 'DINHEIRO'

    @Column(nullable = false, length = 100)
    private String categoria; // Ex: 'Salário', 'Água', 'Supermercado'

    @Column(nullable = false)
    private Boolean validado = false; // O botão que muda o status do gasto

    @Column(name = "data_competencia", nullable = false)
    private LocalDate dataCompetencia; // Data em que o gasto realmente aconteceu

    // Quem realizou o lançamento (Lucas ou Lane)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Vinculado ao casal para isolar os dados de vocês
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "casal_id", nullable = false)
    private Casal casal;

    // Qual conta bancária foi afetada por esse lançamento
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_bancaria_id")
    private ContaBancaria contaBancaria;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}