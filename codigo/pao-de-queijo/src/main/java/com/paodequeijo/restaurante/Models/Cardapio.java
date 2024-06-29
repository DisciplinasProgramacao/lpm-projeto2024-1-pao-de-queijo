package com.paodequeijo.restaurante.Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Cardapio {
    //#region Atributos
       protected List<EItem> meusItens;
    // #endregion

    // #region Contrutor
    public Cardapio() {
        meusItens = new ArrayList<>();
        inicializarItens();
    }
    // #endregion

    // #region Métodos
    /**
     * Inicializa os itens do cardápio.
     */
    private void inicializarItens() {
        for (EItem item : EItem.values()) {
            meusItens.add(item);
        }
    }

    /**
     * Mostra o cardápio.
     * @return Cardápio.
     */
    public abstract String exibirCardapio();

    /**
     * Retorna o Item correspondente ao numero escolhido.
     * @param opcao
     * @return
     */
    public EItem itemEscolhido(int opcao) {
        int pos = opcao - 1;
        return meusItens.get(pos);
    }
    // #endregion
}
