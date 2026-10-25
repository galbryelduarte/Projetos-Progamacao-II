package SGHA;
import java.util.Objects;

public class Equipe {
    private String nome;
    private String categoria;
    private Participante[] participantes;
    private Participante responsavel;

    public Equipe(String nome, String categoria, Participante responsavel) {
        this.nome = nome;
        this.categoria = categoria;
        this.responsavel = responsavel;
        this.participantes = new Participante[5];
        this.participantes[0] = responsavel;
    }

    public void cadastraParticipante(Participante participante){
        if (participante == null) {
            throw new IllegalArgumentException("Não é possível cadastrar participantes nulos");
        }
        for (int i = 1; i < this.participantes.length; i++) {
            if (this.participantes[i] == null) {
                this.participantes[i] = participante;
                return;
            }
        }
        throw new IllegalArgumentException("Esta equipe atingiu o limite de participantes");
    }

    public void acrescentaParticipacao() {
        for (int i = 0; i < this.participantes.length; i++) {
            if (this.participantes[i] != null) {
                this.participantes[i].incrementaQuantidadeAtividades();
            }
        }
    }

    public Participante[] getParticipantes(){
        return this.participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipe equipe)) return false;
        return Objects.equals(nome, equipe.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
