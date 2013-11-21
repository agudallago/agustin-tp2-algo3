package algoritmos.gpschallenge.modelo.sorpresa;

import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class SorpresaCambioVehiculo extends Sorpresa {

	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.cambiar();
	}
	
}
