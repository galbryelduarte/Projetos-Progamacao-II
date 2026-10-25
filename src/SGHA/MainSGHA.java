package SGHA;

import java.util.Scanner;
import java.util.ArrayList;

public class MainSGHA {

    public static void main(String[] args) {
        SGHA sistema = new SGHA();
        Scanner scanner = new Scanner(System.in);
        String escolha = "";

        while (true) {
            escolha = menu(scanner);
            comando(escolha, sistema, scanner);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(P)Cadastrar participante\n" +
                        "(D)Cadastrar desafio\n" +
                        "(E)Cadastrar equipe\n" +
                        "(M)Adicionar membro na equipe\n" +
                        "(S)Realizar sorteio\n" +
                        "(F)Finalizar desafio\n" +
                        "(V)Exibir vencedores do sorteio\n" +
                        "(X)Sair\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    private static void comando(String opcao, SGHA sistema, Scanner scanner) {
        switch (opcao) {
            case "P":
                cadastrarParticipante(sistema, scanner);
                break;
            case "D":
                cadastrarDesafio(sistema, scanner);
                break;
            case "E":
                cadastrarEquipe(sistema, scanner);
                break;
            case "M":
                adicionarMembro(sistema, scanner);
                break;
            case "S":
                realizarSorteio(sistema);
                break;
            case "F":
                finalizarDesafio(sistema, scanner);
                break;
            case "V":
                exibirVencedores(sistema);
                break;
            case "X":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarParticipante(SGHA sistema, Scanner scanner) {
        System.out.print("\nNome> ");
        String nome = scanner.next();
        System.out.print("Email> ");
        String email = scanner.next();
        System.out.print("Instituição> ");
        String instituicao = scanner.next();
        try {
            sistema.cadastraParticipante(nome, email, instituicao);
            System.out.println("PARTICIPANTE CADASTRADO");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cadastrarDesafio(SGHA sistema, Scanner scanner) {
        System.out.print("\nTítulo> ");
        String titulo = scanner.next();
        System.out.print("Descrição> ");
        String descricao = scanner.next();
        System.out.print("Mentor> ");
        String mentor = scanner.next();
        System.out.print("Vagas para equipes> ");
        int vagas = scanner.nextInt();

        System.out.print("Deseja adicionar palavras-chave? (S/N)> ");
        String desejaTags = scanner.next().toUpperCase();

        try {
            int id;
            if (desejaTags.equals("S")) {
                System.out.print("Quantidade de palavras-chave (Máx 3)> ");
                int qtd = scanner.nextInt();
                if (qtd > 3) qtd = 3;

                String[] palavras = new String[qtd];
                for (int i = 0; i < qtd; i++) {
                    System.out.print("Palavra " + (i + 1) + "> ");
                    palavras[i] = scanner.next();
                }
                id = sistema.cadastrarDesafio(titulo, descricao, mentor, vagas, palavras);
            } else {
                id = sistema.cadastrarDesafio(titulo, descricao, mentor, vagas);
            }
            System.out.println("DESAFIO CADASTRADO COM ID: " + id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cadastrarEquipe(SGHA sistema, Scanner scanner) {
        System.out.print("\nNome da equipe> ");
        String nome = scanner.next();
        System.out.print("Categoria> ");
        String categoria = scanner.next();
        System.out.print("ID Comercial do líder> ");
        int idLider = scanner.nextInt();
        try {
            sistema.cadastrarEquipe(nome, categoria, idLider);
            System.out.println("EQUIPE CADASTRADA");
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao cadastrar equipe: " + e.getMessage());
        }
    }

    private static void adicionarMembro(SGHA sistema, Scanner scanner) {
        System.out.print("\nID Comercial do participante> ");
        int idParticipante = scanner.nextInt();
        System.out.print("Índice da equipe no sistema> ");
        int idEquipe = scanner.nextInt();
        try {
            sistema.cadastrarParticipanteEmEquipe(idParticipante, idEquipe);
            System.out.println("MEMBRO ADICIONADO");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Erro ao adicionar membro: " + e.getMessage());
        }
    }

    private static void realizarSorteio(SGHA sistema) {
        try {
            String resultado = sistema.fazerSorteio();
            System.out.println("GANHADOR DO SORTEIO:" + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void finalizarDesafio(SGHA sistema, Scanner scanner) {
        System.out.print("\nID Comercial do desafio> ");
        int idDesafio = scanner.nextInt();
        try {
            sistema.finalizarDesafio(idDesafio);
            System.out.println("DESAFIO CONCLUÍDO");
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro ao finalizar: " + e.getMessage());
        }
    }

    private static void exibirVencedores(SGHA sistema) {
        ArrayList<Participante> vencedores = sistema.getVencedoresSorteio();
        if (vencedores.isEmpty()) {
            System.out.println("Nenhum participante foi sorteado ainda.");
            return;
        }
        System.out.println("\nLista de Ganhadores:");
        for (int i = 0; i < vencedores.size(); i++) {
            Participante p = vencedores.get(i);
            if (p != null) {
                System.out.println((i + 1) + " - " + p.getNome() + " (" + p.getEmail() + ")");
            }
        }
    }

    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }
}