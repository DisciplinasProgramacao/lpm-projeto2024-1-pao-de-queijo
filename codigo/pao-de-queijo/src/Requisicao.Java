import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa uma requisição de um cliente em um restaurante.
 */
public class Requisicao {
        
     private int id;
     private Date data;
     private int quantClientes;
     private LocalDateTime horaSaida;
     private Cliente cliente;
     private boolean atendida;
     private Mesa mesa;
 
     /**
      * Construtor da classe Requisicao.
      * @param id Identificador da requisição.
      * @param data Data da requisição.
      * @param horaEntrada Hora de entrada do cliente no restaurante.
      * @param cliente Cliente que fez a requisição.
      */
     public Requisicao( int quantClientes, Cliente cliente) {
         this.quantClientes = quantClientes;
         this.cliente = cliente;
         this.atendida = false;
         this.mesa = null;
     }

    public int getId() {
         return id;
     }

     public int getquantClientes(){
        return quantClientes;
        
     }
 
     public Cliente getCliente() {
         return cliente;
     }
 
     public boolean isAtendida() {
         return atendida;
     }
 
     public LocalDateTime getHoraSaida() {
         return horaSaida;
     }
 
     public Mesa getMesa() {
         return mesa;
     }
 
     /**
      * Associa uma mesa à requisição.
      * @param mesa Mesa a ser associada à requisição.
      */
     public void associarMesa(Mesa mesa) {
         this.mesa = mesa;
     }

    /**
     * Finaliza a requisição, definindo a hora de saída e marcando como finalizada.
     * @param localDateTime Hora em que o cliente saiu do restaurante.
     */
    public void finalizar(LocalDateTime localDateTime) {
        this.horaSaida = localDateTime;
        this.atendida = true;
        this.mesa.setDisponivel(true);
    }
}