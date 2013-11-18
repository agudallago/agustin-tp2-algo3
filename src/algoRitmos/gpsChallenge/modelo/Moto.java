package algoRitmos.gpsChallenge.modelo;
import java.lang.Math;

public class Moto implements ITipoVehiculo {

	public ITipoVehiculo cambiar() {
		return new Auto();
	}

	public int atravesarPozo(int penalizacionPozo) {
		
		//Devuelve la penalización de 3 movimientos que le corresponde al Moto por cruzar un pozo.
		return penalizacionPozo;    
	}

	public int atravesarControlPolicial(int penalizacionControlPolicial) {
		
		double numeroAleatorio = Math.random();
				
		//Existe un 80% de probabilidad que una Moto sea penalizada por el Control Policial.
		if (numeroAleatorio < 0.8)
			return penalizacionControlPolicial;
		
		else
			//Sin embargo, tiene un 20% de probabilidad de evitar la penalización.
			return 0;			
	}


}
