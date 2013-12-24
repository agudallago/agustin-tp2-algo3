package algoritmos.gpschallenge.modelo.test.unit;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import com.thoughtworks.xstream.*;

public class XStreamTest {
	@Test
	public void testCrearXStreamNoNulo() {		
		XStream xStream = new XStream();
		
		Assert.assertNotNull(xStream);
	}
	
	@Test
	public void testPersistenciaObjeto() throws 
	FileNotFoundException, IOException, ClassNotFoundException {
		XStream xStream = new XStream();
		
		OutputStream fos = new FileOutputStream("objeto.xml");
		ObjectOutputStream out = xStream.createObjectOutputStream(fos);

		out.writeObject(new String("Joe"));
		out.writeObject(new String("Someone"));
		out.writeObject("hello");
		out.writeInt(12345);

		out.close();
		fos.close();
		
		InputStream fis = new FileInputStream("objeto.xml");
		ObjectInputStream in = xStream.createObjectInputStream(fis);

		String a = (String)in.readObject();
		String b = (String)in.readObject();
		String c = (String)in.readObject();
		int    d = in.readInt();
		
		in.close();
				
		Assert.assertEquals(d, 12345);
	}		
}
