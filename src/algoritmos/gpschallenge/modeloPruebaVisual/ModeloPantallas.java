package algoritmos.gpschallenge.modeloPruebaVisual;

//import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ModeloPantallas {

	//private ControladorPantallas control;
/*
	private PantallaBienvenida wBienvenida;
	private PantallaGanador wGanador;
	private PantallaJugadorExistente wJugadorExistente;
	private PantallaJugadorNuevo wJugadorNuevo;
	private PantallaNuevaPartida wNuevaPartida;
	private PantallaOpciones wOpciones;
	private PantallaPerdedor wPerdedor;
	private PantallaPuntajes wPuntajes;
	private VistaMapa wVistaMapa;
*/
	private PantallaGPSChallenge ventanaActiva;
	
	
	public ModeloPantallas(){
/*		wBienvenida = null;
		wGanador = null;
		wJugadorExistente = null;
		wJugadorNuevo = null;
		wNuevaPartida = null;
		wOpciones = null;
		wPerdedor = null;
		wPuntajes = null;
		wVistaMapa = null; */
		ventanaActiva = PantallaBienvenida.getInstance();	
	}

	public void abrirPantallaJugadorExistente() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		//ventanaActiva.setVisible(false);
		ventanaActiva = PantallaJugadorExistente.getInstance();
		ventanaActiva.setVisible(true);
		}

	public void abrirPantallaJugadorNuevo() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		//ventanaActiva.setVisible(false);
		//ventanaActiva = null;
		ventanaActiva = PantallaJugadorNuevo.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaBienvenida() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		ventanaActiva = PantallaBienvenida.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaOpciones() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		ventanaActiva = PantallaOpciones.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaNuevaPartida() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		ventanaActiva = PantallaNuevaPartida.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaPuntajes() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		ventanaActiva = PantallaPuntajes.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirVistaMapa() {
		// TODO Auto-generated method stub
		ventanaActiva.dispose();
		ventanaActiva = VistaMapa.getInstance();
		ventanaActiva.setVisible(true);
	}
		
	public void setVentanaActiva(PantallaGPSChallenge pantalla){
	
		ventanaActiva = pantalla;
		
	}


	
}
