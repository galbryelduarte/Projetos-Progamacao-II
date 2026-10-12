package EstudeMais;

public class Aluno {
    private String nome;
    private String cpf;
    private int creditos;
    public Aluno (String nomeDoAluno, String cpfDoAluno, int creditos) {
        this.nome = nomeDoAluno;
        this.cpf = cpfDoAluno;
        this.creditos = creditos;
    }
    public String getCPF() { return this.cpf;
    }
    public String getNome() { return this.nome;
    }
    public boolean equals (Object o) {
    if (this == o) {
        return true;
    }
    if (o == null) {
        return false;
    }
    Aluno outroAluno = (Aluno) o;
    return this.cpf.equals(outroAluno.cpf);
    }
    public int hashCode() {
        return this.cpf.hashCode();
    }
    public void somaCreditos() {
        this.creditos ++;
    }
    public int getCreditos () {
        return this.creditos;
    }
    public String toString() {
        return "Dados do aluno:\nNome: " + this.nome + "\nCPF: " + this.cpf +  "\nCréditos: " + this.creditos;
    }
}
