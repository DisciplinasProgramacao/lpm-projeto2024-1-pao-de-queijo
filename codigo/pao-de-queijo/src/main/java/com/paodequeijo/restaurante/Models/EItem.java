package com.paodequeijo.restaurante.Models;

enum EItem {
    //#region Atributos
    FALAFEL_ASSADO(20, "Falafel assado"),
    CAÇAROLA_DE_LEGUMES(20, "Caçarola de legumes"),
    COPO_DE_SUCO(5, "Copo de suco"),
    REFRIGERANTE_ORGANICO(7, "Refrigerante orgânico"),
    CERVEJA_VEGANA(10, "Cerveja vegana"),
    TACA_DE_VINHO_VEGANO(15, "Taça de vinho vegano"),
    MOQUECA_DE_PALMITO(25, "Moqueca de palmito"),
    SALADA_PRIMAVERA_COM_MACARRAO_KONJAC(15, "Salada primavera com macarrão konjac"),
    ESCONDIDINHO_DE_INHAME(20, "Escondidinho de inhame"),
    STROGONOFF_DE_COGUMELOS(25, "Strogonoff de cogumelos"),
    AGUA(3, "Água");

    private double valor;
    private String descricao;
    //#endregion

    //#region Construtor
    private EItem(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
    //#endregion

    //#region Getters
    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    //#endregion

    @Override
    public String toString() {
        return String.format("%s: (R$ %2.2f)", descricao, valor);
    }
}