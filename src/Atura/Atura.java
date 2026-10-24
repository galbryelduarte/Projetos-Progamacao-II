package Atura;

public class Atura {
    private Aluno[] alunos = new Aluno[100];
    private Curso[] cursos = new Curso[20];

    public int increverCurso(String titulo, String ementa, String instrutor, int vagas, String[] palavrasChave, int idadeMinima) {
        Curso curso = new Curso(titulo, ementa, instrutor, vagas, palavrasChave, idadeMinima);
        for (int i = 0; i<this.cursos.length; i++) {
            if (this.cursos[i] == null) {
                this.cursos[i] = curso;
                return i+1;
            }
        }
        return -1;
    }

    public int increverCurso(String titulo, String ementa, String instrutor, int vagas, int idadeMinima) {
        Curso curso = new Curso(titulo, ementa, instrutor, vagas, idadeMinima);
        for (int i = 0; i<this.cursos.length; i++) {
            if (this.cursos[i] == null) {
                this.cursos[i] = curso;
                return i+1;
            }
        }
        return -1;
    }

    public int inscreverAluno(String nome, String cpf, int idade) {
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] != null && this.alunos[i].getCpf().equals(cpf)) {
                return -1;
            }
        }
        Aluno aluno = new Aluno(nome, cpf, idade);
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] == null) {
                this.alunos[i] = aluno;
                return i + 1;
            }
        }
        return -1;
    }

    public boolean adicionarAlunoCurso(int identificadorCurso, int identificadorAluno) {

        return this.cursos[identificadorCurso-1].cadastrarAluno(this.alunos[identificadorAluno-1]);
    }

    public String statusCurso (int identificadorCurso) {
        return this.cursos[identificadorCurso-1].getStatus();
    }

    public void alterarPalavrasChaves(int identificadorCurso, String[] palavrasChaves) {
        this.cursos[identificadorCurso-1].cadastrarPalavrasChave(palavrasChaves);
    }
    public boolean fecharInscricao(int identificadorCurso) {
        if (this.cursos[identificadorCurso-1] != null) {
            this.cursos[identificadorCurso-1].setStatus("Em andamento");
            return true;
        }
        return false;
    }
    public boolean concluirCursos(int identificadorCurso) {
        if (this.cursos[identificadorCurso-1] != null) {
            this.cursos[identificadorCurso-1].setStatus("Concluído");
            Aluno[] matriculados = this.cursos[identificadorCurso-1].getAlunosMatriculados();
            String tituloDoCurso = this.cursos[identificadorCurso-1].getTitulo();
            for (int i = 0; i < matriculados.length; i++) {
                if (matriculados[i] != null) {
                    matriculados[i].adicionaHistorico(tituloDoCurso);
                }
            }

            return true;
        }
        return false;
    }
    public String listaAlunoCurso (int identificadorCurso) {
        return this.cursos[identificadorCurso-1].getListaAlunos();
    }
    public int vagasLivresCurso(int identificadorCurso) {
        return this.cursos[identificadorCurso-1].getVagasLivres();
    }
    public String[] buscaCurso(String palavraChave) {
        int contador = 0;
        for (int i = 0; i<this.cursos.length; i ++) {
            if (this.cursos[i] != null && this.cursos[i].buscaPalavraChave(palavraChave)) {
                contador++;
            }
        }
        String[] cursosAchados = new String[contador];
        int j = 0;
        for (int i = 0; i<this.cursos.length; i ++) {
            if (this.cursos[i] != null && this.cursos[i].buscaPalavraChave(palavraChave)) {
                cursosAchados[j] = this.cursos[i].getTitulo();
                j++;
            }
        }
        return cursosAchados;
    }
    public String listaHistoricoCursos(int identificadorAluno) {
        return alunos[identificadorAluno-1].getHistorico();
    }
}
