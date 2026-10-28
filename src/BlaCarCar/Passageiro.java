package BlaCarCar;

import java.util.Arrays;
import java.util.Objects;

public class Passageiro {
    private String nome;
    private String cpf;
    private String[] pontosFrequentes;
    private String link;

    public Passageiro(String nome, String cpf, String[] pontosFrequentes) {
        this.nome = nome;
        this.cpf = cpf;
        this.pontosFrequentes = new String[3];
        this.link = "";
        for (int i = 0; i < pontosFrequentes.length; i++) {
            this.pontosFrequentes[i] = pontosFrequentes[i];
        }
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCpf() {
        return cpf;
    }

    public String[] getPontosFrequentes() {
        return pontosFrequentes;
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Passageiro that)) return false;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", pontosFrequentes=" + Arrays.toString(pontosFrequentes) +
                ", link='" + link + '\'' +
                '}';
    }
}
