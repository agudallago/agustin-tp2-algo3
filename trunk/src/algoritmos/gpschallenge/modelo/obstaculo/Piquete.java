package algoritmos.gpschallenge.modelo.obstaculo;

import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Piquete extends Obstaculo {

	public Piquete() {
		this.mMovimientosDePenalizacion = 2;				
	}
	
	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.atravesarPiquete(mMovimientosDePenalizacion);
	}	
	
}
