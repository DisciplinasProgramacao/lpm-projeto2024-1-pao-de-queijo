package com.paodequeijo.restaurante.Models;
public abstract class Item {
    //#region Atributos
    protected EItem item;
    //#endregion

    //#region Construtor
    /** Construtor do Item
     */
    public Item(EItem item) {
        this.item = item;
    }
    //#endregion

    @Override
    public String toString() {
        return item.toString();
    }
    //#endregion
}
