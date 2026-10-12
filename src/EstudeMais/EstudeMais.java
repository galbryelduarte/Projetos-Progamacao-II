//testes criados com auxilio de IA para verificar funcionalidades do programa
package EstudeMais;
public class EstudeMais {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTES DO SISTEMA ESTUDEMAIS ===\n");

        // 1. Criando Alunos (Nome, CPF, Créditos Iniciais)
        Aluno aluno1 = new Aluno("Carlos Silva", "111.222.333-44", 0);
        Aluno aluno2 = new Aluno("Maria Souza", "555.666.777-88", 0);
        Aluno aluno3 = new Aluno("Pedro Santos", "999.000.111-22", 0); // Aluno intruso (não vai entrar no grupo)

        // 2. Criando o Grupo de Estudos (Tema, Limite Alunos, Limite Anotações)
        // Criamos com espaço para 2 alunos e 5 anotações
        GrupoDeEstudos grupo = new GrupoDeEstudos("Estrutura de Dados", 2, 5);

        System.out.println("--- Testando Cadastro de Alunos ---");

        // Teste 1: Cadastrar aluno 1 (Deve dar true)
        System.out.println("Cadastrando Carlos: " + grupo.cadastraAluno(aluno1));

        // Teste 2: Tentar cadastrar o Carlos de novo (Deve dar false pelo equals do CPF)
        System.out.println("Cadastrando Carlos de novo (Duplicado): " + grupo.cadastraAluno(aluno1));

        // Teste 3: Cadastrar aluno 2 (Deve dar true)
        System.out.println("Cadastrando Maria: " + grupo.cadastraAluno(aluno2));

        // Teste 4: Tentar cadastrar aluno 3 (Deve dar false porque o grupo está cheio, limite = 2)
        System.out.println("Cadastrando Pedro (Grupo Cheio): " + grupo.cadastraAluno(aluno3));

        System.out.println("\n--- Estado Atual do Grupo ---");
        System.out.println(grupo.toString());

        System.out.println("\n--- Testando Cadastro de Anotações ---");

        // Teste 5: Carlos cria anotação com tema correto (Deve dar true e somar 1 crédito)
        boolean nota1 = grupo.cadastraAnotacao("12/10/2026", "Estrutura de Dados", "Estudei arrays fixos hoje.", aluno1);
        System.out.println("Carlos adicionando nota tema correto: " + nota1);
        System.out.println("Créditos do Carlos atualizado: " + aluno1.getCreditos()); // Deve ser 1

        // Teste 6: Maria tenta criar anotação com tema ERRADO (Deve dar false e NÃO somar créditos)
        boolean nota2 = grupo.cadastraAnotacao("12/10/2026", "Cálculo I", "Derivadas são difíceis.", aluno2);
        System.out.println("Maria adicionando nota tema errado: " + nota2);
        System.out.println("Créditos da Maria (não deve ter ganho): " + aluno2.getCreditos()); // Deve ser 0

        // Teste 7: Pedro (não pertence ao grupo) tenta criar anotação (Deve dar false)
        boolean nota3 = grupo.cadastraAnotacao("12/10/2026", "Estrutura de Dados", "Tentando invadir o grupo.", aluno3);
        System.out.println("Pedro (não membro) adicionando nota: " + nota3);
        System.out.println("Créditos do Pedro: " + aluno3.getCreditos()); // Deve ser 0

        System.out.println("\n--- Imprimindo Listagens do Grupo ---");
        System.out.println(">> Lista de Alunos no Grupo:");
        grupo.listaAlunos();

        System.out.println("\n>> Lista de Anotações do Grupo:");
        grupo.listaAnotacoes();

        System.out.println("\n--- Estado Final do Grupo ---");
        System.out.println(grupo.toString());

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}