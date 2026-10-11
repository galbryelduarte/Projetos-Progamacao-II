package Coisa;

public class Disciplina {
    String disciplina;
    int horas = 0;
    double nota1;
    double nota2;
    double nota3;
    double nota4;
    double[] notas;
    int[] pesos;
    /**
     * Cria e inicializa o objeto disciplina que recebe apenas o nome dela.
     * @param nomeDisciplina o nome da disciplina.
     */
    public Disciplina (String nomeDisciplina) {
        this.disciplina = nomeDisciplina;
    }

    /**
     * Cria e inicializa o objeto disciplina que recebe nome e notas.
     * @param nome o nome da disciplina.
     * @param numeroNotas número de notas que será registradas.
     */

    public Disciplina (String nome, int numeroNotas) {
        this.disciplina = nome;
        this.notas = new double[numeroNotas];
        this.pesos = new int[numeroNotas];
        for (int i = 0; i < numeroNotas; i++){
            this.pesos[i] = 1;
        }
    }
    /**
     * Cria e inicializa o objeto disciplina com nome da disciplina, numero de notas e pesos para notas.
     * @param nome o nome da disciplina.
     * @param numeroNotas número de notas que será registradas.
     * @param pesos lista de inteiros que representa o peso de cada nota.
     */

    public Disciplina (String nome, int numeroNotas, int[] pesos) {
        this.disciplina = nome;
        this.pesos = pesos;
        this.notas = new double[numeroNotas];
    }

    /**
     * Soma horas ao total ja acumulado.
     * @param horasAcrescentar inteiro que será somado ao total ja acumulado.
     */
    public void cadastraHoras(int horasAcrescentar) {
        horas += horasAcrescentar;
    }

    /**
     * dado a opção, cadastra as notas no espaco adequado definido pela opção.
     * @param nota inteiro que define qual nota será alterada.
     * @param valorNota double que representa o valor da nota em si a ser acrescentada.
     */
    public void cadastraNota(int nota, double valorNota) {
        if (notas == null) {
            switch (nota) {
                case 1 -> nota1 = valorNota;
                case 2 -> nota2 = valorNota;
                case 3 -> nota3 = valorNota;
                case 4 -> nota4 = valorNota;
                default -> System.out.println("valor inválido");
            }
        }
        else if (nota >= 1 && nota <= notas.length){
            notas[nota-1] = valorNota;
        }
        else {
            System.out.println("valor inválido");
        }
    }
    /**
     * calcula a media do estudante de acordo com o tipo de disciplina.
     * @return a media do estudante.
     */
    private double calcularMedia() {
        double media = 0;
        double total = 0;
        if (notas == null) {
            media = (nota1 + nota2 + nota3 + nota4) / 4;
        }
        else if (pesos != null) {
            int somaPesos = 0;
            for (int i = 0; i < notas.length; i++) {
                total += notas[i] * pesos[i];
                somaPesos += pesos[i];
            }
            media = total / somaPesos;
        }
        else {
            for (int i = 0; i < notas.length; i++) {
                total += notas[i];
            }
            media = total / notas.length;
        }
        return media;
    }

    /**
     * verifica se a media do estudante é o suficiente pra aprovação.
     * @return true ou false dependendo se a nota é maior igual ou menor que 7.0.
     */
    public boolean aprovado() {
        return calcularMedia() >= 7.0;
    }

    /**
     * metodo que transforma as informações do objeto como nome da disciplina, horas, media e notas em representação String.
     * @return as informações do objeto como String.
     */
    public String toString() {
        if (notas == null) {
            return (this.disciplina + " " + this.horas + " "  + calcularMedia() + " [" + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + "]");
        }
        String listaNotas = " [";
        for (int i = 0; i < notas.length; i++) {
            listaNotas += notas[i];
            if (notas.length-1 > i) {
                listaNotas += ", ";
            }
        }
        return (this.disciplina + " " + this.horas + " "  + calcularMedia() + listaNotas + "]");
    }
}
