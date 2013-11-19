package algoRitmos.gpsChallenge.modelo;
import java.lang.Math;

public class Auto implements ITipoVehiculo {
	
	
	public String ToString() {
		return "Auto";
	}
		
	public ITipoVehiculo cambiar() {
		return new CuatroPorCuatro();
	}
	
	public boolean aplicaPozo() {
		return true;		
	}
	
	public boolean aplicaControlPolicial() {
		
		double numeroAleatorio = Math.random();
		
		//Existe un 50% de probabilidad que un Auto sea penalizado por el Control Policial.
		if (numeroAleatorio < 0.5)
			return true;
		
		else
			//Sin embargo, tiene un 50% de probabilidad de evitar la penalización.
			return false;			
	}

	public boolean aplicaPiquete() {
		return true;
	}
	
}
