package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pecas")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeca;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo; // nova ou usada

    @Column(nullable = false)
    private Double preco;

    private Integer quantidade;
}
