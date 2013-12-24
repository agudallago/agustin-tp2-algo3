package algoritmos.gpschallenge.modelo.juego;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Jugador {
		
	//////////////////// Atributos //////////////////////
	private static int mContadorJugadores = 0;
	private Vehiculo mVehiculo;
	private int mId;							// Identificador univoco de jugador
    private String mNombre;
    private float mPuntajeActual;
	
    ///////////////// Métodos Públicos ///////////////////
	
    public Jugador(String nombre, Vehiculo vehiculo) {
        this.mId = mContadorJugadores++;
    	this.mNombre = nombre;
        this.mVehiculo = vehiculo;
        this.mPuntajeActual = 0;
    }
    
    public String getNombre() {
		return mNombre;
	}
    
    public float getPuntaje() {
		return mPuntajeActual;
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
		return (mId == ( (Jugador)otroJugador ).getId() );
	}
	
	public int hashCode() {
		return mNombre.hashCode();
	}
    
		///////////////// Metodos Privados ///////////////////
    
	private void actualizarPuntaje() {
    	this.mPuntajeActual = mVehiculo.getMovimientos() + mVehiculo.getMovimientosBonus();
    }
	
	@SuppressWarnings("unused")
	private Jugador() {
		// no usar!
	}
}