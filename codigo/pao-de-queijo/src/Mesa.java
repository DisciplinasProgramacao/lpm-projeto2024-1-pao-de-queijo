/**
 * Representa uma mesa no restaurante
*/
public class Mesa{
    //#region atributos de classe
    private static int ultimoNumero = 0;
    ////#endregion

    public int numero;
    public int capacidade;
    private boolean disponivel;
    
    /**
     * Construtor da classe Mesa.
     * @param numero Numero da mesa
     * @param capacidade Capacidade da mesa
     * @param disponivel Mostra se a mesa esta disponivel (diponivel = true) ou não (disponivel = false)
    */
    public Mesa(int capacidade, boolean disponivel) {
        this.numero = ++ultimoNumero;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

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

}