package com.paodequeijo.restaurante.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardapioFechado {
    //#region Atributos
       private List<EItem> meusItens;
    // #endregion
    //#endregion

    //#region Contrutor
    public CardapioFechado() {
       meusItens = new ArrayList<>();
        inicializarItens();
    }
    //#endregion

    //#region Métodos de negócio
    private void inicializarItens() {
        for (EItem item : EItem.values()) {
            meusItens.add(item);
        }
    }

   
    
    public String mostrarMenu() {
        return Arrays.stream(itens)
                     .map(item -> (Arrays.asList(itens).indexOf(item) + 1) + ": " + item.descricao)
                     .collect(Collectors.joining("\n"));
    }

    /**
     * Retorna o Item correspondente ao numero escolhido.
     * @param opcao
     * @return
     */
    public Item itemEscolhido(int opcao){
        int pos = opcao - 1;
        return itens[pos];
    }
    //#endregion
}