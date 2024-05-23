package main.java.com.paodequeijo.restaurante.Models;
import java.util.ArrayList;
import java.util.List;

import main.java.com.paodequeijo.restaurante.Models.Cardapio;
import main.java.com.paodequeijo.restaurante.Models.Requisicao; 

/**
 * Representa o Restaurante
 */
public class Restaurante {

    //#region Atributos
    private String nome;
    private List<Cliente> clientes;
    private List<Mesa> mesas;
    private static List<Requisicao> requisicoesPendentes;
    private static List<Requisicao> requisicoesAtendidas;
    private static List<Requisicao> requisicoesFinalizadas;
    private static List<Requisicao> todasRequisicoes;
    private Cardapio cardapio;
    //#endregion

    //#region Construtor
    /**
     * Construtor da classe Restaurante.
     * @param nome Nome do Restaurante
     * @param clientes Lista de clientes
     * @param mesas  Lista de mesas
    */
    public Restaurante(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.cardapio = new Cardapio();
        criarMesas();

        Restaurante.requisicoesPendentes = new ArrayList<>();
        Restaurante.requisicoesAtendidas = new ArrayList<>();
        Restaurante.requisicoesFinalizadas = new ArrayList<>();
        Restaurante.todasRequisicoes = new ArrayList<>();
    }
    //#endregion

    //#region Geters
    public String getNome() {
        return nome;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public List<Requisicao> getRequisicoesPendentes() {
        return requisicoesPendentes;
    }

    public List<Requisicao> getRequisicoesAtendidas() {
        return requisicoesAtendidas;
    }

    public List<Requisicao> getRequisicoesFinalizadas() {
        return requisicoesFinalizadas;
    }

    public List<Requisicao> getTodasRequisicoes() {
        return todasRequisicoes;
    }
    //#endregion

    //#region Métodos
    
    /**
     * Chama o método de gerar as mesas 
     * do restaurante que possui:
     * 4 mesas para 4 pessoas,
     * 4 mesas para 6 pessoas,
     * 2 mesas para 8 pessoas
     */
    private void criarMesas() {
        gerarMesas(4, 4);
        gerarMesas(6, 4);
        gerarMesas(8, 2);
    }

    /**
     * Popula a lista de mesas
     * @param capacidade Valor da capacidade das mesas que serão geradas
     * @param quantidade Valor da quantidade de mesas a serem geradas
     */
    private void gerarMesas(int capacidade, int quantidade) {
        for (int i = 1; i <= quantidade; i++) {
            mesas.add(new Mesa(capacidade));
        }
    }

    /**
     * Imprime a lista de mesas
     * @return String com a lista das mesas
     */
    public String imprimirMesas() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < this.mesas.size(); i++) {
            sb.append("Mesa " + mesas.get(i).getNumero() + " | Capacidade: " + mesas.get(i).getCapacidade() + " | Disponivel: " + mesas.get(i).isDisponivel());
            sb.append("\n");
        }
        
        return sb.toString();
    }

    /**
      * Salva um novo cliente na lista
      * @param cliente cliente a salvo
      */
    public void salvarNovoCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
      * Verifica se o cliente é cadastrado
      * @param documento É utilizado para a busca
      */
    public Cliente buscarCliente(long documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                return cliente;
            }
        }

        return null;
    }

    /**
      * Cria uma Requisição
      * @param cliente É atribuido à Requisição
      * @param quantPessoas É utilizado para buscar uma mesa disponível de acordo com a capacidade
      */
    public Requisicao criarRequisicao(Cliente cliente, int quantPessoas) {
        Requisicao requisicao = new Requisicao(quantPessoas, cliente);
        todasRequisicoes.add(requisicao);

        Mesa mesaDisponivel = procurarMesa(quantPessoas);
        if (mesaDisponivel != null) {
            requisicao.associarMesa(mesaDisponivel);
            requisicoesAtendidas.add(requisicao);
        } else {
            requisicoesPendentes.add(requisicao);
        }
        
        return requisicao;
    }

    /**
      * Busca uma mesa disponível
      * @param quantPessoas É utilizado para a buscar a mesa de acordo com a capacidade
      */
    private Mesa procurarMesa(int quantPessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.atendeRequisicao(quantPessoas)) {
                return mesa;
            }
        }

        return null;
    }
    /**
      * Exibe o cardápio
      */
    public String exibirCardapio() {
        return cardapio.mostrarMenu();
    }
    /**
      * Adiciona um item ao pedido de uma requisição
      * @param requisicao Idica qual Requisição 
        @param item Idica qual o item 
      */
    public void adicionarItemAoPedido(int mesa, int idItem) {
        Item item = cardapio.itemEscolhido(idItem);
        Requisicao req = localizarAtendida(mesa);
        if(req != null){
            req.adicionarItemAoPedido(item);
        }
    }

    /**
      * Finaliza uma Requisição
      * @param mesa Número da mesa 
      */
    public String finalizarRequisicao(int mesa) {
        Requisicao requisicao = localizarAtendida(mesa);
        requisicao.finalizar();
        requisicoesAtendidas.remove(requisicao);
        requisicoesFinalizadas.add(requisicao);

        return requisicao.toString();
    }

    /**
     * Localiza uma requisição atendida
     * @param numero Número da mesa
     * @return Retorna a requisição
     */
    public Requisicao localizarAtendida(int mesa) {
        for (Requisicao req : requisicoesAtendidas) {
            if (req.getMesa().getNumero() == mesa) {
                return req;
            }
        }
        return null;
    }
}