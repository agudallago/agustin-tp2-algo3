package algoritmos.gpschallenge.modelo.admin;

import java.io.FileNotFoundException;
import java.io.IOException;

import algoritmos.gpschallenge.modelo.juego.Partida;

public class AdminDePartida extends AdminXML {
		
	public Partida cargarPartida(String ruta)
	throws FileNotFoundException, IOException, ClassNotFoundException {		
		return (Partida)cargarXML(ruta);		
	}
		
	public void guardarPartida(Partida partida, String ruta)
	throws FileNotFoundException, IOException {
		this.guardarXML(partida, ruta);
	}
}
