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
    private Date horaEntrada;
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
    public Requisicao(int id, Date data, Date horaEntrada, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.cliente = cliente;
        this.atendida = false;
        this.mesa = null;
    }

    /**
     * Finaliza a requisição, definindo a hora de saída e marcando como finalizada.
     * @param localDateTime Hora em que o cliente saiu do restaurante.
     */
    public void finalizar(LocalDateTime localDateTime) {
        this.horaSaida = localDateTime;
        this.atendida = true;
        Restaurante.requisicoesFinalizadas.add(this);
    }

    /**
     * Associa uma mesa à requisição e move a requisição para a lista de atendidas.
     * @param mesa Mesa a ser associada à requisição.
     */
    public void associarMesa(Mesa mesa) {
        this.mesa = mesa;
        Restaurante.requisicoesAtendidas.add(this);
        Restaurante.requisicoesPendentes.remove(this);
    }
}