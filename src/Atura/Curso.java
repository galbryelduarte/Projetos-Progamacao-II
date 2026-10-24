package Atura;

public class Curso {
    private String titulo;
    private String ementa;
    private String nomeInstrutor;
    private String status;
    private int vagas;
    private int idadeMinima;
    private String[] palavrasChave;
    private Aluno[] alunosMatriculados;

    public Curso(String titulo, String ementa, String nomeInstrutor, int vagas, int idadeMinima) {
        this.titulo = titulo;
        this.ementa = ementa;
        this.nomeInstrutor = nomeInstrutor;
        this.vagas = vagas;
        this.status = "Aceitando inscrições";
        this.alunosMatriculados = new Aluno[this.vagas];
        this.idadeMinima = idadeMinima;
    }

    public Curso(String titulo, String ementa, String nomeInstrutor, int vagas, String[] palavrasChave, int idadeMinima) {
        this.titulo = titulo;
        this.ementa = ementa;
        this.nomeInstrutor = nomeInstrutor;
        this.vagas = vagas;
        this.palavrasChave = palavrasChave;
        this.status = "Aceitando inscrições";
        this.alunosMatriculados = new Aluno[this.vagas];
        this.idadeMinima = idadeMinima;
    }

    public void cadastrarPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public boolean buscaPalavraChave(String palavraChave) {
        for (int i = 0; i < this.palavrasChave.length; i++) {
            if (palavrasChave[i] != null && palavraChave.equals(palavrasChave[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarAluno(Aluno aluno) {
        if (this.status.equals("Concluído") || this.status.equals("Em andamento")) {
            return false;
        }
        if (aluno.getIdade() < this.idadeMinima) {
            return false;
        }
        for (int i = 0; i<vagas; i++) {
            if (alunosMatriculados[i] == null) {
                alunosMatriculados[i] = aluno;
                return true;
            }
        }
        return false;
    }

    public void setStatus (String status) {
        this.status = status;
    }
    public String getPalavrasChaves(){
        String palavras = "[";
        for (int i = 0; i<this.palavrasChave.length; i++) {
            if (palavrasChave[i] != null) {
                palavras += (i+1) + ". " + palavrasChave[i];
            }
        }
        return palavras + "]";
    }
    public String getListaAlunos() {
        String alunos = "Lista alunos:\n";
        for (int i = 0; i<this.vagas; i++) {
            if (alunosMatriculados[i] != null) {
                alunos += (i + 1) + ". " + alunosMatriculados[i].getNome() + "\n";
            }
        }
        return alunos;
    }

    public Aluno[] getAlunosMatriculados() {
        return this.alunosMatriculados;
    }

    public int getVagas() {
        return this.vagas;
    }
    public int getVagasLivres() {
        int ocupadas = 0;
        for (int i = 0; i < alunosMatriculados.length; i++) {
            if (alunosMatriculados != null) {
                ocupadas ++;
            }
        }
        return this.vagas - ocupadas;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getStatus() {
        return this.status;
    }
    public String toString() {
        return "-DETALHES DO CURSO-" +
                "\n Título: " + this.titulo +
                "\n Ementa: " + this.ementa +
                "\n Nome do Instrutor: " + this.nomeInstrutor +
                "\n Vagas totais: " + this.vagas +
                "\n Palavras Chaves: " + getPalavrasChaves() +
                "\n Status do Curso: " + this.status +
                "\n Alunos matriculados: " + getListaAlunos();
    }
}
