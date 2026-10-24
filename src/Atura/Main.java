package Atura;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      INICIANDO SISTEMA DE TESTES - ATURA        ");
        System.out.println("=================================================");

        // 1. Instanciando o sistema central
        Atura sistema = new Atura();

        // ====================================================================
        // TESTE 1: Cadastrar Alunos (Retorna ID sequencial iniciando em 1)
        // ====================================================================
        System.out.println("\n>>> [TESTE 1] Cadastro de Alunos");
        int idAluno1 = sistema.inscreverAluno("João Silva", "111.111.111-11", 20);
        int idAluno2 = sistema.inscreverAluno("Maria Souza", "222.222.222-22", 15); // Jovem
        int idAluno3 = sistema.inscreverAluno("Carlos Andrade", "333.333.333-33", 25);

        // Testando a validação de CPF único que você implementou
        int idAlunoRepetido = sistema.inscreverAluno("João Clone", "111.111.111-11", 22);

        System.out.println("Aluno 1 cadastrado com ID: " + idAluno1); // Esperado: 1
        System.out.println("Aluno 2 cadastrado com ID: " + idAluno2); // Esperado: 2
        System.out.println("Aluno 3 cadastrado com ID: " + idAluno3); // Esperado: 3
        System.out.println("Tentativa com CPF repetido retornou: " + idAlunoRepetido); // Esperado: -1 (Sucesso na validação!)


        // ====================================================================
        // TESTE 2: Cadastrar Cursos (Com e Sem palavras-chave)
        // ====================================================================
        System.out.println("\n>>> [TESTE 2] Cadastro de Cursos");
        String[] tagsJava = {"Programação", "Backend", "Java"};

        // Curso 1: Java (2 vagas, idade mínima 18)
        int idCursoJava = sistema.increverCurso("Java Avançado", "POO Avançada", "Prof. Guanabara", 2, tagsJava, 18);

        // Curso 2: Python (5 vagas, idade mínima 12, sem palavras-chave iniciais)
        int idCursoPython = sistema.increverCurso("Python para Todos", "Sintaxe Básica", "Prof. Silva", 5, 12);

        System.out.println("Curso Java criado com ID: " + idCursoJava);     // Esperado: 1
        System.out.println("Curso Python criado com ID: " + idCursoPython); // Esperado: 2


        // ====================================================================
        // TESTE 3: Adicionar Alunos aos Cursos (Matrícula e Validação de Idade)
        // ====================================================================
        System.out.println("\n>>> [TESTE 3] Matrícula de Alunos");

        // João (ID 1, 20 anos) no Curso de Java -> Deve permitir
        boolean mat1 = sistema.adicionarAlunoCurso(idCursoJava, idAluno1);
        System.out.println("Matrícula de João no Curso Java: " + (mat1 ? "Sucesso" : "Falha"));

        // Maria (ID 2, 15 anos) no Curso de Java -> Deve falhar (Idade mínima é 18)
        boolean mat2 = sistema.adicionarAlunoCurso(idCursoJava, idAluno2);
        System.out.println("Matrícula de Maria no Curso Java (Menor de idade): " + (mat2 ? "Sucesso" : "Falha"));

        // Carlos (ID 3, 25 anos) no Curso de Java -> Deve permitir (Ocupa a última vaga)
        boolean mat3 = sistema.adicionarAlunoCurso(idCursoJava, idAluno3);
        System.out.println("Matrícula de Carlos no Curso Java: " + (mat3 ? "Sucesso" : "Falha"));


        // ====================================================================
        // TESTE 4: Verificar Listagem e Status do Curso
        // ====================================================================
        System.out.println("\n>>> [TESTE 4] Listagem e Status");
        System.out.println("Status atual do Curso Java: " + sistema.statusCurso(idCursoJava));
        System.out.println(sistema.listaAlunoCurso(idCursoJava));


        // ====================================================================
        // TESTE 5: Alterar Palavras-Chaves e Buscar por Palavra-Chave
        // ====================================================================
        System.out.println("\n>>> [TESTE 5] Gerenciamento de Palavras-Chave");

        // Inserindo tags no curso de Python que foi criado sem nenhuma
        String[] novasTagsPython = {"Scripts", "Backend", "Automação"};
        sistema.alterarPalavrasChaves(idCursoPython, novasTagsPython);
        System.out.println("Palavras-chave do Python atualizadas.");

        // Buscando cursos com a palavra "Backend" (Deve retornar ambos os cursos)
        System.out.println("Buscando cursos com a tag 'Backend':");
        String[] resultados = sistema.buscaCurso("Backend");
        for (String nomeCurso : resultados) {
            System.out.println(" -> Encontrado: " + nomeCurso);
        }


        // ====================================================================
        // TESTE 6: Modificar Estados do Curso (Fechar Inscrições e Concluir)
        // ====================================================================
        System.out.println("\n>>> [TESTE 6] Ciclo de Vida do Curso e Histórico");

        // Fechando inscrições do curso Python
        sistema.fecharInscricao(idCursoPython);
        System.out.println("Status do Python após fechar inscrições: " + sistema.statusCurso(idCursoPython));

        // Concluindo o Curso de Java
        System.out.println("Status do Java antes de concluir: " + sistema.statusCurso(idCursoJava));
        sistema.concluirCursos(idCursoJava);
        System.out.println("Status do Java após concluir: " + sistema.statusCurso(idCursoJava));


        // ====================================================================
        // TESTE 7: Verificação do Histórico dos Alunos (Regra de Negócio Principal)
        // ====================================================================
        System.out.println("\n>>> [TESTE 7] Verificação de Históricos Acadêmicos");

        // João e Carlos estavam matriculados em Java, o histórico deles deve conter "Java Avançado"
        System.out.println("Histórico do João (ID 1): " + sistema.listaHistoricoCursos(idAluno1));
        System.out.println("Histórico do Carlos (ID 3): " + sistema.listaHistoricoCursos(idAluno3));

        // Maria não foi matriculada, histórico deve estar limpo
        System.out.println("Histórico da Maria (ID 2): " + sistema.listaHistoricoCursos(idAluno2));

        System.out.println("\n=================================================");
        System.out.println("           FIM DOS TESTES COM SUCESSO            ");
        System.out.println("=================================================");
    }
}
