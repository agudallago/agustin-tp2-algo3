package algoritmos.gpschallenge.vista.componentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class PanelMascara extends JPanel {

		  private Image imagenMapa;
		  private int x, y;
		  private int RADIO_MASCARA = 160;		  
		  private int COORDX_META = 550;
		  private int COORDY_META = 370;
		  
		  public PanelMascara(String imagenMapa) {
		    this(new ImageIcon(imagenMapa).getImage());
		  }

		  public PanelMascara(Image imagenMapa) {
		    this.imagenMapa = imagenMapa;
		    Dimension size = new Dimension(imagenMapa.getWidth(null), imagenMapa.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
			  Graphics2D g2 = (Graphics2D) g; 
			  //Si se quiere hacer con un círculo, descomentar lo comentado y comentar la implementación de
			  //del rectángulo
			  
			  //private Ellipse2D ellipse = new Ellipse2D.Float();
			  //ellipse.setFrame(x, y, ew, eh);
			  //g2.setClip(ellipse)
			  final Rectangle2D rect = new Rectangle2D.Float();
			  final Rectangle2D meta = new Rectangle2D.Float();
			  meta.setFrame(COORDX_META, COORDY_META, RADIO_MASCARA/2, RADIO_MASCARA/2);
			  
			  rect.setFrame(this.x , this.y, RADIO_MASCARA, RADIO_MASCARA);
			  g2.setClip(rect);
			  g.drawImage(imagenMapa, 0, 0, null);
			  g2.setClip(meta);
			  g.drawImage(imagenMapa, 0, 0, null);
		  }
		  
		  public void setUbicacion (int x, int y) {
			  this.x = x - RADIO_MASCARA/2;
			  this.y = y - RADIO_MASCARA/2;
			  
		  }

}
