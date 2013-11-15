package algoRitmos.gpsChallenge.modelo;

import java.util.HashMap;

public class Esquina {
	
	private HashMap<Direccion, Esquina> mEsquinasProximas;
	private ElementoDeMapa mElementoEnEsquina;
	
	public Esquina() {
		this.mEsquinasProximas = new HashMap<Direccion, Esquina>();		
	};
	
	public void setEsquinaAl(Direccion direccion, Esquina esquina) {		 
		this.mEsquinasProximas.put(direccion, esquina);
	};
	
	public Esquina getEsquinaAl(Direccion direccion) {
		return this.mEsquinasProximas.get(direccion);
	};	
	
}
