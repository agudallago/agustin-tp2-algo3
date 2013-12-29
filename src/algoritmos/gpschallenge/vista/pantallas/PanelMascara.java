package algoritmos.gpschallenge.vista.pantallas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class PanelMascara extends JPanel {

		  private Image imagenMapa;
		  private int x, y, width, height;
		  private int RADIO_MASCARA = 160;		  
		  
		  
		  public PanelMascara(String imagenMapa) {
		    this(new ImageIcon(imagenMapa).getImage());
		    x = y = width = height = 0;
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
			  //private Ellipse2D ellipse = new Ellipse2D.Float();
			  //ellipse.setFrame(x, y, ew, eh);
			  //g2.setClip(ellipse)
			  final Rectangle2D rect = new Rectangle2D.Float();
			  final Rectangle2D meta = new Rectangle2D.Float();
			  meta.setFrame(this.getWidth()-RADIO_MASCARA/4, this.getHeight()/2 + RADIO_MASCARA, RADIO_MASCARA/3, RADIO_MASCARA/3);
			  rect.setFrame(this.x - RADIO_MASCARA/2, this.y - RADIO_MASCARA/2, RADIO_MASCARA, RADIO_MASCARA);
			  g2.setClip(rect);
			  g.drawImage(imagenMapa, 0, 0, null);
			  g2.setClip(meta);
			  g.drawImage(imagenMapa, 0, 0, null);
		  }
		  
		  public void setUbicacion (int x, int y) {
			  this.x = x;
			  this.y = y;
			  
		  }

}
