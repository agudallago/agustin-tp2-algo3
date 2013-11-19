package algoRitmos.gpsChallenge.modelo;

public interface ITipoVehiculo {
		
	public String ToString();
	public ITipoVehiculo cambiar();
	public boolean aplicaPozo();
	public boolean aplicaControlPolicial();
	public boolean aplicaPiquete();
	
}
