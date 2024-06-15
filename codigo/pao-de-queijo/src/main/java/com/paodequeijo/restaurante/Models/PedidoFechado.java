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
    public String adicionarItem(Item item) {
        if (PRATOS.contains(item.descricao) && !pratoEscolhido) {
            pratoEscolhido = true;
        } else if (BEBIDAS.contains(item.descricao) && !bebidaEscolhida) {
            bebidaEscolhida = true;
        } else {
            throw new IllegalArgumentException("Item inválido ou já escolhido.");
        }
        super.adicionarItem(item);
        return String.format("%s adicionado(a) com sucesso ao pedido do Menu Fechado.", item.descricao);
    }

    @Override
    public double calcularTotal() {
        return VALOR_MENU_FECHADO * GORJETA;
    }

    @Override
    public double calcularDesconto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularDesconto'");
    }
}
