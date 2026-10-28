package BlaCarCar;

import java.util.ArrayList;

public class Viagem {
    private String nome;
    private String descricao;
    private int quantidadeMaxima;
    private String contato;
    private String[] pontosParada;
    private ArrayList<Passageiro> listaInscritos;
    private Passageiro[] listaConfirmados;
    private int contadorConfirmados;

    public Viagem(String nome, String descricao, int quantidadeMaxima, String contato, String[] pontosParada) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeMaxima = quantidadeMaxima;
        this.contato = contato;
        this.pontosParada = new String[3];
        this.listaInscritos = new ArrayList<>();
        this.listaConfirmados = new Passageiro[quantidadeMaxima];
        this.contadorConfirmados = 0;
        for (int i = 0; i < pontosParada.length; i++) {
            this.pontosParada[i] = pontosParada[i];
        }
    }

    public void inscreverPassageiro(Passageiro passageiro) {
        this.listaInscritos.add(passageiro);
    }

    public void confirmarPassageiro(Passageiro passageiro) {
        for (int i = 0; i < this.listaConfirmados.length; i++) {
            if (this.listaConfirmados[i] == null) {
                this.listaConfirmados[i] = passageiro;
                this.contadorConfirmados++;
                return;
            }
        }
    }

    public String[] getPontosParada() {
        return pontosParada;
    }
    public void incrementeContadorConfirmados() {
        this.contadorConfirmados++;
    }

    public int getContadorConfirmados() {
        return contadorConfirmados;
    }

    public ArrayList<Passageiro> getListaInscritos() {
        return listaInscritos;
    }

    public Passageiro[] getListaConfirmados() {
        return listaConfirmados;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }
}
