package algoRitmos.gpsChallenge.modelo;

public class SorpresaFavorable extends Sorpresa{

	protected final float porcentaje;
	private float movTotal;

	public void AplicarA(Vehiculo unVehiculo) {
		movTotal = unVehiculo.getMovimientos();
		movTotal = movTotal * porcentaje;
		unVehiculo.addMovimientos(movTotal);
	}
			
}	
	
	public SorpresaFavorable(){
		
		this.setPorcentaje(-0.2);		
		
	}	
}
