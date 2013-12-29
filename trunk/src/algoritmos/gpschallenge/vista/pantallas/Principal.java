package algoritmos.gpschallenge.vista.pantallas;

import java.io.FileNotFoundException;
import java.io.IOException;

import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.modelo.juego.ModeloJuego;
import algoritmos.gpschallenge.modelo.vista.ModeloPantallas;

public class Principal {

	public Principal (){
	//	
	}
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		//Se crean los modelos de pantalla y de juego
		ModeloPantallas modeloPantalla = new ModeloPantallas();
		ModeloJuego modeloJuego = new ModeloJuego();
		
		//Se crea el controlador de pantallas y se le asignan los modelos
		ControladorPantallas controlPantallas = ControladorPantallas.getInstance();
		controlPantallas.setModeloPantalla(modeloPantalla);
		controlPantallas.setModeloJuego(modeloJuego);
		
		//Se crea la pantalla de bienvenida y se la hace visible para comenzar el juego
		PantallaBienvenida wBienvenida = PantallaBienvenida.getInstance();
		wBienvenida.setVisible(true);
				}
		
}