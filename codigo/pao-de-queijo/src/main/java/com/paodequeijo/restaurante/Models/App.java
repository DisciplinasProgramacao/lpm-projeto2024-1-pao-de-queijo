package com.paodequeijo.restaurante.Models;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    static Scanner scanner;
    static Restaurante restaurante = new Restaurante("Pão de Queijo");

    public static void limpar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa() {
        System.out.println("\nTecle Enter para continuar.");
        scanner.nextLine();
    }

    static void cabecalho() {
        limpar();
        System.out.println("========================================");
        System.out.println("Bem vindo ao Restaurante Pão de Queijo!");
        System.out.println("========================================");
    }

    static int MenuPrincipal() {
        int opcao;
        cabecalho();

        System.out.println("1 - Requisicoes");
        System.out.println("2 - Pedidos");
        System.out.println("3 - Mesas");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcao = -1;
        }

        return opcao;
    }

    static int MenuRequisicoes() {
        int opcao;
        cabecalho();

        System.out.println("1 - Abrir Requisicao");
        System.out.println("2 - Finalizar Requisicao");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcao = -1;
        }

        return opcao;
    }

    static Requisicao abrirRequisicao() {
        Cliente cliente;
        long documento;
        System.out.print("Qual o seu documento (somente números)? ");

        try {
            documento = Long.parseLong(scanner.nextLine());
            cliente = restaurante.buscarCliente(documento); 
        } catch (NumberFormatException e) {
            return null;
        }

        if (cliente == null) {
            cliente = cadastrarNovoCliente(documento);
        } 

        if (cliente == null) {
            return null;
        }

        Requisicao requisicao = criarRequisicao(cliente);
        return requisicao;
    }

    static Cliente cadastrarNovoCliente(long documento) {
        Cliente cliente;

        System.out.print("Qual o seu nome? ");
        String nome = scanner.nextLine();

        try {
            cliente = new Cliente(nome, documento);
            restaurante.salvarNovoCliente(cliente);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return null;
        }
        
        return cliente;
    }

    static Requisicao criarRequisicao(Cliente cliente) {
        Requisicao requisicao;
        Pedido pedido;
        int quantPessoas = 0;

        System.out.print("Bem-vindo(a), " + cliente.getNome() + "! Mesa para quantas pessoas? ");
        try {
            quantPessoas = Integer.parseInt(scanner.nextLine());
            pedido = criarPedido(quantPessoas);
            requisicao = restaurante.criarRequisicao(cliente, quantPessoas, pedido);
        } catch (NumberFormatException e) {
            requisicao = null;
        }

        return requisicao;
    }

    static Pedido criarPedido(int quantPessoas) {
        int opcao;
        Pedido pedido;
        System.out.println("\n1 - Pedido com cardápo aberto");
        System.out.println("2 - Pedido com cardápio fechado");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");

        try {
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao < 0 || opcao > 2) {
                throw new NumberFormatException("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            throw new NullPointerException("Opção inválida.");
        }

        switch (opcao) {
            case 1:
                pedido = new PedidoAberto();
                break;
            
            case 2:
                pedido = new PedidoFechado(quantPessoas);
                break;
        
            default:
                pedido = null;
                break;
        }

        return pedido;
    }

    static int MenuPedidos() {
        int opcao;
        cabecalho();

        System.out.println("1 - Fazer pedido");
        System.out.println("2 - Ver pedido");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            opcao = -1;
        }

        return opcao;
    }

    static Requisicao buscarRequisicao() {
        int numeroMesa;

        System.out.println("\nQual o numero da mesa?");
        System.out.println("(Se ainda não tiver mesa envie 0 para voltar) ");

        numeroMesa = Integer.parseInt(scanner.nextLine());

        try {
            boolean mesaVazia = restaurante.mesaIsDisponivel(numeroMesa);

            if (mesaVazia) {
                System.out.println("Mesa vazia.");
                pausa();
                return null;
            }
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            pausa();
            return null;
        }

        Requisicao requisicao = restaurante.localizarAtendida(numeroMesa);

        return requisicao;
    }

    static void cabecalhoCardapio() {
        limpar();
        System.out.println("========================================");
        System.out.println("  Cardápio - Restaurante Pão de Queijo!");
        System.out.println("========================================");
    }

    static int[] MenuCardapio(Pedido pedido) {
        int[] idItens;;
        String input;

        cabecalhoCardapio();
        System.out.println(pedido.exibirCardapio());
        System.out.print("Quais os números dos itens que gostaria de pedir?\n");
        System.out.println("(Escreva com espaço entre eles. Ex: 1 2 3 4 5 etc.)");
        input = scanner.nextLine();

        try {
            String[] splInput = input.split(" ");
            idItens = Arrays.stream(splInput).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            idItens = null;
        }

        return idItens;
    }

    static void cabecalhoMesas() {
        limpar();
        System.out.println("=========================================");
        System.out.println("          Mesas - " + restaurante.getNome());
        System.out.println("=========================================");
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Requisicao requisicao;
        Pedido pedido;
        int opcao;

        do {
            opcao = MenuPrincipal();
            switch (opcao) {
                case 1:
                    opcao = MenuRequisicoes();
                    switch (opcao) {
                        case 1:
                            try {
                                requisicao = abrirRequisicao();
                            } catch (NullPointerException ne) { 
                                System.out.println(ne.getMessage());
                                pausa();
                                break;
                            }

                            if (requisicao == null) {
                                System.out.println("Requisiçao cancelada.");
                                pausa();
                                break;
                            }

                            System.out.println(requisicao);
                            pausa();
                            break;

                        case 2:
                            System.out.print("Qual o número da mesa? ");

                            try {
                                int mesa = Integer.parseInt(scanner.nextLine());
                                System.out.println(restaurante.finalizarRequisicao(mesa));
                                pausa();
                            } catch (NumberFormatException e) {
                                System.out.println("Número de mesa inválido.");
                                pausa();
                            }
                            break;

                        default:
                            break;
                    }
                    break;

                case 2:
                    opcao = MenuPedidos();
                    switch (opcao) {
                        case 1:
                            requisicao = buscarRequisicao();
                            if (requisicao != null) {
                                try {
                                    pedido = requisicao.getPedido();
                                } catch (NullPointerException ne) {
                                    System.out.println(ne.getMessage());
                                    pausa();
                                    break;
                                }
                            } else {
                                System.out.println("Requisicao não encontrada.");
                                pausa();
                                break;
                            }

                            int[] idItens = MenuCardapio(pedido);
                            for (int idItem : idItens) {
                                System.out.println(restaurante.adicionarItem(requisicao, idItem));
                            }
                            pausa();
                            break;

                        case 2:
                            requisicao = buscarRequisicao();
                            if (requisicao != null) {
                                pedido = requisicao.getPedido();
                                System.out.println(pedido);
                                pausa();
                            } else {
                                System.out.println("Tecle Enter para voltar ao menu principal.");
                                scanner.nextLine();
                            }
                            break;

                        default:
                            break;
                    }
                    break;

                case 3:
                    cabecalhoMesas();
                    System.out.println(restaurante.imprimirMesas());
                    pausa();
                    break;
            }

        } while (opcao != 0);
        System.out.println("\nAgradeçemos a preferência, volte sempre <3\n");
        scanner.close();
    }
}