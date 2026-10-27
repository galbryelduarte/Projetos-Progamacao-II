package MuseuDigital;
import java.util.Arrays;
import java.util.Objects;

public class Artista {
    private String nome;
    private String biografia;
    private String[] tipoExpressao;
    private int contadorEdicoesVendidas;

    public Artista(String nome, String biografia, String[] tipoExpressao) {
        this.nome = nome;
        this.biografia = biografia;
        this.tipoExpressao = new String[tipoExpressao.length];
        this.contadorEdicoesVendidas = 0;
        for (int i = 0; i < tipoExpressao.length; i++) {
            this.tipoExpressao[i] = tipoExpressao[i];
        }
    }

    public void incrementaContadorEdicoesVendidas() {
        this.contadorEdicoesVendidas++;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNome() {
        return nome;
    }

    public String[] getTipoExpressao() {
        return tipoExpressao;
    }

    public int getContadorEdicoesVendidas() {
        return contadorEdicoesVendidas;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", biografia='" + biografia + '\'' +
                ", tipoExpressao=" + Arrays.toString(tipoExpressao) +
                ", contadorEdicoesVendidas=" + contadorEdicoesVendidas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Artista artista)) return false;
        return Objects.equals(nome, artista.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
