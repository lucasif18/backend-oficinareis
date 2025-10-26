package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pecas_motor")
public class PecaMotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPecaMotor;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: Eixo Virabrequim, Bloco, Cabeçote
}