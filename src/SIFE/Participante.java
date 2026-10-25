package SIFE;

import java.util.Objects;

public class Participante {
    private String nome;
    private String email;
    private String instituicao;
    private int projetosResponsaveis;

    public Participante (String nome, String email, String instituicao) {
        this.nome = nome;
        this.email = email;
        this.instituicao = instituicao;
        this.projetosResponsaveis = 0;
    }

    public void incrementaProjetosResponsaveis() {
        this.projetosResponsaveis++;
    }
    public int getNumeroProjetosResponsaveis() {
        return this.projetosResponsaveis;
    }
    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public String getInstituicao() {
        return this.instituicao;
    }

    @Override
    public String toString() {
        return "Nome:" + this.nome + "; Email:" + this.email + "; Instituição: " + this.instituicao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Participante that)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
