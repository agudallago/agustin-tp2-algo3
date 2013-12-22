package algoritmos.gpschallenge.modeloPruebaVisual;

//import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ModeloPantallas {

	private PantallaGPSChallenge ventanaActiva;

	public ModeloPantallas(){
		ventanaActiva = PantallaBienvenida.getInstance();	
	}

	public void abrirPantallaJugadorExistente() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaJugadorExistente.getInstance();
		ventanaActiva.setVisible(true);
		}

	public void abrirPantallaJugadorNuevo() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaJugadorNuevo.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaBienvenida() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaBienvenida.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaOpciones() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaOpciones.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaNuevaPartida() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaNuevaPartida.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaPuntajes() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaPuntajes.getInstance();
		ventanaActiva.setVisible(true);
	}

	public void abrirVistaMapa() {
		ventanaActiva.dispose();
		ventanaActiva = VistaMapa.getInstance();
		ventanaActiva.setVisible(true);
	}
		
	public void setVentanaActiva(PantallaGPSChallenge pantalla){
	
		ventanaActiva = pantalla;
		
	}


	
}
