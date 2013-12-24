package algoritmos.gpschallenge.modelo.juego;

public class Partida {
	
	private Jugador mJugador;
	private Mapa mMapa;
	
	public Partida(Jugador jugador, Mapa mapa) {
		this.mJugador = jugador;
		this.mMapa = mapa;
	}
	
	public Jugador getJugador() {
		return mJugador;
	}
	
	public Mapa getMapa() {
		return mMapa;
	}
	
	public boolean equals(Object otraPartida) {
		Partida partida = (Partida)otraPartida;		
		boolean chau = partida.getMapa().equals(mMapa);
		
		return partida.getJugador().equals(mJugador) && partida.getMapa().equals(mMapa);
	}
	
}
