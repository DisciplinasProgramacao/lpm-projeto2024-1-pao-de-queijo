package com.paodequeijo.restaurante.Models;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Representa o Restaurante
 */
public class Restaurante {

    //#region Atributos
    private String nome;
    private Map<Long, Cliente> clientes;
    private Map<Integer, Mesa> mesas;
    private static List<Requisicao> requisicoesPendentes;
    private static List<Requisicao> requisicoesAtendidas;
    private static List<Requisicao> requisicoesFinalizadas;
    private static List<Requisicao> todasRequisicoes;
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
      this.clientes = new HashMap<>();
      this.mesas = new HashMap<>();
      criarMesas();

      requisicoesPendentes = new ArrayList<>();
      requisicoesAtendidas = new ArrayList<>();
      requisicoesFinalizadas = new ArrayList<>();
      todasRequisicoes = new ArrayList<>();
    } 
    //#endregion

    //#region Geters
    public String getNome() {
        return nome;
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
      int start = mesas.size() + 1;
      mesas.putAll(
          IntStream.range(start, start + quantidade)
                   .boxed()
                   .collect(Collectors.toMap(i -> i, i -> new Mesa(i)))
      );
    }

    /**
     * Imprime a lista de mesas
     * @return String com a lista das mesas
     */
    public String imprimirMesas() {
      return mesas.values().stream()
                  .map(Mesa::toString)
                  .collect(Collectors.joining("\n"));
    }
 
    /**
      * Salva um novo cliente na lista
      * @param cliente cliente a salvo
      */
      public void salvarNovoCliente(Cliente cliente) {
        clientes.put(cliente.getDocumento(), cliente);
      }

    /**
      * Verifica se o cliente é cadastrado
      * @param documento É utilizado para a busca
      */
      public Cliente buscarCliente(long documento) {
        return clientes.get(documento);
      }

    /**
      * Cria uma Requisição
      * @param cliente É atribuido à Requisição
      * @param quantPessoas É utilizado para buscar uma mesa disponível de acordo com a capacidade
      */
    public Requisicao criarRequisicao(Cliente cliente, int quantPessoas, Pedido pedido) {
        Requisicao requisicao = new Requisicao(quantPessoas, cliente, pedido);
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
      return mesas.values().stream()
                  .filter(mesa -> mesa.atendeRequisicao(quantPessoas))
                  .findFirst()
                  .orElse(null);
    }

    /**
      * Finaliza uma Requisição
      * @param mesa Número da mesa 
      */
      public String finalizarRequisicao(int mesa) {
        try {
            Requisicao requisicao = localizarAtendida(mesa);
            if (requisicao != null) {
                requisicao.finalizar();
                requisicoesAtendidas.remove(requisicao);
                requisicoesFinalizadas.add(requisicao);
                return requisicao.toString();
            }
            return "Requisição não encontrada";
        } catch (Exception e) {
            return "Erro ao finalizar requisição: " + e.getMessage();
        }
      } 

    /**
     * Localiza uma requisição atendida
     * @param numero Número da mesa
     * @return Retorna a requisição
     */
    public Requisicao localizarAtendida(int mesa) {
        return requisicoesAtendidas.stream()
                                   .filter(req -> req.getMesa().getNumero() == mesa)
                                   .findFirst()
                                   .orElse(null);
    }

  /**
   * Localiza uma mesa
   * 
   * @param numero Número da mesa
   * @return Retorna a mesa
   */
  public boolean mesaIsDisponivel(int numero) {
    if (mesas.get(numero) != null) {
      return mesas.get(numero).isDisponivel();
    } else {
      throw new IllegalArgumentException("Mesa não encontrada.");
    }
  }

  /**
     * Adiciona um item ao pedido de uma requisição
     * 
     * @param requisicao Indica qual Requisição
     * @param item       Indica qual o item
     */
    public String adicionarItem(Requisicao requisicao, int idItem) {
      EItem item = requisicao.localizarItem(idItem);
      requisicao.adicionarItemAoPedido(item);
      return "\n" + item.toString() + " | adicionado com sucesso.";
  }
}