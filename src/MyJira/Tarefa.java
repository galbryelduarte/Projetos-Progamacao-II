package MyJira;

import java.util.Objects;

public class Tarefa {
    private String nome;
    private int tempoEstimado;
    private  String status;

    public Tarefa(String nome, int tempoEstimado) {
        this.nome = nome;
        this.tempoEstimado = tempoEstimado;
        this.status = "não iniciada";
    }

    public void setStatus(String status) {
        if (!status.equals("em andamento") && !status.equals("finalizada")){
            throw new IllegalArgumentException("Status inválido."); }
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(nome, tarefa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
                "; Status: " + this.status +
                "; Tempo Estimado: " + this.tempoEstimado;
    }
}
