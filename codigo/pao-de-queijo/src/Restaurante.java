import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List; 

/**
 * Representa o Restaurante
 */
public class Restaurante {

    private String nome;
    private List<Cliente> clientes;
    private List<Mesa> mesas;
    public static List<Requisicao> requisicoesPendentes;
    public static List<Requisicao> requisicoesAtendidas;
    public static List<Requisicao> requisicoesFinalizadas;

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

        this.mesas.addAll(gerarMesas(4, 4));
        this.mesas.addAll(gerarMesas(6, 4));
        this.mesas.addAll(gerarMesas(8, 2));
        Restaurante.requisicoesPendentes = new ArrayList<>();
        Restaurante.requisicoesAtendidas = new ArrayList<>();
        Restaurante.requisicoesFinalizadas = new ArrayList<>();
    }

    private List<Mesa> gerarMesas(int capacidade, int quant){
        for (int i = 0; i < quant; i++) {
            Mesa nova = new Mesa(capacidade, false);
            mesas.add(nova);
        }

        return mesas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public List<Requisicao> getRequisicoesPendentes() {
        return requisicoesPendentes;
    }

    public void setRequisicoesPendentes(List<Requisicao> requisicoesPendentes) {
        Restaurante.requisicoesPendentes = requisicoesPendentes;
    }

    public List<Requisicao> getRequisicoesAtendidas() {
        return requisicoesAtendidas;
    }

    public void setRequisicoesAtendidas(List<Requisicao> requisicoesAtendidas) {
        Restaurante.requisicoesAtendidas = requisicoesAtendidas;
    }

    public List<Requisicao> getRequisicoesFinalizadas() {
        return requisicoesFinalizadas;
    }

    public void setRequisicoesFinalizadas(List<Requisicao> requisicoesFinalizadas) {
        Restaurante.requisicoesFinalizadas = requisicoesFinalizadas;
    }

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
    public Mesa procurarMesa (int quantPessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel() && mesa.getCapacidade() >= quantPessoas) {
                return mesa;
            }
        }
        return null;
    }

    /**
      * Finaliza uma Requisição
      * @param numero Numero da mesa 
      */
    public void finalizarRequisicao(int numero) {
        Requisicao requisicao = localizarAtendidas(numero);
        requisicao.finalizar(LocalDateTime.now());
        removerRequisicaoAtendida(requisicao);
        adicionarRequisicaoFinalizada(requisicao);
    }

    public Requisicao localizarAtendidas(int numero) {
        for (Requisicao req : requisicoesAtendidas) {
            if (req.getMesa().getNumero() == numero) {
                return req;
            }
        }
        return null;
    }

    private void adicionarRequisicaoPendente(Requisicao requisicao) {
        requisicoesPendentes.add(requisicao);
    }

    private void removerRequisicaoPendente(Requisicao requisicao) {
        requisicoesPendentes.remove(requisicao);
    }

    private void adicionarRequisicaoAtendida(Requisicao requisicao) {
        requisicoesAtendidas.add(requisicao);
    }

    private void removerRequisicaoAtendida(Requisicao requisicao) {
        requisicoesAtendidas.remove(requisicao);
    }

    public void adicionarRequisicaoFinalizada(Requisicao requisicao) {
        requisicoesFinalizadas.add(requisicao);
    }

    public void removerRequisicaoFinalizada(Requisicao requisicao) {
        requisicoesFinalizadas.remove(requisicao);
    }
}