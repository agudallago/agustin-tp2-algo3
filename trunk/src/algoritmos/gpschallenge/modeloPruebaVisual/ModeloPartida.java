package algoritmos.gpschallenge.modeloPruebaVisual;

import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.juego.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class ModeloPartida extends java.util.Observable {

	private int posX;
	private int posY;
	int incremento = 38;
	
	//Elementos del Juego
	private Jugador mJugador;
	private Mapa mMapa;
	private Partida mPartida;
	private Direccion norte, sur, oeste, este;
	private GeneradorDeMapas generadorMapas = new GeneradorDeMapas();
	String imagenMapa;
	String imagenVehiculo;
	
	public ModeloPartida() {
		
	//Inicializo las direcciones para pasarle a vehículo
		norte = new Norte();
		sur   = new Sur();
		oeste = new Oeste();
		este  = new Este();

		//setPosX(100);
		//setPosY(100);
		ActualizarObservadores();	
	}
	
	//----------------------------------------------------------
	public void crearPartida (String nombre, String vehiculo, String dificultad) {
		//Crea la partida y asigna las imagenes a las variables. Esto idealmente se podría leer de un archivo.
		
		if (dificultad.equalsIgnoreCase("Facil")) {
			crearMapaFacil();
			imagenMapa = "images/mapafacil.png";
		}
		if (dificultad.equalsIgnoreCase("Moderado")) {
			crearMapaModerado();
			imagenMapa = "images/mapamoderado.png";
		}
		if (dificultad.equalsIgnoreCase("Dificil")) {
			crearMapaDificil();
			imagenMapa = "images/mapadificil.png";
		}
		
		if (vehiculo.equalsIgnoreCase("Auto")) {
			//crearJugador(nombre, new Vehiculo(mMapa.getEsquinaInicial(), new Auto()));
			imagenVehiculo = "images/auto.png";
		}
		if (vehiculo.equalsIgnoreCase("Moto")) {
			//crearJugador(nombre, new Vehiculo(mMapa.getEsquinaInicial(), new Moto()));
			imagenVehiculo = "images/moto.png";
		}
		if (vehiculo.equalsIgnoreCase("4x4"))  {
			//crearJugador(nombre, new Vehiculo(mMapa.getEsquinaInicial(), new CuatroPorCuatro()));
			imagenVehiculo = "images/4x4.png";
		}
		
		mPartida = new Partida (mJugador, mMapa);
	}
	
	public String getImagenMapa() {
		return imagenMapa;
	}
	
	public String getImagenVehiculo() {
		return imagenVehiculo;
	}
	
	//---------------------------------------------------------------
	// Creación de mapas
	private void crearMapaFacil ( ) {
		//this.mMapa = generadorMapas.generarMapaFacil();
	}
	
	private void crearMapaModerado () {
		//this.mMapa = generadorMapas.generarMapaModerado();
	}
	
	private void crearMapaDificil () {
		//this.mMapa = generadorMapas.generarMapaDificil();
	}
	//----------------------------------------------------------
	// Creación de Jugador
	
	private void crearJugador (String nombre, Vehiculo vehiculo) {
		this.mJugador = new Jugador(nombre, vehiculo);
	}
	
	//----------------------------------------------------------
	
	public void moverNorte() {
		//mJugador.moverVehiculoA(norte);
		setPosY(getPosY() - incremento);
		ActualizarObservadores();
	}
	
	public void moverSur() {
		//mJugador.moverVehiculoA(sur);
		setPosY(getPosY() + incremento);
		ActualizarObservadores();
	}
	
	public void moverEste() {
		//mJugador.moverVehiculoA(este);
		setPosX(getPosX() + incremento);
		ActualizarObservadores();
	}
	
	public void moverOeste() {
		//mJugador.moverVehiculoA(oeste);
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
