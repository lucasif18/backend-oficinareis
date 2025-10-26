// PASTA: model
// ARQUIVO: CategoriaVeiculo.java (MUDANÇA DE NOME)
package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias_veiculo") // <-- Renomeado
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaVeiculo { // <-- Renomeado

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria; // <-- Para padronizar

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(length = 255)
    private String descricao;
}
