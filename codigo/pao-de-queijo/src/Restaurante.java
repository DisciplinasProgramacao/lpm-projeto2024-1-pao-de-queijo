import java.util.ArrayList;
import java.util.List; 

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
        adicionarATodas(requisicao);

        Mesa mesaDisponivel = procurarMesa(quantPessoas);
        if (mesaDisponivel != null) {
            requisicao.associarMesa(mesaDisponivel);
            adicionarRequisicaoAtendida(requisicao);
        } else {
            adicionarRequisicaoPendente(requisicao);
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
      * Finaliza uma Requisição
      * @param mesa Número da mesa 
      */
    public String finalizarRequisicao(int mesa) {
        Requisicao requisicao = localizarAtendida(mesa);
        requisicao.finalizar();
        removerRequisicaoAtendida(requisicao);
        adicionarRequisicaoFinalizada(requisicao);

        return "Requisição " + requisicao.getId() + " finalizada com sucesso, " + "mesa " + requisicao.getMesa().getNumero() + " liberada.";
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

    //#region Métodos das listas de requisicoes
    /**
     * Adiciona uma requisição à lista de requisições pendentes
     * @param requisicao
     */
    private void adicionarRequisicaoPendente(Requisicao requisicao) {
        requisicoesPendentes.add(requisicao);
    }

    /**
     * Remove uma requisição à lista de requisições pendentes
     * @param requisicao
     */
    private void removerRequisicaoPendente(Requisicao requisicao) {
        requisicoesPendentes.remove(requisicao);
    }

    /**
     * Adiciona uma requisição à lista de requisições atendidas
     * @param requisicao
     */
    private void adicionarRequisicaoAtendida(Requisicao requisicao) {
        requisicoesAtendidas.add(requisicao);
    }

    /**
     * Remove uma requisição à lista de requisições atendidas
     * @param requisicao
     */
    private void removerRequisicaoAtendida(Requisicao requisicao) {
        requisicoesAtendidas.remove(requisicao);
    }

    /**
     * Adiciona uma requisição à lista de requisições finalizadas
     * @param requisicao
     */
    public void adicionarRequisicaoFinalizada(Requisicao requisicao) {
        requisicoesFinalizadas.add(requisicao);
    }

    /**
     * Remove uma requisição à lista de requisições finalizadas
     * @param requisicao
     */
    public void removerRequisicaoFinalizada(Requisicao requisicao) {
        requisicoesFinalizadas.remove(requisicao);
    }

    /**
     * Adiciona uma requisição à lista de requisições finalizadas
     * @param requisicao
     */
    public void adicionarATodas(Requisicao requisicao) {
        todasRequisicoes.add(requisicao);
    }
    //#endregion
}