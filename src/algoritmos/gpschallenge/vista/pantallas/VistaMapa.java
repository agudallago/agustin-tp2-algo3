package algoritmos.gpschallenge.vista.pantallas;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JFrame;

import algoritmos.gpschallenge.control.*;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloJuegoPrueba;
import algoritmos.gpschallenge.modelo.vehiculo.Auto;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

import javax.swing.JButton;


public class VistaMapa extends PantallaGPSChallenge implements Observer{
		
		private PanelImagen panelMapa; //Panel que contiene la imagen del mapa
		private TextField textoMapa = new TextField(); //texto que mostrara el Nivel 
		private JButton botonNorte = new JButton();  //boton para ir al Norte
		private JButton botonSur = new JButton("Sur", null);  //boton para ir al Sur
		private JButton botonEste = new JButton("Este", null);  //boton para ir al Este
		private JButton botonOeste = new JButton("Oeste", null);  //boton para ir al Oeste
		private PanelImagen panelAuto = new PanelImagen("images/auto.png");
		private ControladorVistaMapa controlJuego = new ControladorVistaMapa();
		private String imagenMapaNivel = "images/fondo.png";
		
		//Clase auxiliar para escuchar el evento de cerrado de la ventana
		public static class CloseListener extends WindowAdapter	{
			
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		} //Fin de CloseListener

		//Constructor de la vista
			public VistaMapa() {
				super();
				initialize();
				addListeners();						
				}


		//Método para agregar los listeners de los botones del Frame
		private void addListeners() {

			//Agregamos el listener de los botones "Norte", "Sur", "Este" y "Oeste"
			//Notar que los listeners se los pedimos al controlador
			botonNorte.addActionListener(controlJuego.getListenerBotonNorte());
			botonSur.addActionListener(controlJuego.getListenerBotonSur());
			botonOeste.addActionListener(controlJuego.getListenerBotonOeste());
			botonEste.addActionListener(controlJuego.getListenerBotonEste());
		}
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			//armado de la ventana
			frame = new JFrame("GPS Challenge"); //creamos el marco
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setFocusable(true);
			frame.getContentPane().setLayout(null);
			
			Label label = new Label("NIVEL DIFICIL");
			label.setBounds(0, 0, 984, 22);
			frame.getContentPane().add(label);  //agregamos un titulo
			textoMapa.setBounds(0, 0, 0, 0);
			frame.getContentPane().add(textoMapa); //agregamos el texto que muestra el Nivel
			panelAuto.setSize(59,22);
			
			//frameMapa.add(panelAuto);
			frame.getContentPane().add(panelAuto);
			panelAuto.setLocation(20,240);
			panelAuto.setLayout(null);
			//modelo.setPosX(20);
			//modelo.setPosY(240);
			
			//Creamos panel de Mapa y lo agregamos al frame
			panelMapa = new PanelImagen(imagenMapaNivel); //Panel que contiene la imagen del mapa
			panelMapa.setBounds(0, 22, 984, 600);
			frame.getContentPane().add(panelMapa);   //agregamos el panel con el mapa
			panelMapa.setLayout(null);
			botonNorte.setBounds(753, 456, 66, 22);
			botonNorte.setText("Norte");
			panelMapa.add(botonNorte);
			botonEste.setBounds(822, 484, 61, 22);
			panelMapa.add(botonEste);
			botonOeste.setBounds(690, 484, 61, 22);
			panelMapa.add(botonOeste);
			botonSur.setBounds(753, 510, 66, 22);
			panelMapa.add(botonSur);
		
			JButton button = new JButton("   ");
			button.setBounds(753, 484, 66, 22);
			panelMapa.add(button);
								
			frame.addKeyListener(controlJuego.getListenerTeclas());
			frame.setSize(1000,680);  //seteamos las dimensiones del marco
			frame.setVisible(true);  //mostramos el marco

			//agregamos el listener del evento de cerrado de la ventana		
			frame.addWindowListener(new CloseListener());

			// Conectamos esta vista con el modelo
			//TODO: this.modelo = modelo;
			//TODO: this.modelo.addObserver(this);

		}
		
		
		//Metodo que es llamado por el modelo al actualizarse el mismo
		public void update(Observable t, Object o) {	
			//TODO panelAuto.setLocation(modelo.getPosX(), modelo.getPosY());			
		}

		public static VistaMapa getInstance(){
			if (instance == null) { 
					instance = new VistaMapa(); 
					} 
			return (VistaMapa) instance; 
		}
		
		//public void setTextoMapa(String s){ textoTemp.setText(s);}
	
		/*
		  public static void main(String[] args) {
			  ModeloJuego modelo =  new ModeloJuego();
			  ControladorVistaMapa controlador = new ControladorVistaMapa(modelo);
			  VistaMapa vistaMapa = new VistaMapa();
			    
			}
			*/
	}
