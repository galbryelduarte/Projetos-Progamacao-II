package SIFE;
import java.util.ArrayList;

public class SIFE {
    private Participante[] participantes;
    private ArrayList<Palestra> palestras;
    private ArrayList<Projeto> projetos;

    public SIFE() {
        this.participantes = new Participante[200];
        this.palestras = new ArrayList<>();
        this.projetos = new ArrayList<>();
    }

    public int cadastraParticipante(String nome, String email, String instituicao) {
        Participante participante = new Participante(nome, email, instituicao);
        for (int i = 0; i < this.participantes.length; i++) {
            if (this.participantes[i] != null && this.participantes[i].equals(participante)) {
                throw new IllegalStateException("Esse participante já foi cadastrado no evento.");
            }
        }
        for (int i = 0; i < this.participantes.length; i++) {
            if (this.participantes[i] == null) {
                this.participantes[i] = participante;
                return i+1;
            }
        }
        throw new IllegalStateException("Não há mais vagas disponíveis no evento.");
    }

    public void cadastraProjeto(String titulo, String descricao, String areaAtuacao, Participante responsavel) {
        Projeto projeto = new Projeto(titulo, descricao, areaAtuacao, responsavel);
        for (int i = 0; i < this.projetos.size(); i++) {
            if (this.projetos.get(i).equals(projeto)) {
                throw new IllegalStateException("Esse projeto já foi cadastrado");
            }
        }
        this.projetos.add(projeto);
    }

    public void cadastraPalestra(String titulo, String descricao, String palestrante, int quantidadeVagas) {
        Palestra palestra = new Palestra(titulo,descricao,palestrante,quantidadeVagas);
        this.palestras.add(palestra);
    }

    public String getTresMelhoresProjetos () {
        String melhores = "Ranking:\n";
        ArrayList<Integer> achados = new ArrayList<>(3);
        for (int i = 0; i < 3; i ++) {
            double maior = 0;
            String melhor = "";
            int indiceMelhor = -1;
            for (int j = 0; j < projetos.size(); j++) {
                if (this.projetos.get(j).getMedia() > maior && !achados.contains(j)) {
                    maior = this.projetos.get(j).getMedia();
                    melhor = this.projetos.get(j).getTitulo();
                    indiceMelhor = j;
                }
            }
            if (indiceMelhor != -1) {
                achados.add(indiceMelhor); }
            melhores += (i+1) + ". " + melhor + "\n";
        }
        return melhores;
    }

    public Participante getParticipante(int idParticipante) {
        return this.participantes[idParticipante];
    }

    public ArrayList<Projeto> getProjetos() {
        return this.projetos;
    }
}
