package algoritmos.gpschallenge.modelo.vehiculo;
import java.lang.Math;

public class CuatroPorCuatro implements ITipoVehiculo {

	private static final double PROBABILIDAD_DE_SER_DETENIDO = 0.3;
	
	public String toString() {
		return "CuatroPorCuatro";
	}
	
	public ITipoVehiculo cambiar() {
		return new Moto();
	}

	public void atravesarPozo(Vehiculo vehiculo, int penalizacion) {
		// No afecta a las 4x4	
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
