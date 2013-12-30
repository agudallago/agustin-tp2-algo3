package algoritmos.gpschallenge.modelo.juego;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import algoritmos.gpschallenge.modelo.admin.AdminDeJugadores;
import algoritmos.gpschallenge.modelo.admin.AdminDePartida;
import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class ModeloJuego extends java.util.Observable {

    private int mPosX, mPosY;
    private int mPosXModelo, mPosYModelo;
    
    private final int POS_INICIAL_X = 0;
    private final int POS_INICIAL_Y = 0;
    private final int INCREMENTO = 38;
    
    // Administradores de juego
    private AdminDeJugadores mAdminDeJugadores;   
    private AdminDePartida mAdminDePartida;
	private final String RUTA_JUGADORES_XML = "players.xml";
	private final String RUTA_PARTIDA_XML = "savegame.xml";
	    
    //Elementos del Juego
    private Jugador mJugador;
    private Vehiculo mVehiculo;
    private Mapa mMapa;
    private Partida mPartida;
    private Direccion norte, sur, oeste, este;
    private GeneradorDeMapas generadorMapas = new GeneradorDeMapas();
    String imagenMapa;
    String imagenVehiculo;
    String imagenVehiculoGrande;
    
    public ModeloJuego() throws FileNotFoundException, IOException, ClassNotFoundException {
		mAdminDeJugadores = AdminDeJugadores.cargarJugadores(RUTA_JUGADORES_XML);
		mAdminDePartida = new AdminDePartida();
		
		//Inicializo las direcciones para pasarle a vehículo
        norte = new Norte();
        sur   = new Sur();
        oeste = new Oeste();
        este  = new Este();

        setPosX(POS_INICIAL_X);
        setPosY(POS_INICIAL_Y);
        ActualizarObservadores();
	}	

    //TODO: refactorizar Métodos de Prueba
    
    public int getPosXModelo () {
    	return mPosXModelo;
    }
    public int getPosYModelo () {
    	return mPosYModelo;
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
        		mVehiculo = new Vehiculo(mMapa.getEsquinaInicialMapa(), new Auto());
                crearJugador(nombre, mVehiculo);
                imagenVehiculo = "images/auto.png";
                imagenVehiculoGrande = "images/auto_grande.png";;
        }
        if (vehiculo.equalsIgnoreCase("Moto")) {
        		mVehiculo = new Vehiculo(mMapa.getEsquinaInicialMapa(), new Moto());
                crearJugador(nombre, mVehiculo);
                imagenVehiculo = "images/moto.png";
                imagenVehiculoGrande = "images/moto_grande.png";;
        }
        if (vehiculo.equalsIgnoreCase("4x4"))  {
        		mVehiculo = new Vehiculo(mMapa.getEsquinaInicialMapa(), new CuatroPorCuatro());
                crearJugador(nombre, mVehiculo);
                imagenVehiculo = "images/4x4.png";
                imagenVehiculoGrande = "images/4x4_grande.png";;
        }
        
        mPartida = new Partida (mJugador, mMapa);
    }
    
    public String getImagenMapa() {
        return imagenMapa;
    }
    
    public String getImagenVehiculo() {
        return imagenVehiculo;
    }

    public String getImagenVehiculoGrande() {
        return imagenVehiculoGrande;
    }

    //---------------------------------------------------------------
    // Creación de mapas
    private void crearMapaFacil ( ) {
        this.mMapa = generadorMapas.generarMapaFacil();
    }
    
    private void crearMapaModerado () {
        this.mMapa = generadorMapas.generarMapaModerado();
    }
    
    private void crearMapaDificil () {
        this.mMapa = generadorMapas.generarMapaDificil();
    }
    //----------------------------------------------------------
    // Creación de Jugador
    
    private void crearJugador (String nombre, Vehiculo vehiculo) {
        this.mJugador = new Jugador(nombre, vehiculo);
    }
    
    //----------------------------------------------------------
    
    public void moverNorte() {
        mJugador.moverVehiculoA(norte);
        
        setPosY(getPosY() - INCREMENTO);
        this.mPosXModelo = mVehiculo.getPosX();
    	this.mPosYModelo = mVehiculo.getPosY();
        ActualizarObservadores();
    }
    
    public void moverSur() {
        mJugador.moverVehiculoA(sur);
        setPosY(getPosY() + INCREMENTO);
        this.mPosXModelo = mVehiculo.getPosX();
    	this.mPosYModelo = mVehiculo.getPosY();
        ActualizarObservadores();
    }
    
    public void moverEste() {
        mJugador.moverVehiculoA(este);
        setPosX(getPosX() + INCREMENTO);
        this.mPosXModelo = mVehiculo.getPosX();
    	this.mPosYModelo = mVehiculo.getPosY();
        ActualizarObservadores();
    }
    
    public void moverOeste() {
        mJugador.moverVehiculoA(oeste);
        setPosX(getPosX() - INCREMENTO);
        this.mPosXModelo = mVehiculo.getPosX();
    	this.mPosYModelo = mVehiculo.getPosY();
        ActualizarObservadores();       
    }

    
    public void ActualizarObservadores() {
        setChanged();
        notifyObservers();              
    }

    public int getPosX() {
        return mPosX;
    }

    public void setPosX(int posX) {
        this.mPosX = posX;
    }

    public int getPosY() {
        return mPosY;
    }
    

    public void setPosY(int posY) {
        this.mPosY = posY;
    }

	public int getMovimientos() {
		return mVehiculo.getMovimientos();
	}
	
	//////////////////Comunicacion con AdminJugadores ///////////////////
		
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

}