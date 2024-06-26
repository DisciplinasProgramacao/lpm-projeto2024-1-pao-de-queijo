package com.paodequeijo.restaurante.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardapioFechado extends Cardapio {
    //#region Atributos
    private List<EItem> meusPratos;
    private List<EItem> minhasBebidas;
    // #endregion

    // #region Contrutor
    public CardapioFechado() {
        super();
        meusPratos = new ArrayList<>();
        minhasBebidas = new ArrayList<>();

        meusPratos = meusItens.stream()
                              .limit(2)
                              .collect(Collectors.toList());

        minhasBebidas = meusItens.stream()
                                 .skip(2)
                                 .limit(3)
                                 .collect(Collectors.toList());
    }
    // #endregion

    // #region Métodos
    @Override    
    public String exibirCardapio() {
        StringBuilder sb = new StringBuilder();

        String strPratos = meusPratos.stream()
                                      .map(item -> (meusItens.indexOf(item) + 1) + ": " + item)
                                      .collect(Collectors.joining("\n"));

        String strBebidas = minhasBebidas.stream()
                                         .map(item -> (meusItens.indexOf(item) + 1) + ": " + item)
                                         .collect(Collectors.joining("\n"));

        sb.append("\n   Opções de pratos: \n");
        sb.append(strPratos).append("\n");
        sb.append("\n");
        sb.append("   Opções de bebidas: \n");
        sb.append(strBebidas).append("\n");

        return sb.toString();
    }
    // #endregion
}