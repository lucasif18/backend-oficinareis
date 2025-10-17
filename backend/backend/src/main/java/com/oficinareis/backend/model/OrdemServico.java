package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ordens_servico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data; // data da ordem
    private String numeroOrdem;
    private String tipoVeiculo; // carro, moto, barco, caminhão
    private String modeloMotor;
    private String serie; // ex: 1.0, 1.8
    private String tipoPeca; // nova ou usada

    // 🧍 Cliente (muitos → um)
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // ⚙️ Categoria (muitos → um)
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    // 🧩 Peças (muitos ↔ muitos)
    @ManyToMany
    @JoinTable(name = "ordem_pecas", joinColumns = @JoinColumn(name = "id_ordem"), inverseJoinColumns = @JoinColumn(name = "id_peca"))
    private List<Peca> pecas;

    // 🧰 Serviços (muitos ↔ muitos)
    @ManyToMany
    @JoinTable(name = "ordem_servicos_detalhes", joinColumns = @JoinColumn(name = "id_ordem"), inverseJoinColumns = @JoinColumn(name = "id_servico"))
    private List<Servico> servicos;
}
