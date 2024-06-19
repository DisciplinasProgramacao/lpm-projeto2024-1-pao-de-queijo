package com.paodequeijo.restaurante.Models;

import java.util.List;

public class PedidoFechado extends Pedido {
    
    private static final double VALOR_MENU_FECHADO = 32.00;

    static final List<String> PRATOS = List.of("Falafel assado", "Caçarola de legumes");
    static final List<String> BEBIDAS = List.of("Copo de suco", "Cerveja vegana", "Refrigerante orgânico");

    private boolean pratoEscolhido;
    private boolean bebidaEscolhida;

    public PedidoFechado() {
        super();
        this.pratoEscolhido = false;
        this.bebidaEscolhida = false;
    }

    @Override
    public String adicionarItem(EItem item) {
        if (PRATOS.contains(item.getDescricao()) && !pratoEscolhido) {
            pratoEscolhido = true;
        } else if (BEBIDAS.contains(item.getDescricao()) && !bebidaEscolhida) {
            bebidaEscolhida = true;
        } else {
            throw new IllegalArgumentException("Item inválido ou já escolhido.");
        }
        super.adicionarItem(item);
        return String.format("%s adicionado(a) com sucesso ao pedido do Menu Fechado.", item.getDescricao());
    }

    @Override
    public double calcularTotal() {
        return VALOR_MENU_FECHADO * GORJETA;
    }
}
