public abstract class Item {
    //#region Atributos
    protected double valor;
    protected String descricao;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Bebida.
     * @param valor Valor da bebida.
     */
    public Item(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
    //#endregion

    //#region Métodos de negócio
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("%s: (R$ %2.2f)", descricao, valor);
    }
    //#endregion
}
