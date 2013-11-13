package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

import algoRitmos.gpsChallenge.modelo.Direccion;

public class DireccionTest {
	
	@Test
	public void crearNorteNoNuloYToStringRetornaDireccion() {
		Direccion direccion = new Norte();
		
		Assert.assertNotNull(direccion);
		Assert.assertEquals("norte", direccion.toString());
	}
	
}
