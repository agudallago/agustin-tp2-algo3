package algoRitmos.gpsChallenge.modelo;

public class Jugador {
	
    public Jugador(String nombre, Vehiculo vehiculo) {
        this.mNombre = nombre;
        this.mVehiculo = vehiculo;
        this.mPuntaje = 0;
    }
    
    public String getNombre() {
		return mNombre;
	}
    
    public int getPuntaje() {
		return mPuntaje;
	}
        
    public void moverVehiculoA(Direccion direccion) {
    	this.mVehiculo.moverA(direccion);
    }
    
    private Vehiculo mVehiculo;
    private String mNombre;
    private int mPuntaje;
}