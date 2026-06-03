package com.example.sentinela2.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    // número do telefone suspeito — campo novo
    @Column(nullable = false)
    private String numero;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAmeaca tipoAmeaca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DenunciaStatus status;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false, name = "usuario_id")
    private String usuarioId;

    public Denuncia() {}

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public TipoAmeaca getTipoAmeaca() { return tipoAmeaca; }
    public void setTipoAmeaca(TipoAmeaca tipoAmeaca) { this.tipoAmeaca = tipoAmeaca; }
    public DenunciaStatus getStatus() { return status; }
    public void setStatus(DenunciaStatus status) { this.status = status; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
}