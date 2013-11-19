package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

public class VehiculoLlegaALaMetaTest {

	
	@Test
	public void vehiculoLlegaALaMeta() {	
        Mapa mapa = new Mapa(2, new Meta());
        
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Moto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.actualizar();
        
        // La Moto llega a la esquina donde está el pozo, con 4 movimientos, dejando su puntaje final en 4.         
             
       Assert.assertTrue(jugador.getPuntaje() == 4);
	
       // Adicionalmente, llega a la meta.
       
       Assert.assertTrue(jugador.juegoTerminado());
	}
}
