package algoritmos.gpschallenge.control;
import java.awt.event.*;

import algoritmos.gpschallenge.modelo.juego.ModeloJuego;

public class ControladorVistaMapa {

	private static final int INCREMENTO = 38;
	private static final int POSICION_INICIAL = 38;
	private ModeloJuego modelo;
	private int posX, posY; //Coordenadas de la imagen del vehículo
	
	//Constructor de la clase Controlador
		public ControladorVistaMapa(ModeloJuego modelo) {
			this.modelo = modelo;
			this.transformarCoordModeloAVista();
		}
	
	//Setter y Getters de posY y posX
		public int getPosY() {
			return posY;
		}

		public int getPosX() {
			return posX;
		}

		
// Transformada entre coordenadas del modelo y la vista
		
		public void transformarCoordModeloAVista() {
			this.posX = modelo.getPosX() * INCREMENTO + POSICION_INICIAL;
			this.posY = modelo.getPosY() * INCREMENTO + POSICION_INICIAL;		
		}
		
	//----------------------------------------------------------------------
		private class EscuchaBotonNorte implements ActionListener {	
			public void actionPerformed(ActionEvent e) {	
				modelo.moverNorte();
				transformarCoordModeloAVista();
			}
		}
		
		public ActionListener getListenerBotonNorte() {
			return new EscuchaBotonNorte();
		}

	//----------------------------------------------------------------------
		private class EscuchaBotonSur implements ActionListener	{
			public void actionPerformed(ActionEvent e)	{
				modelo.moverSur();
				transformarCoordModeloAVista();
			}
		}

		public ActionListener getListenerBotonSur() {
			return new EscuchaBotonSur();
		}

	//----------------------------------------------------------------------
		private class EscuchaBotonEste implements ActionListener {	
			public void actionPerformed(ActionEvent e)	{
				modelo.moverEste();
				transformarCoordModeloAVista();
			}
		}
			
		public ActionListener getListenerBotonEste() {
			return new EscuchaBotonEste();
		}
		
	//----------------------------------------------------------------------
		private class EscuchaBotonOeste implements ActionListener {	
			public void actionPerformed(ActionEvent e)	{
				modelo.moverOeste();
				transformarCoordModeloAVista();
			}
		}
		
		public ActionListener getListenerBotonOeste() {
			return new EscuchaBotonOeste();
	}


	//----------------------------------------------------------------------
		public KeyListener getListenerTeclas() {
			return new EscuchaTeclas();
	}
		
		private class EscuchaTeclas implements KeyListener {	

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        switch (keyCode){
		        	case 37: 
		        		modelo.moverOeste();
		        		transformarCoordModeloAVista();
		        		break;
		        	case 38: 
		        		modelo.moverNorte();
		        		transformarCoordModeloAVista();
		        		break;
		        	case 39:
		        		modelo.moverEste();
		        		transformarCoordModeloAVista();
		        		break;
		        	case 40:
		        		modelo.moverSur();
		        		transformarCoordModeloAVista();
		        		break;
		        }
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}			
			
		}
				
}
