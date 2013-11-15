package algoRitmos.gpsChallenge.modelo;

public abstract class Direccion {
	
	protected String mDireccion;
	
	public String toString() {
		return mDireccion;
	}
	
	public boolean equals(Direccion otraDireccion) {
		if(this.mDireccion.equals(otraDireccion.toString())) {
			return true;
		}
		else {
			return false;
		}
	}	
}
