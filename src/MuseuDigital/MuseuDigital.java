package MuseuDigital;
import java.util.ArrayList;

public class MuseuDigital {
    private ArrayList<Artista> artistas;
    private ArrayList<Obra> obras;
    private ArrayList<Colecionador> colecionadores;
    private ArrayList<Colecionador> compradores;

    public MuseuDigital() {
        this.artistas = new ArrayList<>();
        this.obras = new ArrayList<>();
        this.colecionadores = new ArrayList<>();
        this.compradores = new ArrayList<>();
    }
    public boolean cadastrarArtista(String nome, String biografia, String[] tipoExpressao){
        if (nome == null) {
            return false;
        }
        if (tipoExpressao.length > 3) {
            return false;
        }
        for (int i = 0; i < tipoExpressao.length; i++) {
            if (!tipoExpressao[i].equals("Arte gráfica") &&
                    !tipoExpressao[i].equals("Música") &&
                    !tipoExpressao[i].equals("Fotografia") &&
                    !tipoExpressao[i].equals("Animação")) {
                return false;
            }
        }
        Artista artista = new Artista(nome, biografia, tipoExpressao);
        for (int i = 0; i < this.artistas.size(); i++) {
            if (this.artistas.get(i).equals(artista)) {
                return false;
            }
        }
        this.artistas.add(artista);
        return true;
    }

    public void atualizarBioArtista(String nomeArtista, String novaBio) {
        if (nomeArtista == null) {
            throw new IllegalArgumentException("Nome inválido");
        }
        for (int i = 0; i < this.artistas.size(); i++) {
            if (this.artistas.get(i).getNome().equals(nomeArtista)){
                this.artistas.get(i).setBiografia(novaBio);
                return;
            }
        }
    }

    public String[] listarArtistas() {
        String[] retorno = new String[this.artistas.size()];
        for (int i = 0; i < this.artistas.size(); i++) {
            retorno[i] = this.artistas.get(i).toString();
        }
        return retorno;
    }

    public int cadastrarObra(String titulo, String tipo, String artista, int quantidadeDisponivel, double valor, String[] caracteristas){
        if (caracteristas.length > 3) {
            return (-1);
        }
        for (int i = 0; i < caracteristas.length; i++) {
            if (!caracteristas[i].equals("abstrato") &&
                    !caracteristas[i].equals("interativo") &&
                    !caracteristas[i].equals("pixel art") &&
                    !caracteristas[i].equals("3D") &&
                    !caracteristas[i].equals("paisagem")) {
                    return (-1);
            }
        }

        if (artista == null) {
            return (-1);
        }
        Obra obra = new Obra(titulo, tipo, artista, quantidadeDisponivel, valor, caracteristas);
        for (int i = 0; i < this.artistas.size(); i++) {
            if (this.artistas.get(i).getNome().equals(artista)) {
                String[] aceitos = this.artistas.get(i).getTipoExpressao();
                for (int j = 0; j < aceitos.length; j++) {
                    if (tipo.equals(aceitos[j])) {
                        this.obras.add(obra);
                        return (this.obras.size()-1);
                    }
                }
            }
        }
        return (-1);
    }

    public String[] listarObras() {
        String[] retorno = new String[this.obras.size()];
        for (int i = 0; i < this.obras.size(); i++) {
            retorno[i] = this.obras.get(i).toString();
        }
        return retorno;
    }

    public boolean cadastrarColecionador(String nome, String cpf, String[] interesses) {
        if (cpf == null) {
            return false;
        }
        if (interesses.length != 3) {
            return false;
        }
        for (int i = 0; i < interesses.length; i++) {
            if (!interesses[i].equals("abstrato") &&
                    !interesses[i].equals("interativo") &&
                    !interesses[i].equals("pixel art") &&
                    !interesses[i].equals("3D") &&
                    !interesses[i].equals("paisagem")) {
                return false;
            }
        }
        Colecionador colecionador= new Colecionador(nome, cpf, interesses);
        for (int i = 0; i < this.colecionadores.size(); i++) {
            if (this.colecionadores.get(i).equals(colecionador)) {
                return false;
            }
        }
        this.colecionadores.add(colecionador);
        return true;
    }

    public boolean cadastrarColecionador(String nome, String cpf, String[] interesses, String link) {
        if (cpf == null || link == null) {
            return false;
        }
        if (interesses.length != 3) {
            return false;
        }
        for (int i = 0; i < interesses.length; i++) {
            if (!interesses[i].equals("abstrato") &&
                    !interesses[i].equals("interativo") &&
                    !interesses[i].equals("pixel art") &&
                    !interesses[i].equals("3D") &&
                    !interesses[i].equals("paisagem")) {
                return false;
            }
        }
        Colecionador colecionador= new Colecionador(nome, cpf, interesses);
        colecionador.setLink(link);
        for (int i = 0; i < this.colecionadores.size(); i++) {
            if (this.colecionadores.get(i).equals(colecionador)) {
                return false;
            }
        }
        this.colecionadores.add(colecionador);
        return true;
    }

