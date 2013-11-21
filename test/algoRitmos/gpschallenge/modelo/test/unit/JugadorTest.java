package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.juego.Jugador;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class JugadorTest {

	@Test
	public void crearJugadorYObtenerNombre(){
		Jugador unJugador = new Jugador("Pepe", new Vehiculo(null,null));
        String nombre = unJugador.getNombre();
        Assert.assertEquals("Pepe", nombre);
	} 
	
}
