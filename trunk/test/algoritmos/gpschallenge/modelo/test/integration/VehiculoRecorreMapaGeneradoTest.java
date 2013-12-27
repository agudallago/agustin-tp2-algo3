package algoritmos.gpschallenge.modelo.test.integration;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class VehiculoRecorreMapaGeneradoTest {

	@Test
	public void testRecorrerMapaFacilConVehiculo() {
        
		GeneradorDeMapas generador = new GeneradorDeMapas();
		Mapa mapa = generador.generarMapaFacil();
        Jugador jugador = new Jugador("Marito", new Vehiculo(mapa.getEsquinaInicialMapa(), new Auto()));
                
        Direccion norte = new Norte();
        Direccion sur = new Sur();
        Direccion este = new Este();
        Direccion oeste = new Oeste();
        
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);  // Atraviesa un pozo
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
                   
        Esquina posicionVehiculo = jugador.getUbicacionVehiculo();
        Assert.assertEquals(posicionVehiculo, mapa.getEsquina(8,14));
        
        //Ahora intentara irse fuera del mapa. Deberá permanecer en la misma esquina.
        
        jugador.moverVehiculoA(este);
        
        posicionVehiculo = jugador.getUbicacionVehiculo();
        Assert.assertEquals(posicionVehiculo, mapa.getEsquina(8,14));
                    
        //Ahora intentara atravesar un piquete. No podrá dado que es un auto. Volverá a quedar en la misma esquina.
        
        jugador.moverVehiculoA(sur);
        
        posicionVehiculo = jugador.getUbicacionVehiculo();
        Assert.assertEquals(posicionVehiculo, mapa.getEsquina(8,14));
           
        //Ahora retomará hasta llegar a la meta.
        
        jugador.moverVehiculoA(oeste);
        jugador.moverVehiculoA(oeste);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(norte);
      
        Assert.assertTrue(jugador.juegoTerminado());
        
       //27 movs + 1 pozo (3 movs de penalizacion) = 30
      
        jugador.actualizar();
        
        Assert.assertTrue(jugador.getPuntaje() == 30);
        
                
	}
}
