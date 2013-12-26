package algoritmos.gpschallenge.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import algoritmos.gpschallenge.modeloPruebaVisual.*;
import algoritmos.gpschallenge.vista.pantallas.*;

public class ControladorPantallas {
	
	private static ControladorPantallas instance = null;
	private ModeloPantallas modeloPantalla;
	private ModeloJuegoPrueba modeloJuego;
	
	
	protected ControladorPantallas () {
		//Contructor protegido
	}
	

	//ControladorPantallas es una Clase con patron Singleton porque es única para el juego y debe ser 
	//accesible para todas las instancias de Pantallas
	
	public static ControladorPantallas getInstance () {
		if(instance == null) {
	         instance = new ControladorPantallas();
	      }
	      return instance;
	   }

	//Método para setear el modelo de Pantallas
	public void setModeloPantalla (ModeloPantallas modeloPantalla) {
		this.modeloPantalla = modeloPantalla;
	}
	
	//Método para setear el modelo de Juego
	public void setModeloJuego (ModeloJuegoPrueba modelo) {
		this.modeloJuego = modelo;
	}
	
	
	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorExistente() {
		return new EscuchaBtnJugadorExistente();
	}
	
	private class EscuchaBtnJugadorExistente implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaJugadorExistente();
		}
	}

	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorNuevo() {
		return new EscuchaBtnJugadorNuevo();
	}
	
	private class EscuchaBtnJugadorNuevo implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaJugadorNuevo();
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public ActionListener getListenerBtnVolver() {
		return new EscuchaBtnVolver();
	}
	
	private class EscuchaBtnVolver implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaBienvenida();
		}
	}

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnVolverAOpciones() {
		return new EscuchaBtnVolverAOpciones();
	}
	
	private class EscuchaBtnVolverAOpciones implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaOpciones();
		}
	}

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnNuevaPartida() {
		return new EscuchaBtnNuevaPartida();
	}

	private class EscuchaBtnNuevaPartida implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaNuevaPartida();
		}
	}
	

//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnPuntajes() {
		return new EscuchaBtnPuntajes();
	}
	
	private class EscuchaBtnPuntajes implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaPuntajes();
		}
	}

//--------------------------------------------------------------------------------------------
		
	public ActionListener getListenerBtnGuardar(JTextField campoNombre) {
		return new EscuchaBtnGuardar(campoNombre);
	}
	
	private class EscuchaBtnGuardar implements ActionListener {
		private JTextField campo;
		
		public EscuchaBtnGuardar(JTextField campoNombre) {
			// TODO Auto-generated constructor stub
			this.campo = campoNombre;
		}

		public void actionPerformed(ActionEvent e) {
			//TODO Pedir al modelo Juego que cree el jugador.
			modeloPantalla.setNombreJugador(campo.getText());
			modeloPantalla.abrirPantallaOpciones();		
			}
	}
	
//--------------------------------------------------------------------------------------------

	public ActionListener getListenerBtnJugar() {
		return new EscuchaBtnJugar();
	}
	
	private class EscuchaBtnJugar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {	
			//TODO revisar. Ver si creo jugador o cargó jugador existente.
			//modeloJuego.crearJugador();
			modeloPantalla.abrirVistaMapa();
			
			//ModeloJuego modelo =  new ModeloJuego();
			//ControladorVistaMapa controlador = new ControladorVistaMapa(modelo);
			//windowMapa = new VistaMapa(modelo, controlador, jugador, "images/fondo.jpg");
			
		}
	}
	
//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnCerrar() {
		return new EscuchaBtnCerrar();
	}
	
	private class EscuchaBtnCerrar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			//Para esta versión vuelve a la pantalla opciones
			modeloPantalla.abrirPantallaOpciones();
		}
	}
	

}
	