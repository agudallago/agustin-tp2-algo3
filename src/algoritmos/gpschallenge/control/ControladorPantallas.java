package algoritmos.gpschallenge.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algoritmos.gpschallenge.modeloPruebaVisual.ModeloPantallas;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ControladorPantallas {
	
	private static ControladorPantallas instance = null;
	private ModeloPantallas modelo;
	 
	
	protected ControladorPantallas () {
		//Contructor protegido
	}
	
	public static ControladorPantallas getInstance () {
		if(instance == null) {
	         instance = new ControladorPantallas();
	      }
	      return instance;
	   }
	
	public void setModelo (ModeloPantallas modelo) {
		this.modelo = modelo;
	}
	
	/* public ControladorPantallas(ModeloPantallas modelo){
		this.modelo = modelo;
	}
	*/
	
	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorExistente(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnJugadorExistente();
	}
	
	private class EscuchaBtnJugadorExistente implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			modelo.abrirPantallaJugadorExistente();
		}
	}

	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorNuevo(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnJugadorNuevo();
	}
	
	private class EscuchaBtnJugadorNuevo implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modelo.abrirPantallaJugadorNuevo();
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public ActionListener getListenerBtnVolver(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnVolver();
	}
	
	private class EscuchaBtnVolver implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modelo.abrirPantallaBienvenida();
		}
	}

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnVolverAOpciones(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnVolverAOpciones();
	}
	
	private class EscuchaBtnVolverAOpciones implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modelo.abrirPantallaOpciones();
		}
	}

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnNuevaPartida(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnNuevaPartida();
	}

	private class EscuchaBtnNuevaPartida implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modelo.abrirPantallaNuevaPartida();
		}
	}
	

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnPuntajes(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnPuntajes();
	}
	
	private class EscuchaBtnPuntajes implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modelo.abrirPantallaPuntajes();
		}
	}

//--------------------------------------------------------------------------------------------
		
	public ActionListener getListenerBtnGuardar(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnGuardar();
	}
	
	private class EscuchaBtnGuardar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			//TODO guardar datos del jugador
			modelo.abrirPantallaOpciones();		
			}
	}
	
//--------------------------------------------------------------------------------------------

	public ActionListener getListenerBtnJugar(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnJugar();
	}
	
	private class EscuchaBtnJugar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			//TODO revisar
			modelo.abrirVistaMapa();
			
			//ModeloJuego modelo =  new ModeloJuego();
			//ControladorVistaMapa controlador = new ControladorVistaMapa(modelo);
			//windowMapa = new VistaMapa(modelo, controlador, jugador, "images/fondo.jpg");
			
		}
	}
	
//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnCerrar(PantallaGPSChallenge pantalla) {
		return new EscuchaBtnCerrar();
	}
	
	private class EscuchaBtnCerrar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			//Para esta versión vuelve a la pantalla opciones
			modelo.abrirPantallaOpciones();
		}
	}
}
	