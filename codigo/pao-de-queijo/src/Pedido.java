import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //#region Atributos
    private static final double GORJETA = 1.1;
    private static List<Item> itens;
    private final Requisicao requisicao;
    private double total;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Pedido.
     * @param cardapio Cardápio com os pratos e bebidas disponíveis.
     * @param mesa Mesa que está fazendo o pedido.
     */
    public Pedido(Requisicao requisicao) {
        Pedido.itens = new ArrayList<>();
        this.requisicao = requisicao;
        this.total = 0;
    }
    //#endregion

    //#region Métodos
    /**
     * Adiciona um item do cardápio ao pedido
     * @param prato
     * @param conta
     */
    public void adicionarItem(Item item) {
        itens.add(item);
        this.total += item.getValor();
    }

    /**
     * Calcula a conta final do pedido.
     * @return Valor total do pedido com a taxa de 10%.
     */
    public double calcularTotal() {
        return this.total * GORJETA;
    }

    /**
     * Calcula o valor final a ser pago por pessoa na mesa.
     * @return Valor a ser pago por pessoa.
     */
    public double calcularValorPorPessoa() {
        return calcularTotal() / requisicao.getMesa().getCapacidade();
    }

    @Override
    public String toString() {
        return "";
    }
    //#endregion
}
