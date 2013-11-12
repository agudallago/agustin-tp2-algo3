package algoRitmos.gpsChallenge.modelo;

import junit.framework.Assert;
import org.junit.Test;

import algoRitmos.gpsChallenge.modelo.Auto;

public class AutoTest {
	
	@Test
	public void crearAutoNoNulo() {
		Auto auto = new Auto();
		Assert.assertNotNull(auto);		
	}
	
}
