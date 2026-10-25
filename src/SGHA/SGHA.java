package SGHA;
import java.util.ArrayList;
import java.util.Random;

public class SGHA {
    private Participante[] participantes;
    private Desafio[] desafios;
    private ArrayList<Integer> indicesSorteados;
    private ArrayList<Participante> vencedoresSorteio;
    private ArrayList<Equipe> equipes;
    private int contadorParticipantes;

    public SGHA() {
        this.participantes = new Participante[300];
        this.desafios = new Desafio[20];
        this.indicesSorteados = new ArrayList<>();
        this.vencedoresSorteio = new ArrayList<>();
        this.contadorParticipantes = 0;
        this.equipes = new ArrayList<>();
    }

    public void cadastraParticipante(String nome, String email, String instituicao) {
        //para evitar nullPointerException quando for comparar emails.
        if (email == null) {
            throw new IllegalArgumentException("Email inválido.");
        }
        Participante participante = new Participante(nome, email, instituicao);
        for (int i = 0; i < participantes.length; i++) {
            if (this.participantes[i] != null && this.participantes[i].equals(participante)) {
                throw new IllegalArgumentException("Este participante já foi cadastrado.");
            }
        }
        for (int i = 0; i < participantes.length; i++) {
            if (this.participantes[i] == null) {
                this.participantes[i] = participante;
                this.contadorParticipantes++;
                return;
            }
        }
        throw new IllegalArgumentException("Não há mais vagas disponíveis");
    }

    public String fazerSorteio() {
        if (this.contadorParticipantes == 0) {
            throw new IllegalArgumentException("Não há participantes para fazer sorteio");
        }
        if (this.indicesSorteados.size() == this.contadorParticipantes) {
            throw new IllegalArgumentException("Todos participantes já foram sorteados");
        }
        ArrayList<Integer> disponiveis = new ArrayList<>();
        for (int i = 0; i < this.contadorParticipantes; i++) {
            if (!this.indicesSorteados.contains(i)) {
                disponiveis.add(i);
            }
        }
        Random aleatorio = new Random();
        int escolhaAleatoria = aleatorio.nextInt(disponiveis.size());
        int numero = disponiveis.get(escolhaAleatoria);
        this.indicesSorteados.add(numero);
        this.vencedoresSorteio.add(this.participantes[numero]);
        return "\nNome: " + this.participantes[numero].getNome() +
                "\nEmail: " + this.participantes[numero].getEmail();
    }

    public ArrayList<Participante> getVencedoresSorteio(){
        return this.vencedoresSorteio;
    }

    public int cadastrarDesafio(String titulo, String descricao, String mentor, int quantidadeVagas) {
        if (titulo == null) {
            throw new IllegalArgumentException("O título não pode ser nulo.");
        }
        Desafio desafio = new Desafio(titulo, descricao, mentor, quantidadeVagas);
        for (int i = 0; i < this.desafios.length; i++) {
            if (this.desafios[i] != null && this.desafios[i].equals(desafio)) {
                throw new IllegalArgumentException("Esse desafio já foi incluido");
            }
        }
        for (int i = 0; i < this.desafios.length; i++) {
            if (this.desafios[i] == null) {
                this.desafios[i] = desafio;
                return i+1;
            }
        }
        throw new IllegalArgumentException("Não há mais espaços para desafios.");
    }

    public int cadastrarDesafio(String titulo, String descricao, String mentor, int quantidadeVagas, String[] palavrasChave) {
        if (titulo == null) {
            throw new IllegalArgumentException("O título não pode ser nulo.");
        }
        if (palavrasChave.length > 3) {
            throw new IllegalArgumentException("Só é permitido cadastrar 3 palavras-chaves");
        }
        Desafio desafio = new Desafio(titulo, descricao, mentor, quantidadeVagas, palavrasChave);
        for (int i = 0; i < this.desafios.length; i++) {
            if (this.desafios[i] != null && this.desafios[i].equals(desafio)) {
                throw new IllegalArgumentException("Esse desafio já foi incluido");
            }
        }
        for (int i = 0; i < this.desafios.length; i++) {
            if (this.desafios[i] == null) {
                this.desafios[i] = desafio;
                return i+1;
            }
        }
        throw new IllegalArgumentException("Não há mais espaços para desafios.");
    }

    public void cadastrarEquipe(String nome, String categoria, int idParticipante) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        Equipe equipe = new Equipe(nome, categoria, this.participantes[idParticipante-1]);
        for (int i = 0; i < this.equipes.size(); i++) {
            if (this.equipes.get(i).equals(equipe)) {
                throw new IllegalArgumentException("Esta equipe já foi cadastrada");
            }
        }
        this.equipes.add(equipe);
    }

    public void cadastrarParticipanteEmEquipe(int idParticipante, int idEquipe) {
        if (this.participantes[idParticipante-1] == null) {
            throw new IllegalArgumentException("Essa posição de participante é nula");
        }
        this.equipes.get(idEquipe).cadastraParticipante(this.participantes[idParticipante-1]);

    }

    public void finalizarDesafio(int idDesafio) {
        if (this.desafios[idDesafio-1] != null) {
            this.desafios[idDesafio-1].setStatus("Concluído");
        }
    }

    public ArrayList<Equipe> getEquipes() {
        return this.equipes;
    }
    public Participante[] getParticipantes() {
        return this.participantes;
    }

}
