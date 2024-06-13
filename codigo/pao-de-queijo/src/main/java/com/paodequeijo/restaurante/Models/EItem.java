package com.paodequeijo.restaurante.Models;

enum EItem {
    AGUA(3, "Água"),
    COPO_DE_SUCO(5, "Copo de suco"),
    REFRIGERANTE_ORGANICO(7, "Refrigerante orgânico"),
    CERVEJA_VEGANA(10, "Cerveja vegana"),
    TACA_DE_VINHO_VEGANO(15, "Taça de vinho vegano"),
    MOQUECA_DE_PALMITO(25, "Moqueca de palmito"),
    FALAFEL_ASSADO(20, "Falafel assado"),
    SALADA_PRIMAVERA_COM_MACARRAO_KONJAC(15, "Salada primavera com macarrão konjac"),
    ESCONDIDINHO_DE_INHAME(20, "Escondidinho de inhame"),
    STROGONOFF_DE_COGUMELOS(25, "Strogonoff de cogumelos"),
    CAÇAROLA_DE_LEGUMES(20, "Caçarola de legumes");

    private double valor;
    private String descricao;

    private EItem(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return String.format("%s: (R$ %2.2f)", descricao, valor);
    }
}