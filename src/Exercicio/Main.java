package Exercicio;

public class Main {
    public static void main (String[] args) {
        Programa programaDeExercicios = new Programa ("Emagrecimento");
        Exercicio exercicio1 = new Exercicio("Agachamento", 300);
        Exercicio exercicio2 = new Exercicio("Pull Down", 200);
        Exercicio exercicio3 = new Exercicio("Remada alta", 150);
        Exercicio exercicio4 = new Exercicio("Rosca", 100);
        Exercicio exercicio5 = new Exercicio("Corrida", 500);
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio1));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio2));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio3, 2));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio4));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio5, 6));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio5, 4));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio5, 1));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio5, 0));
        System.out.println(programaDeExercicios.adicionarExercicio(exercicio4));
        System.out.println(programaDeExercicios.toString());
        System.out.println(exercicio5.getPopularidade());
        System.out.println(exercicio5.toString());
        System.out.println(exercicio5.obterGastoCalorico(5));

        System.out.println("--- TESTES DE AVALIAÇÕES DO PROGRAMA ---");
        System.out.println(programaDeExercicios.getMediaAvaliacoes());
        System.out.println(programaDeExercicios.getAvaliacoes());

        Avaliacao av1 = new Avaliacao(5, "Treino excelente, queima muita caloria!");
        Avaliacao av2 = new Avaliacao(4, "Muito bom, mas cansa bastante a lombar.");
        Avaliacao av3 = new Avaliacao(3, "Achei muito pesado para iniciantes.");

        programaDeExercicios.adicionarAvaliacao(av1);
        programaDeExercicios.adicionarAvaliacao(av2);
        programaDeExercicios.adicionarAvaliacao(av3);

        System.out.println(programaDeExercicios.getMediaAvaliacoes());
        System.out.println(programaDeExercicios.getAvaliacoes());
        System.out.println(av1.toString());
        System.out.println(av1.getNota());
    }
}
