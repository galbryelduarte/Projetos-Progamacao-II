package MuseuDigital;

import java.util.ArrayList;
import java.util.Arrays;

public class Obra {
    private String titulo;
    private String tipo;
    private String artistaResponsavel;
    private int quantidadeDisponivel;
    private double valor;
    private String[] caracteristicas;
    private ArrayList<Colecionador> compradores;

    public Obra(String titulo, String tipo, String artistaResponsavel, int quantidadeDisponivel, double valor, String[] caracteristas) {
        this.titulo = titulo;
        this.tipo = tipo;
        this. artistaResponsavel = artistaResponsavel;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.valor = valor;
        this.caracteristicas = new String[caracteristas.length];
        this.compradores = new ArrayList<>();
        for (int i = 0; i < caracteristas.length; i++) {
            this.caracteristicas[i] = caracteristas[i];
        }
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public String getArtistaResponsavel() {
        return artistaResponsavel;
    }

    public void acrescentaComprador(Colecionador comprador) {
        if (comprador != null) {
            this.compradores.add(comprador);
        }
    }

    public ArrayList<Colecionador> getCompradores() {
        return compradores;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", artistaResponsavel='" + artistaResponsavel + '\'' +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", valor=" + valor +
                ", caracteristicas=" + Arrays.toString(caracteristicas) +
                '}';
    }

    public String toString2() {
        return "Obra{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", artistaResponsavel='" + artistaResponsavel + "}";
    }
}
