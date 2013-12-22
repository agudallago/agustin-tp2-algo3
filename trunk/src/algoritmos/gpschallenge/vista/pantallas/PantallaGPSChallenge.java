package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;

import algoritmos.gpschallenge.control.ControladorPantallas;


//Clase abstracta de la cual heredan las otras pantallas

public class PantallaGPSChallenge {

	protected static JFrame frame;
	public ControladorPantallas control;
	protected static PantallaGPSChallenge instance;
	
	/* Metodos */
	
	public PantallaGPSChallenge() {
		this.control = ControladorPantallas.getInstance();
		this.frame = new JFrame();
		instance = this;
	}

	public static PantallaGPSChallenge getInstance(){
		if (instance == null) { 
				instance = new PantallaGPSChallenge(); 
				} 
		return instance; 
	}
	
	public static void setInstanceNull () {
		instance = null;
	}
	
	private void addListeners(){

	}
	
	public void dispose(){
		this.setInstanceNull();
		frame.dispose();
	}
	
	public void setVisible(boolean b){
		frame.setVisible(b);
	}
}
