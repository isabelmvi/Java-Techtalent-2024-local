package GeometriaTest;

import org.junit.jupiter.api.Test;

import Geometria.areaCuadrado;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class Cuadrado {
	
	@Test
	void testAdd() {
      areaCuadrado areaC = new areaCuadrado();
      assertEquals(16, areaCuadrado.add(8, 2), "8*2 deberían ser 16");
    }

}
