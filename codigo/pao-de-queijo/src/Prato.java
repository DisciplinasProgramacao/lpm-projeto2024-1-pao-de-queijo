public abstract class Prato {
    private final double valor;

    /**
     * Construtor da classe Prato.
     * @param valor Valor do prato.
     */
    public Prato(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o valor do prato.
     * @return Valor do prato.
     */
    public double getValor() {
        return valor;
    }
}
