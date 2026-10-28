
package StudyConnect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyConnectTest {
    private StudyConnect sc;

    @BeforeEach
    void preparaStudyConnect() {
        this.sc = new StudyConnect();
    }

    @Test
    void testaCadastrarEstudante() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        String[] resultado = this.sc.listarEstudantes();

        assertEquals(1, resultado.length);
        assertTrue(resultado[0].contains("Ana"));
        assertTrue(resultado[0].contains("2026001"));
    }

    @Test
    void testaCadastrarEstudanteComLink() {
        this.sc.cadastraEstudante(
                "Ana", "2026001", "https://exemplo.com",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        String resultado = this.sc.listarEstudantes()[0];

        assertTrue(resultado.contains("https://exemplo.com"));
    }

    @Test
    void testaCadastrarEstudanteComMatriculaDuplicada() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.cadastraEstudante(
                        "Carlos", "2026001",
                        new String[]{"Python", "Redes", "Cálculo"}
                )
        );

        assertEquals("Esse estudante já está cadastrado.", excecao.getMessage());
        assertEquals(1, this.sc.listarEstudantes().length);
    }

    @Test
    void testaCadastrarEstudanteComMatriculaNula() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.cadastraEstudante(
                        "Ana", null, new String[]{"Java", "POO", "Banco de Dados"}
                )
        );

        assertEquals(
                "A matricula é identificador único portanto não pode ser nula.",
                excecao.getMessage()
        );
    }

    @Test
    void testaAtualizarLinkPerfil() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.atualizarLinkPerfil(
                "2026001", "https://novo-perfil.com"
        );

        assertTrue(
                this.sc.listarEstudantes()[0].contains("https://novo-perfil.com")
        );
    }

    @Test
    void testaAtualizarLinkDeEstudanteInexistente() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.atualizarLinkPerfil("999999", "https://exemplo.com")
        );

        assertEquals(
                "Não foi achado entre os cadastrados estudantes com essa matricula",
                excecao.getMessage()
        );
    }

    @Test
    void testaCadastrarGrupo() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        int resultado = this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Algoritmos"}
        );

        assertEquals(0, resultado);
        assertEquals(1, this.sc.listarGrupos().length);
    }

    @Test
    void testaCadastrarGrupoComResponsavelInexistente() {
        int resultado = this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "999999",
                5,
                new String[]{"Java", "POO", "Algoritmos"}
        );

        assertEquals(-1, resultado);
        assertEquals(0, this.sc.listarGrupos().length);
    }

    @Test
    void testaSolicitarParticipacao() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Algoritmos"}
        );

        this.sc.solicitarParticipacao("2026001", 0);

        String[] interessados = this.sc.listarInteressadosGrupo(0);

        assertEquals(1, interessados.length);
        assertTrue(interessados[0].contains("2026001"));
    }

    @Test
    void testaSolicitarParticipacaoComEstudanteInexistente() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Algoritmos"}
        );

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.solicitarParticipacao("999999", 0)
        );

        assertEquals(
                "Não foi achado entre os cadastrados estudantes com essa matricula",
                excecao.getMessage()
        );
    }

    @Test
    void testaSolicitarParticipacaoComGrupoInexistente() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.solicitarParticipacao("2026001", 0)
        );

        assertEquals("Indice inválido", excecao.getMessage());
    }

    @Test
    void testaSolicitarParticipacaoDuplicada() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Algoritmos"}
        );

        this.sc.solicitarParticipacao("2026001", 0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.solicitarParticipacao("2026001", 0)
        );

        assertEquals(
                "Este estudante já faz parte do grupo.",
                excecao.getMessage()
        );

        assertEquals(1, this.sc.listarInteressadosGrupo(0).length);
    }

    @Test
    void testaCompatibilidadeSemDisciplinasEmComum() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Python",
                "Grupo para estudar Python",
                "2026001",
                5,
                new String[]{"Python", "Redes", "Cálculo"}
        );

        assertEquals(0, this.sc.calcularCompatibilidade("2026001", 0));
    }

    @Test
    void testaCompatibilidadeComUmaDisciplinaEmComum() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "Redes", "Cálculo"}
        );

        assertEquals(30, this.sc.calcularCompatibilidade("2026001", 0));
    }

    @Test
    void testaCompatibilidadeComDuasDisciplinasEmComum() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Cálculo"}
        );

        assertEquals(70, this.sc.calcularCompatibilidade("2026001", 0));
    }

    @Test
    void testaCompatibilidadeComTresDisciplinasEmComum() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        assertEquals(100, this.sc.calcularCompatibilidade("2026001", 0));
    }

    @Test
    void testaCompatibilidadeComEstudanteInexistente() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                5,
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.calcularCompatibilidade("999999", 0)
        );
    }

    @Test
    void testaConfirmarParticipanteCompativel() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Java",
                "Grupo para estudar Java",
                "2026001",
                1,
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.solicitarParticipacao("2026001", 0);

        String[] confirmados = this.sc.confirmarParticipantes(0, 70);

        assertTrue(confirmados[0].contains("2026001"));
        assertTrue(
                this.sc.listaParticipantesConfirmados(0)[0].contains("2026001")
        );
    }

    @Test
    void testaNaoConfirmarParticipanteAbaixoDaCompatibilidadeMinima() {
        this.sc.cadastraEstudante(
                "Ana", "2026001",
                new String[]{"Java", "POO", "Banco de Dados"}
        );

        this.sc.cadastrarGrupo(
                "Grupo Python",
                "Grupo para estudar Python",
                "2026001",
                1,
                new String[]{"Python", "Redes", "Cálculo"}
        );

        this.sc.solicitarParticipacao("2026001", 0);

        String[] confirmados = this.sc.confirmarParticipantes(0, 30);

        assertNull(confirmados[0]);
    }

    @Test
    void testaConfirmarParticipantesComCompatibilidadeInvalida() {
        assertThrows(
                IllegalArgumentException.class,
                () -> this.sc.confirmarParticipantes(0, 101)
        );
    }
}
