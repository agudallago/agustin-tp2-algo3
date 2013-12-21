package algoritmos.gpschallenge.modelo.juego;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Jugador {
		
		//////////////////// Atributos //////////////////////
	private static int mContadorJugadores = 0;
	private Vehiculo mVehiculo;
	private int mId;
    private String mNombre;
    private float mPuntaje;
	
    	///////////////// Métodos Públicos ///////////////////
	
    public Jugador(String nombre, Vehiculo vehiculo) {
        this.mId = mContadorJugadores++;
    	this.mNombre = nombre;
        this.mVehiculo = vehiculo;
        this.mPuntaje = 0;
    }
    
    public String getNombre() {
		return mNombre;
	}
    
    public float getPuntaje() {
		return mPuntaje;
	}  
    
    public void actualizar() {
    	this.actualizarPuntaje();
    }
           
    public void moverVehiculoA(Direccion direccion) {
    	if (direccion != null) {    	
    		this.mVehiculo.moverA(direccion);
    	}
    }
    
    public Esquina getUbicacionVehiculo() {
    	return mVehiculo.getUbicacion();
    }
    
    public String getTipoDeVehiculo() {
    	return this.mVehiculo.getTipoDeVehiculoAsString();
    }

	public boolean juegoTerminado() {
		return this.mVehiculo.estaEnLaMeta();
	}
	
	public int getId() {
		return this.mId;
	}
	
	public boolean equals(Object otroJugador) {		
		if(mId == ( (Jugador)otroJugador ).getId() ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return mNombre.hashCode();
	}
    
		///////////////// Metodos Privados ///////////////////
    
	private void actualizarPuntaje() {
    	this.mPuntaje = mVehiculo.getMovimientos() + mVehiculo.getMovimientosBonus();
    }
	
	@SuppressWarnings("unused")
	private Jugador() {
		// no usar!
	}
}