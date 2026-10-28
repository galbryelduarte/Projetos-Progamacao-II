package StudyConnect;

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
        return (this.gruposEstudo.size()-1);
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
        if (indexGrupo >= this.gruposEstudo.size()){
            throw new IllegalArgumentException("Indice inválido");
        }
        for (int i = 0; i < this.gruposEstudo.get(indexGrupo).getEstudantesInteressados().length; i++) {
            if (this.gruposEstudo.get(indexGrupo).getEstudantesInteressados()[i].equals(this.estudantes.get(indiceEstudante))) {
                throw new IllegalArgumentException("Este estudante já faz parte do grupo.");
            }
        }
        this.gruposEstudo.get(indexGrupo).cadastraEstudante(this.estudantes.get(indiceEstudante));
    }

    public String[] listarInteressadosGrupo(int indexGrupo) {
        String[] listaInteressadosString = new String[this.gruposEstudo.get(indexGrupo).getEstudantesInteressados().length];
        Estudante[] listaInteressadosEstudante = this.gruposEstudo.get(indexGrupo).getEstudantesInteressados();
        for (int i = 0; i < listaInteressadosString.length; i++) {
            if (listaInteressadosEstudante[i] != null) {
                listaInteressadosString[i] = listaInteressadosEstudante[i].toString();
            }
        }
        return listaInteressadosString;
    }

    public int calcularCompatibilidade(String matricula, int indexGrupo) {
        int indexEstudante = encontraIndiceEstudante(matricula);
        if (indexEstudante == -1) {
            throw new IllegalArgumentException("Não foi achado entre os cadastrados estudantes com essa matricula");
        }
        if (indexGrupo >= this.gruposEstudo.size()){
            throw new IllegalArgumentException("Indice inválido");
        }
        String[] disciplinasGrupo = this.gruposEstudo.get(indexGrupo).getDisciplinasInteresse();
        String[] disciplinasEstudante = this.estudantes.get(indexEstudante).getDisciplinasInteresse();
        int contador = 0;
        for (int i = 0; i < disciplinasGrupo.length; i++) {
            String disciplina = disciplinasGrupo[i];
            for (int j = 0; j < disciplinasEstudante.length; j++) {
                if (disciplinasEstudante[j] != null && disciplina.equals(disciplinasEstudante[j])) {
                    contador ++;
                }
            }
        }
        if (contador==3) {
            return 100;
        }
        if (contador==2) {
            return 70;
        }
        if (contador==1) {
            return 30;
        }
        return 0;
    }
    public String[] confirmarParticipantes(int indexGrupo, int compatibilidade) {
        if (indexGrupo >= this.gruposEstudo.size()){
            throw new IllegalArgumentException("Indice inválido");
        }
        if (compatibilidade > 100 || compatibilidade < 0) {
            throw new IllegalArgumentException("Compatibilidade precisa ser entre 0 e 100.");
        }
        Estudante[] listaEstudantesInteressasdos = this.gruposEstudo.get(indexGrupo).getEstudantesInteressados();
        String[] confirmados = new String[listaEstudantesInteressasdos.length];
        if (this.gruposEstudo.get(indexGrupo).getEstudantesInteressados().length < this.gruposEstudo.get(indexGrupo).getQuantidadeMaximaParticipantes()) {
            for (int i = 0; i < this.gruposEstudo.get(indexGrupo).getEstudantesInteressados().length; i++) {
                int compatibilidadeEstudante = calcularCompatibilidade(listaEstudantesInteressasdos[i].getMatricula(), indexGrupo);
                if (compatibilidadeEstudante >= compatibilidade) {
                    confirmados[i] = listaEstudantesInteressasdos[i].toString();
                    listaEstudantesInteressasdos[i].incrementaQuantidadeGrupos();
                }
            }
            this.gruposEstudo.get(indexGrupo).setEstudantesConfirmados(confirmados);
            return confirmados;
        }
        for (int i = 0; i < this.gruposEstudo.get(indexGrupo).getQuantidadeMaximaParticipantes(); i++) {
            int compatibilidadeEstudante = calcularCompatibilidade(listaEstudantesInteressasdos[i].getMatricula(), indexGrupo);
            if (compatibilidadeEstudante >= compatibilidade) {
                confirmados[i] = listaEstudantesInteressasdos[i].toString();
                listaEstudantesInteressasdos[i].incrementaQuantidadeGrupos();
            }
        }
        this.gruposEstudo.get(indexGrupo).setEstudantesConfirmados(confirmados);
        return confirmados;
    }

    public String[] listaParticipantesConfirmados(int indexGrupo) {
        if (indexGrupo >= this.gruposEstudo.size()){
            throw new IllegalArgumentException("Indice inválido");
        }
        return this.gruposEstudo.get(indexGrupo).getEstudantesConfirmados();
    }
}
