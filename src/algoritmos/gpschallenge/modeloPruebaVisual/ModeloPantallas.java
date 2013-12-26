package algoritmos.gpschallenge.modeloPruebaVisual;

//import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ModeloPantallas {

	private PantallaGPSChallenge ventanaActiva;
	String nombreJugador;  //se utiliza como referencia rápida para las pantallas donde se muestra el nombre.
	
	public ModeloPantallas(){
		ventanaActiva = PantallaBienvenida.getInstance();	
	}

	public void setNombreJugador(String nombre) {
		this.nombreJugador = nombre;
	}
	
	public String getNombreJugador() {
		return this.nombreJugador;
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
		ventanaActiva.setFieldNombre(nombreJugador);
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaNuevaPartida() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaNuevaPartida.getInstance();
		ventanaActiva.setFieldNombre(nombreJugador);
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaPuntajes() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaPuntajes.getInstance();
		ventanaActiva.setFieldNombre(nombreJugador);
		ventanaActiva.setVisible(true);
	}

	public void abrirVistaMapa() {
		ventanaActiva.dispose();
		ventanaActiva = VistaMapa.getInstance();
		ventanaActiva.setFieldNombre(nombreJugador);
		ventanaActiva.setVisible(true);
	}
		
	public void setVentanaActiva(PantallaGPSChallenge pantalla){
		ventanaActiva = pantalla;
		
	}

	public void abrirPantallaGanador() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaGanador.getInstance();
		ventanaActiva.setFieldNombre(nombreJugador);
		ventanaActiva.setVisible(true);
	}

	public void abrirPantallaPerdedor() {
		ventanaActiva.dispose();
		ventanaActiva = PantallaPerdedor.getInstance();
		ventanaActiva.setFieldNombre(nombreJugador);
		ventanaActiva.setVisible(true);
	}
	

	
}
