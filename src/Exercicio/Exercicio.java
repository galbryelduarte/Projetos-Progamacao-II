package Exercicio;

public class Exercicio {
    private String nome;
    private int gasto;
    private int popularidade = 0;

    public Exercicio (String nome, int gasto) {
        this.nome = nome;
        this.gasto = gasto;
    }

    public int obterGastoCalorico (int horas) {
        return horas * this.gasto;
    }

    public void atualizarPopularidade () {
        this.popularidade += 1;
    }

    public int getPopularidade () {
        return this.popularidade;
    }

    @Override
    public String toString () {
        return "Nome: " + this.nome + "; Gasto calórico: " + this.gasto +
                "; Popularidade: " + this.popularidade;
    }
}
