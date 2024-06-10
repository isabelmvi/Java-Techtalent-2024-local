package ud21.calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    
    @Test
    void testAdd() {
        Calc calculator = new Calc();
        assertEquals(5, calculator.add(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    void testSubtract() {
    	Calc calculator = new Calc();
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 debería ser 1");
    }
}