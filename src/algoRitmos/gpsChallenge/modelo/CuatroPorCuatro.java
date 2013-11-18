package algoRitmos.gpsChallenge.modelo;
import java.lang.Math;

public class CuatroPorCuatro implements ITipoVehiculo {

	public ITipoVehiculo cambiar() {
		return new Moto();
	}

	public int atravesarPozo(int penalizacionPozo) {
		
		//Devuelve una penalización nula, ya que una 4x4 no es afectada por cruzar un pozo.
		return 0;    
	}

	public int atravesarControlPolicial(int penalizacionControlPolicial) {
		
		double numeroAleatorio = Math.random();
		
		//Existe un 30% de probabilidad que una 4x4 sea penalizada por el Control Policial.
		if (numeroAleatorio < 0.3)
			return penalizacionControlPolicial;
		
		else
			//Sin embargo, tiene un 70% de probabilidad de evitar la penalización.
			return 0;			
	}

}
