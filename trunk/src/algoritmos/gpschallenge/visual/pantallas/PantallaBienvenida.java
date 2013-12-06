package algoritmos.gpschallenge.visual.pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;


public class PantallaBienvenida {

	private JFrame frmGpsChallenge;
	private JTextField txtBienvenido;
	private JButton btnYaSoyJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaBienvenida window = new PantallaBienvenida();
					window.frmGpsChallenge.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaBienvenida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gaston\\JAVAworkspace\\PruebaMVC\\images\\minicooper64_2.ico"));
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setName("frameBienvenida");
		frmGpsChallenge.getContentPane().setBackground(new Color(255, 255, 255));
		frmGpsChallenge.getContentPane().setForeground(new Color(0, 0, 0));
		frmGpsChallenge.setBounds(100, 100, 450, 300);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpsChallenge.getContentPane().setLayout(null);
		
		txtBienvenido = new JTextField();
		txtBienvenido.setRequestFocusEnabled(false);
		txtBienvenido.setBorder(null);
		txtBienvenido.setBackground(new Color(255, 255, 255));
		txtBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenido.setForeground(new Color(0, 102, 204));
		txtBienvenido.setFont(new Font("Arial", Font.BOLD, 18));
		txtBienvenido.setEditable(false);
		txtBienvenido.setText("BIENVENIDO");
		txtBienvenido.setBounds(10, 49, 414, 29);
		frmGpsChallenge.getContentPane().add(txtBienvenido);
		txtBienvenido.setColumns(10);
		
		JButton btnNuevoJugador = new JButton("Nuevo Jugador");
		btnNuevoJugador.setActionCommand("NuevoJugador");
		btnNuevoJugador.setBounds(132, 109, 171, 49);
		frmGpsChallenge.getContentPane().add(btnNuevoJugador);
		
		btnYaSoyJugador = new JButton("Ya soy Jugador");
		btnYaSoyJugador.setActionCommand("YaSoyJugador");
		btnYaSoyJugador.setBounds(132, 169, 171, 49);
		frmGpsChallenge.getContentPane().add(btnYaSoyJugador);
		frmGpsChallenge.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido, btnNuevoJugador}));
	}
}
