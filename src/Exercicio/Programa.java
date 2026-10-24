package Exercicio;
import java.util.ArrayList;

public class Programa {
    private String objetivo;
    private Exercicio[] serieDeExercicios = new Exercicio[5];
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    public Programa (String objetivo) {
        this.objetivo = objetivo;
    }
    public boolean adicionarExercicio (Exercicio exercicio) {
        if (exercicio == null) {
            return false;
        }
        for (int i = 0; i < this.serieDeExercicios.length; i++) {
            if (this.serieDeExercicios[i] == null) {
                this.serieDeExercicios[i] = exercicio;
                this.serieDeExercicios[i].atualizarPopularidade();
                return true;
            }
        }
        return false;
    }

    public boolean adicionarExercicio (Exercicio exercicio, int dia) {
        if (exercicio == null || dia < 1 || dia > 5) {
            return false;
        }
        this.serieDeExercicios[dia-1] = exercicio;
        this.serieDeExercicios[dia-1].atualizarPopularidade();
        return true;
    }

    public int gastoCaloricoTotal(int horas) {
        int gasto = 0;
        for (int i = 0; i < this.serieDeExercicios.length; i++) {
            if (this.serieDeExercicios[i] != null) {
                gasto += this.serieDeExercicios[i].obterGastoCalorico(horas);
            }
        }
        return gasto;
    }
    public boolean adicionarAvaliacao (Avaliacao avaliacao) {
        if (avaliacao == null) {
            return false;
        }
        this.avaliacoes.add(avaliacao);
        return true;
    }

    public double getMediaAvaliacoes() {
        int somatorio = 0;
        for (int i = 0; i < this.avaliacoes.size(); i++) {
            somatorio += this.avaliacoes.get(i).getNota();
        }
        return (double) somatorio / this.avaliacoes.size();
    }

    public String getAvaliacoes() {
        String avaliacoes = "";
        for (int i = 0; i < this.avaliacoes.size(); i++) {
            avaliacoes += "Avaliação número: " + (i+1) + ": " + this.avaliacoes.get(i) + "\n";
        }
        return avaliacoes;
    }

    @Override

    public String toString() {
        return "Objetivo: " + this.objetivo + "\n" +
                "Segunda-Feira> " + this.serieDeExercicios[0] + "\n" +
                "Terça-Feira> " + this.serieDeExercicios[1] + "\n" +
                "Quarta-Feira> " + this.serieDeExercicios[2] + "\n" +
                "Quinta-Feira> " + this.serieDeExercicios[3] + "\n" +
                "Sexta-Feira> " + this.serieDeExercicios[4] + "\n";
    }
}
