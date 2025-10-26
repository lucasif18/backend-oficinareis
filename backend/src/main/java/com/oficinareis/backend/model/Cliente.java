package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Indica que é uma tabela do DB
@Data // Lombok: Gera Getters e Setters automaticamente
@NoArgsConstructor // Lombok: Construtor sem argumentos
@AllArgsConstructor // Lombok: Construtor com todos os argumentos
@Table(name = "clientes") // Nome da tabela no MySQL
public class Cliente {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long idCliente; // Mapeia id_cliente

    @Column(nullable = false) // Garante que o nome não será nulo
    private String nome;

    private String telefone;

    private String endereco;
}
