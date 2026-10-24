package Exercicio;

public class Avaliacao {
    private int nota;
    private String comentario;

    public Avaliacao (int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return this.nota;
    }

    @Override
    public String toString() {
        return "Nota: " + this.nota + "; " +
                "Comentário: " + this.comentario;
    }
}
