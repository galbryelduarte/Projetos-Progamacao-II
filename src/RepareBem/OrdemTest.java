package RepareBem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrdemTest {

    @Test
    void testarSetStatus() {
        Ordem ordem = new Ordem("concerto", "66666", "jeans azul");
        ordem.setStatus("Em andamento");
        assertEquals("Em andamento", ordem.getStatus());
    }
}