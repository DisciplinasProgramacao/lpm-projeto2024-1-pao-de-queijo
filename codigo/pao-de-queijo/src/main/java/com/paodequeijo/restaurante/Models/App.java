package com.paodequeijo.restaurante.Models;

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
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    static int MenuRequisicoes() {
        int opcao;
        cabecalho();

        System.out.println("1 - Abrir Requisicao");
        System.out.println("2 - Ver Requisicoes");
        System.out.println("3 - Finalizar Requisicao");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    static Requisicao abrirRequisicao() {
        System.out.print("Qual o seu documento (somente números)? ");
        long documento = Long.parseLong(scanner.nextLine());

        Cliente cliente = buscarCliente(documento);
        if (cliente == null) {
            cliente = cadastrarNovoCliente(documento);
        }

        Requisicao requisicao = criarRequisicao(cliente);
        return requisicao;
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

    static int MenuVerRequisicoes() {
        int opcao;
        cabecalho();

        System.out.println("1 - Requisicoes Atendidas");
        System.out.println("2 - Requisicoes Pendentes");
        System.out.println("3 - Requisicoes Finalizadas");
        System.out.println("4 - Todas");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    static int MenuPedidos() {
        int opcao;
        cabecalho();

        System.out.println("1 - Fazer pedido");
        System.out.println("2 - Ver pedido");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    static int MenuCriarPedido() {
        int opcao;
        cabecalho();

        System.out.println("1 - Ver Cardapio");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
        opcao = Integer.parseInt(scanner.nextLine());

        return opcao;
    }

    static Requisicao buscarRequisicao() {
        System.out.println("\nQual o numero da mesa?");
        System.out.println("(Se ainda não tiver mesa envie 0 para voltar) ");
        int mesa = Integer.parseInt(scanner.nextLine());
        Requisicao requisicao = restaurante.localizarAtendida(mesa);

        return requisicao;
    }

    static void cabecalhoCardapio() {
        limpar();
        System.out.println("========================================");
        System.out.println("  Cardápio - Restaurante Pão de Queijo!");
        System.out.println("========================================");
    }

    static Item MenuCardapio() {
        int opcao;
        Item item;
        cabecalho();

        System.out.println("1 - Cardápio");
        System.out.println("2- Cardapio Fechado");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                cabecalhoCardapio();
                Cardapio cardapio = new Cardapio();
                System.out.println(cardapio.mostrarMenu());
                System.out.println("Qual o número do item que gostaria de pedir?");
                int escolhaPrato = Integer.parseInt(scanner.nextLine());
                item = cardapio.itemEscolhido(escolhaPrato);
                break;
            case 2:
                cabecalhoCardapio();
                CardapioFechado cardapioFechado = new CardapioFechado();
                System.out.println(cardapioFechado.mostrarMenu());
                System.out.println("Qual o número do item que gostaria de pedir?");
                int escolherPrato = Integer.parseInt(scanner.nextLine());
                item = cardapioFechado.itemEscolhido(escolherPrato);
                System.out.println(cardapioFechado.mostrarMenu());
                System.out.println("Qual o número do item que gostaria de pedir?");
                int escolherBebida2 = Integer.parseInt(scanner.nextLine());
                item = cardapioFechado.itemEscolhido(escolherBebida2);
                System.out.println(cardapioFechado.mostrarMenu());
                System.out.println("Qual o número do item que gostaria de pedir?");
                int escolherBebida = Integer.parseInt(scanner.nextLine());
                item = cardapioFechado.itemEscolhido(escolherBebida);
                
                break;
            default:
                item = null;
                break;
        }

        return item;
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
                            requisicao = abrirRequisicao();
                            pedido = new Pedido();
                            System.out.println(requisicao);
                            pausa();
                            break;

                        case 2:
                            opcao = MenuVerRequisicoes();
                            switch (opcao) {
                                case 1:
                                    System.out.println(restaurante.getRequisicoesAtendidas());
                                    pausa();
                                    break;

                                case 2:
                                    System.out.println(restaurante.getRequisicoesPendentes());
                                    pausa();
                                    break;

                                case 3:
                                    System.out.println(restaurante.getRequisicoesFinalizadas());
                                    pausa();
                                    break;

                                case 4:
                                    System.out.println(restaurante.getTodasRequisicoes());
                                    pausa();
                                    break;

                                default:
                                    break;
                            }
                            break;

                        case 3:
                            System.out.print("Qual o número da mesa? ");
                            int mesa = Integer.parseInt(scanner.nextLine());
                            System.out.println(restaurante.finalizarRequisicao(mesa));
                            pausa();
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
                                Item itemEscolhido = MenuCardapio();
                                pedido = requisicao.getPedido();
                                if (pedido == null) {
                                    pedido = new Pedido();
                                }

                                System.out.println(pedido.adicionarItem(itemEscolhido));
                                pausa();
                            } else {
                                System.out.println("Tecle Enter para voltar ao menu principal.");
                                scanner.nextLine();
                            }

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