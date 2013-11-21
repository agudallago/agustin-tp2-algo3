package algoritmos.gpschallenge.modelo.vehiculo;
import java.lang.Math;

public class Moto implements ITipoVehiculo {

	private static final double PROBABILIDAD_DE_SER_DETENIDO = 0.8;
	
	public String toString() {
		return "Moto";
	}
	
	public ITipoVehiculo cambiar() {
		return new Auto();
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
		vehiculo.addMovimientosBonus(penalizacion);
	}

}