    public String[] listarColecionadores() {
        String[] retorno = new String[this.colecionadores.size()];
        for (int i = 0; i < this.colecionadores.size(); i++) {
            retorno[i] = this.colecionadores.get(i).toString();
        }
        return retorno;
    }

    public int consultarAfinidade(int idColecionador, int idObra) {
        int emComum = 0;
        for (int i = 0; i < this.obras.get(idObra).getCaracteristicas().length; i++) {
            for (int j = 0; j < this.colecionadores.get(idColecionador).getInteresses().length; j++) {
                if (this.obras.get(idObra).getCaracteristicas()[i].equals(this.colecionadores.get(idColecionador).getInteresses()[j])) {
                    emComum++;
                }
            }
        }
        if (emComum == 1) {
            return 30;
        }
        if (emComum == 2) {
            return 70;
        }
        if (emComum == 3) {
            return 100;
        }
        return 0;
    }

    private int encontraIdColecionador(String cpf) {
        int idColecionador = -1;
        for (int i = 0; i < this.colecionadores.size(); i++) {
            if (this.colecionadores.get(i).getCPF().equals(cpf)) {
                idColecionador = i;
                break;
            }
        }
        return idColecionador;
    }

    public String[] listarObrasCompativeis(String cpf, int afinidade) {
        int idColecionador = encontraIdColecionador(cpf);
        ArrayList<String> compativeis = new ArrayList<>();
    if (idColecionador == -1) {
        throw new IllegalArgumentException("Não foram achados colecionadores com esse CPF");
    }
    if (afinidade != 30 && afinidade != 70 && afinidade != 100) {
        throw new IllegalArgumentException("Afinidade inválida");
    }

    for (int i = 0; i < this.obras.size(); i++) {
        int afinidadeEncontrada = consultarAfinidade(idColecionador, i);
        if (afinidadeEncontrada >= afinidade) {
            compativeis.add(this.obras.get(i).toString2());
        }
    }
    String[] compativeisString = new String[compativeis.size()];
    for (int i = 0; i < compativeis.size(); i++){
        compativeisString[i] = compativeis.get(i);
    }
    return compativeisString;
    }

    public String exibirDetalhesObra(int indexObra) {
        return this.obras.get(indexObra).toString();
    }
    public void atualizarLinkPerfil(String cpf, String novoLink) {
        for (int i = 0; i < this.colecionadores.size(); i++) {
            if (this.colecionadores.get(i).getCPF().equals(cpf)) {
                this.colecionadores.get(i).setLink(novoLink);
                return;
            }
        }
        throw new IllegalArgumentException("Não foram achados colecionadores com esse CPF");
    }

    public void comprarEdicao(String cpf, int indexObra) {
        if (this.obras.get(indexObra).getQuantidadeDisponivel() == 0) {
            throw new IllegalArgumentException("OBRA INDISPONÍVEL");
        }
        for (int i = 0; i < this.colecionadores.size(); i++) {
            if (this.colecionadores.get(i).getCPF().equals(cpf)) {
                this.compradores.add(this.colecionadores.get(i));
                break;
            }
        }
        String artista = this.obras.get(indexObra).getArtistaResponsavel();
        for (int i = 0; i < this.artistas.size(); i++) {
            if (this.artistas.get(i).getNome().equals(artista)) {
                this.artistas.get(i).incrementaContadorEdicoesVendidas();
                return;
            }
        }
    }

    public String[] listarCompradoresObra(int indexObra) {
        String[] compradoresString = new String[this.obras.get(indexObra).getCompradores().size()];
        ArrayList<Colecionador> compradores = this.obras.get(indexObra).getCompradores();
        for (int i = 0; i < compradoresString.length; i++) {
            int idColecionador = encontraIdColecionador(this.compradores.get(i).getCPF());
            compradoresString[i] = compradores.get(i).toString() + ", " + this.obras.get(indexObra).getTitulo() +
                    ", " + consultarAfinidade(idColecionador, indexObra);
        }
        return compradoresString;
    }

    public String emitirRelatorioMaioresVendas() {
        if (this.artistas.size() == 0) {
            throw new IllegalArgumentException("Ainda não foram cadastrados artistas.");
        }
        int maior = 0;
        Artista maiorVendendor = null;
        for (int i = 0; i < this.artistas.size(); i++) {
            if (this.artistas.get(i).getContadorEdicoesVendidas() > maior) {
                maior = this.artistas.get(i).getContadorEdicoesVendidas();
                maiorVendendor = this.artistas.get(i);
            }
        }
        return maiorVendendor.toString();
    }
}
