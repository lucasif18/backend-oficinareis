package com.financas.sistemacasal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "investimentos")
@Data
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descricao; // Ex: 'Tesouro Direto', 'CDB Reserva de Emergência'

    @Column(name = "valor_aportado", nullable = false)
    private BigDecimal valorAportado;

    @Column(name = "saldo_atual_rendimento", nullable = false)
    private BigDecimal saldoAtualRendimento = BigDecimal.ZERO;

    @Column(nullable = false, length = 20)
    private String status = "ATIVO"; // 'ATIVO' ou 'RESGATADO'

    @Column(name = "data_aporte", nullable = false)
    private LocalDate dataAporte;

    @Column(name = "data_resgate")
    private LocalDate dataResgate;

    // Vinculado ao casal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "casal_id", nullable = false)
    private Casal casal;

    // Conta bancária de onde saiu o dinheiro para render
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_origem_id")
    private ContaBancaria contaOrigem;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}