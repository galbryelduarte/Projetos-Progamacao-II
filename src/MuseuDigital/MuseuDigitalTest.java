package MuseuDigital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MuseuDigitalTest {
    private MuseuDigital museuDigital;
    private ArrayList<Colecionador> colecionadores;
    private ArrayList<Obra> obras;
    @BeforeEach
    void consultarAfinidade() {
        this.museuDigital = new MuseuDigital();
        this.colecionadores = new ArrayList<>();
        this.obras = new ArrayList<>();
    }

    @Test
    void testTestarSemAfinidade() {
        this.museuDigital.cadastrarArtista("Arafe", "Bio", new String[]{"Música"});
        String[] caracteristicas = {"3D", "pixel art", "interativo"};
        this.museuDigital.cadastrarObra("quero", "Música", "Arafe", 300, 67.0, caracteristicas);
        String[] interesses = {"abstrato", "paisagem", "abstrato"};
        this.museuDigital.cadastrarColecionador("quero", "muito", interesses);
        int resultado = this.museuDigital.consultarAfinidade(0, 0);
        assertEquals(resultado, 0);
    }

    @Test
    void testTestar30Afinidade() {
        this.museuDigital.cadastrarArtista("Arafe", "Bio", new String[]{"Música"});
        String[] caracteristicas = {"3D", "pixel art", "interativo"};

        this.museuDigital.cadastrarObra("quero", "Música", "Arafe", 300, 67.0, caracteristicas);
        String[] interesses = {"abstrato", "paisagem", "pixel art"};

        this.museuDigital.cadastrarColecionador("quero", "muito", interesses);
        int resultado = this.museuDigital.consultarAfinidade(0, 0);
        assertEquals(resultado, 30);
    }

    @Test
    void testTestar70Afinidade() {
        this.museuDigital.cadastrarArtista("Arafe", "Bio", new String[]{"Música"});
        String[] caracteristicas = {"3D", "pixel art", "interativo"};

        this.museuDigital.cadastrarObra("quero", "Música", "Arafe", 300, 67.0, caracteristicas);
        String[] interesses = {"abstrato", "3D", "pixel art"};

        this.museuDigital.cadastrarColecionador("quero", "muito", interesses);
        int resultado = this.museuDigital.consultarAfinidade(0, 0);
        assertEquals(resultado, 70);
    }

    @Test
    void testTestar100Afinidade() {
        this.museuDigital.cadastrarArtista("Arafe", "Bio", new String[]{"Música"});
        String[] caracteristicas = {"3D", "pixel art", "interativo"};

        this.museuDigital.cadastrarObra("quero", "Música", "Arafe", 300, 67.0, caracteristicas);
        String[] interesses = {"interativo", "3D", "pixel art"};

        this.museuDigital.cadastrarColecionador("quero", "muito", interesses);
        int resultado = this.museuDigital.consultarAfinidade(0, 0);
        assertEquals(resultado, 100);
    }
}