package com.paodequeijo.restaurante.Models;

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
    
    public String mostrarMenu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itens.length; i++) {
            sb.append((i+1) + ": " + itens[i].descricao);
            sb.append("\n");
        }
        
        return sb.toString();
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