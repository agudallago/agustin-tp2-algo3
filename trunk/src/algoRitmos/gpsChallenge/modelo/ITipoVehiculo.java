package algoRitmos.gpsChallenge.modelo;

public interface ITipoVehiculo {
		
	public ITipoVehiculo cambiar();

	public int atravesarPozo(int penalizacionPozo);

	public int atravesarControlPolicial(int penalizacionControlPolicial);
	
}
