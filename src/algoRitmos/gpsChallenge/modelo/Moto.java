package algoRitmos.gpsChallenge.modelo;

public class Moto implements ITipoVehiculo {

	public ITipoVehiculo cambiar() {
		return new Auto();
	}

}
