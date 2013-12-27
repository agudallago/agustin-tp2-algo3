package algoritmos.gpschallenge.vista.pantallas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MapaPanel extends JPanel {

		  private Image imagenMapa;
		  private int x, y, width, height;
		  
		  
		  public MapaPanel(String imagenMapa) {
		    this(new ImageIcon(imagenMapa).getImage());
		    x = y = width = height = 0;
		  }

		  public MapaPanel(Image imagenMapa) {
		    this.imagenMapa = imagenMapa;
		    Dimension size = new Dimension(imagenMapa.getWidth(null), imagenMapa.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
			  private Ellipse2D ellipse = new Ellipse2D.Float();
			  ellipse.setFrame(x, y, ew, eh);
			  g2.setClip(ellipse)
		    g.drawImage(imagenMapa, 0, 0, null);
		  }

}
