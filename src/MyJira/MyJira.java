package MyJira;

import java.util.Scanner;

public class MyJira {
    private static Projeto projeto;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cadastraProjeto("Sistema de Gestão MyJira");
        gerenciaProjeto();
    }

    public static void cadastraProjeto(String nome) {
        projeto = new Projeto(nome);
        System.out.println("--- Projeto '" + nome + "' inicializado com sucesso! ---");
    }

    public static void gerenciaProjeto() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU MYJIRA =====");
            System.out.println("1. Cadastrar Desenvolvedor");
            System.out.println("2. Cadastrar Tarefa");
            System.out.println("3. Atribuir Tarefa a Desenvolvedor");
            System.out.println("4. Finalizar Tarefa de um Desenvolvedor");
            System.out.println("5. Emitir Relatório de Tarefas");
            System.out.println("6. Visualizar Desenvolvedor e suas Tarefas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> menuCadastrarDesenvolvedor();
                    case 2 -> menuCadastrarTarefa();
                    case 3 -> menuAtribuirTarefa();
                    case 4 -> menuFinalizarTarefa();
                    case 5 -> menuEmitirRelatorio();
                    case 6 -> menuVisualizarDesenvolvedor();
                    case 0 -> System.out.println("Encerrando o MyJira... Até mais!");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void menuCadastrarDesenvolvedor() {
        System.out.print("Nome do Desenvolvedor: ");
        String nome = scanner.nextLine();
        System.out.print("Time do Desenvolvedor: ");
        String time = scanner.nextLine();

        projeto.adicionarDesenvolvedor(nome, time);
        System.out.println("Desenvolvedor cadastrado com sucesso!");
    }

    private static void menuCadastrarTarefa() {
        System.out.print("Nome da Tarefa: ");
        String nome = scanner.nextLine();
        System.out.print("Tempo Estimado (em horas): ");
        int tempo = Integer.parseInt(scanner.nextLine());

        projeto.adicionarTarefa(nome, tempo);
        System.out.println("Tarefa cadastrada com sucesso!");
    }

    private static void menuAtribuirTarefa() {
        System.out.print("Identificador (Índice) da Tarefa: ");
        int idTarefa = Integer.parseInt(scanner.nextLine());
        System.out.print("Identificador (Índice) do Desenvolvedor: ");
        int idDev = Integer.parseInt(scanner.nextLine());

        projeto.atribuirTarefaADesenvolvedor(idTarefa, idDev);
        System.out.println("Tarefa atribuída com sucesso!");
    }

    private static void menuFinalizarTarefa() {
        System.out.print("Identificador (Índice) do Desenvolvedor: ");
        int idDev = Integer.parseInt(scanner.nextLine());
        System.out.print("Posição da tarefa no Dev (1 a 5): ");
        int posicao = Integer.parseInt(scanner.nextLine());

        projeto.getDesenvolvedores().get(idDev).finalizarTarefa(posicao);
        System.out.println("Tarefa finalizada e removida do desenvolvedor com sucesso!");
    }

    private static void menuEmitirRelatorio() {
        System.out.print("Digite o status para filtrar (não iniciada / em andamento / finalizada): ");
        String status = scanner.nextLine();

        String relatorio = projeto.emitirRelatorioDeTarefas(status);
        if (relatorio.isBlank()) {
            System.out.println("Nenhuma tarefa encontrada com o status '" + status + "'.");
        } else {
            System.out.println("\n--- Relatório de Tarefas (" + status + ") ---" + relatorio);
        }
    }

    private static void menuVisualizarDesenvolvedor() {
        System.out.print("Identificador (Índice) do Desenvolvedor: ");
        int idDev = Integer.parseInt(scanner.nextLine());

        Desenvolvedor dev = projeto.getDesenvolvedores().get(idDev);
        System.out.println("\n" + dev);
    }
}
