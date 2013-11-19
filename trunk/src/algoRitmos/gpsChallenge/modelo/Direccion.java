package algoRitmos.gpsChallenge.modelo;

public abstract class Direccion {

	/////////// Atributos /////////////
	protected String mDireccion;
	
	/////////// Metodos ///////////////
	
	public String toString() {
		return mDireccion;
	}
		
	public boolean equals(Object otraDireccion) {
		if(this.mDireccion.equals(otraDireccion.toString())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.toString().hashCode();
	}
}
