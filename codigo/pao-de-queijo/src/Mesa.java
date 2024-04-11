/**
 * Representa uma mesa no restaurante
*/
public class Mesa{
    public int numero;
    private int capacidade;
    private boolean disponivel;
    
    
    
    /**
     * Construtor da classe Mesa.
     * @param numero Numero da mesa
     * @param capacidade Capacidade da mesa
     * @param disponivel Mostra se a mesa esta disponivel (diponivel = true) ou não (disponivel = false)
     * 
     */

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getCapacidade() {
        return this.capacidade;
    }
    
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    public boolean isDisponivel() {
        return this.disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}