public abstract class Bebida {
    private final double valor;

    /**
     * Construtor da classe Bebida.
     * @param valor Valor da bebida.
     */
    public Bebida(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o valor da bebida.
     * @return Valor da bebida.
     */
    public double getValor() {
        return valor;
    }
}