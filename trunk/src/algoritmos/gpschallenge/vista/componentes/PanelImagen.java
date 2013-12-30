package algoritmos.gpschallenge.vista.componentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PanelImagen extends JPanel {

		  private Image imagenMapa;

		  public PanelImagen(String imagen) {
		    this(new ImageIcon(imagen).getImage());
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
