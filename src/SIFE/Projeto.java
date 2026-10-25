package SIFE;
import java.util.ArrayList;
import java.util.Objects;

public class Projeto {
    private String titulo;
    private String descricao;
    private String areaAtuacao;
    private Participante responsavel;
    private Participante[] associados;
    private ArrayList<Integer> notas;
    private ArrayList<String> comentarios;

    public Projeto (String titulo, String descricao, String areaAtuacao, Participante responsavel) {
        if (responsavel == null) {
            throw new IllegalArgumentException("O participante responsável não pode ser nulo.");
        }
        if (responsavel.getNumeroProjetosResponsaveis() >= 3) {
            throw new IllegalArgumentException("Este participante já é responsável por 3 projetos.");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.areaAtuacao = areaAtuacao;
        this.responsavel = responsavel;
        this.associados = new Participante[4];
        this.responsavel.incrementaProjetosResponsaveis();
        this.notas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    public void cadastraParticipante(Participante participante) {
        if (participante == null) {
            throw new IllegalArgumentException("Este participante é inválido.");
        }
        for (int i = 0; i < this.associados.length; i++) {
            if (this.associados[i] != null && this.associados[i].equals(participante)) {
                throw new IllegalArgumentException("Este participante já faz parte do Projeto.");
            }
        }
        for (int i = 0; i < this.associados.length; i++) {
            if (this.associados[i] == null) {
                this.associados[i] = participante;
                return;
            }
        }
        throw new IllegalArgumentException("Esse projeto atingiu o limite de associados.");
    }

    public void receberAvaliacao(int nota, String comentario) {
        if (comentario == null) {
            throw new IllegalArgumentException("Comentario inválido.");
        }
        if (nota > 10 || nota < 0) {
            throw new IllegalArgumentException("A nota precisa está entre 0 e 10");
        }
        this.notas.add(nota);
        this.comentarios.add(comentario);
    }

    public void receberAvaliacao(int nota) {
        if (nota > 10 || nota < 0) {
            throw new IllegalArgumentException("A nota precisa está entre 0 e 10");
        }
        this.notas.add(nota);
    }

    public double getMedia() {
        if (this.notas.size() == 0) {
            throw new IllegalStateException("Esse projeto ainda não recebeu notas");
        }
        int soma = 0;
        for (int i = 0; i < this.notas.size(); i++) {
            soma += this.notas.get(i);
        }
        return (double) soma / notas.size();
    }

    public ArrayList<Integer> getNotas() {
        return this.notas;
    }
    public ArrayList<String> getComentarios() {
        return this.comentarios;
    }
    public Participante getResponsavel() {
        return this.responsavel;
    }
    public Participante[] getAssociados() {
        return this.associados;
    }
    public String getTitulo() {
        return this.titulo;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Projeto projeto)) return false;
        return Objects.equals(titulo, projeto.titulo);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }
}

