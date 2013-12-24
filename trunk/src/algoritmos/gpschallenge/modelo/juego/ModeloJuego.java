package algoritmos.gpschallenge.modelo.juego;

import java.io.FileNotFoundException;
import java.io.IOException;

import algoritmos.gpschallenge.modelo.admin.*;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class ModeloJuego extends java.util.Observable {

	private AdminDeJugadores mAdminDeJugadores;
	private AdminDePartida mAdminDePartida;
	private final String RUTA_JUGADORES_XML = "players.xml";
	private final String RUTA_PARTIDA_XML = "savegame.xml";
	private final int INCREMENTO = 38;
	
	private int posX;
	private int posY;

	// TODO hacer hookup con juego real
	
	public ModeloJuego() throws FileNotFoundException, IOException, ClassNotFoundException {
		mAdminDeJugadores = AdminDeJugadores.cargarJugadores(RUTA_JUGADORES_XML);
		mAdminDePartida = new AdminDePartida();
	}	
	
	////////////////// Comunicacion con AdminJugadores ///////////////////
	
	public void guardarJugadoresYPuntajes() throws FileNotFoundException, IOException {
		mAdminDeJugadores.guardarJugadoresYPuntajes(RUTA_JUGADORES_XML);
	}
	
	public void addJugadorYPuntaje(Jugador jugador, float puntaje) {
		this.mAdminDeJugadores.addJugadorYPuntaje(jugador, puntaje);
	}
	
	public List<Jugador> getListaDeJugadores() {
		return this.mAdminDeJugadores.getListaDeJugadores();
	}
	
	public Set<Entry<Jugador, Float>> getRankingComoSet() {
		return this.mAdminDeJugadores.getRankingComoSet();			
	}
	
	////////////// Comunicacion con AdminPartida ///////////////////
	
	public Partida cargarPartida()
	throws FileNotFoundException, IOException, ClassNotFoundException {		
		return this.mAdminDePartida.cargarPartida(RUTA_PARTIDA_XML);		
	}
		
	public void guardarPartida(Partida partida)
	throws FileNotFoundException, IOException {
		this.mAdminDePartida.guardarPartida(partida, RUTA_PARTIDA_XML);
	}
	
	///////////////// Dinamica de juego ////////////////
	
	public void moverNorte() {
		setPosY(getPosY() - INCREMENTO);
		ActualizarObservadores();
	}
	
	public void moverSur() {
		setPosY(getPosY() + INCREMENTO);
		ActualizarObservadores();
	}
	
	public void moverEste() {
		setPosX(getPosX() + INCREMENTO);
		ActualizarObservadores();
	}
	
	public void moverOeste() {
		setPosX(getPosX() - INCREMENTO);
		ActualizarObservadores();	
	}

	private int getPosX() {
		return posX;
	}

	private void setPosX(int posX) {
		this.posX = posX;
	}

	private int getPosY() {
		return posY;
	}

	private void setPosY(int posY) {
		this.posY = posY;
	}
		
	/////////////// Notificacion de observadores /////////
	
	public void ActualizarObservadores() {
		setChanged();
		notifyObservers();		
	}

}
