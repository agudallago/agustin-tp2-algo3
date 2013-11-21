package algoritmos.gpschallenge.modelo.test.integration;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class VehiculoRecorreMapaTest {

	@Test
	public void recorrerMapaConVehiculo() {
        Mapa mapa = new Mapa(1, null);
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

		@Test
	public void VehiculoIntentaIrseFueraDeMapaLuegoDeLlegarALaEsquinaFinal() {
        Mapa mapa = new Mapa(1, null);
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
        
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        
        //En este momento, el vehículo está en la esquina final. Hacia el Este no hay esquina,
        //por lo tanto se intentará mover hacia allí. El auto no deberá moverse y quedará en
        //la misma esquina en la que estaba.
        jugador.moverVehiculoA(este);
        
        Esquina posicionFinalVehiculo = jugador.getUbicacionVehiculo();
        Assert.assertEquals(posicionFinalVehiculo, mapa.getEsquinaFinal());
	}
	
}
