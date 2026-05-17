package com.example.sentinela2;

public class Denuncia {
    private Long id;
    private String numeroTelefone;
    private String tipoGolpe;
    private String descricao;

    // Construtor vazio (obrigatório)
    public Denuncia() {}

    // Getters e Setters (essenciais para a API funcionar)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroTelefone() { return numeroTelefone; }
    public void setNumeroTelefone(String numeroTelefone) { this.numeroTelefone = numeroTelefone; }
    public String getTipoGolpe() { return tipoGolpe; }
    public void setTipoGolpe(String tipoGolpe) { this.tipoGolpe = tipoGolpe; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}