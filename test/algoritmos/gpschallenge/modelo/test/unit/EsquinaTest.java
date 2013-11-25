package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;

import algoritmos.gpschallenge.modelo.juego.Esquina;
import algoritmos.gpschallenge.modelo.obstaculo.Pozo;
import algoritmos.gpschallenge.modelo.direccion.*;

public class EsquinaTest {
	
	@Test
	public void testCrearEsquinaNoNula() {
		Esquina unaEsquina = new Esquina();
		
		Assert.assertNotNull(unaEsquina);
	}
	
	@Test
	public void testCrearEsquinaYVerificarNoTieneElemento() {
		Esquina unaEsquina = new Esquina();
		Assert.assertNull(unaEsquina.getElementoEnEsquina());
	}
	
	
	@Test
	public void testCrearEsquinaYChequearQueEsteAislada() {
		Esquina esquina = new Esquina();
		
		Assert.assertNull(esquina.getEsquinaAl(new Norte()));
		Assert.assertNull(esquina.getEsquinaAl(new Sur()));
		Assert.assertNull(esquina.getEsquinaAl(new Este()));
		Assert.assertNull(esquina.getEsquinaAl(new Oeste()));
	}
	
	@Test
	public void testCrearEsquinaYAsociarlaConEsquinaNorte() {
		Esquina esquina = new Esquina();
		Esquina esquinaNorte = new Esquina();
				
		esquina.setEsquinaAl(new Norte(), esquinaNorte);
		Assert.assertNotNull(esquina.getEsquinaAl(new Norte()));
	}
	
	@Test
	public void testAgregarElementoEnEsquina() {
		Esquina unaEsquina = new Esquina();
		Pozo unObstaculo = new Pozo(); 

		unaEsquina.addElementoEnEsquina(unObstaculo);
		Assert.assertEquals(unObstaculo, unaEsquina.getElementoEnEsquina());
	}
	
	@Test
	public void testCrearEsquinacConEsquinasProximasNoNulas() {
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNorte = new Esquina();
		Esquina unaEsquinaSur = new Esquina();
		Esquina unaEsquinaOeste = new Esquina();
		Esquina unaEsquinaEste = new Esquina();
		
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNorte);
		unaEsquina.setEsquinaAl(new Sur(), unaEsquinaSur);
		unaEsquina.setEsquinaAl(new Oeste(), unaEsquinaOeste);
		unaEsquina.setEsquinaAl(new Este(), unaEsquinaEste);
		
		Assert.assertEquals(unaEsquina.getEsquinaAl(new Norte()), unaEsquinaNorte);
		Assert.assertEquals(unaEsquina.getEsquinaAl(new Sur()), unaEsquinaSur);
		Assert.assertEquals(unaEsquina.getEsquinaAl(new Oeste()), unaEsquinaOeste);
		Assert.assertEquals(unaEsquina.getEsquinaAl(new Este()), unaEsquinaEste);
		
	}
	
	@Test
	public void testTieneEsquinasProximasNulasYNoNulas() {
		Esquina unaEsquina = new Esquina();
		Esquina unaEsquinaNorte = new Esquina();
		Esquina unaEsquinaSur = new Esquina();
		//No se agrega una esquina al Oeste
		//No se agrega una esquina al Este
		
		unaEsquina.setEsquinaAl(new Norte(), unaEsquinaNorte);
		unaEsquina.setEsquinaAl(new Sur(), unaEsquinaSur);
		
		Assert.assertEquals(unaEsquina.getEsquinaAl(new Norte()), unaEsquinaNorte);
		Assert.assertEquals(unaEsquina.getEsquinaAl(new Sur()), unaEsquinaSur);
		Assert.assertNull(unaEsquina.getEsquinaAl(new Oeste()));
		Assert.assertNull(unaEsquina.getEsquinaAl(new Este()));
		
	}
	
	
}
