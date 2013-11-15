package algoRitmos.gpsChallenge.modelo;

public class Vehiculo {

	private Esquina mUbicacion;
	private ITipoVehiculo mTipo;
	private int mMovimientos;
	
	public Vehiculo(Esquina ubicacion, ITipoVehiculo tipo) {
		this.mUbicacion = ubicacion;
		this.mTipo = tipo;
		this.mMovimientos = 0;
	}
	
	public void moverA(Direccion direccion) {
		this.mUbicacion = this.mUbicacion.getEsquinaAl(direccion);
		mMovimientos++;
	}
	
	public Esquina getUbicacion() {
		return mUbicacion;
	}
	
	public double getMovimientos () {
		return mMovimientos;
	}

	public void addMovimientos(double cantidadDeMovimientos) {
		this.mMovimientos += cantidadDeMovimientos;
	}
	
	public void cambiarVehiculo() {
		// TODO: Do stuff	
	}
	
	private Vehiculo() {
		// no usar!
	}
}
