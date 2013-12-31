package algoritmos.gpschallenge.modelo.admin;

import java.io.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import algoritmos.gpschallenge.modelo.juego.Jugador;

public class AdminDeJugadores extends AdminXML {
	
	//////////////////////Atributos ////////////////////////////
	private HashMap<Jugador, Float> mPuntajeMaxPorJugador;	
	static final int MAX_RANKING = 10;
	
	// TODO: remover! Esta usado para stubbeo
	//static boolean yaEntre = false;	
	
	///////////////////Clase Privada ///////////////////////////
	
	private class Compare implements Comparator<Entry<Jugador, Float>> {
		public int compare(Entry<Jugador, Float> o1, Entry<Jugador, Float> o2) {
			return o2.getValue().compareTo(o1.getValue());
		}
	}
	
	////////////////// Metodos Publicos /////////////////////////
		
	public AdminDeJugadores() {
		this.mPuntajeMaxPorJugador = new HashMap<Jugador, Float>();		
	}
	
	// Metodo de clase
	public static AdminDeJugadores cargarJugadores(String ruta)
	throws FileNotFoundException, IOException, ClassNotFoundException {				
		return (AdminDeJugadores)cargarXML(ruta);	
	}
	
	public void guardarJugadoresYPuntajes(String ruta)
	throws FileNotFoundException, IOException {
		guardarXML(this, ruta);
	}
	
	public void addJugadorYPuntaje(Jugador jugador, float puntaje) {
		float puntajeMax;
		
		if(mPuntajeMaxPorJugador.containsKey(jugador) == true) {
			puntajeMax = this.mPuntajeMaxPorJugador.get(jugador);
			if(puntajeMax < puntaje) {
				puntajeMax = puntaje;
			}			
		}
		else {
			puntajeMax = puntaje;
		}		
		this.mPuntajeMaxPorJugador.put(jugador, puntajeMax);
	}

	public ArrayList<Jugador> getListaDeJugadores() {
		Set<Jugador> setJugadores = mPuntajeMaxPorJugador.keySet();
		Iterator<Jugador> it = setJugadores.iterator();
		ArrayList<Jugador> lista = new ArrayList<Jugador>(setJugadores.size());		
		while(it.hasNext()) {
			lista.add(it.next());
		}		
		return lista;
	}
	/*
	// TODO Remover stub!	
	private void addJugadoresYPuntajesStub() {
		if(yaEntre == true) {
			return;
		}
		yaEntre = true;
		
		Jugador jugador = new Jugador("Pepe", new Vehiculo(null, new Auto()));
		this.addPuntaje(jugador, 20);
		this.addPuntaje(jugador, 10);
				
		jugador = new Jugador("Agustin", new Vehiculo(null, new Moto()));
		this.addPuntaje(jugador, 1);
		this.addPuntaje(jugador, 5);
	}*/
	
	public Set<Entry<Jugador, Float>> getRankingComoSet() {
		// TODO Remover stub!	
		//addJugadoresYPuntajesStub();
		
		TreeSet<Entry<Jugador, Float>> setPuntajes = new TreeSet<Entry<Jugador, Float>>(new Compare());
				
		Iterator<Entry<Jugador, Float>> it = this.mPuntajeMaxPorJugador.entrySet().iterator();		
		while(it.hasNext()) {
			setPuntajes.add(it.next());			
		}
		
		// Keep the first MAX_RANKING positions
		it = setPuntajes.iterator();
		int i = 0;
		Entry<Jugador, Float> elem = null;
		while(i < MAX_RANKING && it.hasNext()) {
			i++;
			elem = it.next();
		}
				
		return setPuntajes.headSet(elem, true);			
	}

	
}
