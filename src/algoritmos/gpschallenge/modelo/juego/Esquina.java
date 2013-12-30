package algoritmos.gpschallenge.modelo.juego;

import java.util.HashMap;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Esquina {
	
	////////////////////// Atributos ////////////////////////////
	private HashMap<Direccion, Esquina> mEsquinasProximas;
	private ElementoDeEsquina mElementoEnEsquina;
	private final int mPosX;
	private final int mPosY;
	
	////////////////// Metodos Publicos /////////////////////////
	
	public Esquina(int posX, int posY) {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();
		this.mElementoEnEsquina = null;
		this.mPosX = posX;
		this.mPosY = posY;
	}
	
	public Esquina(ElementoDeEsquina elementoEnEsquina, int posX, int posY) {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();
		this.mElementoEnEsquina = elementoEnEsquina;
		this.mPosX = posX;
		this.mPosY = posY;
	}
	
	public int getPosX() {
		return this.mPosX;
	}
	
	public int getPosY() {
		return this.mPosY;
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
