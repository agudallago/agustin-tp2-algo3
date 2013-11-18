package algoRitmos.gpsChallenge.modelo;

import junit.framework.Assert;
import org.junit.Test;

//public class FooTest {

//	@Test
//	public void doFooShouldReturnFoo() {
//		Foo foo = new Foo();
//		String result = foo.doFoo();
//		Assert.assertEquals("Foo", result);
//	}

//}

public class VehiculoTest {

	@Test
	public void testVehiculoMover() {
		
		Esquina unaEsquina = new Esquina;
		Esquina unaEsquinaNorte = new Esquina();
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNorte);
		
		Vehiculo unVehiculo new Vehiculo(unaEsquina, new Auto());;
		
		Assert.assertEquals(unVehiculo.getUbicacionVehiculo, unaEsquina);
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacionVehiculo, unaEsquinaNorte);
	
	}
}
