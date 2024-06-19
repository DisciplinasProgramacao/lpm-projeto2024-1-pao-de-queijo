package com.paodequeijo.restaurante.Models;

public class PedidoAberto extends Pedido {
    // #region Construtor
    /**
     * Construtor da classe Pedido.
     */
    public PedidoAberto() {
        super();
    }
    // #endregion

    // #region Métodos
    /**
     * Adiciona um item ao pedido.
     * 
     * @param item Item a ser adicionado.
     * @return Mensagem de confirmação.
     */
    public String adicionarItem(EItem item) {
        itens.add(item);
        this.total += item.getValor();
        return String.format("%s adicionado(a) com sucesso ao pedido.", item.getDescricao());
    }

    /**
     * Calcula o total do pedido com gorjeta.
     * 
     * @return Total do pedido com gorjeta.
     */
    public double calcularTotal() {
        return this.total * GORJETA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        for (EItem item : itens) {
            sb.append(item.getDescricao()).append(" = R$").append(item.getValor()).append("\n");
        }
        sb.append("Total (com gorjeta): R$").append(String.format("%.2f", calcularTotal())).append("\n");
        return sb.toString();
    }
    // #endregion
}
