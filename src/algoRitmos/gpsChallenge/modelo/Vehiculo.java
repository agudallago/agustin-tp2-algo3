package algoRitmos.gpsChallenge.modelo;

public class Vehiculo {

	private Esquina mUbicacion;
	private ITipoVehiculo mTipo;
	private double mMovimientos;
	
	public Vehiculo() {
		this.mUbicacion = new Esquina();
		this.mTipo = new Auto();
		this.mMovimientos = 0;
	}
	
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
}
