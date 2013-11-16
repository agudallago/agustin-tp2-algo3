package algoRitmos.gpsChallenge.modelo;

import org.junit.Assert;
import org.junit.Test;

public class VehiculoRecorreMapaYTocaSorpresaTest {
	 
	@Test
	public void aplicarSorpresaEnVehiculo() {	
        Mapa mapa = new Mapa(2, new SorpresaDesfavorable());
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion norte = new Norte();
        Direccion este = new Este();
        
        for (int i = 0; i < 10; ++i) {
        	jugador.moverVehiculoA(sur);
	        jugador.moverVehiculoA(norte);
        }
        
        // Hasta acá ya tiene 20 movimientos y esta en posicion inicial
        	
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        
        // llegó a posicion final, donde esta la sorpresa con 24 movs.
        // La sorpresa desfavorable lo dejaria en 24*1.25 = 30
        
        jugador.actualizar();
        Assert.assertTrue(jugador.getPuntaje() == 30);
	}
 
}
