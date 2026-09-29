package Bicicleta;
import java.util.Scanner;

/**
 * Gerenciador de uma bicicleta que guarda informações sobre a velocidade atual, velocidade máxima e o modelo.
 * A velocidade muda em 2 ou -2 se acelerada ou desacelerada. Pode-se parar a bicicleta. Pode-se comparar os modelos de duas para ver se são iguais.
 *
 * @author Gabryel Duarte Leal Farias
 */

public class Bicicleta {
    final String modelo;
    final int velocidadeMaxima;
    int velocidadeAtual;

    public Bicicleta (String modelo, int velocidadeMaxima) {
        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0;
    }

    /**
     * Se a opção do usuario for == 1 a bicicleta acelera, se for == 2 a bicicleta desacelera. se for 3 a bicicleta para.
     * @param opcaoVelocidade variavel que determina se a bicicleta vai acelerar ou desacelerar.
     */
    public void alteraVelocidade(int opcaoVelocidade) {
        if (opcaoVelocidade == 1) {
            if (velocidadeAtual >= velocidadeMaxima) {
                System.out.println("A velocidade não pode aumentar mais pois a bicicleta alcançou o limite");
            }
            else {
                velocidadeAtual += 2;
            }
        }
        else if (opcaoVelocidade == 2) {
            if (velocidadeAtual > 0) {
                velocidadeAtual -= 2;
            }
            else {
                System.out.println("A velocidade não pode abaixar mais pois a bicicleta está parada.");
            }
        }
        else if (opcaoVelocidade == 3){
            velocidadeAtual = 0;
        }
    }

    /**
     * Transforma o objeto em String;
     * @return objeto declarado como String;
     */
    public String toString() {
        return "Modelo: " + this.modelo + "| Velocidade Máxima" + this.velocidadeMaxima;
    }

    /**
     * Verifica a igualdade do modelo entre duas bicicletas
     * @param outra a outra bicicleta que será comparada com a atual
     * @return se a igualdade é verdadeira ou falsa
     */

    public boolean igualdade(Bicicleta outra) {
        return this.modelo.equals(outra.modelo);
    }

    /**
     * Através de um menu interativo, o main executa as funções do código
     */

    static void main (String[] args){
        Scanner ler = new Scanner(System.in);
        Bicicleta bicicleta1 = new Bicicleta("monark", 40);
        Bicicleta bicicleta2 = new Bicicleta("monark", 50);
        while (true) {
        System.out.println("Menu interativo \n Velocidade Atual: " + bicicleta1.velocidadeAtual + "km/h \n 1. Aumentar velocidade; \n 2. Diminuir velocidade; \n 3. Parar bicicleta6; \n 4. Exibir informações do modelo;  \n 5. Comparar bicicletas; \n 6. Sair;");
        int opcao = ler.nextInt();
        if (opcao <= 3) {
            bicicleta1.alteraVelocidade(opcao);
        }
        else if (opcao == 4) {
            System.out.println(bicicleta1);
        }
        else if (opcao == 5) {
            System.out.println("Igualdade entre bicicleta1 e bicicleta2: " + bicicleta1.igualdade(bicicleta2));
        }
        else {
            break;
        }
        }
    }
}
