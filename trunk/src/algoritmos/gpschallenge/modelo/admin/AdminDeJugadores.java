package algoritmos.gpschallenge.modelo.admin;

import java.io.*;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import algoritmos.gpschallenge.modelo.juego.Jugador;

public class AdminDeJugadores {
	
	//////////////////////Atributos ////////////////////////////
	private HashMap<Jugador, List<Float>> mPuntajesPorJugador;
	static final int MAX_PUNTAJES_POR_JUGADOR = 10;
	static final int MAX_JUGADORES_FRECUENTES = 10;
	
	////////////////// Metodos Publicos /////////////////////////
		
	public AdminDeJugadores() {
		this.mPuntajesPorJugador = new HashMap<Jugador, List<Float>>();		
	}
	
	public void guardarJugadores(String ruta) throws FileNotFoundException, IOException {
		XStream xStream = new XStream();
		
		OutputStream outFile = new FileOutputStream(ruta);
		ObjectOutputStream outStream = xStream.createObjectOutputStream(outFile);

		outStream.writeObject(this);
		
		outStream.close();
		outFile.close();
	}
	
	public static AdminDeJugadores cargarJugadores(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException {
		XStream xStream = new XStream();
		
		InputStream inFile = new FileInputStream(ruta);
		ObjectInputStream inStream = xStream.createObjectInputStream(inFile);

		AdminDeJugadores admin = (AdminDeJugadores)inStream.readObject();
		
		inFile.close();
		inStream.close();
		
		return admin;
	}
	
	public void addPuntaje(Jugador jugador, float puntaje) {
		List<Float> lista;
		
		if(mPuntajesPorJugador.containsKey(jugador) == true) {
			lista = this.mPuntajesPorJugador.get(jugador);
		}
		else {
			lista = new ArrayList<Float>();
		}
		lista.add(puntaje);
		this.mPuntajesPorJugador.put(jugador, lista);
	}
	
	
	/*
	
	public List<Jugador> getListaDeJugadoresFrecuentes() {
	//TODO FILL THIS
	}
	
	public List<Float> getPuntajesDeJugador(Jugador jugador) {
	//TODO FILL THIS
	}
	
	public Map<Jugador, List<Float>> getTopTenComoMapa() {
		//TODO FILL THIS
	}

	*/
}
