package algoritmos.gpschallenge.vista.pantallas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//import sun.java2d.ScreenUpdateManager;


public class PanelImagen extends JPanel {

		  private Image imagenMapa;

		  public PanelImagen(String imagenMapa) {
		    this(new ImageIcon(imagenMapa).getImage());
		  }

		  public PanelImagen(Image imagenMapa) {
		    this.imagenMapa = imagenMapa;
		    Dimension size = new Dimension(imagenMapa.getWidth(null), imagenMapa.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
		      
		      g.drawImage(imagenMapa, 0, 0, null);
		    
		  }

}
