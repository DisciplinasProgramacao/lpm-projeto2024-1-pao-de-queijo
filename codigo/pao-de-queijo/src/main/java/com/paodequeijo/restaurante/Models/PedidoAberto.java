package com.paodequeijo.restaurante.Models;

public class PedidoAberto extends Pedido {
    // #region Construtor
    /**
     * Construtor da classe Pedido.
     */
    public PedidoAberto() {
        super();
        this.cardapio = new CardapioAberto();
    }
    // #endregion

    // #region Métodos
    /**
     * Adiciona um item ao pedido.
     * 
     * @param item Item a ser adicionado.
     * @return Mensagem de confirmação.
     */
    @Override
    public String adicionarItem(EItem item) {
        itens.add(item);
        this.total += item.getValor();
        return item.toString() + " | adicionado com sucesso.";
    }

    /**
     * Calcula o total do pedido com gorjeta.
     * 
     * @return Total do pedido com gorjeta.
     */
    @Override
    public double calcularTotal() {
        return this.total * GORJETA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPedido com cardápio aberto:\n");
        for (EItem item : itens) {
            sb.append(item.getDescricao()).append(" = R$").append(item.getValor()).append("\n");
        }
        sb.append("\nTotal (com gorjeta): R$").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }
    // #endregion
}
