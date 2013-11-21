package algoRitmos.gpsChallenge.modelo;

public class Piquete extends Obstaculo {

	public Piquete() {
		this.mMovimientosDePenalizacion = 2;				
	}
	
	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.atravesarPiquete(mMovimientosDePenalizacion);
	}	
	
}
