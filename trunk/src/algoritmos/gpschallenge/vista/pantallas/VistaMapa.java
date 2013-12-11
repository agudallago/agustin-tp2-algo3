package algoritmos.gpschallenge.vista.pantallas;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JFrame;


import algoritmos.gpschallenge.control.*;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloJuego;
import javax.swing.JButton;

public class VistaMapa implements Observer{
		
		private ModeloJuego modelo; //referencia al modelo
		private JFrame frameMapa; //marco que contendr� el mapa
		private MapaPanel panelMapa; //Panel que contiene la imagen del mapa
		private TextField textoMapa = new TextField(); //texto que mostrara el Nivel 
		private JButton botonNorte = new JButton();  //boton para ir al Norte
		private JButton botonSur = new JButton("Sur", null);  //boton para ir al Sur
		private JButton botonEste = new JButton("Este", null);  //boton para ir al Este
		private JButton botonOeste = new JButton("Oeste", null);  //boton para ir al Oeste
		private MapaPanel panelAuto = new MapaPanel("images/auto.png");
				
		//Clase auxiliar para escuchar el evento de cerrado de la ventana
		public static class CloseListener extends WindowAdapter	{
			
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		} //Fin de CloseListener


//Constructor de la vista
		public VistaMapa(ModeloJuego modelo, ControladorVistaMapa control, String imagenMapaNivel) {
			
			//armado de la ventana
			frameMapa = new JFrame("GPS Challenge"); //creamos el marco
			frameMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameMapa.setFocusable(true);
			frameMapa.getContentPane().setLayout(null);
			
			Label label = new Label("Nivel 1 ");
			label.setBounds(0, 0, 984, 22);
			frameMapa.getContentPane().add(label);  //agregamos un titulo
			textoMapa.setBounds(0, 0, 0, 0);
			frameMapa.getContentPane().add(textoMapa); //agregamos el texto que muestra el Nivel
			panelAuto.setSize(59, 22);
			
			
			//frameMapa.add(panelAuto);
			frameMapa.getContentPane().add(panelAuto);
			panelAuto.setLocation(100,77);
			panelAuto.setLayout(null);
			modelo.setPosX(100);
			modelo.setPosY(100);
			
			//Creamos panel de Mapa y lo agregamos al frame
			panelMapa = new MapaPanel(imagenMapaNivel); //Panel que contiene la imagen del mapa
			panelMapa.setBounds(0, 22, 984, 542);
			frameMapa.getContentPane().add(panelMapa);   //agregamos el panel con el mapa
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
		botonSur.addActionListener(control.getListenerBotonSur());
		botonOeste.addActionListener(control.getListenerBotonOeste());
		botonEste.addActionListener(control.getListenerBotonEste());
			
			//agregamos el listener de los botones "Norte", "Sur", "Este" y "Oeste"
			//Notar que los listeners se los pedimos al controlador
		botonNorte.addActionListener(control.getListenerBotonNorte());
			
			frameMapa.addKeyListener(control.getListenerTeclas());
			frameMapa.setSize(1000,600);  //seteamos las dimensiones del marco
			frameMapa.setVisible(true);  //mostramos el marco

			//agregamos el listener del evento de cerrado de la ventana		
			frameMapa.addWindowListener(new CloseListener());

		// Conectamos esta vista con el modelo
		this.modelo = modelo;
		this.modelo.addObserver(this);
			
		}
		
		//Metodo que es llamado por el modelo al actualizarse el mismo
		public void update(Observable t, Object o) {	
			
			panelAuto.setLocation(modelo.getPosX(), modelo.getPosY());
			
			
		}

		//public void setTextoMapa(String s){ textoTemp.setText(s);}
	
		
		  public static void main(String[] args) {
			  ModeloJuego modelo =  new ModeloJuego();
			  ControladorVistaMapa controlador = new ControladorVistaMapa(modelo);
			  VistaMapa vistaMapa = new VistaMapa(modelo, controlador, "images/fondo.jpg");
			    
			}
	}