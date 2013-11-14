package algoRitmos.gpsChallenge.modelo;


	public abstract class Sorpresa {
	protected double porcentaje;
	private double movTotal;
	
	public void AplicarA(Vehiculo unVehiculo){
		
		movTotal = unVehiculo.getMovimientos();
		movTotal = movTotal * porcentaje;
		unVehiculo.addMovimientos(movTotal);
				
	}	


	protected void setPorcentaje(double unPorcentaje) {
		
		porcentaje = unPorcentaje;
		
	}	
	
	
	
}
