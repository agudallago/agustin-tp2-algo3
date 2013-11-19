package algoRitmos.gpsChallenge.modelo;

public class Vehiculo {

	private Esquina mUbicacion;
	private Esquina mUbicacionPrevia;
	private ITipoVehiculo mTipo;
	private int mMovimientos;
	private float mMovimientosBonus;
	private boolean mEstaEnLaMeta;
	
	public Vehiculo(Esquina ubicacion, ITipoVehiculo tipo) {
		this.mUbicacion = ubicacion;
		this.mUbicacionPrevia = null;
		this.mTipo = tipo;
		this.mMovimientos = 0;
		this.mMovimientosBonus = 0;
		this.mEstaEnLaMeta = false;
	}
	
	public void moverA(Direccion direccion) {
		if (this.getUbicacion().tieneEsquinaEnLaDireccion(direccion)) {
			
		this.mUbicacionPrevia = this.mUbicacion;
		this.mUbicacion = this.mUbicacion.getEsquinaAl(direccion);
		mMovimientos++;
		this.aplicarElementoEnLaEsquina();
		
		}
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

	public String getTipoDeVehiculoAsString() {
		return this.mTipo.ToString();
	}
	
	public boolean estaEnLaMeta() {
		return this.mEstaEnLaMeta;
	}
	
	public void addMovimientosBonus(float cantidadDeMovimientos) {
		this.mMovimientosBonus += cantidadDeMovimientos;
	}
	
	public void cruzarLaMeta() {
		this.cambiarEstado();
	}
	
	private void cambiarEstado() {
	
		this.mEstaEnLaMeta= true;
	}
	
	public void cambiar() {
		this.mTipo = mTipo.cambiar();	
	}
	
	public void aplicarElementoEnLaEsquina() {
		ElementoDeEsquina elemento = this.mUbicacion.getElementoEnEsquina();
		
		if (elemento != null) {
			elemento.aplicarA(this);
	
		}
	}
	
	public void atravesarPozo(int penalizacionPozo) {
		
		if (this.mTipo.aplicaPozo()) {
		
			this.mMovimientos += penalizacionPozo;
		}
	}

	public void atravesarControlPolicial(int penalizacionControlPolicial) {
		
		if (this.mTipo.aplicaControlPolicial()) {
			
			this.mMovimientos += penalizacionControlPolicial;
		}
	}

	public void atravesarPiquete(int penalizacionPiquete) {

		if (this.mTipo.aplicaPiquete()) {
			
			//En este caso, como el piquete impedirá el paso, con lo cual la ubicación del Vehículo
			//será su ubicación previa ("pega la vuelta")
			
			this.mUbicacion = this.mUbicacionPrevia;
		}
		
			else {
			
					this.mMovimientos += penalizacionPiquete;
			}
		
	}
	
	private Vehiculo() {
		// no usar!
	}
	
}
