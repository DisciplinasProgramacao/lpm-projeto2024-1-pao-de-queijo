/**
 * Representa uma mesa no restaurante
*/
public class Mesa{
    //#region Atributos de classe
    private static int ultimoNumero = 0;
    //#endregion

    //#region Atributos
    private int numero;
    private int capacidade;
    private boolean disponivel;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Mesa.
     * @param numero Numero da mesa
     * @param capacidade Capacidade da mesa
     * @param disponivel Mostra se a mesa esta disponivel (diponivel = true) ou não (disponivel = false)
    */
    public Mesa(int capacidade) {
        this.numero = ++ultimoNumero;
        this.capacidade = capacidade;
        this.disponivel = true;
    }
    //#endregion

    //#region Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    //#endregion

    //#region Métodos
    public boolean atendeRequisicao(int quantPessoas) {
        boolean atende = false;

        if (this.disponivel && this.capacidade >= quantPessoas) {
            atende = true;
        }

        return atende;
    }
    //#endregion
}