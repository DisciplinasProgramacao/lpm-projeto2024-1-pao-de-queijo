package com.paodequeijo.restaurante.Models;
public class Cliente {
    //#region Atributos
    private String nome;
    private Long documento;
    //#endregion

    /**
     * Construtor da classe Cliente
     * @param nome
     * @param string
     */
    Cliente(String nome, Long string) {
        this.nome = nome;
        this.documento = string;
    }

    //#region Geters e Seters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getDocumento() {
        return documento;
    }
    //#endregion
}
