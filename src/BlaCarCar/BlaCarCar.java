package BlaCarCar;

import java.util.ArrayList;

public class BlaCarCar {
    private ArrayList<Passageiro> passageiros;
    private ArrayList<Viagem> viagens;

    public BlaCarCar() {
        this.passageiros = new ArrayList<>();
        this.viagens = new ArrayList<>();
    }

    private int buscaIndicePassageiro(String cpf) {
        for (int i = 0; i < this.passageiros.size(); i++) {
            if (this.passageiros.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    public int cadastrarViagem(String motorista, String descricao, int vagas, String contato, String[] pontos) {
        if (pontos.length > 3) {
            throw new IllegalArgumentException("A quantidade máxima de pontos é 3.");
        }
        Viagem viagem = new Viagem(motorista, descricao, vagas, contato, pontos);
        this.viagens.add(viagem);
        return viagens.size();
    }

    public boolean cadastrarPassageiro(String nome, String cpf, String link, String[] pontos) {
        if (pontos.length > 3) {
            return false;
        }
        Passageiro passageiro = new Passageiro(nome, cpf, pontos);
        passageiro.setLink(link);
        this.passageiros.add(passageiro);
        return true;
    }

    public boolean cadastrarPassageiro(String nome, String cpf, String[] pontos) {
        if (pontos.length > 3) {
            return false;
        }
        Passageiro passageiro = new Passageiro(nome, cpf, pontos);
        this.passageiros.add(passageiro);
        return true;
    }

    public void atualizarLinkPerfil(String cpf, String novoLink) {
        int indicePassageiro = buscaIndicePassageiro(cpf);
        if (indicePassageiro == -1) {
            throw new IllegalArgumentException("CPF inexistente entre os passageiros cadastrados.");
        }
        this.passageiros.get(indicePassageiro).setLink(novoLink);
    }

    public String[] listarPassageiros() {
        String[] passageirosLista = new String[this.passageiros.size()];
        for (int i = 0; i < passageirosLista.length; i++) {
            passageirosLista[i] = this.passageiros.get(i).toString();
        }
        return passageirosLista;
    }

    public int calcularCompatibilidade(String cpf, int indexViagem) {
        int indicePassageiro = buscaIndicePassageiro(cpf);
        if (indicePassageiro == -1) {
            throw new IllegalArgumentException("CPF inexistente entre os passageiros cadastrados.");
        }
        if (indexViagem >= this.viagens.size()) {
            throw new IllegalArgumentException("Indice de viagem inexistente.");
        }
        int somadorCompatibilidade = 0;
        String[] pontosViagem = this.viagens.get(indexViagem).getPontosParada();
        String[] pontosPassageiro = this.passageiros.get(indicePassageiro).getPontosFrequentes();
        for (int i = 0; i < pontosViagem.length; i++) {
            if (pontosViagem[i] != null) {
                String ponto = pontosViagem[i];
                for (int j = 0; j < pontosPassageiro.length; j++) {
                    if (pontosPassageiro[j] != null) {
                        if (pontosPassageiro[j].equals(ponto)) {
                            somadorCompatibilidade++;
                            break;
                        }
                    }
                }
            }
        }
        if (somadorCompatibilidade == 1) {
            return 30;
        }
        if (somadorCompatibilidade == 2) {
            return 70;
        }
        if (somadorCompatibilidade == 3) {
            return 100;
        }
        return 0;
    }

    public void solicitarVaga(String cpf, int indexViagem) {
        if (indexViagem >= this.viagens.size()) {
            throw new IllegalArgumentException("Indice de viagem inexistente.");
        }
        int indicePassageiro = buscaIndicePassageiro(cpf);
        if (indicePassageiro == -1) {
            throw new IllegalArgumentException("CPF inexistente entre os passageiros cadastrados.");
        }
        this.viagens.get(indexViagem).inscreverPassageiro(this.passageiros.get(indicePassageiro));
    }

    public String[] listarPassageirosInscritosViagem(int indexViagem) {
        if (indexViagem >= this.viagens.size()) {
            throw new IllegalArgumentException("Indice de viagem inexistente.");
        }
        String[] listaInscritos = new String[this.viagens.get(indexViagem).getListaInscritos().size()];
        for (int i = 0; i < listaInscritos.length; i++) {
            listaInscritos[i] = this.viagens.get(indexViagem).getListaInscritos().get(i).getNome() + ", " +
                    this.viagens.get(indexViagem).getListaInscritos().get(i).getLink() + ", " +
                    calcularCompatibilidade(this.viagens.get(indexViagem).getListaInscritos().get(i).getCpf(), indexViagem);
        }
        return listaInscritos;
    }

    public String[] listarPassageirosConfirmadosViagem(int indexViagem) {
        if (indexViagem >= this.viagens.size()) {
            throw new IllegalArgumentException("Indice de viagem inexistente.");
        }
        String[] listaConfirmados = new String[this.viagens.get(indexViagem).getListaConfirmados().length];
        for (int i = 0; i < listaConfirmados.length; i++) {
            if (this.viagens.get(indexViagem).getListaConfirmados()[i] != null) {
                listaConfirmados[i] = this.viagens.get(indexViagem).getListaConfirmados()[i].getNome() + ", " +
                        this.viagens.get(indexViagem).getListaConfirmados()[i].getLink() + ", " +
                        calcularCompatibilidade(this.viagens.get(indexViagem).getListaConfirmados()[i].getCpf(), indexViagem);
            }
        }
        return listaConfirmados;
    }

    public String[] listarPassageirosInscritosCompativeis(int indexViagem, int compatibilidade) {
        if (indexViagem >= this.viagens.size()) {
            throw new IllegalArgumentException("Indice de viagem inexistente.");
        }
        String[] compativeis = new String[this.viagens.get(indexViagem).getListaInscritos().size()];
        for (int i = 0; i < compativeis.length; i++) {
            int compatibilidadePassageiro = calcularCompatibilidade(this.viagens.get(indexViagem).getListaInscritos().get(i).getCpf(), indexViagem);
            if (compatibilidadePassageiro >= compatibilidade) {
                compativeis[i] = this.viagens.get(indexViagem).getListaInscritos().get(i).getNome() + ", " +
                        this.viagens.get(indexViagem).getListaInscritos().get(i).getLink() + ", " +
                        calcularCompatibilidade(this.viagens.get(indexViagem).getListaInscritos().get(i).getCpf(), indexViagem);
            }
        }
        return compativeis;
    }

    public String[] confirmarPassageiros(int indexViagem, int compatibilidade) {
        if (indexViagem >= this.viagens.size()) {
            throw new IllegalArgumentException("Indice de viagem inexistente.");
        }
        Viagem viagemAtual = this.viagens.get(indexViagem);
        String[] listaConfirmados = new String[viagemAtual.getListaInscritos().size()];
        for (int i = 0; i < listaConfirmados.length; i++) {
            if (viagemAtual.getContadorConfirmados() >= viagemAtual.getQuantidadeMaxima()) {
                break;
            }
            Passageiro passageiro = viagemAtual.getListaInscritos().get(i);
            int compatibilidadePassageiro = calcularCompatibilidade(passageiro.getCpf(), indexViagem);
            if (compatibilidadePassageiro >= compatibilidade) {
                viagemAtual.confirmarPassageiro(passageiro);
                listaConfirmados[i] = passageiro.getNome() + ", " +
                        passageiro.getLink() + ", " +
                        compatibilidadePassageiro;
            }
        }
        return listaConfirmados;
    }
}
