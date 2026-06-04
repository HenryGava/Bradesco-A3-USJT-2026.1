package com.example.sentinela2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "O número suspeito é obrigatório")
    @Size(min = 19, message = "Digite o número completo com DDD e código do país")
    @Column(nullable = false)
    private String numero;

    @NotBlank(message = "A descrição é obrigatória")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "Selecione o tipo de ameaça")
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