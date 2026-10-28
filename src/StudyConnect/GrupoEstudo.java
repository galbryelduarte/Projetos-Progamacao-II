package StudyConnect;

public class GrupoEstudo {
    private String nome;
    private String descricao;
    private String estudanteResponsavel;
    private int quantidadeMaximaParticipantes;
    private String[] disciplinasInteresse;
    private Estudante[] estudantesInteressados;

    public GrupoEstudo(String nome, String descricao, String estudanteResponsavel, int quantidadeMaximaParticipantes, String[] disciplinasInteresse) {
        this.nome = nome;
        this.descricao = descricao;
        this.estudanteResponsavel = estudanteResponsavel;
        this.quantidadeMaximaParticipantes = quantidadeMaximaParticipantes;
        this.disciplinasInteresse = disciplinasInteresse;
        this.estudantesInteressados = new Estudante[quantidadeMaximaParticipantes];
    }
    public void cadastraEstudante(Estudante estudante) {
        for (int i = 0; i < this.estudantesInteressados.length; i++) {
            if (this.estudantesInteressados[i] == null) {
                this.estudantesInteressados[i] = estudante;
                return;
            }
        }
    }
    public Estudante[] getEstudantesInteressados() {
        return estudantesInteressados;
    }

    public String[] getDisciplinasInteresse() {
        return disciplinasInteresse;
    }
}
