package algoritmos.gpschallenge.modelo.test.integration;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class VehiculoLlegaALaMetaTest {
	
	@Test
	public void testVehiculoLlegaALaMeta() {	
        Mapa mapa = new Mapa(2, new Meta());
        
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Moto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.actualizar();
        
        // La Moto llega a la esquina donde est� el pozo, con 4 movimientos, dejando su puntaje final en 4.         
             
       Assert.assertTrue(jugador.getPuntaje() == 4);
	
       // Adicionalmente, llega a la meta.
       
       Assert.assertTrue(jugador.juegoTerminado());
	}
}
