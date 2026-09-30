package Coisa;

public class Descanso {
    /**
     * a variavél horasDescanso representa as horas de descanso do estudante registradas.
     */
    int horasDescanso;
    /**
     * a variavél numeroSemanas representa a quantidade de semanas consideradas no calculo
     */
    int numeroSemanas;

    /**
     * Recebe um inteiro e o usa pra atualizar as horas de descanso nela;
     * @param valor inteiro que será usado pra atualizar as horas;
     */
    public void defineHorasDescanso(int valor) {
        horasDescanso = valor;
    }

    /**
     * Recebe um inteiro e o usa pra atualizar os numeros de semana nela.
     * @param valor inteiro que será usado pra atualizar o numero de semanas;
     */
    public void defineNumeroSemanas(int valor) {
        numeroSemanas = valor;
    }

    /**
     * Após o cálculo da média geral de descanso do estudante, retorna se ele está cansado ou descansado;
     * @return status geral descrevendo a situação do estudante como cansado ou descansado;
     */
    public String getStatusGeral() {
        if (numeroSemanas == 0) {
            return ("cansado");
        }
        double mediaDescanso = (double)horasDescanso / numeroSemanas;
        if (mediaDescanso >= 26) {
            return ("descansado");
        }
        return ("cansado");
    }
}
