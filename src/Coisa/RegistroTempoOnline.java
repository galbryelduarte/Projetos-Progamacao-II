package Coisa;

public class RegistroTempoOnline {
    String disciplina;
    int tempoOnline = 0;
    int metaTempoOnline;

    /**
     * Cria e inicializa um objeto com o nome da disciplina e o tempo online esperado nela;
     * @param nomeDisciplina nome da disciplina;
     * @param tempoOnlineEsperado tempo online esperado nela;
     */
    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
        this.disciplina = nomeDisciplina;
        this.metaTempoOnline = tempoOnlineEsperado;
    }

    /**
     * Cria e inicializa um objeto com o nome da disciplina e o tempo online esperado padrao de 120 horas;
     * @param nomeDisciplina nome da disciplina;
     */
    public RegistroTempoOnline (String nomeDisciplina) {
        this.disciplina = nomeDisciplina;
        this.metaTempoOnline = 120;
    }

    /**
     * Soma horas a variável tempoOnline;
     * @param tempo inteiro que representa horas a serem somadas ao tempo ja registrado;
     */
    public void adicionaTempoOnline(int tempo) {
        tempoOnline += tempo;
    }

    /**
     * Metodo que verifica se o tempo online registrado já ultrapassou a meta de tempo online;
     * @return 'true' se atingiu ou ja ultrapassou e 'false' se ainda nao ultrapassaou.
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnline >= metaTempoOnline) {
            return true;
        }
        return false;
    }

    /**
     * Transforma as variavéis do objeto em string;
     * @return retorna uma representação textual das informações do objeto.
     */
    public String toString() {
        return (this.disciplina + " " + this.tempoOnline + "/" + this.metaTempoOnline);
    }
}
