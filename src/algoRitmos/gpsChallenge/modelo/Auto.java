package algoRitmos.gpsChallenge.modelo;
import java.lang.Math;

public class Auto implements ITipoVehiculo {
	
	public ITipoVehiculo cambiar() {
		return new CuatroPorCuatro();
	}
	
	public int atravesarPozo(int penalizacionPozo) {
		
		//Devuelve la penalización de 3 movimientos que le corresponde al Auto por cruzar un pozo.
		return penalizacionPozo;    
	}

	public int atravesarControlPolicial(int penalizacionControlPolicial) {
		
		double numeroAleatorio = Math.random();
		
		//Existe un 50% de probabilidad que un Auto sea penalizado por el Control Policial.
		if (numeroAleatorio < 0.5)
			return penalizacionControlPolicial;
		
		else
			//Sin embargo, tiene un 50% de probabilidad de evitar la penalización.
			return 0;			
	}

	
}
