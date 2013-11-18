package algoRitmos.gpsChallenge.modelo;

public class Vehiculo {

	private Esquina mUbicacion;
	private ITipoVehiculo mTipo;
	private int mMovimientos;
	private float mMovimientosBonus;
	
	public Vehiculo(Esquina ubicacion, ITipoVehiculo tipo) {
		this.mUbicacion = ubicacion;
		this.mTipo = tipo;
		this.mMovimientos = 0;
		this.mMovimientosBonus = 0;
	}
	
	public void moverA(Direccion direccion) {
		this.mUbicacion = this.mUbicacion.getEsquinaAl(direccion);
		mMovimientos++;
	}
	
	public Esquina getUbicacion() {
		return mUbicacion;
	}
	
	public int getMovimientos() {
		return mMovimientos;
	}
	
	public float getMovimientosBonus() {
		return mMovimientosBonus;
	}

	public void addMovimientosBonus(float cantidadDeMovimientos) {
		this.mMovimientosBonus += cantidadDeMovimientos;
	}
	
	public void cambiar() {
		this.mTipo = mTipo.cambiar();	
	}
	
	public void actualizar() {
		ElementoDeEsquina elemento = this.mUbicacion.getElementoEnEsquina();
		if (elemento != null) {
			elemento.aplicarA(this);
		}
	}
	
/*	private Vehiculo() {
		// no usar!
	}*/
}
