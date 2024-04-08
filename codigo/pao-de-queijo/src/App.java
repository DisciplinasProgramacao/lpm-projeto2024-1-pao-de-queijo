import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao Restaurante Pão de Queijo!");
        System.out.println("Já possui cadastro?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        String resposta = scanner.nextInt();

        if (resposta == 1) {
            System.out.println("Qual o número do seu documento?");
            Long documento = scanner.nextLong();
            Cliente cliente = buscarCliente(documento);

            if (cliente.isNullOrEmpty) {
                
            }
        }

        scanner.close;
    }
}
