package algoritmos.gpschallenge.modeloPruebaVisual;

public class ModeloJuego extends java.util.Observable {

	private int posX;
	private int posY;
	int incremento = 38;
	
	public void ModeloJuego() {
		//setPosX(100);
		//setPosY(100);
	}
	
	public void moverNorte() {
		setPosY(getPosY() - incremento);
		ActualizarObservadores();
	}
	
	public void moverSur() {
		setPosY(getPosY() + incremento);
		ActualizarObservadores();
	}
	
	public void moverEste() {
		setPosX(getPosX() + incremento);
		ActualizarObservadores();
	}
	
	public void moverOeste() {
		setPosX(getPosX() - incremento);
		ActualizarObservadores();	
	}

	
	public void ActualizarObservadores() {
		setChanged();
		notifyObservers();		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
