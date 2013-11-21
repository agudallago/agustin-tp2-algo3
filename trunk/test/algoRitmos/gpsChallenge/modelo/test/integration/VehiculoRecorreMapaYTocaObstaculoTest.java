package algoritmos.gpschallenge.modelo.test.integration;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;
import algoritmos.gpschallenge.modelo.obstaculo.*;

public class VehiculoRecorreMapaYTocaObstaculoTest {
	 
	
	@Test
	public void aplicarPozoEnMoto() {	
        Mapa mapa = new Mapa(2, new Pozo());
        
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Moto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
                     
        // La Moto llega a la esquina donde está el pozo, con 4 movimientos.
        // El pozo debe penalizarla con 3 movimientos, dejando su puntaje final en 7.
        
       jugador.actualizar();
       
       Assert.assertTrue(jugador.getPuntaje() == 7);
	
	}

	@Test
	public void aplicarPozoEnAuto() {	
        Mapa mapa = new Mapa(2, new Pozo());
        
        Jugador jugador = new Jugador("Juan", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
                     
        // El Auto llega a la esquina donde está el pozo, con 4 movimientos.
        // El pozo debe penalizarlo con 3 movimientos, dejando su puntaje final en 7.
        
       jugador.actualizar();
       
       Assert.assertTrue(jugador.getPuntaje() == 7);
	
	}
	
	@Test
	public void aplicarPozoEnCuatroPorCuatro() {	
        Mapa mapa = new Mapa(2, new Pozo());
        
        Jugador jugador = new Jugador("Marito", new Vehiculo(mapa.getEsquinaInicial(), new CuatroPorCuatro()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();   
       
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
                     
        // La CuatroPorCuatro llega a la esquina donde está el pozo, con 4 movimientos.
        // Como no es afectada por el pozo, su puntaje final debe ser 4.
        
       jugador.actualizar();
       
       Assert.assertTrue(jugador.getPuntaje() == 4);
	
	}
	
	@Test
	public void aplicarPiqueteEnMoto() {	
        Mapa mapa = new Mapa(2, new Piquete());
        
        Jugador jugador = new Jugador("Pepe", new Vehiculo(mapa.getEsquinaInicial(), new Moto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.actualizar();
        
        // La Moto llega a la esquina donde está el piquete, con 4 movimientos.
        // El Piquete deja pasar la Moto, pero la penalizarla con 2 movimientos, dejando su puntaje final en 6.
                    
       Assert.assertTrue(jugador.getPuntaje() == 6);
       
       	// Aqui comprobamos que la Moto pudo avanzar sobre el Piquete.
       
       Assert.assertEquals(mapa.getEsquinaFinal(), jugador.getUbicacionVehiculo());
	
	}

	@Test
	public void aplicarPiqueteEnAuto() {	
        Mapa mapa = new Mapa(2, new Piquete());
        
        Jugador jugador = new Jugador("Juan", new Vehiculo(mapa.getEsquinaInicial(), new Auto()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.actualizar();
        
        // El Auto llega a la esquina donde está el pozo, con 4 movimientos.
        // El Piquete lo obliga a "pegar la vuelta", volviendo a la última posición donde estuvo
        // pero tambien agregándole un movimiento más.
        Assert.assertTrue(jugador.getPuntaje() == 5);
        Assert.assertEquals(mapa.getEsquinaAlOesteDeLaFinal(), jugador.getUbicacionVehiculo());
	}
	
	@Test
	public void aplicarPiqueteEnCuatroPorCuatro() {	
        Mapa mapa = new Mapa(2, new Piquete());
        
        Jugador jugador = new Jugador("Marito", new Vehiculo(mapa.getEsquinaInicial(), new CuatroPorCuatro()));
        
        Direccion sur = new Sur();
        Direccion este = new Este();
                
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.moverVehiculoA(sur);
        jugador.moverVehiculoA(este);
        jugador.actualizar();
        
        // La CuatroPorCuatro llega a la esquina donde está el pozo, con 4 movimientos.
        // El Piquete lo obliga a "pegar la vuelta", volviendo a la última posición donde estuvo
        // pero tambien agregándole un movimiento más.
       Assert.assertTrue(jugador.getPuntaje() == 5);
       Assert.assertEquals(mapa.getEsquinaAlOesteDeLaFinal(), jugador.getUbicacionVehiculo());
	}
	
}