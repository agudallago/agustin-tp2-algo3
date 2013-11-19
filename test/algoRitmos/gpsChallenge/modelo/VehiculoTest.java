package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testVehiculoMover() {
	//Prueba que el vehículo se mueva a la nueva esquina y que se incremente 
	//el contador de movimientos
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
	public void testVehiculoCambiarTipo() {
		//Prueba que el vehículo cambie su tipo
			Vehiculo unVehiculo = new Vehiculo(null, new Auto());;
						
			unVehiculo.getTipoDeVehiculoAsString();
			Assert.assertEquals(unVehiculo.getTipoDeVehiculoAsString(), "Auto");
			
			unVehiculo.cambiar();
			Assert.assertEquals(unVehiculo.getTipoDeVehiculoAsString(), "CuatroPorCuatro");
			
			unVehiculo.cambiar();
			Assert.assertEquals(unVehiculo.getTipoDeVehiculoAsString(), "Moto");
			
			unVehiculo.cambiar();
			Assert.assertEquals(unVehiculo.getTipoDeVehiculoAsString(), "Auto");
	
	}
}