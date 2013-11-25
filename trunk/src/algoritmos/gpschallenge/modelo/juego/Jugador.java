package algoritmos.gpschallenge.modelo.juego;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Jugador {
		
		//////////////////// Atributos //////////////////////
	
	private Vehiculo mVehiculo;
    private String mNombre;
    private float mPuntaje;
	
    	///////////////// M�todos P�blicos ///////////////////
	
    public Jugador(String nombre, Vehiculo vehiculo) {
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
    
		///////////////// Metodos Privados ///////////////////
    
	private void actualizarPuntaje() {
    	this.mPuntaje = mVehiculo.getMovimientos() + mVehiculo.getMovimientosBonus();
    }
	
	@SuppressWarnings("unused")
	private Jugador() {
		// no usar!
	}
}