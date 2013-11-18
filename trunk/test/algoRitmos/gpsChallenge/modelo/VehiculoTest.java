package algoRitmos.gpsChallenge.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testVehiculoMover() {
		
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNorte = new Esquina();
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNorte);
		
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
		
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaNorte);
		
	}
	
	@Test
	public void testVehiculoMoverADireccionEsquinaNull() {
	//Al mover el veh�culo hacia una esquina Null, deber�a quedarse en la misma posici�n actual
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNull = null;
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNull);
		
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
		
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		
	}
}
