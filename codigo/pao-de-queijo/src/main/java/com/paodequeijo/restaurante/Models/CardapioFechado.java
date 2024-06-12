package com.paodequeijo.restaurante.Models;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CardapioFechado {
    //#region Atributos
    private Item[] itens;
    //#endregion

    //#region Contrutor
    public CardapioFechado() {
        this.itens = inicializarItens();
    }
    //#endregion

    //#region Métodos de negócio
    private Item[] inicializarItens() {
        return new Item[] {
          
            new CopoDeSuco(),
            new RefrigeranteOrganico(),
            new CervejaVegana(),
            new FalafelAssado(),
            new CaçarolaDeLegumes(),
        };
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