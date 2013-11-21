package algoritmos.gpschallenge.modelo.juego;
import java.util.ArrayList;

import algoritmos.gpschallenge.modelo.direccion.Direccion;
import algoritmos.gpschallenge.modelo.direccion.Este;
import algoritmos.gpschallenge.modelo.direccion.Norte;
import algoritmos.gpschallenge.modelo.direccion.Oeste;
import algoritmos.gpschallenge.modelo.direccion.Sur;


public class Mapa {

	private ArrayList<Esquina> mEsquinas;	

	public Mapa(int numeroDeMapa, ElementoDeEsquina elemento) {
		mEsquinas = new ArrayList<Esquina>();
		
		switch (numeroDeMapa) {	
			case 1:
				this.generarMapa3por3Vacio();
				break;
			case 2:
				this.generarMapa3por3ElementoAlFinal(elemento);
				break;
			
		}
	}
	
	public Esquina getEsquinaInicial() {
		return mEsquinas.get(0); 					// la primer esquina en la lista es la inicial
	}
	
	public Esquina getEsquinaFinal() {
		return mEsquinas.get(mEsquinas.size()-1); 	// la ultima esquina en la lista es la final
	}
	
	public Esquina getEsquinaAlOesteDeLaFinal() {
		return mEsquinas.get(mEsquinas.size()-2); 	// la anteultima esquina en la lista est� ubicada al Oeste de la final.
	}
	
	private void generarMapa3por3Vacio() {
		Esquina esquina11 = addEsquina();				
		Esquina esquina12 = addEsquina();		
		Esquina esquina13 = addEsquina();		
		Esquina esquina21 = addEsquina();		
		Esquina esquina22 = addEsquina();		
		Esquina esquina23 = addEsquina();		
		Esquina esquina31 = addEsquina();		
		Esquina esquina32 = addEsquina();		
		Esquina esquina33 = addEsquina();		
		
		Direccion norte = new Norte();
		Direccion sur = new Sur();
		Direccion este = new Este();
		Direccion oeste = new Oeste();
		
		esquina11.setEsquinaAl(este, esquina12);
		esquina11.setEsquinaAl(sur, esquina21);
		
		esquina12.setEsquinaAl(oeste, esquina11);
		esquina12.setEsquinaAl(sur, esquina22);
		esquina12.setEsquinaAl(este, esquina13);
		
		esquina13.setEsquinaAl(oeste, esquina12);
		esquina13.setEsquinaAl(sur, esquina23);
		
		esquina21.setEsquinaAl(norte, esquina11);
		esquina21.setEsquinaAl(sur, esquina31);
		esquina21.setEsquinaAl(este, esquina22);
		
		esquina22.setEsquinaAl(norte, esquina12);
		esquina22.setEsquinaAl(sur, esquina32);
		esquina22.setEsquinaAl(este, esquina23);
		esquina22.setEsquinaAl(oeste, esquina21);
		
		esquina23.setEsquinaAl(norte, esquina13);
		esquina23.setEsquinaAl(sur, esquina33);
		esquina23.setEsquinaAl(oeste, esquina22);
		
		esquina31.setEsquinaAl(norte, esquina21);		
		esquina31.setEsquinaAl(este, esquina32);
		
		esquina32.setEsquinaAl(norte, esquina22);
		esquina32.setEsquinaAl(oeste, esquina31);
		esquina32.setEsquinaAl(este, esquina33);
		
		esquina33.setEsquinaAl(norte, esquina23);
		esquina33.setEsquinaAl(oeste, esquina32);
		
	}
	
	private void generarMapa3por3ElementoAlFinal(ElementoDeEsquina elemento) {
		this.generarMapa3por3Vacio();
		
		this.getEsquinaFinal().addElementoEnEsquina(elemento);
	}
	
		
	private Esquina addEsquina() {
		Esquina esquina = new Esquina();
		this.mEsquinas.add(esquina);
		
		return esquina;
	}
		
}
