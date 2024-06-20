package com.paodequeijo.restaurante.Models;

import java.util.stream.Collectors;

public class CardapioFechado extends Cardapio {
    // #region Contrutor
    public CardapioFechado() {
        super();
    }
    // #endregion

    // #region Métodos de negócio
    @Override    
    public String mostrarMenu() {
        return meusItens.stream()
        .map(item -> (meusItens.indexOf(item) + 1) + ": " + item)
        .limit((5))
        .collect(Collectors.joining("\n"));
    }
    // #endregion
}