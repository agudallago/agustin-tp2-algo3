package algoRitmos.gpsChallenge.modelo;

import java.util.HashMap;

public class Esquina {
	
	private HashMap<Direccion, Esquina> mEsquinasProximas;
	private ElementoDeEsquina mElementoEnEsquina;	
	
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
	
}
