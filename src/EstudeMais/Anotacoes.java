package EstudeMais;

public class Anotacoes {
    private String data;
    private String texto;
    private String tema;
    private Aluno autor;
    public Anotacoes (String data, String tema, String texto, Aluno aluno) {
        this.data = data;
        this.texto = texto;
        this.tema = tema;
        this.autor = aluno;
    }
    public String getTema() {
        return this.tema;
    }
    public void setTexto(String novo) {
        this.texto = novo;
    }
    public String toString() {
        return "Autor: " + this.autor.getNome() + "\nData: " + this.data + "\nTema: " + this.tema + "\nTexto: " + this.texto;
    }
}
