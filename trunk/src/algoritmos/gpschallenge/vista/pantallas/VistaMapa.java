package algoritmos.gpschallenge.vista.pantallas;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algoritmos.gpschallenge.control.Controlador;
import algoritmos.gpschallenge.control.*;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloJuego;

public class VistaMapa implements Observer{
		
		private ModeloJuego modelo; //referencia al modelo
		private JFrame frameMapa; //marco que contendrá el mapa
		private MapaPanel panelMapa; //Panel que contiene la imagen del mapa
		private TextField textoMapa = new TextField(); //texto que mostrara el Nivel 
		private Button botonNorte = new Button("Norte");  //boton para ir al Norte
		private Button botonSur = new Button("Sur");  //boton para ir al Sur
		private Button botonEste = new Button("Este");  //boton para ir al Este
		private Button botonOeste = new Button("Oeste");  //boton para ir al Oeste
		private MapaPanel panelAuto = new MapaPanel("images/auto.png");
				
		//Clase auxiliar para escuchar el evento de cerrado de la ventana
		public static class CloseListener extends WindowAdapter	{
			
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		} //Fin de CloseListener


//Constructor de la vista
		public VistaMapa(ModeloJuego modelo, Controlador control, String imagenMapaNivel) {
			
			//armado de la ventana
			frameMapa = new JFrame("GPS Challenge"); //creamos el marco
			frameMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameMapa.setFocusable(true);
			
			frameMapa.add("North", new Label("Nivel 1 "));  //agregamos un titulo
			frameMapa.add("Center", textoMapa); //agregamos el texto que muestra el Nivel
			
			
			//frameMapa.add(panelAuto);
			frameMapa.getContentPane().add(panelAuto);
			panelAuto.setLocation(100,100);
			modelo.setPosX(100);
			modelo.setPosY(100);
			
			//Creamos panel de Mapa y lo agregamos al frame
			panelMapa = new MapaPanel(imagenMapaNivel); //Panel que contiene la imagen del mapa
			frameMapa.add("Center",panelMapa);   //agregamos el panel con el mapa
			
			frameMapa.addKeyListener(control.getListenerTeclas()); //agregamos el listener de teclas
			
			//Creamos panel de Botones y agregamos los botones de "Norte", "Sur", "Este"y "Oeste" al panel
			Panel panelBotones = new Panel(); //creamos un panel para los botones	
			panelBotones.add(botonNorte);  
			panelBotones.add(botonSur);  
			panelBotones.add(botonEste);  
			panelBotones.add(botonOeste);  
			
			frameMapa.add("South", panelBotones);  //agregamos el panel al marco
			frameMapa.setSize(1000,600);  //seteamos las dimensiones del marco
			frameMapa.setVisible(true);  //mostramos el marco

			//agregamos el listener del evento de cerrado de la ventana		
			frameMapa.addWindowListener(new CloseListener());
			
			//agregamos el listener de los botones "Norte", "Sur", "Este" y "Oeste"
			//Notar que los listeners se los pedimos al controlador
		botonNorte.addActionListener(control.getListenerBotonNorte());
		botonSur.addActionListener(control.getListenerBotonSur());
		botonEste.addActionListener(control.getListenerBotonEste());
		botonOeste.addActionListener(control.getListenerBotonOeste());

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
			  Controlador controlador = new Controlador(modelo);
			  
			  VistaMapa vistaMapa = new VistaMapa(modelo, controlador, "images/fondo.jpg");
			    
			}
		
	}
