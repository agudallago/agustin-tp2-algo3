package algoRitmos.gpsChallenge.modelo;
import java.lang.Math;

public class Moto implements ITipoVehiculo {

	public String toString() {
		return "Moto";
	}
	
	public ITipoVehiculo cambiar() {
		return new Auto();
	}

	public boolean aplicaPozo() {
		return true;		
	}

	public boolean aplicaControlPolicial() {
		
		double numeroAleatorio = Math.random();
				
		//Existe un 80% de probabilidad que una Moto sea penalizada por el Control Policial.
		if (numeroAleatorio < 0.8)
			return true;
		
		else
			//Sin embargo, tiene un 20% de probabilidad de evitar la penalización.
			return false;			
	}

	public boolean aplicaPiquete() {
		return false;
	}

}
