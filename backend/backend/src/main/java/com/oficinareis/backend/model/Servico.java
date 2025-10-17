package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ex: "Eixo Virabrequim", "Bloco", "Cabeçote"
    @Column(nullable = false)
    private String nomePeca;

    // Ex: "Retificar", "Polir", "Facear"
    @Column(nullable = false)
    private String tipoServico;

    // Ex: "Linha Leve 8V", "Linha Pesada", "Moto"
    private String categoria;

    // Valor pré-definido do serviço
    @Column(nullable = false)
    private Double preco;
}
