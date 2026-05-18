package com.example.sentinela2.dto;

import com.example.sentinela2.model.DenunciaStatus;
import com.example.sentinela2.model.TipoAmeaca;

import java.time.LocalDateTime;

public class DenunciaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private TipoAmeaca tipoAmeaca;
    private DenunciaStatus status;
    private LocalDateTime data;
    private String usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoAmeaca getTipoAmeaca() {
        return tipoAmeaca;
    }

    public void setTipoAmeaca(TipoAmeaca tipoAmeaca) {
        this.tipoAmeaca = tipoAmeaca;
    }

    public DenunciaStatus getStatus() {
        return status;
    }

    public void setStatus(DenunciaStatus status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
