package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.vehiculo.Auto;

public class AutoTest {
	
	@Test
	public void crearAutoNoNulo() {
		Auto auto = new Auto();
		Assert.assertNotNull(auto);		
	}
	
	
	
}
