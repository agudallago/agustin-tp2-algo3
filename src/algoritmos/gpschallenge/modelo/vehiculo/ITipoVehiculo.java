package algoritmos.gpschallenge.modelo.vehiculo;

public interface ITipoVehiculo {
		
	public String toString();
	public ITipoVehiculo cambiar();
	public void atravesarPozo(Vehiculo vehiculo, int penalizacion);
	public void atravesarControlPolicial(Vehiculo vehiculo, int penalizacion);
	public void atravesarPiquete(Vehiculo vehiculo, int penalizacion);
	
}
