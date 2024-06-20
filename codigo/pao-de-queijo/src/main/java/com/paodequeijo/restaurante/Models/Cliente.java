package com.paodequeijo.restaurante.Models;
public class Cliente {
    //#region Atributos
    private String nome;
    private Long documento;
    //#endregion

    /**
     * Construtor da classe Cliente
     * @param nome
     * @param documento
     */
    Cliente(String nome, Long documento) {
        if (nome.length() == 0) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        
        this.nome = nome;
        this.documento = documento;
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
