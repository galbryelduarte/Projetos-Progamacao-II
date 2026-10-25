package SGHA;

import java.util.Objects;

public class Participante {
    private String nome;
    private String email;
    private String instituicao;
    private String[] desafiosConcluidos;
    private int quantidadeAtividades;
    private int quantidadeCheckIns;

    public Participante(String nome, String email, String instituicao) {
        this.nome = nome;
        this.email = email;
        this.instituicao = instituicao;
        this.quantidadeCheckIns = 0;
        this.desafiosConcluidos = new String[20];
    }

    public void fazerCheckIn(){
        this.quantidadeCheckIns++;
    }
    public void incrementaQuantidadeAtividades() {
        if (this.quantidadeAtividades >= 5) {
            throw new IllegalArgumentException("O participante já atingiu o limite de 5 tarefas simultâneas.");
        }
        this.quantidadeAtividades++;
    }

    public void atualizarDesafiosConcluidos(String desafio) {
        for (int i = 0; i < this.desafiosConcluidos.length; i++) {
            if (this.desafiosConcluidos[i] == null) {
                this.desafiosConcluidos[i] = desafio;
                return;
            }
        }
    }
    public String[] getDesafiosConcluidos() {
        return this.desafiosConcluidos;
    }
    public String getEmail() {
        return this.email;
    }
    public String getNome() {
        return nome;
    }
    public String getInstituicao() {
        return instituicao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Participante that)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
