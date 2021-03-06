package algoritmos.gpschallenge.modelo.test.integration;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;
import algoritmos.gpschallenge.modelo.sorpresa.*;

public class VehiculoRecorreMapaYTocaSorpresaTest {
	 
	
	@Test
	public void testAplicarSorpresaDesfavorableEnVehiculo() {	
        Mapa mapa = new Mapa(2, new SorpresaDesfavorable());
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion norte = new Norte();
        Direccion este = new Este();
                
        for (int i = 0; i < 10; ++i) {
        	jugador.moverVehiculoA(sur);
	        jugador.moverVehiculoA(norte);
        }
        
        // Hasta ac� ya tiene 20 movimientos y esta en posicion inicial
        	
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
                     
        // lleg� a posicion final, donde esta la sorpresa con 24 movs.
        // La sorpresa desfavorable lo dejaria en 24 x 1.25 = 30
        
       jugador.actualizar();
       
       Assert.assertTrue(jugador.getPuntaje() == 30);
	}

	
	@Test
	public void testAplicarSorpresaFavorableEnVehiculo() {	
        Mapa mapa = new Mapa(2, new SorpresaFavorable());
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion norte = new Norte();
        Direccion este = new Este();
        
        for (int i = 0; i < 10; ++i) {
        	jugador.moverVehiculoA(sur);
	        jugador.moverVehiculoA(norte);
        }
        
        // Hasta ac� ya tiene 20 movimientos y esta en posicion inicial
        	
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        
        // lleg� a posicion final, donde esta la sorpresa con 24 movs.
        // La sorpresa favorable lo dejaria en 24 x 0.8 = 19.2
       
        jugador.actualizar();
       
        Assert.assertEquals(jugador.getPuntaje(), 19.2, 0.1);
	}

	
	@Test
	public void testAplicarSorpresaCambioVehiculo() {	
        Mapa mapa = new Mapa(2, new SorpresaCambioVehiculo());
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                             	
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
                     
        // lleg� a posicion final, donde esta la sorpresa de cambio de veh�culo
        // ahora el auto deberia ser una 4x4
            
        Assert.assertEquals(jugador.getTipoDeVehiculo(), "CuatroPorCuatro");
	
	}
	
}
