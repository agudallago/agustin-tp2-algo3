package algoritmos.gpschallenge.control;
import java.awt.event.*;

import algoritmos.gpschallenge.modeloPruebaVisual.ModeloJuego;


public class Controlador {

	private ModeloJuego modelo;
	
	//Constructor de la clase Controlador
		public Controlador(ModeloJuego modelo) {
			this.modelo = modelo;
		}
	
	//----------------------------------------------------------------------
		private class EscuchaBotonNorte implements ActionListener {	
			public void actionPerformed(ActionEvent e) {	
				modelo.moverNorte();
			}
		}
		
		public ActionListener getListenerBotonNorte() {
			return new EscuchaBotonNorte();
		}

	//----------------------------------------------------------------------
		private class EscuchaBotonSur implements ActionListener	{
			public void actionPerformed(ActionEvent e)	{
				modelo.moverSur();
			}
		}

		public ActionListener getListenerBotonSur() {
			return new EscuchaBotonSur();
		}

	//----------------------------------------------------------------------
		private class EscuchaBotonEste implements ActionListener {	
			public void actionPerformed(ActionEvent e)	{
				modelo.moverEste();
			}
		}
			
		public ActionListener getListenerBotonEste() {
			return new EscuchaBotonEste();
		}
		
	//----------------------------------------------------------------------
		private class EscuchaBotonOeste implements ActionListener {	
			public void actionPerformed(ActionEvent e)	{
				modelo.moverOeste();
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
		        		break;
		        	case 38: 
		        		modelo.moverNorte();
		        		break;
		        	case 39:
		        		modelo.moverEste();
		        		break;
		        	case 40:
		        		modelo.moverSur();
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
