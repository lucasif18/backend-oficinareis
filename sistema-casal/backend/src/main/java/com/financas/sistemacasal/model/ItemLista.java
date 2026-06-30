package com.financas.sistemacasal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "tb_item_lista")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer quantidadeAComprar;

    private Boolean comprado = false;

    @Column(length = 50)
    private String categoria; // "Alimentação", "Limpeza", etc.

    // Campos para a inteligência de Estoque e Vencimento do Módulo 4
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "lista_compra_id", nullable = false)
    private ListaCompra listaCompra;
}