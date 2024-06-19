package com.paodequeijo.restaurante.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cardapio {
    // #region Atributos
    private List<EItem> meusItens;
    // #endregion

    // #region Contrutor
    public Cardapio() {
        meusItens = new ArrayList<>();
        inicializarItens();
    }
    // #endregion

    // #region Métodos de negócio
    private void inicializarItens() {
        for (EItem item : EItem.values()) {
            meusItens.add(item);
        }
    }

    public String mostrarMenu() {
        return meusItens.stream()
                        .map(item -> (meusItens.indexOf(item) + 1) + ": " + item)
                        .collect(Collectors.joining("\n"));
    }


    /**
     * Retorna o Item correspondente ao numero escolhido.
     * 
     * @param opcao
     * @return
     */
    public EItem itemEscolhido(int opcao) {
        int pos = opcao - 1;
        return meusItens.get(pos);
    }
    // #endregion
}