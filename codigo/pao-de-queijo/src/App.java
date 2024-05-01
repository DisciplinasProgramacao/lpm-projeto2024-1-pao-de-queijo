import java.util.Scanner;

public class App {
    static Scanner scanner;
    static Restaurante restaurante = new Restaurante("Pão de Queijo");

    public static void limpar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa() {
        System.out.println("Tecle Enter para continuar.");
        scanner.nextLine();
    }

    static void cabecalho() {
        limpar();
        System.out.println("========================================");
        System.out.println("Bem vindo ao Restaurante Pão de Queijo!");
        System.out.println("========================================");
    }

    static int menu() {
        int opcao;
        cabecalho();

        System.out.println("1 - Abrir Requisicao");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    static Cliente buscarCliente(long documento) {
        Cliente cliente;
        cabecalho();

        cliente = restaurante.buscarCliente(documento);

        return cliente;
    }

    static Cliente cadastrarNovoCliente(long documento) {
        Cliente cliente;

        System.out.print("Qual o seu nome? ");
        String nome = scanner.nextLine();
        cliente = new Cliente(nome, documento);
        restaurante.salvarNovoCliente(cliente);

        return cliente;
    }

    static Requisicao criarRequisicao(Cliente cliente) {
        Requisicao requisicao;

        System.out.print("Bem-vindo(a), " + cliente.getNome() + "! Mesa para quantas pessoas? ");
        int quantPessoas = Integer.parseInt(scanner.nextLine());
        requisicao = restaurante.criarRequisicao(cliente, quantPessoas);

        return requisicao;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Requisicao requisicaoAtual;
        Cliente cliente;
        int opcao;
        
        do {
            opcao = menu();
            switch(opcao) {
                case 1:
                    System.out.print("Qual o seu documento (somente números)? ");
                    long documento = Long.parseLong(scanner.nextLine());
                    
                    cliente = buscarCliente(documento);
                    if (cliente == null) {
                        cliente = cadastrarNovoCliente(documento);
                    }
                    
                    requisicaoAtual = criarRequisicao(cliente);
                    System.out.println(requisicaoAtual);
                    pausa();
                    break;
                    
                case 2: 
                    //System.out.println(cardapio.mostrarMenu());
                    //int escolha = teclado.nexLine();
                    //Prato escolhido = cardapio.fazerPedido(escolha);
                    //requisicaoAtual.adicionarPrato(escolhido);
            }
            
        } while (opcao != 0);
        System.out.println("Agradeçemos a preferência, volte sempre.");
        scanner.close();
    }
}