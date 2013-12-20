package algoritmos.gpschallenge.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algoritmos.gpschallenge.modelo.juego.Jugador;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloJuego;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ControladorPantallas {
	
	private ModeloJuego modelo;
	private ControladorPantallas control = this;
	private PantallaBienvenida wBienvenida;
	private PantallaGanador wGanador;
	private PantallaJugadorExistente wJugadorExistente;
	private PantallaJugadorNuevo wJugadorNuevo;
	private PantallaNuevaPartida wNuevaPartida;
	private PantallaOpciones wOpciones;
	private PantallaPerdedor wPerdedor;
	private PantallaPuntajes wPuntajes;
	private VistaMapa wVistaMapa;
	
	
	/* Método Main de prueba */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Jugador unJugador = new Jugador();
		ControladorPantallas controlador = new ControladorPantallas();
		controlador.wBienvenida.setVisible(true);
	}

	/**/
	
	public ControladorPantallas(){
		wBienvenida = new PantallaBienvenida(this);
		wGanador = null;
		wJugadorExistente = null;
		wJugadorNuevo = null;
		wNuevaPartida = null;
		wOpciones = null;
		wPerdedor = null;
		wPuntajes = null;
		wVistaMapa = null;
	}
	
	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorExistente(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnJugadorExistente();
	}
	
	private class EscuchaBtnJugadorExistente implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			if (wJugadorExistente == null) {
				wJugadorExistente = new PantallaJugadorExistente(control);	
				}
			wJugadorExistente.setVisible(true);
		}
	}

	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorNuevo(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnJugadorNuevo();
	}
	
	private class EscuchaBtnJugadorNuevo implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			if (wJugadorNuevo == null) {
				wJugadorNuevo = new PantallaJugadorNuevo(control);
			}
			wJugadorNuevo.setVisible(true);
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public ActionListener getListenerBtnVolver(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnVolver();
	}
	
	private class EscuchaBtnVolver implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			if (wBienvenida == null) {
				wBienvenida = new PantallaBienvenida(control);
			}
			wBienvenida.setVisible(true);
		}
	}

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnVolverAOpciones(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnVolverAOpciones();
	}
	
	private class EscuchaBtnVolverAOpciones implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			if (wOpciones == null) {
				wOpciones = new PantallaOpciones(control);
			}
			wOpciones.setVisible(true);
		}
	}

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnNuevaPartida(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnNuevaPartida();
	}

	private class EscuchaBtnNuevaPartida implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			if (wNuevaPartida == null) {
				wNuevaPartida = new PantallaNuevaPartida(control);
			}
			wNuevaPartida.setVisible(true);
		}
	}
	

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnPuntajes(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnPuntajes();
	}
	
	private class EscuchaBtnPuntajes implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			if (wPuntajes == null) {
				wPuntajes = new PantallaPuntajes(control);
			}
			wPuntajes.setVisible(true);
		}
	}

//--------------------------------------------------------------------------------------------
		
	public ActionListener getListenerBtnGuardar(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnGuardar();
	}
	
	private class EscuchaBtnGuardar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			//TODO guardar datos del jugador
			if (wOpciones == null) {
				wOpciones = new PantallaOpciones(control);
			}
			wOpciones.setVisible(true);
		}
	}
	
//--------------------------------------------------------------------------------------------

	public ActionListener getListenerBtnJugar(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnJugar();
	}
	
	private class EscuchaBtnJugar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			//TODO revisar
			ModeloJuego modelo =  new ModeloJuego();
			ControladorVistaMapa controlador = new ControladorVistaMapa(modelo);
			//windowMapa = new VistaMapa(modelo, controlador, jugador, "images/fondo.jpg");
		}
	}
	
//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnCerrar(PantallaGPSChallenge pantalla) {
		pantalla.setVisible(false);
		return new EscuchaBtnCerrar();
	}
	
	private class EscuchaBtnCerrar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
		}
	}
}
	