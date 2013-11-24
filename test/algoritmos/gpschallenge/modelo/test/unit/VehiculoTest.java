package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;
import algoritmos.gpschallenge.modelo.direccion.*;

public class VehiculoTest {

	@Test
	public void testAddMovimientosBonus() {
		//Prueba de Movimientos Bonus. Agrega 0 movimientos y verifica.
		//Agrego un número arbitrario (3) y verifica que los sume bien.
			Vehiculo unVehiculo = new Vehiculo(null, new Auto());;
			float cantidadDeMovimientos = 0;
			float movimientosBonus;
			
			movimientosBonus = unVehiculo.getMovimientosBonus();
			unVehiculo.addMovimientosBonus(cantidadDeMovimientos);	
			Assert.assertEquals((double)unVehiculo.getMovimientosBonus(), (double)movimientosBonus, 0);
			
			cantidadDeMovimientos = 3; 
			unVehiculo.addMovimientosBonus(cantidadDeMovimientos);
			Assert.assertEquals((double)unVehiculo.getMovimientosBonus(), (double)(movimientosBonus+cantidadDeMovimientos), 0);
			
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
	public void testVehiculoMoverNorteyVolverAEsquinaInicialUsandoMover() {
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
	public void testVehiculoMoverNorteyVolverAUbicacionPrevia() {
		Esquina unaEsquinaInicial = new Esquina();
		Esquina unaEsquinaNorte = new Esquina();
		unaEsquinaInicial.setEsquinaAl(new Norte(), unaEsquinaNorte);
		//No es necesario setear la Esquina inicial en la Esquina norte porque esta
		//informacion la guarda el vehiculo
		int movimientos;
		Vehiculo unVehiculo = new Vehiculo(unaEsquinaInicial, new Auto());;
		
		movimientos = unVehiculo.getMovimientos();
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaInicial);
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
		unVehiculo.moverA(new Norte());
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquinaNorte);
		movimientos++;
		Assert.assertEquals(unVehiculo.getMovimientos(), movimientos);
		
		unVehiculo.volverAUbicacionPrevia();
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
	
	@Test
	public void testVehiculoGetUbicacion() {
	//Prueba que el vehículo guarde la ubicación Inicial
		Esquina unaEsquina = new Esquina();
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
		
		Assert.assertEquals(unVehiculo.getUbicacion(), unaEsquina);
		Assert.assertEquals(unVehiculo.getMovimientos(), 0);
		
	}
	
}