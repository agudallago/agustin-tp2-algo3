
package algoRitmos.gpsChallenge.modelo;


public class Esquina {

	private Coordenada coordenada;
	private ElementoDeMapa elementoEnEsquina;

	private void Esquina(coordenadas){
		elementosEnEsquina = null;
	}
	
	public void addElemento(unElemento){
		elementosEnEsquina.add(unElemento); 
	}

	public void getElemento(){
		return elementoEnEsquina; 
	}
	
	public Esquina getEsquinaIzquierda{
		return esquinaInquierda;	
	}
	
	public Esquina getEsquinaDerecha{
		return esquinaDerecha;	
	}
	
	public Esquina getEsquinaArriba{
		return esquinaArriba;	
	}
	
	public Esquina getEsquinaAbajo{
		return esquinaAbajo;	
	}
}

