package JogoDoBixo;
import java.util.Random;

/**
 * Gerenciador do Jogo do Bicho que permite recuperar animais por números,
 * realizar apostas aleatórias e imprimir os bilhetes.
 *
 * @author Gabryel Duarte Leal Farias
 */

public class JogoDoBixo {
    /**
     * Dado um número inteiro recupera o bicho correspondente a esse número, em grupos de 4 de 1 a 25 animais.
     *
     * @param numero O número informado para descobrir o animal.
     * @return O nome do bicho correspondente ou "Inválido" se o número não existir.
     */
    public String pegarBixo(int numero) {
        if (numero < 1 || numero > 100) {
            return "Inválido";
        }
        // Fórmula matemática para descobrir o grupo (de 1 a 25)
        int grupo = (numero - 1) / 4 + 1;
        // O switch escolhe o bicho direto pelo número do grupo
        return switch (grupo) {
            case 1 -> "Avestruz";
            case 2 -> "Águia";
            case 3 -> "Burro";
            case 4 -> "Borboleta";
            case 5 -> "Cachorro";
            case 6 -> "Cabra";
            case 7 -> "Carneiro";
            case 8 -> "Camelo";
            case 9 -> "Cobra";
            case 10 -> "Coelho";
            case 11 -> "Cavalo";
            case 12 -> "Elefante";
            case 13 -> "Galo";
            case 14 -> "Gato";
            case 15 -> "Jacaré";
            case 16 -> "Leão";
            case 17 -> "Macaco";
            case 18 -> "Porco";
            case 19 -> "Pavão";
            case 20 -> "Peru";
            case 21 -> "Touro";
            case 22 -> "Tigre";
            case 23 -> "Urso";
            case 24 -> "Veado";
            case 25 -> "Vaca";
            default -> "Inválido";
        };
    }

    /**
     * Gera uma lista de 5 números aleatórios.
     *
     * @return a lista de 5 números inteiros
     */
    public int[] fazerAposta() {
        Random aleatorio = new Random();
        int[] lista = new int[5];
        for (int j = 0; j < 5; j++) {
            lista[j] = -1;
        }
        int i = 0;
        while (i != 5) {
            int atual = aleatorio.nextInt(100) +1;
            if (atual != lista[0] && atual != lista[1] && atual != lista[2] && atual != lista[3] && atual != lista[4] ) {
                lista[i] = atual;
                i ++;
            }
        }
        for (int k = 1; k < lista.length; k++) {
            int chave = lista[k];
            int l = k - 1;
            while (l >= 0 && lista[l] > chave) {
                lista[l+1] = lista[l];
                l -= 1;
            }
            lista[l+1] = chave;
        }
        return lista;
    }
    /**
     * Imprime os animais correspondentes a cada número inteiro presente na listaDeNumeros.
     *
     * @param listaDeNumeros um array de numeros inteiros aleatorios apostados.
     */
    public void imprimirAposta(int[] listaDeNumeros) {
        for(int numero : listaDeNumeros) {
            String bixo = pegarBixo(numero);
            System.out.println(bixo + ";");
        }
    }
    /**
     * Executa as principais funções do código
     */
    public static void main (String[] args) {
        JogoDoBixo jogo = new JogoDoBixo();
        int[] bilhete = jogo.fazerAposta();
        System.out.println("Bilhete gerado: ");
        for (int numero : bilhete) {
            System.out.print(numero + " ");
        }
        System.out.println();
        System.out.println("Animais sorteados: ");
        jogo.imprimirAposta(bilhete);
    }
}
