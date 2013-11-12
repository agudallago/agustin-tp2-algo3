package algoRitmos.gpsChallenge.modelo;

public class Vehiculo {
	
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
	
	private Esquina mUbicacion;
	private ITipoVehiculo mTipo;
	private int mMovimientos;
}
