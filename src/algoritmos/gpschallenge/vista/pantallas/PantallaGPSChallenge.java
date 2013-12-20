package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;

import algoritmos.gpschallenge.control.ControladorPantallas;


//Clase abstracta de la cual heredan las otras pantallas

public abstract class PantallaGPSChallenge {

	public JFrame frame;
	public ControladorPantallas control;
	
	/* Metodos */
	
	public PantallaGPSChallenge() {
		this.frame = new JFrame();
	}

	private void addListeners(){

	}
	
	public void dispose(){
		this.frame.dispose();
	}
	
	public void setVisible(boolean b){
		this.frame.setVisible(b);
	}
}
