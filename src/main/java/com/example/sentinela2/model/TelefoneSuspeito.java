package com.example.sentinela2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone_suspeito")
public class TelefoneSuspeito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(name = "total_denuncias", nullable = false)
    private int totalDenuncias = 0;

    @Column(nullable = false)
    private boolean bloqueado = false;

    public TelefoneSuspeito() {}

    public TelefoneSuspeito(String numero) {
        this.numero = numero;
    }

    public Long getId() { return id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public int getTotalDenuncias() { return totalDenuncias; }
    public void setTotalDenuncias(int totalDenuncias) { this.totalDenuncias = totalDenuncias; }
    public void incrementarDenuncias() { this.totalDenuncias++; }
    public boolean isBloqueado() { return bloqueado; }
    public void setBloqueado(boolean bloqueado) { this.bloqueado = bloqueado; }
}