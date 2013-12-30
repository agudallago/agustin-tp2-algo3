package algoritmos.gpschallenge.modelo.vehiculo;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.juego.Esquina;

public class Vehiculo {

	//////////////////// Atributos //////////////////////
	
	private Esquina mUbicacion;
	private Esquina mUbicacionPrevia;
	private ITipoVehiculo mTipo;
	private int mMovimientos;
	private float mMovimientosBonus;
	private boolean mAlcanzoMeta;
	
	///////////////// Métodos Publicos ///////////////////
	
	public Vehiculo(Esquina ubicacion, ITipoVehiculo tipo) {
		this.mUbicacionPrevia = null;
		this.mMovimientos = 0;
		this.mMovimientosBonus = 0;
		this.mAlcanzoMeta = false;
		
		this.mUbicacion = ubicacion;		
		this.mTipo = tipo;		
	}
	
	public void moverA(Direccion direccion) {
		if (this.getUbicacion().tieneEsquinaEnLaDireccion(direccion)) {				
			this.mUbicacionPrevia = this.mUbicacion;
			this.mUbicacion = this.mUbicacion.getEsquinaAl(direccion);
			mMovimientos++;
			this.aplicarElementosEnLaEsquina();				
		}
		// TODO: Lanzar excepcion fuera de mapa
	}
	
	public Esquina getUbicacion() {
		return mUbicacion;
	}
	
	public int getPosX() {
		return mUbicacion.getPosX();
	}
	
	public int getPosY() {
		return mUbicacion.getPosY();
	}
	
	public int getMovimientos() {
		return mMovimientos;
	}
	
	public float getMovimientosBonus() {
		return mMovimientosBonus;
	}

	public String getTipoDeVehiculoAsString() {
		return this.mTipo.toString();
	}
	
	public boolean estaEnLaMeta() {
		return this.mAlcanzoMeta;
	}
	
	public void addMovimientosBonus(float cantidadDeMovimientos) {
		this.mMovimientosBonus += cantidadDeMovimientos;
	}
	
	public void cruzarLaMeta() {
		this.mAlcanzoMeta = true;
	}	
	
	public void atravesarPozo(int penalizacion) {		
		this.mTipo.atravesarPozo(this, penalizacion);
	}

	public void atravesarControlPolicial(int penalizacion) {		
		this.mTipo.atravesarControlPolicial(this, penalizacion);
	}

	public void volverAUbicacionPrevia() {
		Esquina ubicacionActual = mUbicacion;
		this.mUbicacion = this.mUbicacionPrevia;
		this.mUbicacionPrevia = ubicacionActual;		
		mMovimientos++;
		this.aplicarElementosEnLaEsquina();	
	}
	
	public void atravesarPiquete(int penalizacion) {
		this.mTipo.atravesarPiquete(this, penalizacion);		
	}
	
	public void cambiar() {
		this.mTipo = mTipo.cambiar();	
	}
	
	///////////////// Metodos Privados ///////////////////
		
	private void aplicarElementosEnLaEsquina() {
		this.mUbicacion.aplicarElementosA(this);		
	}
	
	@SuppressWarnings("unused")
	private Vehiculo() {
		// no usar!
	}
	
}
