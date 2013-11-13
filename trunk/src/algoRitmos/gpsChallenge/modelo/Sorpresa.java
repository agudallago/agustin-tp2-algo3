package algoRitmos.gpsChallenge.modelo;

public abstract class Sorpresa {
	private const porcentaje;
	private float movTotal;
	
	public AplicarA(Vehiculo unVehiculo){
		
		movTotal = unVehiculo.getMovimientos() * porcentaje;
		unVehiculo.addMovimientos(movTotal); 

	}	
}
