package com.paodequeijo.restaurante.Models;

import java.util.stream.Collectors;

public class CardapioAberto extends Cardapio {
    // //#region Contrutor
    public CardapioAberto() {
        super();
    }
    //#endregion

    // #region Métodos de negócio
    @Override
    public String mostrarMenu() {
        return meusItens.stream()
                        .map(item -> (meusItens.indexOf(item) + 1) + ": " + item)
                        .collect(Collectors.joining("\n"));
    }
    // #endregion
}