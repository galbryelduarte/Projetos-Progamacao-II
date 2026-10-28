package RepareBem;

import java.util.Objects;

public class Reparo {
    private String indentificador;
    private String descricao;
    private double preco;

    public Reparo(String indentificador, String descricao, double preco) {
        this.indentificador = indentificador;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void setPreco(double percentual) {
        this.preco += this.preco * (percentual / 100);
    }

    public String getIndentificador() {
        return indentificador;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reparo reparo)) return false;
        return Objects.equals(indentificador, reparo.indentificador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(indentificador);
    }
}
