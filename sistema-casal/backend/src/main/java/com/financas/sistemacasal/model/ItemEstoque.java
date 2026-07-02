package com.financas.sistemacasal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "itens_estoque")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer quantidadeAtual;

    @Column(nullable = false)
    private Integer quantidadeMinima;

    @Column(length = 20)
    private String unidadeMedida;

    @Column(length = 50)
    private String categoria;

    // Novos campos para a próxima Sprint
    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "dias_validade_apos_aberto")
    private Integer diasValidadeAposAberto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "casal_id", nullable = false)
    @JsonIgnore
    private Casal casal;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(length = 50)
    private String marca;

    @Column(length = 50)
    private String localArmazenamento;

    @Transient
    public boolean isAbaixoDoMinimo() {
        return this.quantidadeAtual <= this.quantidadeMinima;
    }

    // Lógica preliminar para o status calculado
    @Transient
    public StatusValidade getStatusValidade() {
        if (dataValidade == null) {
            return StatusValidade.INDETERMINADO;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = dataValidade;

        // Se estiver aberto e tiver validade reduzida, calcula o novo limite
        if (dataAbertura != null && diasValidadeAposAberto != null) {
            LocalDate limiteAberto = dataAbertura.plusDays(diasValidadeAposAberto);
            if (limiteAberto.isBefore(dataLimite)) {
                dataLimite = limiteAberto;
            }
        }

        if (hoje.isAfter(dataLimite)) {
            return StatusValidade.VENCIDO;
        } else if (hoje.plusDays(3).isAfter(dataLimite)) { // Alerta prévio de 3 dias
            return StatusValidade.PROXIMO_AO_VENCIMENTO;
        }

        return StatusValidade.VALIDO;
    }
}