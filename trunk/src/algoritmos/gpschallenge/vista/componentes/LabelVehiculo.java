package algoritmos.gpschallenge.vista.componentes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelVehiculo extends JLabel {
//Se crea esta clase para emprolijar la carga de la imagen del vehículo que se este utilizando
	public LabelVehiculo (String imagenVehiculo) {
		this.setBackground(Color.WHITE);
		this.setForeground(Color.WHITE);
		updateImage(imagenVehiculo);
	}
	
	public void updateImage(String imagenVehiculo) {
 		this.setIcon(new ImageIcon(imagenVehiculo));
	}
	
}
