package MuseuDigital;

import java.util.Arrays;
import java.util.Objects;

public class Colecionador {
    private String nome;
    private String CPF;
    private String[] interesses;
    private String link;

    public Colecionador(String nome, String CPF, String[] interesses) {
        this.nome = nome;
        this.CPF = CPF;
        this.interesses = new String[interesses.length];
        for (int i = 0; i < interesses.length; i++) {
            this.interesses[i] = interesses[i];
        }
    }

    public String[] getInteresses() {
        return interesses;
    }

    public String getCPF() {
        return CPF;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Colecionador{" +
                "nome='" + nome + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Colecionador that)) return false;
        return Objects.equals(CPF, that.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }
}
