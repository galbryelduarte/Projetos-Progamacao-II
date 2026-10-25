package SIFE;

public class Palestra {
    private String titulo;
    private String descricao;
    private String palestrante;
    private int quantidadeVagas;
    private Participante[] participantes;
    private int ocupadas;

    public Palestra(String titulo, String descricao, String palestrante, int quantidadeVagas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.palestrante = palestrante;
        this.quantidadeVagas = quantidadeVagas;
        this.participantes = new Participante[this.quantidadeVagas];
        this.ocupadas = 0;
    }

    public void incluirParticipante(Participante participante) {
        if (participante == null) {
            throw new IllegalArgumentException("Participante inválido.");
        }
        for (int i = 0; i < this.participantes.length; i++) {
            if (this.participantes[i] != null && this.participantes[i].equals(participante)) {
                throw new IllegalArgumentException("Esse participante já está cadastrado");
            }
        }

        for (int i = 0; i < this.participantes.length; i++) {
            if (this.participantes[i] == null) {
                this.participantes[i] = participante;
                this.ocupadas++;
                return;
            }
        }
        throw new IllegalArgumentException("Não há mais vagas na palestra.");
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public String getPalestrante() {
        return this.palestrante;
    }
    public int getQuantidadeVagas() {
        return this.quantidadeVagas;
    }
    public Participante[] getParticipantes() {
        return this.participantes;
    }
    private String getParticipantesString() {
        String participantes = "Participantes:\n";
        for (int i = 0; i < this.participantes.length; i++){
            if(this.participantes[i] != null) {
                participantes += (i+1) + ". " + this.participantes[i] + "\n";
            }
        }
        return participantes;
    }
    public int getVagasDisponiveis() {
        return this.participantes.length - this.ocupadas;
    }

    public String toString() {
        return "\nTitulo: " + this.titulo +
                "\nDescrição: " + this.descricao +
                "\nPalestrante: " + this.palestrante +
                "\nQuantidade de Vagas Totais: " + this.quantidadeVagas +
                "\nQuantidade de Vagas Disponíveis: " +getVagasDisponiveis() +
                "\nParticipantes: " + getParticipantesString();
    }
}
