package com.example.sentinela2.dto;

import com.example.sentinela2.model.TipoAmeaca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DenunciaRequestDTO {

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotNull(message = "Tipo de ameaça é obrigatório")
    private TipoAmeaca tipoAmeaca;

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
}
