public class Pedido {
    private static int id;
    private Cardapio cardapio;
    private Mesa mesa;
    private Requisicao requisicao;
    private double total;

    public static int setId() {
        id = id+1;
        return id;
    }
    public static int getId() {
        return id;
    }

    /**
     * Construtor da classe Pedido.
     * @param cardapio Cardápio com os pratos e bebidas disponíveis.
     * @param mesa Mesa que está fazendo o pedido.
     */
    public Pedido(Cardapio cardapio, Mesa mesa, Requisicao requisicao) {
        this.cardapio = cardapio;
        this.mesa = mesa;
        this.requisicao = requisicao;
        this.total = 0;
    }

    /**
     * Adiciona um prato ao pedido.
     * @param prato Prato a ser adicionado.
     */
    public void adicionarPrato(Prato prato) {
        this.total += prato.getValor();
    }

    /**
     * Adiciona uma bebida ao pedido.
     * @param bebida Bebida a ser adicionada.
     */
    public void adicionarBebida(Bebida bebida) {
        this.total += bebida.getValor();
    }

    /**
     * Calcula a conta final do pedido.
     * @return Valor total do pedido com a taxa de 10%.
     */
    public double calcularContaFinal() {
        return this.total * 1.10;
    }

    /**
     * Calcula o valor final a ser pago por pessoa na mesa.
     * @return Valor a ser pago por pessoa.
     */
    public double calcularValorPorPessoa() {
        return calcularContaFinal() / mesa.getCapacidade();
    }
}
