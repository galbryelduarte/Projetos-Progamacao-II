package StudyConnect;

import EstudeMais.GrupoDeEstudos;

import java.util.ArrayList;

public class StudyConnect {
    private ArrayList<Estudante> estudantes;
    private ArrayList<GrupoEstudo> gruposEstudo;

    public StudyConnect() {
        this.estudantes = new ArrayList<>();
        this.gruposEstudo = new ArrayList<>();
    }

    private int encontraIndiceEstudante(String matricula) {
        for (int i = 0; i < this.estudantes.size(); i++) {
            if (this.estudantes.get(i).getMatricula().equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public boolean cadastraEstudante(String nome, String matricula, String link, String[] disciplinas) {
        if (matricula == null) {
            throw new IllegalArgumentException("A matricula é identificador único portanto não pode ser nula.");
        }
        Estudante estudante = new Estudante(nome, matricula, disciplinas);
        for (int i = 0; i < this.estudantes.size(); i++) {
            if (this.estudantes.get(i).equals(estudante)) {
                throw new IllegalArgumentException("Esse estudante já está cadastrado.");
            }
        }
        estudante.setLink(link);
        this.estudantes.add(estudante);
        return true;
    }

    public boolean cadastraEstudante(String nome, String matricula, String[] disciplinas) {
        if (matricula == null) {
            throw new IllegalArgumentException("A matricula é identificador único portanto não pode ser nula.");
        }
        Estudante estudante = new Estudante(nome, matricula, disciplinas);
        for (int i = 0; i < this.estudantes.size(); i++) {
            if (this.estudantes.get(i).equals(estudante)) {
                throw new IllegalArgumentException("Esse estudante já está cadastrado.");
            }
        }
        this.estudantes.add(estudante);
        return true;
    }

    public void atualizarLinkPerfil(String matricula, String novoLink) {
        if (matricula == null) {
            throw new IllegalArgumentException("A matricula não pode ser nula.");
        }
        int indiceEstudante = encontraIndiceEstudante(matricula);
        if (indiceEstudante == -1) {
            throw new IllegalArgumentException("Não foi achado entre os cadastrados estudantes com essa matricula");
        }
        this.estudantes.get(indiceEstudante).setLink(novoLink);
    }

    public String[] listarEstudantes() {
        String[] lista = new String[this.estudantes.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = this.estudantes.get(i).toString();
        }
        return lista;
    }

    public int cadastrarGrupo(String nome, String descricao, String matriculaResponsavel, int vagas, String disciplinas[]) {
        int indiceEstudante = encontraIndiceEstudante(matriculaResponsavel);
        if (indiceEstudante == -1) {
            return -1;
        }
        GrupoEstudo grupoEstudo = new GrupoEstudo(nome, descricao, matriculaResponsavel, vagas, disciplinas);
        this.gruposEstudo.add(grupoEstudo);
        return (this.gruposEstudo.size());
    }

    public String[] listarGrupos() {
        String[] lista = new String[this.gruposEstudo.size()];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = this.gruposEstudo.get(i).toString();
        }
        return lista;
    }

    public void solicitarParticipacao(String matricula, int indexGrupo) {
        int indiceEstudante = encontraIndiceEstudante(matricula);
        if (indiceEstudante == -1) {
            throw new IllegalArgumentException("Não foi achado entre os cadastrados estudantes com essa matricula");
        }
        if (indexGrupo > this.gruposEstudo.size()){
            throw new IllegalArgumentException("Indice inválido");
        }

    }

}
