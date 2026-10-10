package Coisa;

public class Coisa {
    public static void main(String[] args) {
        registrarDescanso();
        System.out.println("-----");
        registrarTempoOnline();
        System.out.println("-----");
        controlarDisciplina();
        System.out.println("-----");
        registrarResumos();
    }
    public static void registrarDescanso() {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }
    private static void registrarTempoOnline() {
        RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        tempoLP2.adicionaTempoOnline(10);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        tempoLP2.adicionaTempoOnline(2);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());
        System.out.println(tempoLP2.toString());
        RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
        System.out.println(tempoP2.toString());
    }
    private static void controlarDisciplina() {
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());
        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());

        Disciplina poo = new Disciplina("POO", 3);
        poo.cadastraHoras(60);
        poo.cadastraNota(1, 8.0);
        poo.cadastraNota(2, 9.0);
        poo.cadastraNota(3, 7.0);
        System.out.println(poo.aprovado());
        System.out.println(poo.toString());

        Disciplina calculo = new Disciplina("CALCULO", 2, new int[]{6, 4});
        calculo.cadastraHoras(80);
        calculo.cadastraNota(1, 8.0);
        calculo.cadastraNota(2, 10.0);
        System.out.println(calculo.aprovado());
        System.out.println(calculo.toString());

        Disciplina fisica = new Disciplina("FISICA", 2, new int[]{7, 3});
        fisica.cadastraNota(1, 5.0);
        fisica.cadastraNota(2, 10.0);
        System.out.println(fisica.aprovado());
        System.out.println(fisica.toString());

        Disciplina historia = new Disciplina("HISTORIA", 5);
        historia.cadastraNota(1, 6.0);
        historia.cadastraNota(2, 8.0);
        historia.cadastraNota(3, 9.0);
        historia.cadastraNota(4, 7.0);
        historia.cadastraNota(5, 10.0);
        System.out.println(historia.aprovado());
        System.out.println(historia.toString());
    }

    private static void registrarResumos() {
        RegistroResumos meusResumos = new RegistroResumos(100);  // 100 resumos
        meusResumos.adicionaResumo("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
        meusResumos.adicionaResumo("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");
        String[] resumos = meusResumos.pegaResumos();
        for (int i = 0; i < meusResumos.contaResumos(); i++) {
            System.out.println(resumos[i]);
        }
        System.out.println();
        System.out.println("Resumos: ");
        System.out.println(meusResumos.imprimeResumos());
        System.out.println(meusResumos.temResumo("Classes"));
        System.out.println(meusResumos.temResumo("Objetos"));
        System.out.println();
        String[] buscadas = meusResumos.busca("um");
        for (String palavra : buscadas) {
            if (palavra != null) {
                System.out.println(palavra);
            }
        }
    }
}

