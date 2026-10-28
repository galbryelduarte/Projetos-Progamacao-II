package RepareBem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReparoTest {

    @Test
    void testarSetPreco() {
        Reparo reparo = new Reparo("calça", "jeans azul", 20);
        reparo.setPreco(10);
        assertEquals(22, reparo.getPreco());
    }


}