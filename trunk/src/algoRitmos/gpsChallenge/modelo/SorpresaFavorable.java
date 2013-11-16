package algoRitmos.gpsChallenge.modelo;

public class SorpresaFavorable extends SorpresaDePuntaje {

		
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
