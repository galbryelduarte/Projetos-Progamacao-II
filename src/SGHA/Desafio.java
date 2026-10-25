package SGHA;

import java.util.Objects;

public class Desafio {
    private String titulo;
    private String descricao;
    private String mentor;
    private String[] palavrasChave;
    private String status;
    private Equipe[] equipes;
    private int quantidadeVagas;

    public Desafio (String titulo, String descricao, String mentor, int quantidadeVagas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.mentor = mentor;
        this.quantidadeVagas = quantidadeVagas;
        this.status = "Aceitando Equipes";
        this.equipes = new Equipe[quantidadeVagas];
    }

    public Desafio (String titulo, String descricao, String mentor, int quantidadeVagas, String[] palavrasChave) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.mentor = mentor;
        this.quantidadeVagas = quantidadeVagas;
        this.palavrasChave = new String[3];
        this.status = "Aceitando Equipes";
        this.equipes = new Equipe[quantidadeVagas];
        for (int i = 0; i < palavrasChave.length; i++) {
            this.palavrasChave[i] = palavrasChave[i];
        }
    }

    public void acrescentarPalavraChave(String palavra) {
        if (palavrasChave.length > 3) {
            throw new IllegalArgumentException("Já foram cadastradas o máximo de palavras-chave");
        }
        if (palavra == null) {
            throw new IllegalArgumentException("Não é possivel cadastrar palavra-chave nula.");
        }
        for (int i = 0; i < this.palavrasChave.length; i++) {
            if (this.palavrasChave[i] == null) {
                this.palavrasChave[i] = palavra;
                return;
            }
        }
    }

    public void cadastrarEquipes(Equipe equipe) {
        if (equipe == null){
            throw new IllegalArgumentException("Não podem ser cadastradas equipes nulas");
        }
        if(!this.status.equals("Aceitando Equipes")) {
            throw new IllegalArgumentException("Esse desafio não está mais aceitando equipes");
        }
        for (int i = 0; i < this.equipes.length; i++){
            if (this.equipes[i] == null) {
                this.equipes[i] = equipe;
                this.equipes[i].acrescentaParticipacao();
                return;
            }
        }
        throw new IllegalArgumentException("Não há mais espaço pra equipes nesse desafio");
    }

    public String getTitulo() {
        return this.titulo;
    }
    public void setStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("Não é possivel cadastrar status nulo.");
        }
        this.status = status;
        if (status.equals("Concluído")) {
            for (int i = 0; i < this.equipes.length; i++) {
                if (this.equipes[i] != null) {
                    Participante[] participantes = this.equipes[i].getParticipantes();
                    for (int j = 0; j < participantes.length; j++) {
                        if (participantes[j] != null) {
                            participantes[j].atualizarDesafiosConcluidos(this.titulo);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Desafio desafio)) return false;
        return Objects.equals(titulo, desafio.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }
}
