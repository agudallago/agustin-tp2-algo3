package algoRitmos.gpsChallenge.modelo;
import java.lang.Math;

public class CuatroPorCuatro implements ITipoVehiculo {

	public String toString() {
		return "CuatroPorCuatro";
	}
	
	public ITipoVehiculo cambiar() {
		return new Moto();
	}

	public boolean aplicaPozo() {
		return false;		
	}

	public boolean aplicaControlPolicial() {
		
		double numeroAleatorio = Math.random();
		
		//Existe un 30% de probabilidad que una 4x4 sea penalizada por el Control Policial.
		if (numeroAleatorio < 0.3)
			return true;
		
		else
			//Sin embargo, tiene un 70% de probabilidad de evitar la penalización.
			return false;			
	}

	public boolean aplicaPiquete() {
		return true;
	}
	
}
