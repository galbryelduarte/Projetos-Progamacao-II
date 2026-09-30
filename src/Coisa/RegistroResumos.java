package Coisa;

public class RegistroResumos {
    int numero;
    int indice;
    String[] temas;
    String[] conteudos;

    /**
     * Cria e inicializa o objeto registro de resumos;
     * @param numeroDeResumos define a quantidade maxima de resumos que podem ser cadastrados;
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numero = numeroDeResumos;
        this.temas = new String[numero];
        this.conteudos = new String[numero];
    }

    /**
     * Adiciona um novo resumo na lista de resumos, caso o tema ja não esteja cadastrado;
     * @param tema define o tema do resumo;
     * @param conteudo define o conteudo do resumo;
     */
    public void adicionaResumo(String tema, String conteudo) {
        for (String i : this.temas) {
            if (i != null && i.equals(tema)) {
                System.out.println("Esse tema já foi acrescentado a lista de resumos");
                return;
            }
        }
        if (indice == numero) {
            indice = 0;
        }
        this.temas[indice] = tema;
        this.conteudos[indice] = conteudo;
        this.indice += 1;
    }

    /**
     * Pega os resumos que foram cadastrados e junta o tema com o conteudo;
     * @return retorna um vetor com os resumos cadastrados;
     */
    public String[] pegaResumos() {
        String[] resumos = new String[contaResumos()];

        for (int i = 0; i < contaResumos(); i++) {
            resumos[i] = this.temas[i] + ": " + this.conteudos[i];
        }

        return resumos;
    }

    /**
     * Conta quantos resumos foram cadastrados no momento;
     * @return retorna a quantidade de resumos cadastrados;
     */
    public int contaResumos() {
        int contador = 0;

        for (int i = 0; i < conteudos.length; i++) {
            if (conteudos[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Verifica se existe algum resumo cadastrado com o tema informado;
     * @param tema tema que sera procurado na lista de resumos;
     * @return true se o tema existir e false caso não exista;
     */
    public boolean temResumo(String tema) {
        for (String titulo : this.temas) {
            if (titulo != null && titulo.equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Transforma os resumos cadastrados em uma representação String;
     * @return retorna uma String com a quantidade de resumos e seus respectivos temas;
     */
    public String imprimeResumos() {
        String resumos = "";

        for (int i = 0; i < contaResumos(); i++) {
            if (i > 0) {
                resumos += " | ";
            }
            resumos += this.temas[i];
        }

        return "\n- " + contaResumos() + " resumo(s) cadastrado(s)\n"
                + "- " + resumos;
    }
}
