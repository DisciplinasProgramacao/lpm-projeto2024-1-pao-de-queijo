package com.paodequeijo.restaurante.Models;

public class PedidoFechado extends Pedido {
    // #region Atributos
    private static final double VALOR_MENU_FECHADO = 32.00;
    private static int quantMaxPratos;
    private static int quantMaxBebidas;

    private int quantPessoas;
    private int quantPratos;
    private int quantBebidas;
    // #endregion

    // #region Construtor
    /**
     * Construtor da classe Pedido.
     */
    public PedidoFechado(int quantPessoas) {
        super();
        this.cardapio = new CardapioFechado();
        this.quantPessoas = quantPessoas;
        this.quantPratos = 0;
        this.quantBebidas = 0;

        PedidoFechado.quantMaxPratos = quantPessoas;
        PedidoFechado.quantMaxBebidas = quantPessoas * 2;
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
        if (item == EItem.FALAFEL_ASSADO || item == EItem.CAÇAROLA_DE_LEGUMES) {
            if (quantPratos < quantMaxPratos) {
                itens.add(item);
                quantPratos++;
                this.total += item.getValor();
                return item.toString() + " | adicionado com sucesso.";
            } else {
                return "Quantidade máxima de pratos atingida.";
            }

        } else if (item == EItem.COPO_DE_SUCO || item == EItem.REFRIGERANTE_ORGANICO || item == EItem.CERVEJA_VEGANA) {
            if (quantBebidas < quantMaxBebidas) {
                itens.add(item);
                quantBebidas++;
                this.total += item.getValor();
                return item.toString() + " | adicionado com sucesso.";
            } else {
                return "Quantidade máxima de bebidas atingida.";
            }

        } else {
            return "Item inválido.";
        } 
    }

    /**
     * Calcula o total do pedido com gorjeta.
     * 
     * @return Total do pedido com gorjeta.
     */
    @Override
    public double calcularTotal() {
        return VALOR_MENU_FECHADO * quantPessoas * GORJETA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPedido com cardápio fechado para " + quantPessoas + " pessoas: \n");
        for (EItem item : itens) {
            sb.append(item.getDescricao()).append(" = R$").append(item.getValor()).append("\n");
        }
        sb.append("\nTotal (com gorjeta): R$").append(String.format("%.2f", calcularTotal()));

        return sb.toString();
    }
    // #endregion
}