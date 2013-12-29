package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.direccion.Sur;
import algoritmos.gpschallenge.modelo.juego.Esquina;
import algoritmos.gpschallenge.modelo.juego.Jugador;
import algoritmos.gpschallenge.modelo.juego.Mapa;
import algoritmos.gpschallenge.modelo.vehiculo.Auto;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class JugadorTest {

	@Test
	public void testCrearJugadorYObtenerNombre(){
		Jugador unJugador = new Jugador("Pepe", new Vehiculo(null,null));
        String nombre = unJugador.getNombre();
        Assert.assertEquals("Pepe", nombre);
	} 
	
	@Test
	public void testVerificarPuntajeSinMovimientosBonus(){
		Mapa unMapa = new Mapa (1,null); //Mapa Vacio
		Vehiculo unVehiculo = new Vehiculo(unMapa.getEsquinaInicial(), new Auto());
		Jugador unJugador = new Jugador("Pepe", unVehiculo);
		float puntaje; 
	
		puntaje = unJugador.getPuntaje();
        Assert.assertEquals(puntaje, 0, 0);
        
        unJugador.moverVehiculoA(new Sur());
        unJugador.actualizar();
        puntaje += 1;
        Assert.assertEquals(puntaje, unJugador.getPuntaje(), 0);
                
	}
	
	@Test
	public void testVerificarPuntajeConMovimientosBonus(){
		Mapa unMapa = new Mapa (1,null); //Mapa Vacio
		Vehiculo unVehiculo = new Vehiculo(unMapa.getEsquinaInicial(), new Auto());
		Jugador unJugador = new Jugador("Pepe", unVehiculo);
		float movimientosBonus = 3;
		float puntaje; 
	
		puntaje = unJugador.getPuntaje();
        Assert.assertEquals(puntaje, 0, 0);
        
        unVehiculo.addMovimientosBonus(movimientosBonus);
        
        unJugador.moverVehiculoA(new Sur());
        unJugador.actualizar();
        puntaje += 1 + movimientosBonus;
        Assert.assertEquals(puntaje, unJugador.getPuntaje(), 0);
                
	}
	
	@Test
	public void testActualizar(){
		Mapa unMapa = new Mapa (1,null); //Mapa Vacio
		Vehiculo unVehiculo = new Vehiculo(unMapa.getEsquinaInicial(), new Auto());
		Jugador unJugador = new Jugador("Pepe", unVehiculo);
		float puntaje; 
	
		puntaje = unJugador.getPuntaje();
        Assert.assertEquals(puntaje, 0, 0);
        
        //Mueve el vehículo y verifica que el puntaje no se actualizo
        unJugador.moverVehiculoA(new Sur());
        puntaje += 1;
        Assert.assertFalse((puntaje == unJugador.getPuntaje()));
        
        //Actualiza y verifica la igualdad del puntaje del jugador con lo esperado
        unJugador.actualizar();
        Assert.assertEquals(puntaje, unJugador.getPuntaje(), 0);
                
	}
	
	@Test
	public void testJugadorGetUbicacion() {
	//Prueba que el Jugador obtiene bien la ubicación Inicial y la cantidad de movimientos
		
		Esquina unaEsquina = new Esquina(0,0);
		Vehiculo unVehiculo = new Vehiculo(unaEsquina, new Auto());;
		Jugador unJugador = new Jugador("Pepe", unVehiculo);
		
		Assert.assertEquals(unJugador.getUbicacionVehiculo(), unaEsquina);
		Assert.assertEquals(unJugador.getPuntaje(), 0, 0);
		
	}
}
