package algoRitmos.gpsChallenge.modelo;

import java.util.HashMap;

public class Esquina {
	
	private HashMap<String, Esquina> mEsquinasProximas;
	private ElementoDeMapa mElementoEnEsquina;
	
	public Esquina() {
		this.mEsquinasProximas = new HashMap<String, Esquina>();		
	};
	
	public void setEsquinaAl(Direccion direccion, Esquina esquina) {		 
		this.mEsquinasProximas.put(direccion.toString(), esquina);
	};
	
	public Esquina getEsquinaAl(Direccion direccion) {
		return this.mEsquinasProximas.get(direccion.toString());
	};	
	
}
