package com.paodequeijo.restaurante.Models;
public abstract class Item {
    //#region Atributos
    protected double valor;
    protected String descricao;
    protected int id;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Bebida.
     * @param valor Valor da bebida.
     */
    public Item(double valor, String descricao, int id) {
        this.valor = valor;
        this.descricao = descricao;
        this.id = id;
    }
    //#endregion

    //#region Métodos de negócio
    public double getValor() {
        return valor;
    }
    public int getId(){
        return id;
    }
    @Override
    public String toString() {
        return String.format("%s: (R$ %2.2f)", descricao, valor);
    }
    //#endregion
}
