package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.direccion.*;

public class DireccionTest {
	
	@Test
	public void testCrearNorteNoNuloYToStringRetornaDireccion() {
		Direccion direccion = new Norte();
		
		Assert.assertNotNull(direccion);
		Assert.assertEquals("norte", direccion.toString());
	}
	
	@Test
	public void testCrearDosNortesYDebenSerIguales() {
		Direccion norte1 = new Norte();
		Direccion norte2 = new Norte();
		
		Assert.assertEquals(norte1, norte2);
	}
	
}
