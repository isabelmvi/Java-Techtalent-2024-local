package GeometriaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Geometria.areaCirculo;
import Geometria.areaTriangulo;

public class Circulo {
	@Test
	void testAdd() {
      areaCirculo areaCirc = new areaCirculo();
      assertEquals(31.41, areaCirculo.add(5), " deberían ser 31.41");
    }
}
