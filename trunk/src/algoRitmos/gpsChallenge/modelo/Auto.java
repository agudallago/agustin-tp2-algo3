package algoRitmos.gpsChallenge.modelo;

public class Auto implements ITipoVehiculo {
	
	public ITipoVehiculo cambiar() {
		return new CuatroPorCuatro();
	}
	
}
