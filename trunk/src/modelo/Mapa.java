package modelo;
import java.util.ArrayList;

import ejercicioMatriz.Entero;
import ejercicioMatriz.Numero;

public class Mapa {

	private ArrayList<ArrayList<Esquina>> esquinas;

	public Mapa(int alto, int ancho) {
		//Constructor de Mapa
		
		this.esquinas = new ArrayList<ArrayList<Esquina>>();
		for (int i = 0; i < alto -1; i++){
			ArrayList<Esquina> fila = new ArrayList<Esquina>();
			for (int j = 0; j < ancho-1; j++){
				fila.add(new Esquina);
			}
			this.esquinas.add(fila);
		}
		
	}
		
	public Esquina obtenerEsquinaEn(int alto, int ancho) {
		ArrayList<Esquina> esquina = this.esquinas.get(alto);
		return esquina.get(ancho);
	}

//Fin de la Clase
}
