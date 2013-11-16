package algoRitmos.gpsChallenge.modelo;

public class CuatroPorCuatro implements ITipoVehiculo {

	public ITipoVehiculo cambiar() {
		return new Moto();
	}
	
}
