package algoRitmos.gpsChallenge.modelo;

public abstract class Obstaculo extends ElementoDeEsquina {

	protected int mMovimientosDePenalizacion;
	
	public void aplicarA(Vehiculo vehiculo) {
		// Debe ser redefinida por clases derivadas
	}
	
}
