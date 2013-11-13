package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

import algoRitmos.gpsChallenge.modelo.Jugador;

public class JugadorTest {

	@Test
	public void crearJugadorYObtenerNombre(){
        Jugador unJugador = new Jugador("Pepe", new Vehiculo());
        String nombre = unJugador.getNombre();
        Assert.assertEquals("Pepe", nombre);
	}
	
}
