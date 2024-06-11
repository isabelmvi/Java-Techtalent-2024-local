package GeometriaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Geometria.areaTriangulo;

public class Triangulo {
	@Test
	void testAdd() {
      areaTriangulo areaT = new areaTriangulo();
      assertEquals(6, areaTriangulo.add(3, 4), "(3*4)/2 deberían ser 6");
    }

}
