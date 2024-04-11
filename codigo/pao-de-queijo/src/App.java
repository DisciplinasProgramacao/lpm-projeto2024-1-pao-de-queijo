import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Restaurante restaurante = new Restaurante("Pão de Queijo");

    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao Restaurante Pão de Queijo!");
        System.out.println("Já possui cadastro?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        int resposta = Integer.parseInt(scanner.nextLine());

        switch (resposta) {
            case 1:
                System.out.println("Qual o número do seu documento?");
                Long documento = Long.parseLong(scanner.nextLine());
                Cliente cliente = restaurante.buscarCliente(documento);

                if (cliente.isNullOrEmpty) {
                    
                }
                    
                break;
        
            case 2: 
                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();
                System.out.println("Qual o número do seu documento?");
                Long documentoCliente = scanner.nextLong();
                Cliente novoCliente = new Cliente(nomeCliente, documentoCliente);
                break;
            default:
                break;
        }

        scanner.close();
    }
}