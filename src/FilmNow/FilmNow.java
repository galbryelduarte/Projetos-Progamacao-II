package FilmNow;

public class FilmNow {
    private Filme[] filmes = new Filme[100];
    private Filme[] listaFilmesHot = new Filme[10];

    private int getPosicaoHot (int posicao) {
        for (int i = 0; i < this.listaFilmesHot.length; i++) {
            if (this.listaFilmesHot[i] != null) {
                if (this.filmes[posicao-1].equals(this.listaFilmesHot[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String adicionarFilme(int posicao, String nome, String ano, String local){
        if (posicao > 100 || posicao < 1) {return "POSIÇÃO INVÁLIDA";}
        if (nome == null || nome.equals("") || local == null || local.trim().equals("")) {return "FILME INVÁLIDO";}
        Filme filme = new Filme(nome, ano, local);
        for (int i = 0; i < this.filmes.length; i++) {
            if (this.filmes[i] != null && this.filmes[i].equals(filme)) {
                return "FILME JA ADICIONADO";
            }
        }
        if (this.filmes[posicao-1] != null && this.filmes[posicao-1].getStatus().equals("\uD83D\uDD25")) {
            removerFilmeHot(getPosicaoHot(posicao)+1);}
        this.filmes[posicao-1] = filme;
        return "FILME ADICIONADO";
    }

    public String detalharFilme(int posicao) {
        if (posicao < 1 || posicao > 100) {return "POSIÇÃO INVÁLIDA";}
        if (this.filmes[posicao-1] == null) {return "POSIÇÃO INVÁLIDA";}
        return this.filmes[posicao-1].getStatus() + this.filmes[posicao-1].toString();
    }

    public String exibirTodosFilmes() {
        String filmes = "";
        for (int i = 0; i < this.filmes.length; i++) {
            if (this.filmes[i] != null) {
                filmes += "\n" + this.filmes[i].getStatus() + (i+1) + " - " + this.filmes[i].getNome();
            }
        }
        return filmes;
    }

    public String adicionarHotFilme (int posicaoGeral, int posicaoHot) {
        if (posicaoHot < 1 || posicaoHot > 10 || posicaoGeral < 1 || posicaoGeral > 100) {return "POSIÇÃO INVÁLIDA";}
        if (this.filmes[posicaoGeral-1] == null) {return "NÃO HÁ FILME NESSA POSIÇÃO";}
        if (this.filmes[posicaoGeral-1].getStatus().equals("\uD83D\uDD25")) {return "ESTE FILME JÁ ESTÁ NA HOTLIST";}
        if (this.listaFilmesHot[posicaoHot-1] != null) {listaFilmesHot[posicaoHot-1].mudarStatusHot(false);}

        this.filmes[posicaoGeral-1].mudarStatusHot(true);
        this.listaFilmesHot[posicaoHot-1] = this.filmes[posicaoGeral-1];
        return "ADICIONADO NA HOTLIST NA POSIÇÃO " + posicaoHot + "!";
    }

    public String exibirHotList() {
        String hotList = "";
        for (int i = 0; i < this.listaFilmesHot.length; i++) {
            if (this.listaFilmesHot[i] != null) {
                hotList += "\n" + (i+1) + " - " + this.listaFilmesHot[i].getNome();}
        }
        return hotList;
    }

    public String removerFilmeHot (int posicaoHot) {
        if (listaFilmesHot[posicaoHot-1] == null || posicaoHot < 1 || posicaoHot > 10) { return "POSIÇÃO INVÁLIDA";}
        this.listaFilmesHot[posicaoHot-1].mudarStatusHot(false);
        this.listaFilmesHot[posicaoHot-1] = null;
        return "MUDANÇA FEITA!";
    }
}
