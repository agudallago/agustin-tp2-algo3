package algoritmos.gpschallenge.modelo.juego;

import java.io.FileNotFoundException;
import java.io.IOException;

import algoritmos.gpschallenge.modelo.admin.*;
import java.io.*;

public class ModeloJuego extends java.util.Observable {

	private AdminDeJugadores mAdminDeJugadores;
	private final String RUTA_JUGADORES_XML = "./data/players.xml";
	
	private int posX;
	private int posY;
	int incremento = 38;

	// TODO hacer hookup con juego real
	
	public ModeloJuego() throws FileNotFoundException, IOException, ClassNotFoundException {
		mAdminDeJugadores = AdminDeJugadores.cargarJugadores(RUTA_JUGADORES_XML);
		//setPosX(100);
		//setPosY(100);
	}	
	
	////////////////// Persistencia ///////////////////
	
	public void guardarJugadores() throws FileNotFoundException, IOException {
		mAdminDeJugadores.guardarJugadores(RUTA_JUGADORES_XML);
	}	
	
	///////////////// Dinamica de juego ////////////////
	
	public void moverNorte() {
		setPosY(getPosY() - incremento);
		ActualizarObservadores();
	}
	
	public void moverSur() {
		setPosY(getPosY() + incremento);
		ActualizarObservadores();
	}
	
	public void moverEste() {
		setPosX(getPosX() + incremento);
		ActualizarObservadores();
	}
	
	public void moverOeste() {
		setPosX(getPosX() - incremento);
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
