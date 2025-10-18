package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "precos_servico")
public class PrecoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreco;

    // Tabela de ligação: QUAL CATEGORIA?
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaVeiculo categoria;

    // Tabela de ligação: QUAL PEÇA DO MOTOR?
    @ManyToOne
    @JoinColumn(name = "peca_motor_id", nullable = false)
    private PecaMotor pecaMotor;

    // Tabela de ligação: QUAL TIPO DE SERVIÇO?
    @ManyToOne
    @JoinColumn(name = "tipo_servico_id", nullable = false)
    private TipoServico tipoServico;

    @Column(nullable = false)
    private Double valor; // O valor pré-definido para esta combinação
}
