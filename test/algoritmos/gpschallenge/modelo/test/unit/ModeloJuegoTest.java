package algoritmos.gpschallenge.modelo.test.unit;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.juego.Jugador;
import algoritmos.gpschallenge.modelo.juego.Mapa;
import algoritmos.gpschallenge.modelo.juego.ModeloJuego;
import algoritmos.gpschallenge.modelo.juego.Partida;
import algoritmos.gpschallenge.modelo.vehiculo.Auto;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class ModeloJuegoTest {
	
	@Test
	public void testCrearModeloNoNulo() throws FileNotFoundException, ClassNotFoundException, IOException {
		ModeloJuego modelo = new ModeloJuego();
		Assert.assertNotNull(modelo);
	}

	// NO USAR!
	/*
	@Test
	public void testGuardarYCargarPartida() throws FileNotFoundException, ClassNotFoundException, IOException {
		ModeloJuego modelo = new ModeloJuego();
		
		Partida partidaGuardada = new Partida(new Jugador("Agustin", new Vehiculo(null, new Auto())), new Mapa(1, null));
		modelo.guardarPartida(partidaGuardada);
		Partida partidaCargada = modelo.cargarPartida();
		
		Assert.assertEquals(partidaGuardada, partidaCargada);
	}*/
}
