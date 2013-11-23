package algoritmos.gpschallenge.modelo.sorpresa;

import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

public abstract class SorpresaDePuntaje extends Sorpresa {
		
	protected int mPorcentajePenalizado;
	
	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.addMovimientosBonus((float)vehiculo.getMovimientos() * this.mPorcentajePenalizado / 100);		
	}
}
