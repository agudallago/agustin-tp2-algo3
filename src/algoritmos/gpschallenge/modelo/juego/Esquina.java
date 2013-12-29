package algoritmos.gpschallenge.modelo.juego;

import java.util.HashMap;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Esquina {
	
	////////////////////// Atributos ////////////////////////////
	private HashMap<Direccion, Esquina> mEsquinasProximas;
	private ElementoDeEsquina mElementoEnEsquina;
	private final int mUbicacionHorizontal;
	private final int mUbicacionVertical;
	
	////////////////// Metodos Publicos /////////////////////////
	
	public Esquina(int posHorizontal, int posVertical) {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();
		this.mElementoEnEsquina = null;
		this.mUbicacionHorizontal = posHorizontal;
		this.mUbicacionVertical = posVertical;
	}
	
	public Esquina(ElementoDeEsquina elementoEnEsquina, int posHorizontal, int posVertical) {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();
		this.mElementoEnEsquina = elementoEnEsquina;
		this.mUbicacionHorizontal = posHorizontal;
		this.mUbicacionVertical = posVertical;
	}
	
	public int getUbicacionHorizontal() {
		return this.mUbicacionHorizontal;
	}
	
	public int getUbicacionVertical() {
		return this.mUbicacionVertical;
	}
	
	public void setEsquinaAl(Direccion direccion, Esquina esquina) {		 
		this.mEsquinasProximas.put(direccion, esquina);
	}
	
	public Esquina getEsquinaAl(Direccion direccion) {
		return this.mEsquinasProximas.get(direccion);
	}
	
	public ElementoDeEsquina getElementoEnEsquina() {
		return this.mElementoEnEsquina;
	}
	
	public void addElementoEnEsquina(ElementoDeEsquina elemento) {
		this.mElementoEnEsquina = elemento;
	}
	
	public boolean tieneEsquinaEnLaDireccion(Direccion direccion) {
		return this.mEsquinasProximas.containsKey(direccion);
	}
	
	public void aplicarElementosA(Vehiculo vehiculo) {
		if (this.mElementoEnEsquina != null) {
			mElementoEnEsquina.aplicarA(vehiculo);	
		}
	}
	
}
