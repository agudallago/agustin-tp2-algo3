package algoritmos.gpschallenge.modelo.juego;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;

import algoritmos.gpschallenge.modelo.admin.AdminDeJugadores;
import algoritmos.gpschallenge.modelo.admin.AdminDePartida;
import algoritmos.gpschallenge.modelo.direccion.*;
import algoritmos.gpschallenge.modelo.vehiculo.*;

public class ModeloJuego extends java.util.Observable {
            
    private static final int CANT_MOV_MAXIMOS = 50; //Definimos arbirtrariamente un n�mero m�ximo de movimientos
    
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
		
		//Inicializo las direcciones para pasarle a veh�culo
        norte = new Norte();
        sur   = new Sur();
        oeste = new Oeste();
        este  = new Este();
        ActualizarObservadores();
	}	

    //La posici�n X e Y del modelo es la que posee su miembro veh�culo
    public int getPosX () {
    	return mVehiculo.getPosX();
    }
    public int getPosY () {
    	return mVehiculo.getPosY();
    }
    
    //----------------------------------------------------------
    public void crearPartida (String nombre, String vehiculo, String dificultad) {
        //Crea la partida y asigna las imagenes a las variables. Esto idealmente se podr�a leer de un archivo.
        
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
    // Creaci�n de mapas
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
    // Creaci�n de Jugador
    
    private void crearJugador (String nombre, Vehiculo vehiculo) {
        this.mJugador = new Jugador(nombre, vehiculo);
    }
    
    //----------------------------------------------------------
    
    public void moverNorte() {
        mJugador.moverVehiculoA(norte);
        ActualizarObservadores();
    }
    
    public void moverSur() {
        mJugador.moverVehiculoA(sur);
        ActualizarObservadores();
    }
    
    public void moverEste() {
        mJugador.moverVehiculoA(este);
        ActualizarObservadores();
    }
    
    public void moverOeste() {
        mJugador.moverVehiculoA(oeste);
        ActualizarObservadores();       
    }

    
    public void ActualizarObservadores() {
        setChanged();
        notifyObservers();              
    }

	public float getPuntaje() {
		return mJugador.getPuntaje();
	}

	public int getMovimientos() {
		return mVehiculo.getMovimientos();
	}
	
	public boolean juegoTerminado(){
		return mJugador.juegoTerminado();
	}
	
	//////////////////Comunicacion con AdminJugadores ///////////////////
		
	public void guardarJugadoresYPuntajes() throws FileNotFoundException, IOException {
		mAdminDeJugadores.guardarJugadoresYPuntajes(RUTA_JUGADORES_XML);
	}
	
	public void addJugadorYPuntaje(){ //Jugador jugador, float puntaje) {
		this.mAdminDeJugadores.addJugadorYPuntaje(mJugador, this.getPuntaje());
	}
	
	public ArrayList<Jugador> getListaDeJugadores() {
		return this.mAdminDeJugadores.getListaDeJugadores();
	}
	
	public Set<Entry<Jugador, Float>> getRankingComoSet() {
		return this.mAdminDeJugadores.getRankingComoSet();			
	}
	
	////////////// Comunicacion con AdminPartida ///////////////////
	
	public void cargarPartida() //Partida cargarPartida()
	throws FileNotFoundException, IOException, ClassNotFoundException {		
		//return this.mAdminDePartida.cargarPartida(RUTA_PARTIDA_XML);
		this.mPartida = this.mAdminDePartida.cargarPartida(RUTA_PARTIDA_XML);
		mJugador = mPartida.getJugador();
		mMapa = mPartida.getMapa();
		//mVehiculo = mJugador.getVehiculo();  //Este m�todo no existe. Har�a falta para conectarlo con la vista Mapa
	}
	
	public void guardarPartida() //Partida partida)
	throws FileNotFoundException, IOException {
		this.mAdminDePartida.guardarPartida(this.mPartida, RUTA_PARTIDA_XML);
	}

	public void actualizar() {
		mJugador.actualizar();
	}

	public boolean movimientosMaximos() {
		if (mVehiculo.getMovimientos() > CANT_MOV_MAXIMOS) {
			return true;
		} else { 
			return false;
		}
	}

}