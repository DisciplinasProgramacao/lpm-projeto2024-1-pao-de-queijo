package com.paodequeijo.restaurante.Models;
public abstract class Item {
    //#region Atributos
    protected EItem item;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Bebida.
     * @param valor Valor da bebida.
     */
    public Item(EItem item) {
        this.item = item;
    }
    //#endregion

    //#region Métodos de negócio
    public double getValor() {
        return item.getValor();
    }

    @Override
    public String toString() {
        return item.toString();
    }
    //#endregion
}
