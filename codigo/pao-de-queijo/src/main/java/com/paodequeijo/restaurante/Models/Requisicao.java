package com.paodequeijo.restaurante.Models;

import java.time.LocalDateTime;

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
    private LocalDateTime horaSaida;
    private Cliente cliente;
    private boolean atendida;
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
    public Requisicao(int quantPessoas, Cliente cliente) {
        this.id = ++ultimoId;
        this.quantPessoas = quantPessoas;
        this.cliente = cliente;
        this.atendida = false;
        this.mesa = null;
        this.pedido =null;
    }
    // #endregion

    // #region Getters e Setters
    public int getId() {
        return id;
    }

    public int getQuantPessoas() {
        return quantPessoas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

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
     * Adiciona um item ao pedido associado à requisição.
     * 
     * @param item Item a ser adicionado ao pedido.
     */
    public void adicionarItemAoPedido(EItem item) {
        this.pedido.adicionarItem(item);
    }

    /**
     * Finaliza a requisição, definindo a hora de saída e marcando como finalizada.
     * 
     * @param horaSaida2
     */
    public void finalizar() {
        this.horaSaida = LocalDateTime.now();
        this.atendida = true;
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
                    + " pessoas | Cliente: " + cliente.getNome() + "O valor total a pagar é de R$ "
                    + pedido.calcularTotal() + "o total por pessoa é de " + pedido.calcularValorPorPessoa(quantPessoas);
        }
    }
    // #endregion

}
