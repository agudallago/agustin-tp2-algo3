package algoritmos.gpschallenge.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import algoritmos.gpschallenge.modelo.juego.ModeloJuego;
import algoritmos.gpschallenge.modelo.vista.*;
import algoritmos.gpschallenge.vista.pantallas.PantallaNuevaPartida;

public class ControladorPantallas implements Observer {
	
	private static ControladorPantallas instance = null;
	private ModeloPantallas modeloPantalla;
	private ModeloJuego modeloJuego;	
	
	protected ControladorPantallas () {
		//Contructor protegido
		
		
	}

	//ControladorPantallas es una Clase con patron Singleton porque es �nica para el juego y debe ser 
	//accesible para todas las instancias de Pantallas
	
	public static ControladorPantallas getInstance () {
		if(instance == null) {
	         instance = new ControladorPantallas();
	      }
	      return instance;
	   }

	//M�todo para setear el modelo de Pantallas
	public void setModeloPantalla (ModeloPantallas modeloPantalla) {
		this.modeloPantalla = modeloPantalla;
	}
	
	//M�todo para setear el modelo de Juego
	public void setModeloJuego (ModeloJuego modelo) {
		this.modeloJuego = modelo;
		modeloJuego.addObserver(this);
	}
	
	
	//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnJugadorExistente() {
		return new EscuchaBtnJugadorExistente();
	}
	
	private class EscuchaBtnJugadorExistente implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			modeloPantalla.abrirPantallaJugadorExistente(modeloJuego);
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
			modeloPantalla.abrirPantallaPuntajes(modeloJuego);
		}
	}

//--------------------------------------------------------------------------------------------
		
	public ActionListener getListenerBtnGuardar(JTextField campoNombre) {
		return new EscuchaBtnGuardar(campoNombre);
	}
	
	private class EscuchaBtnGuardar implements ActionListener {
		private JTextField campo;
		
		public EscuchaBtnGuardar(JTextField campoNombre) {
			this.campo = campoNombre;
		}

		public void actionPerformed(ActionEvent e) {
			//TODO Pedir al modelo Juego que cree el jugador.
			modeloPantalla.setNombreJugador(campo.getText());
			modeloPantalla.abrirPantallaOpciones();		
			}
	}
	
//--------------------------------------------------------------------------------------------

	public ActionListener getListenerBtnJugar(PantallaNuevaPartida pantalla) {
		return new EscuchaBtnJugar(pantalla);
	}
	
	private class EscuchaBtnJugar implements ActionListener {	
		private PantallaNuevaPartida pantalla;
		
		public EscuchaBtnJugar(PantallaNuevaPartida pantalla) {
			this.pantalla = pantalla;
		}

		public void actionPerformed(ActionEvent e) {	
			//Solicita la selecci�n de los RadioButton a la pantalla. Se los devuelve como 2 string
			String dificultad = this.pantalla.seleccionDificultad();
			String vehiculo = this.pantalla.seleccionVehiculo();
			String nombre = modeloPantalla.getNombreJugador();
			modeloJuego.crearPartida(nombre, vehiculo, dificultad);
			modeloPantalla.abrirPantallaMapa(modeloJuego, new ControladorVistaMapa(modeloJuego), modeloJuego.getImagenMapa(), modeloJuego.getImagenVehiculo());
		}
	}
	
//--------------------------------------------------------------------------------------------
	public ActionListener getListenerBtnCerrar() {
		return new EscuchaBtnCerrar();
	}
	
	private class EscuchaBtnCerrar implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			//Para esta versi�n vuelve a la pantalla opciones
			modeloPantalla.abrirPantallaOpciones();
		}
	}
	
	//--------------------------------------------------------------------------------------------
		public ActionListener getListenerBtnGuardarPartida() {
			return new EscuchaBtnGuardarPartida();
		}
		
		private class EscuchaBtnGuardarPartida implements ActionListener {	
			public void actionPerformed(ActionEvent e) {
				//Para esta versi�n vuelve a la pantalla opciones
				try {
					modeloJuego.guardarPartida();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				modeloPantalla.guardarPartidaYVolverAOpciones();
			}
		}

	//--------------------------------------------------------------------------------------------
		public ActionListener getListenerBtnRecuperarPartida() {
			return new EscuchaBtnRecuperarPartida();
		}

		private class EscuchaBtnRecuperarPartida implements ActionListener {	
			public void actionPerformed(ActionEvent e) {
				//TODO: Revisar carga de Partida
				try {
					modeloJuego.cargarPartida();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//TODO: abrir Pantalla Mapa con partida cargada
				//Faltan m�s referencias: ImagenMapa, imagenVehiculo, etc., para poder recuperar la partida completa.
				//Hay que guardar la instanacia de ModeloJuego completa y no solo la de Partida.
				//modeloPantalla.abrirPantallaMapa(modeloJuego, new ControladorVistaMapa(modeloJuego), modeloJuego.getImagenMapa(), modeloJuego.getImagenVehiculo());	
			}
		}
		
		

	//--------------------------------------------------------------------------------------------	
		@Override
		public void update(Observable t, Object o) {
			modeloJuego.actualizar();
			
			if (modeloJuego.movimientosMaximos()) {
				modeloPantalla.abrirPantallaPerdedor(modeloJuego.getMovimientos());
			}
			
			if (modeloJuego.juegoTerminado()) {
				modeloPantalla.abrirPantallaGanador(modeloJuego.getPuntaje(), modeloJuego.getMovimientos());
				modeloJuego.addJugadorYPuntaje();
			}
			
		}	
	
}
	