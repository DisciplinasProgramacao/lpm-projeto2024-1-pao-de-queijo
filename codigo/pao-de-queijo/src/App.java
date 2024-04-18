import java.util.Scanner;

public class App {
    static Scanner scanner;
    static Restaurante restaurante = new Restaurante("Pão de Queijo");

    static void cabecalho() {
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

    static Cliente buscarCliente() {
        Cliente cliente;
        cabecalho();

        System.out.print("Qual o seu documento (somente números)? ");
        long documento = Long.parseLong(scanner.nextLine());
        cliente = restaurante.buscarCliente(documento);

        return cliente;
    }

    static Cliente cadastrarNovoCliente() {
        Cliente cliente;

        System.out.print("Qual o seu nome? ");
        String nome = scanner.nextLine();
        System.out.print("Qual o seu documento (somente números)? ");
        long documento = Long.parseLong(scanner.nextLine());
        cliente = new Cliente(nome, documento);

        return cliente;
    }

    static Requisicao criarRequisicao(Cliente cliente) {
        Requisicao requisicao;

        System.out.print("Mesa para quantas pessoas? ");
        int quantPessoas = Integer.parseInt(scanner.nextLine());
        requisicao = new Requisicao(quantPessoas, cliente);

        return requisicao;
    }

    static void validarMesa(Requisicao requisicao) {
        
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
                    cliente = buscarCliente();
                    if (cliente == null) {
                        cliente = cadastrarNovoCliente();
                    }
                    requisicaoAtual = criarRequisicao(cliente);
                    validarMesa(requisicaoAtual);
            }
            
        } while (opcao != 0);
        System.out.println("Agradeçemos a preferência, volte sempre.");
        scanner.close();
    }
}