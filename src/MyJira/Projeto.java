package MyJira;
import java.util.ArrayList;

public class Projeto {
    private String nome;
    private ArrayList<Desenvolvedor> desenvolvedores;
    private ArrayList<Tarefa> tarefas;

    public Projeto (String nome) {
        this.nome = nome;
        this.desenvolvedores = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }
    public ArrayList<Desenvolvedor> getDesenvolvedores() {
        return this.desenvolvedores;
    }
    public String emitirRelatorioDeTarefas(String status){
        String relatorio = "";
        for (int i = 0; i < this.tarefas.size(); i++){
            if (this.tarefas.get(i).getStatus().equals(status)) {
                relatorio += "\n" + (i+1) + ". " + this.tarefas.get(i);
            }
        }
        return relatorio;
    }

    public void adicionarDesenvolvedor(String nome, String time) {
        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, time);
        for (int i = 0; i < this.desenvolvedores.size(); i++) {
            if (this.desenvolvedores.get(i).equals(desenvolvedor)) {
                throw new IllegalArgumentException("Esse desenvolvedor já está cadastrado no projeto.");
            }
        }
        this.desenvolvedores.add(desenvolvedor);
    }

    public void adicionarTarefa (String nome, int tempoEstimado) {
        Tarefa tarefa = new Tarefa(nome, tempoEstimado);
        for (int i = 0; i < this.tarefas.size(); i++) {
            if (this.tarefas.get(i).equals(tarefa)) {
                throw new IllegalArgumentException("Essa tarefa já está cadastrada no projeto.");
            }
        }
        this.tarefas.add(tarefa);
    }

    public void atribuirTarefaADesenvolvedor(int identificadorTarefa, int identificadorDesenvolvedor) {
        this.desenvolvedores.get(identificadorDesenvolvedor).adicionarTarefa(this.tarefas.get(identificadorTarefa));
    }
}
