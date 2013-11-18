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
	public void testVehiculoMoverADireccionEsquinaNull() {
	//Al mover el vehículo hacia una esquina Null, debería quedarse en la misma 
	//posición actual y no incrementar el contador de movimientos
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNull = null;
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNull);
		int movimientos;
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());
	
		movimientos = unVehiculo.getMovimientos();
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
	}
	
	public void testVehiculoCambiarTipo() {
		//Prueba que el vehículo cambie su tipo
			Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
			string tipoVehiculo = null;
			
			unVehiculo.getTipo();
			Assert.assertEquals(unVehiculo.getTipo(), 'Auto');
			
			unVehiculo.cambiar();
			Assert.assertEquals(unVehiculo.getTipo(), 'CuatroPorCuatro');
			
			unVehiculo.cambiar();
			Assert.assertEquals(unVehiculo.getTipo(), 'Moto');
			
			unVehiculo.cambiar();
			Assert.assertEquals(unVehiculo.getTipo(), 'Auto');
	
}
