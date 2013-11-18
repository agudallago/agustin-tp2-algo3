package algoRitmos.gpsChallenge.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testVehiculoMover() {
	//Prueba que el veh�culo se mueva a la nueva esquina y que se incremente el contador de movimientos
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNorte = new Esquina();
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNorte);
		int movimientos;
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
		
		movimientos = unVehiculo.getMovimientos();
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaNorte);
		movimientos++;
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
	}
	
	@Test
	public void testVehiculoMoverADireccionEsquinaNull() {
	//Al mover el veh�culo hacia una esquina Null, deber�a quedarse en la misma 
	//posici�n actual y no incrementar el contador de movimientos
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNull = null;
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNull);
		int movimientos;
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
	
		movimientos = unVehiculo.getMovimientos();
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
	}
	
	
	
}
