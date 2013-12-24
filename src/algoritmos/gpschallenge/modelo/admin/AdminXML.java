package algoritmos.gpschallenge.modelo.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;

public class AdminXML {

	protected static Object cargarXML(String ruta)
	throws FileNotFoundException, IOException, ClassNotFoundException {
		XStream xStream = new XStream();
		
		InputStream inFile = new FileInputStream(ruta);
		ObjectInputStream inStream = xStream.createObjectInputStream(inFile);
	
		Object obj = inStream.readObject();
		
		inFile.close();
		inStream.close();
		
		return obj;
	}
	
	protected void guardarXML(Object obj, String ruta)
	throws FileNotFoundException, IOException {
		XStream xStream = new XStream();
		
		OutputStream outFile = new FileOutputStream(ruta);
		ObjectOutputStream outStream = xStream.createObjectOutputStream(outFile);

		outStream.writeObject(obj);
		
		outStream.close();
		outFile.close();
	}	

}