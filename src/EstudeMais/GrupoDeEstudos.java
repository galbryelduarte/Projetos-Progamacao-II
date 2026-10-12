package EstudeMais;

public class GrupoDeEstudos {
    private String tema;
    private Anotacoes[] anotacoes;
    private Aluno[] alunos;

    public GrupoDeEstudos(String tema, int quantidadeAlunos, int quantidadeAnotacoes) {
        this.tema = tema;
        this.alunos = new Aluno[quantidadeAlunos];
        this.anotacoes = new Anotacoes[quantidadeAnotacoes];
    }
    public boolean cadastraAluno (Aluno aluno) {
        if (aluno == null) {
            return false;
        }
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] == null){
                alunos[i] = aluno;
                return true;
            }
            else if (this.alunos[i].equals(aluno)) {
                return false;
            }
        }
        return false;
    }

    public boolean cadastraAnotacao (String data, String tema, String texto, Aluno aluno) {
        if (!tema.equals(this.tema)) {
            return false;
        }
        for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] != null && this.alunos[i].equals(aluno)) {
                Anotacoes nota = new Anotacoes (data, tema, texto, aluno);
                for (int j = 0; j < this.anotacoes.length; j++) {
                    if (this.anotacoes[j] == null){
                        anotacoes[j] = nota;
                        aluno.somaCreditos();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void listaAlunos () {
        for (Aluno aluno : alunos) {
            if (aluno != null) {System.out.println(aluno.toString());}
        }
    }

    public void listaAnotacoes () {
        for (Anotacoes nota : anotacoes) {
            if (nota != null) {System.out.println(nota.toString());}
        }
    }
    private int contaEstudantes (Aluno[] estudantes) {
        int contador = 0;
        for (int i = 0; i < estudantes.length; i++) {
            if (estudantes[i] != null){ contador++; }
        }
        return contador;
    }

    private int contaAnotacoes (Anotacoes[] notas) {
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] != null){ contador++; }
        }
        return contador;
    }

    public String toString() {
        return "Grupo de estudos\nTema: " + this.tema + "\nQuantidade de estudantes: " + contaEstudantes(this.alunos) + "\nQuantidade de anotações: " + contaAnotacoes(this.anotacoes);
    }
}
