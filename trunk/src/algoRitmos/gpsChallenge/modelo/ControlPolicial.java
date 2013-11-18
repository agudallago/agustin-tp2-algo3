package algoRitmos.gpsChallenge.modelo;

public class ControlPolicial extends Obstaculo {

	public ControlPolicial() {
		this.mMovimientosDePenalizacion = 3;				
	}
	
	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.atravesarControlPolicial(mMovimientosDePenalizacion);
	}
}

