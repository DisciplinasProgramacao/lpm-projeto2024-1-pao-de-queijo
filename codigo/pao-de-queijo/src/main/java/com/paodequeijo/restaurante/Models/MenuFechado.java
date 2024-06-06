package com.paodequeijo.restaurante.Models;

import java.util.ArrayList;
import java.util.List;

public class MenuFechado extends Pedido {
    // Valor fixo do menu fechado
    private static final double VALOR_MENU_FECHADO = 32.00;

    // Opções de pratos e bebidas permitidos no menu fechado
    private static final List<String> PRATOS = List.of("Falafel assado", "Caçarola de legumes");
    private static final List<String> BEBIDAS = List.of("Copo de suco", "Cerveja vegana", "Refrigerante orgânico");

    private boolean pratoEscolhido;
    private boolean bebidaEscolhida;

    public MenuFechado() {
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
            return "Item inválido ou já escolhido.";
        }
        super.adicionarItem(item);
        return String.format("%s adicionado(a) com sucesso ao pedido do Menu Fechado.", item.descricao);
    }

    @Override
    public double calcularTotal() {
        if (pratoEscolhido && bebidaEscolhida) {
            return VALOR_MENU_FECHADO * GORJETA;
        } else {
            return 0.0; // ou algum valor que indique que o pedido não está completo
        }
    }
}
