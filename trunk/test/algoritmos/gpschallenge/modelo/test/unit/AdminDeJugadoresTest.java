package algoritmos.gpschallenge.modelo.test.unit;

import java.util.Set;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;


import algoritmos.gpschallenge.modelo.admin.*;
import algoritmos.gpschallenge.modelo.juego.Jugador;

public class AdminDeJugadoresTest {
	
	@Test
	public void testCrearAdminNoNulo() {
		AdminDeJugadores admin = new AdminDeJugadores();
		Assert.assertNotNull(admin);
	}
	
	// No es una prueba real automatizada. Simplemente es una forma rapida de testear 
	// el parseo de la clase desde XML y verla en pantalla
	@Test
	public void testCrearAdminYCargarXML() throws Exception{
		AdminDeJugadores admin = AdminDeJugadores.cargarJugadores("players.xml");
		
		Set<Entry<Jugador, Float>>set2 = admin.getRankingComoSet();
		System.out.println(set2.toString());
		Assert.assertNotNull(admin);
	}
	
	/* NO USAR!
	@Test
	public void testCrearAdminYGuardarXML() throws Exception{
		AdminDeJugadores admin = new AdminDeJugadores();
		Set<Entry<Jugador, Float>>set1 = admin.getRankingComoSet();
		admin.guardarJugadores("players.xml");
		
		admin = AdminDeJugadores.cargarJugadores("players.xml");
		Set<Entry<Jugador, Float>>set2 = admin.getRankingComoSet();
		
		Assert.assertEquals(set1, set2);
	}	*/
	
}
