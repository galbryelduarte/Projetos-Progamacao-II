package FilmNow;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        FilmNow menu = new FilmNow();
        Scanner ler = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n(A)Adicionar filme\n(M)Mostrar todos\n(D)Detalhar filme\n(E)Exibir HotList\n(H)Atribuir Hot\n(R)Remover Hot\n(S)Sair"
            );
            System.out.print("\nOpção> ");
            String opcao = ler.next();
            ler.nextLine();

            switch (opcao) {
                case "A":
                    System.out.print("\nPosição> ");
                    int posicao = ler.nextInt();
                    ler.nextLine();

                    System.out.print("\nNome> ");
                    String nome = ler.nextLine();

                    System.out.print("\nAno> ");
                    String ano = ler.nextLine();

                    System.out.print("\nLocal> ");
                    String local = ler.nextLine();

                    System.out.print(menu.adicionarFilme(posicao, nome, ano, local)); break;

                case "M": System.out.println(menu.exibirTodosFilmes()); break;

                case "D":
                    System.out.print("\nPosição> ");
                    int posicao1 = ler.nextInt();
                    ler.nextLine();
                    System.out.println(menu.detalharFilme(posicao1)); break;

                case "E": System.out.print(menu.exibirHotList()); break;

                case "H":
                    System.out.print("\nPosição Geral> ");
                    int posicaoGeral = ler.nextInt();
                    ler.nextLine();
                    System.out.print("\nPosição Hot> ");
                    int posicaoHot = ler.nextInt();
                    ler.nextLine();
                    System.out.print(menu.adicionarHotFilme(posicaoGeral, posicaoHot)); break;

                case "R":
                    System.out.print("\nPosição Hot> ");
                    int posicaoHot1 = ler.nextInt();
                    ler.nextLine();
                    System.out.print(menu.removerFilmeHot(posicaoHot1)); break;

                case "S":
                    ler.close();
                    return;
                default: System.out.println("OPÇÃO INVÁLIDA!");
            }
        }
    }
}
