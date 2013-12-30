package algoritmos.gpschallenge.vista.pantallas;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algoritmos.gpschallenge.control.*;
import algoritmos.gpschallenge.modelo.juego.ModeloJuego;



import algoritmos.gpschallenge.vista.componentes.LabelVehiculo;
import algoritmos.gpschallenge.vista.componentes.PanelImagen;
import algoritmos.gpschallenge.vista.componentes.PanelMascara;

import javax.swing.JButton;

import java.awt.Font;

public class PantallaMapa implements Observer{
		
		private JFrame frameMapa; //marco que contendrá el mapa
		//private PanelImagen panelMapa; //Panel que contiene la imagen del mapa
		private PanelMascara panelMapa;
		private TextField textoMapa = new TextField(); //texto que mostrara el Nivel
		private JLabel txtMovimientos;
		
		private JButton botonNorte = new JButton("Norte", null);  //boton para ir al Norte
		private JButton botonSur = new JButton("Sur", null);  //boton para ir al Sur
		private JButton botonEste = new JButton("Este", null);  //boton para ir al Este
		private JButton botonOeste = new JButton("Oeste", null);  //boton para ir al Oeste
		private PanelImagen panelVehiculo;
		private ModeloJuego modelo;
		private ControladorVistaMapa controlador;
		private JTextField fldMovimientos;
		private final LabelVehiculo lblVehiculo;
		private final JLabel lblTituloVehiculo = new JLabel("Veh\u00EDculo utilizado");
		
