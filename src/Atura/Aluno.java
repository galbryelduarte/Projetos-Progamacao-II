package Atura;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String cpf;
    private int idade;
    private String historico = "Histórico Acadêmico: ";

    public Aluno (String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public void adicionaHistorico(String titulo) {
        this.historico += titulo + " ;";
    }
    public int getIdade() {
        return this.idade;
    }

    public String getCpf() {
        return this.cpf;
    }
    public String getNome() {
        return this.nome;
    }
    public String getHistorico() {
        return this.historico;
    }

    @Override public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(cpf, aluno.cpf);
    }

    @Override public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override public String toString() {
        return "Dados do alunos: " +
                "\nNome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nHistorico: " + this.historico;
    }
}
