package algoRitmos.gpsChallenge.modelo;

public interface ITipoVehiculo {
		
	public String toString();
	public ITipoVehiculo cambiar();
	public boolean aplicaPozo();
	public boolean aplicaControlPolicial();
	public boolean aplicaPiquete();
	
}
