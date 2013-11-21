package algoritmos.gpschallenge.modelo.obstaculo;

import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Pozo extends Obstaculo {

	public Pozo() {
		this.mMovimientosDePenalizacion = 3;				
	}
	
	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.atravesarPozo(mMovimientosDePenalizacion);
	}
	
}
