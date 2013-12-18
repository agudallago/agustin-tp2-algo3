package algoritmos.gpschallenge.modelo.admin;

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
