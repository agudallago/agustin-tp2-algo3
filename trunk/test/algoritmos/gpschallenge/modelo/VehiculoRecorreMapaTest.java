package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

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
        
        //En este momento, el veh�culo est� en la esquina final. Hacia el Este no hay esquina,
        //por lo tanto se intentar� mover hacia all�. El auto no deber� moverse y quedar� en
        //la misma esquina en la que estaba.
        jugador.moverVehiculoA(este);
        
        Esquina posicionFinalVehiculo = jugador.getUbicacionVehiculo();
        Assert.assertEquals(posicionFinalVehiculo, mapa.getEsquinaFinal());
	}
	
}
