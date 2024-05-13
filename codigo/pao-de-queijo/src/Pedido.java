import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //#region Atributos
    private static final double GORJETA = 1.1;
    private static List<Item> itens;
    private Requisicao requisicao;
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
    public String adicionarItem(Item item) {
        itens.add(item);
        this.total += item.getValor();

        return String.format("%s adicionado(a) com sucesso ao pedido da mesa %d.", item.descricao, requisicao.getMesa().getNumero());
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
        StringBuilder sb = new StringBuilder();
        sb.append("\nMesa " + requisicao.getMesa().getNumero() + ": \n");

        for (int i = 0; i < this.itens.size(); i++) {
            sb.append(itens.get(i).descricao + " = R$" + itens.get(i).getValor());
            sb.append("\n");
        }
        
        return sb.toString();
    }
    //#endregion
}
