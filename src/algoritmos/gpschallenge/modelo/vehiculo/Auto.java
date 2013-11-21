package algoritmos.gpschallenge.modelo.vehiculo;
import java.lang.Math;

public class Auto implements ITipoVehiculo {
	
	private static final double PROBABILIDAD_DE_SER_DETENIDO = 0.5;
	
	public String toString() {
		return "Auto";
	}
		
	public ITipoVehiculo cambiar() {
		return new CuatroPorCuatro();
	}
	
	public void atravesarPozo(Vehiculo vehiculo, int penalizacion) {
		vehiculo.addMovimientosBonus(penalizacion);	
	}
	
	public void atravesarControlPolicial(Vehiculo vehiculo, int penalizacion) {		
		double numeroAleatorio = Math.random();
		
		if (numeroAleatorio < PROBABILIDAD_DE_SER_DETENIDO) {
			// es detenido
			vehiculo.addMovimientosBonus(penalizacion);
		}						
	}

	public void atravesarPiquete(Vehiculo vehiculo, int penalizacion) {
		vehiculo.volverAUbicacionPrevia();
	}
	
}
