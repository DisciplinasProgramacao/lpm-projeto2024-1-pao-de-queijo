package com.paodequeijo.restaurante.Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
    // #region Atributos
    protected static final double GORJETA = 1.1;
    protected List<EItem> itens;
    protected double total;
    public Mesa quantPessoas;
    public Cardapio cardapio;
    // #endregion

    // #region Construtor
    /**
     * Construtor da classe Pedido.
     */
    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = 0;
    }
    // #endregion

    // #region Métodos
    /**
     * Adiciona um item ao pedido.
     * 
     * @param item Item a ser adicionado.
     * @return Mensagem de confirmação.
     */
    public abstract String adicionarItem(EItem item);

    /**
     * Calcula o total do pedido com gorjeta.
     * 
     * @return Total do pedido com gorjeta.
     */
    public abstract double calcularTotal();

    /**
     * Calcula o valor por pessoa.
     * 
     * @param quantPessoas Quantidade de pessoas.
     * @return Valor por pessoa.
     */
    public double calcularValorPorPessoa(int quantPessoas) {
        return calcularTotal() / quantPessoas;
    }
    // #endregion

    /**
     * Exibe o cardápio
     */
    public String exibirCardapio() {
        return cardapio.mostrarMenu();
    }
}
