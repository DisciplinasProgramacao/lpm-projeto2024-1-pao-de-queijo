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

    //#region Geters
    public String getNome() {
        return nome;
    }

    public Long getDocumento() {
        return documento;
    }
    //#endregion
}
