package algoritmos.gpschallenge.vista.pantallas;

import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloPantallas;

public class Principal {

	public Principal (){
		
	}
	
	
	public static void main(String[] args) {
		ModeloPantallas modelo = new ModeloPantallas();
		ControladorPantallas control = ControladorPantallas.getInstance();
		control.setModelo(modelo);
		PantallaBienvenida wBienvenida = new PantallaBienvenida();
		wBienvenida.setVisible(true);
		
				}
		
}