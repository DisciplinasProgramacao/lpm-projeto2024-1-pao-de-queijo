import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa uma requisição de um cliente em um restaurante.
 */
public class Requisicao {

    //#region atributos de classe
    private static int ultimoId = 0;
    ////#endregion

    //#region atributos
    private int id;
    private Date data;
    private int quantPessoas;
    private LocalDateTime horaSaida;
    private Cliente cliente;
    private boolean atendida;
    private Mesa mesa;
    //#endregion

    /**
     * Construtor da classe Requisicao.
     * 
     * @param id          Identificador da requisição.
     * @param data        Data da requisição.
     * @param horaEntrada Hora de entrada do cliente no restaurante.
     * @param cliente     Cliente que fez a requisição.
     */
    public Requisicao(int quantPessoas, Cliente cliente) {
        this.id = ++ultimoId;
        this.quantPessoas = quantPessoas;
        this.cliente = cliente;
        this.atendida = false;
        this.mesa = null;
    }

    public int getId() {
        return id;
    }

    public int getquantPessoas() {
        return quantPessoas;

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
     * 
     * @param mesa Mesa a ser associada à requisição.
     */
    public void associarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.setDisponivel(false);
    }

    @Override
    public String toString() {
        if (mesa == null) {
            return "Requisição " + id + " em espera para " + quantPessoas + " clientes";
        } else {
            return "Requisição " + id + " na mesa " + mesa.getNumero() + " com " + quantPessoas + " clientes";
        }
    }

    /**
     * Finaliza a requisição, definindo a hora de saída e marcando como finalizada.
     * 
     * @param localDateTime Hora em que o cliente saiu do restaurante.
     */
    public void finalizar(LocalDateTime localDateTime) {
        this.horaSaida = localDateTime;
        this.atendida = true;
        this.mesa.setDisponivel(true);
    }
}