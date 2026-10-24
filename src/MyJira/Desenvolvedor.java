package MyJira;

import java.util.Objects;

public class Desenvolvedor {
    private String nome;
    private String time;
    private Tarefa[] tarefas;

    public Desenvolvedor(String nome, String time) {
        this.nome = nome;
        this.time = time;
        this.tarefas = new Tarefa[5];
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa inválida.");
        }
        for (int i = 0; i < this.tarefas.length; i++) {
            if (this.tarefas[i] == null) {
                this.tarefas[i] = tarefa;
                return;
            }
        }
        throw new IllegalArgumentException("Este desenvolvedor atingiu o limite de tarefas possíveis.");
    }

    public void finalizarTarefa(int posicao) {
        if (posicao > 5 || posicao <= 0) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        if (this.tarefas[posicao-1] == null) {
            throw new IllegalArgumentException("Posição vazia.");
        }
        this.tarefas[posicao-1].setStatus("finalizada");
        this.tarefas[posicao-1] = null;
    }

    public String getNome() {
        return this.nome;
    }
    public String getTime() {
        return this.time;
    }
    public Tarefa[] getTarefas() {
        return this.tarefas;
    }

    private String getTarefasString() {
        String tarefas = "";
        for (int i = 0; i < this.tarefas.length; i++) {
            if (this.tarefas[i] != null) {
                tarefas += "\n" + (i+1) + this.tarefas[i];
            }
        }
        return tarefas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Desenvolvedor that)) return false;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\nTime: " + this.time + "\nTarefas: " + this.getTarefasString();
    }
}
