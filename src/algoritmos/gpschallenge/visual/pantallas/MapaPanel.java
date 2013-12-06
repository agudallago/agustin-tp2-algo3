package algoritmos.gpschallenge.visual.pantallas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MapaPanel extends JPanel {

		  private Image imagenMapa;

		  public MapaPanel(String imagenMapa) {
		    this(new ImageIcon(imagenMapa).getImage());
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
		    g.drawImage(imagenMapa, 0, 0, null);
		  }

}
