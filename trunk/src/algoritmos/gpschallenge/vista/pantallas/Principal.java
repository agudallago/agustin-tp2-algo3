package algoritmos.gpschallenge.vista.pantallas;

import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloJuegoPrueba;
import algoritmos.gpschallenge.modeloPruebaVisual.ModeloPantallas;

public class Principal {

	public Principal (){
	//	
	}
	
	public static void main(String[] args) {
		//Se crean los modelos de pantalla y de juego
		ModeloPantallas modeloPantalla = new ModeloPantallas();
		ModeloJuegoPrueba modeloJuego = new ModeloJuegoPrueba();
		
		//Se crea el controlador de pantallas y se le asignan los modelos
		ControladorPantallas controlPantallas = ControladorPantallas.getInstance();
		controlPantallas.setModeloPantalla(modeloPantalla);
		controlPantallas.setModeloJuego(modeloJuego);
		
		//Se crea la pantalla de bienvenida y se la hace visible para comenzar el juego
		PantallaBienvenida wBienvenida = PantallaBienvenida.getInstance();
		wBienvenida.setVisible(true);
		
				}
		
}