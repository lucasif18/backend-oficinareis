package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // Ex: Moto, Linha Leve 8V, Linha Leve 12V, Linha Pesada Vans, etc.

    @Column(length = 255)
    private String descricao; // Informação adicional sobre a categoria
}
