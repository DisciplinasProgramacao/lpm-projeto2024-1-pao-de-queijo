package com.paodequeijo.restaurante.Models;

/**
 * Representa uma requisição de um cliente em um restaurante.
 */
public class Requisicao {

    // #region atributos de classe
    private static int ultimoId = 0;
    //// #endregion

    // #region atributos
    private int id;
    private int quantPessoas;
    private Cliente cliente;
    private Mesa mesa;
    private Pedido pedido;
    // #endregion

    // #region Construtor
    /**
     * Construtor da classe Requisicao.
     * 
     * @param quantPessoas Quantidade de pessoas na requisição.
     * @param cliente      Cliente que fez a requisição.
     */
    public Requisicao(int quantPessoas, Cliente cliente, Pedido pedido) {
        this.id = ++ultimoId;
        this.quantPessoas = quantPessoas;
        this.cliente = cliente;
        this.mesa = null;
        this.pedido = pedido;
    }
    // #endregion

    // #region Getters
    public Mesa getMesa() {
        return mesa;
    }

    public Pedido getPedido() {
        return pedido;
    }
    // #endregion

    // #region Métodos
    /**
     * Associa uma mesa à requisição.
     * 
     * @param mesa Mesa a ser associada à requisição.
     */
    public void associarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.setDisponivel(false);
    }

    /**
     * Localiza um item no cardápio associado à requisição.
     * 
     * @param idItem Identificador do item a ser localizado.
     * @return Item localizado.
     */
    public EItem localizarItem(int idItem) {
        return pedido.cardapio.itemEscolhido(idItem);
    }

    /**
     * Adiciona um item ao pedido associado à requisição.
     * 
     * @param item Item a ser adicionado ao pedido.
     */
    public String adicionarItemAoPedido(EItem item) {
        return this.pedido.adicionarItem(item);
    }

    /**
     * Finaliza a requisição, definindo a hora de saída e marcando como finalizada.
     * 
     */
    public void finalizar() {
        this.mesa.setDisponivel(true);
        this.pedido.calcularTotal();
    }

    /**
     * Calcula o valor total do pedido.
     * 
     * @return Valor total do pedido.
     */
    public double calcularTotal() {
        return this.pedido.calcularTotal();
    }

    @Override
    public String toString() {
        if (mesa == null || pedido == null) {
            return "\nRequisição " + id + " em espera para " + quantPessoas + " pessoas | Cliente: "
                    + cliente.getNome();
        } else {
            return "\nRequisição " + id + " na mesa " + mesa.getNumero() + " com " + quantPessoas
                    + " pessoas | Cliente: " + cliente.getNome() + " | Total a pagar: R$ "
                    + pedido.calcularTotal() + " | Total por pessoa: R$ " + pedido.calcularValorPorPessoa(quantPessoas);
        }
    }
    // #endregion
}
