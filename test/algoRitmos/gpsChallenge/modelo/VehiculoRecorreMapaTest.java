package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

public class VehiculoRecorreMapaTest {

	@Test
	public void recorrerMapaConVehiculo(){
        Mapa mapa = new Mapa();
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
        
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        
        Esquina posicionFinalVehiculo = jugador.getUbicacionVehiculo();
        Assert.assertEquals(posicionFinalVehiculo, mapa.getEsquinaFinal());
	}
	
}
