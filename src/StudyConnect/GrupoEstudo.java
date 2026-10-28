package StudyConnect;

import java.util.ArrayList;

public class GrupoEstudo {
    private String nome;
    private String descricao;
    private String estudanteResponsavel;
    private int quantidadeMaximaParticipantes;
    private String[] disciplinasInteresse;
    private ArrayList<Estudante> estudantesInteressados;
    private String[] estudantesConfirmados;

    public GrupoEstudo(String nome, String descricao, String estudanteResponsavel, int quantidadeMaximaParticipantes, String[] disciplinasInteresse) {
        this.nome = nome;
        this.descricao = descricao;
        this.estudanteResponsavel = estudanteResponsavel;
        this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
        this.disciplinasInteresse = disciplinasInteresse;
        this.estudantesInteressados = new ArrayList<>();
    }
    public void cadastraEstudante(Estudante estudante) {
        this.estudantesInteressados.add(estudante);
    }

    public Estudante[] getEstudantesInteressados() {
        Estudante[] listaEstudantesInteressados = new Estudante[this.estudantesInteressados.size()];
        for (int i = 0; i < listaEstudantesInteressados.length; i++) {
            listaEstudantesInteressados[i] = this.estudantesInteressados.get(i);
        }
        return listaEstudantesInteressados;
    }


    public void setEstudantesConfirmados(String[] estudantesConfirmados) {
        this.estudantesConfirmados = estudantesConfirmados;
    }

    public int getQuantidadeMaximaParticipantes() {
        return quantidadeMaximaParticipantes;
    }

    public String[] getEstudantesConfirmados() {
        return estudantesConfirmados;
    }

    public String[] getDisciplinasInteresse() {
        return disciplinasInteresse;
    }
}
