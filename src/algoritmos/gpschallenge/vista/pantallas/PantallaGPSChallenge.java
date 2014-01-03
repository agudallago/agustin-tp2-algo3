package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algoritmos.gpschallenge.control.ControladorPantallas;


//Clase abstracta de la cual heredan las otras pantallas

public class PantallaGPSChallenge {

	protected static JFrame frame;
	public ControladorPantallas control;
	protected static PantallaGPSChallenge instance;
	protected static JTextField textFieldNombre;
	protected static JLabel lblMovimientos;
	protected static JLabel lblPuntaje;

	
	/* Metodos */
	
	public PantallaGPSChallenge() {
		this.control = ControladorPantallas.getInstance();
		this.frame = new JFrame();
		instance = this;
		this.textFieldNombre = new JTextField();
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
		//Se crea como contrato para las demás pantallas
	}
	
	public void dispose(){
		this.setInstanceNull();
		frame.dispose();
	}
	
	public void setVisible(boolean b){
		frame.setVisible(b);
	}
	
	//Estos métodos no deberían ser comunes a todas las pantallas "hijas". Pero de no ponerlos acá, no
	//permite crearlos en las hijas
	
	public void setFieldNombre(String nombre) {
		textFieldNombre.setText(nombre);
	}
	
	public void setLblPuntaje(float puntaje){
		lblPuntaje.setText(Float.toString(puntaje));
	}
	
	public void setLblMovimientos(int movimientos){
		lblPuntaje.setText(Integer.toString(movimientos));
	}
}
