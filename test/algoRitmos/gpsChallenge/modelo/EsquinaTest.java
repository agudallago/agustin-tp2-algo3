package algoRitmos.gpsChallenge.modelo;

import junit.framework.Assert;
import org.junit.Test;

import algoRitmos.gpsChallenge.modelo.Esquina;

public class EsquinaTest {
	
	@Test
	public void crearEsquinaNoNula() {
		Esquina esquina = new Esquina();
		
		Assert.assertNotNull(esquina);
	}
	
	@Test
	public void crearEsquinaYChequearQueEsteAislada() {
		Esquina esquina = new Esquina();
		
		Assert.assertNull(esquina.getEsquinaAl(new Norte()));
		Assert.assertNull(esquina.getEsquinaAl(new Sur()));
		Assert.assertNull(esquina.getEsquinaAl(new Este()));
		Assert.assertNull(esquina.getEsquinaAl(new Oeste()));
	}
	
	@Test
	public void crearEsquinaYAsociarlaConEsquinaNorte() {
		Esquina esquina = new Esquina();
		Esquina esquinaNorte = new Esquina();
		
		esquina.setEsquinaAl(new Norte(), esquinaNorte);
		Assert.assertNotNull(esquina.getEsquinaAl(new Norte()));
	}
}
