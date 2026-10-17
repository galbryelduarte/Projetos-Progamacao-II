package FilmNow;
import java.util.Objects;

public class Filme {
    private String nome;
    private String anoDeLancamento;
    private String localParaAssistir;
    private boolean status;

    public Filme(String nome, String anoDeLancamento, String localParaAssistir) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.localParaAssistir = localParaAssistir;
        this.status = false;
    }

    public void mudarStatusHot(boolean mudanca) {
        this.status = mudanca;
    }

    public String getStatus(){
        if (this.status) {
            return "\uD83D\uDD25";
        }
        return "";
    }

    public String getNome () {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Filme outroFilme = (Filme) obj;
        return Objects.equals(nome, outroFilme.nome) && Objects.equals(anoDeLancamento, outroFilme.anoDeLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeLancamento);
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.anoDeLancamento + "\n" + localParaAssistir + "\n";
    }
}
