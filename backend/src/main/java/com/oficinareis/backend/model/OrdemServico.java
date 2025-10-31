// PASTA: model
// ARQUIVO: OrdemServico.java (Substituição COMPLETA)
package com.oficinareis.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordens_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdem; // <-- Padronizando idOrdem

    // Cliente (ManyToOne)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Dados da OS
    @Column(nullable = false)
    private String veiculo;

    private String descricaoServico;

    // Valores (Mão de obra e Total calculado)
    private Double valorMaoDeObra;
    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ABERTA;

    private LocalDateTime dataAbertura = LocalDateTime.now();
    private LocalDateTime dataFechamento;

    // Relacionamento com PEÇAS: OneToMany através da tabela ItemOrdemServico
    // PRECISA da classe ItemOrdemServico.java (e Status.java)
    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemOrdemServico> itens;

    public Object getObservacoes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObservacoes'");
    }

    public void setObservacoes(Object observacoes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setObservacoes'");
    }

    public Object getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void setDataCriacao(LocalDateTime now) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataCriacao'");
    }
}