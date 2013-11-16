package algoRitmos.gpsChallenge.modelo;

public abstract class SorpresaDePuntaje extends Sorpresa {
		
	protected int mPorcentajePenalizado;
	
	public void aplicarA(Vehiculo vehiculo) {
		vehiculo.addMovimientosBonus(vehiculo.getMovimientos() * this.mPorcentajePenalizado / 100);		
	}
}
