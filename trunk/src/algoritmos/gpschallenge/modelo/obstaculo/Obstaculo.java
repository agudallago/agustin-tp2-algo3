package algoritmos.gpschallenge.modelo.obstaculo;

import algoritmos.gpschallenge.modelo.juego.ElementoDeEsquina;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public abstract class Obstaculo extends ElementoDeEsquina {

	protected int mMovimientosDePenalizacion;
	
	public abstract void aplicarA(Vehiculo vehiculo);	
	
}
