import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List; 

public class Restaurante {

    private String nome;
    private List<Mesa> mesas;
    private List<Requisicao> requisicoesPendentes;
    private List<Requisicao> requisicoesAtendidas;
    private List<Requisicao> requisicoesFinalizadas;

    public Restaurante(String nome) {
        this.nome = nome;
        this.mesas = new ArrayList<>();
        gerarMesas(4, 4));
        this.mesas.addAll(gerarMesas(6, 4));
        this.mesas.addAll(gerarMesas(8, 2));
        this.requisicoesPendentes = new ArrayList<>();
        this.requisicoesAtendidas = new ArrayList<>();
        this.requisicoesFinalizadas = new ArrayList<>();
    }

    private List<Mesa> gerarMesas(int capacidade, int quant){
        for (int i = 0; i < quant; i++) {
            Mesa nova = new Mesa(capacidade);
            mesas.add(nova);
        }
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
        this.requisicoesPendentes = requisicoesPendentes;
    }

    public List<Requisicao> getRequisicoesAtendidas() {
        return requisicoesAtendidas;
    }

    public void setRequisicoesAtendidas(List<Requisicao> requisicoesAtendidas) {
        this.requisicoesAtendidas = requisicoesAtendidas;
    }

    public List<Requisicao> getRequisicoesFinalizadas() {
        return requisicoesFinalizadas;
    }

    public void setRequisicoesFinalizadas(List<Requisicao> requisicoesFinalizadas) {
        this.requisicoesFinalizadas = requisicoesFinalizadas;
    }

    public boolean procurarMesa(int quantidadePessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel() && mesa.getCapacidade() >= quantidadePessoas) {
                return true;
            }
        }
        return false;
    }

    public Mesa obterMesaDisponivel(int quantidadePessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel() && mesa.getCapacidade() >= quantidadePessoas) {
                return mesa;
            }
        }
        return null;
    }

    public void adicionarRequisicao(Cliente cliente, int quantidadePessoas) {
        Mesa mesaDisponivel = obterMesaDisponivel(quantidadePessoas);
        if (mesaDisponivel != null) {
            atribuirMesa(mesaDisponivel, cliente);
        } else {
            adicionarRequisicaoPendente(new Requisicao(cliente, quantidadePessoas));
        }
    }

    public void finalizarRequisicao(int mesaID) {
        Requisicao req = localizarAtendidas(mesaID);
        requisicao.finalizar(LocalDateTime.now());
        removerRequisicaoAtendida(requisicao);
        adicionarRequisicaoFinalizada(requisicao);
    }

    private void atribuirMesa(Mesa mesa, Cliente cliente) {
        mesa.setDisponivel(false);
        Requisicao requisicao = new Requisicao(cliente, mesa, LocalDateTime.now());
        adicionarRequisicaoAtendida(requisicao);
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