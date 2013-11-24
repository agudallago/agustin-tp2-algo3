package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;
import algoritmos.gpschallenge.modelo.direccion.*;

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
	
	@Test
	public void testVehiculoMoverNorteyVolverAEsquinaInicial() {
		Esquina unaEsquinaInicial = new Esquina();
		Esquina unaEsquinaNorte = new Esquina();
		unaEsquinaInicial.setEsquinaAl(new Norte(), unaEsquinaNorte);
		unaEsquinaNorte.setEsquinaAl(new Sur(), unaEsquinaInicial);
		int movimientos;
		Vehiculo unVehiculo = new Vehiculo(unaEsquinaInicial, new Auto());;
		
		movimientos = unVehiculo.getMovimientos();
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaInicial);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaNorte);
		movimientos++;
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
		unVehiculo.moverA(new Sur());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaInicial);
		movimientos++;
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
	}
	
	@Test
	public void testVehiculoMoverAEsquinaInexistente() {
	//Prueba que el vehículo no se mueva a una esquina inexistente ni tampoco se incremente 
	//el contador de movimientos
		Esquina unaEsquina = new Esquina();
		int movimientos;
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
		
		movimientos = unVehiculo.getMovimientos();
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
	}
}