package algoritmos.gpschallenge.modelo.juego;

import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public class Meta extends ElementoDeEsquina{

	public void aplicarA(Vehiculo vehiculo) {	
		vehiculo.cruzarLaMeta();
	}
	
}
