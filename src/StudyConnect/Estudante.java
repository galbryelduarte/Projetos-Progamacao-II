package StudyConnect;

import java.util.Arrays;
import java.util.Objects;

public class Estudante {
    private String nome;
    private String matricula;
    private String[] disciplinasInteresse;
    private String link;
    private int quantidadeGruposParticipa;

    public Estudante(String nome, String matricula, String[] disciplinasInteresse) {
        this.nome = nome;
        this.matricula = matricula;
        this.disciplinasInteresse = disciplinasInteresse;
        this.quantidadeGruposParticipa = 0;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void incrementaQuantidadeGrupos() {
        this.quantidadeGruposParticipa++;
    }

    public void cadastraDisciplinaInteresse(String disciplina) {
        for (int i = 0; i < this.disciplinasInteresse.length; i++) {
            if (this.disciplinasInteresse[i] == null) {
                this.disciplinasInteresse[i] = disciplina;
                return;
            }
        }
    }

    public String[] getDisciplinasInteresse() {
        return disciplinasInteresse;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Estudante estudante)) return false;
        return Objects.equals(matricula, estudante.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", disciplinasInteresse=" + Arrays.toString(disciplinasInteresse) +
                ", link='" + link + '\'' +
                ", quantidadeGruposParticipa=" + quantidadeGruposParticipa +
                '}';
    }
}
