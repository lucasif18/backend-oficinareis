package com.financas.sistemacasal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bancos")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "codigo_febraban", length = 10)
    private String codigoFebraban;

    @Column(name = "cor_hex", length = 7)
    private String corHex;

    @Column(name = "logo_url", length = 255)
    private String logoUrl;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Banco() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigoFebraban() { return codigoFebraban; }
    public void setCodigoFebraban(String codigoFebraban) { this.codigoFebraban = codigoFebraban; }

    public String getCorHex() { return corHex; }
    public void setCorHex(String corHex) { this.corHex = corHex; }

    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}