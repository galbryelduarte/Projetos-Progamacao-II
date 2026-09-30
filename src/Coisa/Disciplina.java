package Coisa;

public class Disciplina {
    String disciplina;
    int horas = 0;
    double nota1;
    double nota2;
    double nota3;
    double nota4;

    /**
     * Cria e inicializa o objeto disciplina;
     * @param nomeDisciplina o nome da disciplina;
     */
    public Disciplina (String nomeDisciplina) {
        this.disciplina = nomeDisciplina;
    }

    /**
     * Soma horas ao total ja acumulado;
     * @param horasAcrescentar inteiro que será somado ao total ja acumulado;
     */
    public void cadastraHoras(int horasAcrescentar) {
        horas += horasAcrescentar;
    }

    /**
     * dado a opção, cadastra as notas no espaço adequado definido pela opção;
     * @param nota inteiro que define qual nota será alterada;
     * @param valorNota double que representa o valor da nota em si a ser acrescentada;
     */
    public void cadastraNota(int nota, double valorNota) {
        switch (nota) {
                case 1 -> nota1 = valorNota;
                case 2 -> nota2 = valorNota;
                case 3 -> nota3 = valorNota;
                case 4 -> nota4 = valorNota;
                default -> System.out.println("valor inválido");
        }
    }

    /**
     * método que verifica se a media do estudante é o bastante para aprovação;
     * @return true se for maior igual a 7 ou false se não for;
     */
    public boolean aprovado() {
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        if (media >= 7.0) {
            return true;
        }
        return false;
    }

    /**
     * método que transforma as informações do objeto como nome da disciplina, horas, media e notas em representação String;
     * @return as informações do objeto como String;
     */
    public String toString() {
        return (this.disciplina + " " + this.horas + " "  + ((nota1+nota2+nota3+nota4)/4) + " [" + nota1 + "," + nota2 + "," + nota3 + "," + nota4 + "]");
    }
}
