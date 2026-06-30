package com.financas.sistemacasal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal; // Importe o BigDecimal aqui
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_lista_compra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCriacao = LocalDate.now();

    @Column(nullable = false)
    private Boolean finalizada = false;

    // ALTERADO DE Double PARA BigDecimal PARA PADRONIZAR COM SEU SISTEMA FINANCEIRO
    private BigDecimal valorTotal = BigDecimal.ZERO; 

    @ManyToOne
    @JoinColumn(name = "casal_id", nullable = false)
    private Casal casal;

    @OneToMany(mappedBy = "listaCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemLista> itens;
}