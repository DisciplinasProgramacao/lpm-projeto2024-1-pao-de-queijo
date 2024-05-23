package com.paodequeijo.restaurante.Models;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um pedido feito em uma mesa de restaurante.
 */
public class Pedido {
    //#region Atributos
    private static final double GORJETA = 1.1;
    private List<Item> itens;
    private double total;
    public Mesa quantPessoas;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Pedido.
     */
    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = 0;
    }
    //#endregion

    //#region Métodos
    /**
     * Adiciona um item ao pedido.
     * 
     * @param item Item a ser adicionado.
     * @return Mensagem de confirmação.
     */
    public String adicionarItem(Item item) {
        itens.add(item);
        this.total += item.getValor();
        return String.format("%s adicionado(a) com sucesso ao pedido.", item.descricao);
    }

    /**
     * Calcula o total do pedido com gorjeta.
     * 
     * @return Total do pedido com gorjeta.
     */
    public double calcularTotal() {
        return this.total * GORJETA;
    }

    /**
     * Calcula o valor por pessoa.
     * 
     * @param quantPessoas Quantidade de pessoas.
     * @return Valor por pessoa.
     */
    public double calcularValorPorPessoa(int quantPessoas) {
        return calcularTotal() / quantPessoas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        for (Item item : itens) {
            sb.append(item.descricao).append(" = R$").append(item.valor).append("\n");
        }
        sb.append("Total (com gorjeta): R$").append(String.format("%.2f", calcularTotal())).append("\n");
        return sb.toString();
    }
    //#endregion
}
