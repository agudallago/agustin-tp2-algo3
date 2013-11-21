package algoritmos.gpschallenge.modelo.juego;

import java.util.HashMap;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Esquina {
	
	////////////////////// Atributos ////////////////////////////
	private HashMap<Direccion, Esquina> mEsquinasProximas;
	private ElementoDeEsquina mElementoEnEsquina;	
	
	////////////////// Metodos Publicos /////////////////////////
	
	public Esquina() {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();
		this.mElementoEnEsquina = null;
	}
	
	public Esquina(ElementoDeEsquina elementoEnEsquina) {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();
		this.mElementoEnEsquina = elementoEnEsquina;
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
