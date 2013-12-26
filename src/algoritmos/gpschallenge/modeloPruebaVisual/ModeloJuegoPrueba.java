package algoritmos.gpschallenge.modeloPruebaVisual;

import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class ModeloJuegoPrueba extends java.util.Observable {

	private int posX;
	private int posY;
	int incremento = 38;
	
	//Elementos del Juego
	private Jugador mJugador;
	private Mapa mMapa;
	private Partida mPartida;
	private Direccion norte, sur, oeste, este;
	private GeneradorDeMapas generadorMapas = new GeneradorDeMapas();
		
	public ModeloJuegoPrueba() {
		
	//Inicializo las direcciones para pasarle a vehículo
		norte = new Norte();
		sur   = new Sur();
		oeste = new Oeste();
		este  = new Este();
	
		//setPosX(100);
		//setPosY(100);
	}
	
	//----------------------------------------------------------
	public void crearPartida (String nombre, String vehiculo, String dificultad) {
		if (dificultad.equalsIgnoreCase("Facil")) crearMapaFacil();
		if (dificultad.equalsIgnoreCase("Moderado")) crearMapaModerado();
		if (dificultad.equalsIgnoreCase("Dificil")) crearMapaDificil();
		
		if (vehiculo.equalsIgnoreCase("Auto")) crearJugador(nombre, new Vehiculo(mMapa.getEsquinaInicial(), new Auto()));
		if (vehiculo.equalsIgnoreCase("Moto")) crearJugador(nombre, new Vehiculo(mMapa.getEsquinaInicial(), new Moto()));
		if (vehiculo.equalsIgnoreCase("4x4"))  crearJugador(nombre, new Vehiculo(mMapa.getEsquinaInicial(), new CuatroPorCuatro()));
		
		mPartida = new Partida (mJugador, mMapa);
	}
	
	//---------------------------------------------------------------
	// Creación de mapas
	public void crearMapaFacil ( ) {
		this.mMapa = generadorMapas.generarMapaFacil();
	}
	
	public void crearMapaModerado () {
		this.mMapa = generadorMapas.generarMapaModerado();
	}
	
	public void crearMapaDificil () {
		this.mMapa = generadorMapas.generarMapaDificil();
	}
	//----------------------------------------------------------
	// Creación de Jugador
	
	public void crearJugador (String nombre, Vehiculo vehiculo) {
		this.mJugador = new Jugador(nombre, vehiculo);
	}
	
	//----------------------------------------------------------
	
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

	
	public void ActualizarObservadores() {
		setChanged();
		notifyObservers();		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
