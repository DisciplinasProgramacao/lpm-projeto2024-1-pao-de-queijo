package main.java.com.paodequeijo.restaurante.Models;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Pedido pedido;
    //#endregion

    //#region Contrutor
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
    //#endregion

    //#region Getters e Setters
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

    public Pedido getPedido() {
        return pedido;
    }
    //#endregion

    //#region Métodos
    /**
     * Associa uma mesa à requisição.
     * 
     * @param mesa Mesa a ser associada à requisição.
     */
    public void associarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.setDisponivel(false);
    }

    /**
     * Associa um pedido à requisição.
     * 
     * @param pedido Pedido a ser associado à requisição.
     */
    public void associarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Retorna o pedido associado a requisicao
     * 
     * @return Pedido da requisição
     */
    public Pedido localizarPedido() {
        return pedido;
    }

    /**
     * Finaliza a requisição, definindo a hora de saída e marcando como finalizada.
     */
    public void finalizar() {
        this.horaSaida = LocalDateTime.now();
        this.atendida = true;
        this.mesa.setDisponivel(true);
    }

    @Override
    public String toString() {
        if (mesa == null) {
            return "\nRequisição " + id + " em espera para " + quantPessoas + " pessoas | Cliente: " + cliente.getNome();
        } else {
            return "\nRequisição " + id + " na mesa " + mesa.getNumero() + " com " + quantPessoas + " pessoas | Cliente: " + cliente.getNome();
        }
    }
    //#endregion
}