		private String imagenVehiculo;
		//Clase auxiliar para escuchar el evento de cerrado de la ventana
		public static class CloseListener extends WindowAdapter	{
			
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		} //Fin de CloseListener


//Constructor de la vista
		public PantallaMapa(ModeloJuego modelo, ControladorVistaMapa control, String imagenMapa, String imagenVehiculo) {
			
			// Conectamos esta vista con el modelo y el controlador
			this.controlador = control;
			this.modelo = modelo;
			this.modelo.addObserver(this);
			this.imagenVehiculo = imagenVehiculo;
			
			//armado de la ventana
			frameMapa = new JFrame("GPS Challenge"); //creamos el marco
			frameMapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Definimos la accion por defecto al cerrar ventana
			frameMapa.setFocusable(true); 
			frameMapa.getContentPane().setLayout(null); //No especificamos un Layout
			frameMapa.getContentPane().setBackground(Color.BLACK);

			txtMovimientos = new JLabel("Movimientos: ");
			fldMovimientos = new JTextField("--Movimientos--");
			txtMovimientos.setBackground(Color.white);
			fldMovimientos.setBackground(Color.white);
			txtMovimientos.setLocation(frameMapa.getWidth() - txtMovimientos.getWidth()*2, 0);
			fldMovimientos.setLocation(frameMapa.getWidth() - txtMovimientos.getWidth(), 0);
			
			botonNorte.setBounds(753, 456, 66, 22);
			botonNorte.setText("Norte");
			frameMapa.getContentPane().add(botonNorte);
						
			botonEste.setBounds(822, 484, 61, 22);
			botonEste.setText("Este");
			frameMapa.getContentPane().add(botonEste);
			
			botonOeste.setBounds(690, 484, 61, 22);
			botonOeste.setText("Oeste");
			frameMapa.getContentPane().add(botonOeste);
			
			botonSur.setBounds(753, 510, 66, 22);
			botonSur.setText("Sur");
			frameMapa.getContentPane().add(botonSur);
			
			JButton botonCentral = new JButton("");
			botonCentral.setBounds(753, 484, 66, 22);
			frameMapa.getContentPane().add(botonCentral);
			frameMapa.getContentPane().setSize(1000, 600);
							
			//agregamos el listener de los botones "Norte", "Sur", "Este" y "Oeste"
			//Notar que los listeners se los pedimos al controlador
	
			botonSur.addActionListener(control.getListenerBotonSur());
			botonOeste.addActionListener(control.getListenerBotonOeste());
			botonEste.addActionListener(control.getListenerBotonEste());			
			botonNorte.addActionListener(control.getListenerBotonNorte());
			
			Label label = new Label("Nivel");
			frameMapa.getContentPane().add(label);  //agregamos un titulo
			
			textoMapa.setBounds(0, 0, 0, 0);
			frameMapa.getContentPane().add(textoMapa); //agregamos el texto que muestra el Nivel
			
			
			panelVehiculo = new PanelImagen(imagenVehiculo);
			frameMapa.getContentPane().add(panelVehiculo);
			panelVehiculo.setLocation(100,60);
			panelVehiculo.setLayout(null);
			panelVehiculo.setSize(59, 22);
			
			
			//Creamos panel de Mapa y lo agregamos al frame
			//panelMapa = new PanelImagen(imagenMapa); //Panel que contiene la imagen del mapa
			panelMapa = new PanelMascara(imagenMapa); //Panel que contiene la imagen del mapa
			panelMapa.setForeground(Color.WHITE);
			panelMapa.setBounds(0, 22, 600, 600);
			frameMapa.getContentPane().add(panelMapa);   //agregamos el panel con el mapa
			panelMapa.setLayout(null);
			panelMapa.setLocation(10, 10);
			
			JLabel lblMovimientos = new JLabel("Movimientos:");
			lblMovimientos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMovimientos.setForeground(Color.WHITE);
			lblMovimientos.setBounds(648, 33, 103, 14);
			frameMapa.getContentPane().add(lblMovimientos);
			
			fldMovimientos = new JTextField();
			fldMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			fldMovimientos.setText("0");
			fldMovimientos.setBounds(768, 30, 86, 20);
			frameMapa.getContentPane().add(fldMovimientos);
			fldMovimientos.setColumns(10);
			lblVehiculo = new LabelVehiculo(modelo.getImagenVehiculoGrande());
			lblVehiculo.setBounds(685, 118, 250, 250);
			
			frameMapa.getContentPane().add(lblVehiculo);
			lblTituloVehiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTituloVehiculo.setForeground(Color.WHITE);
			lblTituloVehiculo.setBounds(690, 93, 129, 14);
			
			frameMapa.getContentPane().add(lblTituloVehiculo);
			
			frameMapa.addKeyListener(control.getListenerTeclas());
			frameMapa.setSize(600,600);  //seteamos las dimensiones del marco
			frameMapa.setBounds(10, 10, 1000, 600);
			frameMapa.setBackground(Color.black);
			frameMapa.setVisible(true);  //mostramos el marco

			//agregamos el listener del evento de cerrado de la ventana		
			frameMapa.addWindowListener(new CloseListener());
			 
			}
		
		//Metodo que es llamado por el modelo al actualizarse el mismo
		public void update(Observable t, Object o) {	
			panelVehiculo.setLocation(modelo.getPosX(), modelo.getPosY());
			panelMapa.setUbicacion(modelo.getPosX(), modelo.getPosY());
			this.frameMapa.repaint();
			panelMapa.repaint();
			lblVehiculo.updateImage(imagenVehiculo);
			this.fldMovimientos.setText(Integer.toString(modelo.getMovimientos()));
			//modelo.getTipoDeVehiculo()
			this.lblVehiculo.updateImage(imagenVehiculo);
			this.frameMapa.requestFocus(); //Le devuelve el focus al Frame
			
			//Eliminar, solo para pruebas
			System.out.println("--------------------------------------");
			System.out.printf("Modelo X: %d",  modelo.getPosXModelo());
			System.out.println();
			System.out.printf("Modelo Y: %d", modelo.getPosYModelo() );
			System.out.println();
			System.out.printf("Vehiculo X: %d", panelVehiculo.getX());
			System.out.println();
			System.out.printf("Vehiculo Y: %d", panelVehiculo.getY());
			System.out.println("--------------------------------------");
		}
		
		public void setVisible (boolean b) {
			this.frameMapa.setVisible(b);
		}
	}
