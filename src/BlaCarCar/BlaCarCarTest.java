package BlaCarCar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlaCarCarTest {
    private ArrayList<Passageiro> passageiros;
    private ArrayList<Viagem> viagens;
    private BlaCarCar bcc;

    public BlaCarCarTest() {
        this.passageiros = new ArrayList<>();
        this.viagens = new ArrayList<>();
        this.bcc = new BlaCarCar();
    }
    @Test
    void calcular0Compatibilidade() {
        String[] pontosFrequentes = new String[3];
        pontosFrequentes[0] = "casa"; pontosFrequentes[1] = "padaria"; pontosFrequentes[2] = "atacadao";
        bcc.cadastrarPassageiro("BUCHUDA", "123456789", pontosFrequentes);
        String[] pontosPrevistos = new String[3];
        pontosPrevistos[0] = "academia"; pontosPrevistos[1] = "shoping"; pontosPrevistos[2] = "rua";
        bcc.cadastrarViagem("volta", "volta pela cidade", 15, "839987487", pontosPrevistos);;
        int resultado = this.bcc.calcularCompatibilidade("123456789", 0);
        assertEquals(0, resultado);
    }

    @Test
    void calcular30Compatibilidade() {
        String[] pontosFrequentes = new String[3];
        pontosFrequentes[0] = "casa"; pontosFrequentes[1] = "padaria"; pontosFrequentes[2] = "atacadao";
        bcc.cadastrarPassageiro("BUCHUDA", "123456789", pontosFrequentes);
        String[] pontosPrevistos = new String[3];
        pontosPrevistos[0] = "academia"; pontosPrevistos[1] = "shoping"; pontosPrevistos[2] = "casa";
        bcc.cadastrarViagem("volta", "volta pela cidade", 15, "839987487", pontosPrevistos);;
        int resultado = this.bcc.calcularCompatibilidade("123456789", 0);
        assertEquals(30, resultado);
    }

    @Test
    void calcular70Compatibilidade() {
        String[] pontosFrequentes = new String[3];
        pontosFrequentes[0] = "casa"; pontosFrequentes[1] = "academia"; pontosFrequentes[2] = "atacadao";
        bcc.cadastrarPassageiro("BUCHUDA", "123456789", pontosFrequentes);
        String[] pontosPrevistos = new String[3];
        pontosPrevistos[0] = "academia"; pontosPrevistos[1] = "shoping"; pontosPrevistos[2] = "casa";
        bcc.cadastrarViagem("volta", "volta pela cidade", 15, "839987487", pontosPrevistos);;
        int resultado = this.bcc.calcularCompatibilidade("123456789", 0);
        assertEquals(70, resultado);
    }

    @Test
    void calcular100Compatibilidade() {
        String[] pontosFrequentes = new String[3];
        pontosFrequentes[0] = "casa"; pontosFrequentes[1] = "academia"; pontosFrequentes[2] = "atacadao";
        bcc.cadastrarPassageiro("BUCHUDA", "123456789", pontosFrequentes);
        String[] pontosPrevistos = new String[3];
        pontosPrevistos[0] = "academia"; pontosPrevistos[1] = "atacadao"; pontosPrevistos[2] = "casa";
        bcc.cadastrarViagem("volta", "volta pela cidade", 15, "839987487", pontosPrevistos);;
        int resultado = this.bcc.calcularCompatibilidade("123456789", 0);
        assertEquals(100, resultado);
    }

    @Test
    void calcularCpfNaoEncontrado() {
        String[] pontosFrequentes = new String[3];
        pontosFrequentes[0] = "casa"; pontosFrequentes[1] = "academia"; pontosFrequentes[2] = "atacadao";
        bcc.cadastrarPassageiro("BUCHUDA", "123456789", pontosFrequentes);
        String[] pontosPrevistos = new String[3];
        pontosPrevistos[0] = "academia"; pontosPrevistos[1] = "atacadao"; pontosPrevistos[2] = "casa";
        bcc.cadastrarViagem("volta", "volta pela cidade", 15, "839987487", pontosPrevistos);;
        try {
            this.bcc.calcularCompatibilidade("12345678974", 0);
            fail("Deveria ter lançado IllegalArgumentException para CPF inexistente.");

        } catch (IllegalArgumentException e) {
            assertEquals("CPF inexistente entre os passageiros cadastrados.", e.getMessage());
        }
    }
}