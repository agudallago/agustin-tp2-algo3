package algoritmos.gpschallenge.vista.pantallas;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PantallaBienvenida {

	JFrame frame;
	private JTextField txtBienvenido;
	private JButton btnYaSoyJugador;
	private PantallaJugadorNuevo windowJugadorNuevo;
	private PantallaJugadorExistente windowJugadorExistente;
	private PantallaBienvenida windowBienvenida;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaBienvenida window = new PantallaBienvenida();
					window.frame.setVisible(true);
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
		PantallaBienvenida windowBienvenida = this; //new PantallaBienvenida();
		windowBienvenida.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gaston\\JAVAworkspace\\PruebaMVC\\images\\minicooper64_2.ico"));
		frame.setTitle("GPS Challenge");
		frame.setName("frameBienvenida");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		frame.getContentPane().add(txtBienvenido);
		txtBienvenido.setColumns(10);
		
		JButton btnNuevoJugador = new JButton("Nuevo Jugador");
		btnNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowJugadorNuevo = new PantallaJugadorNuevo();
				frame.dispose();
			}
		});
		btnNuevoJugador.setActionCommand("NuevoJugador");
		btnNuevoJugador.setBounds(132, 109, 171, 49);
		frame.getContentPane().add(btnNuevoJugador);
		
		btnYaSoyJugador = new JButton("Ya soy Jugador");
		btnYaSoyJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowJugadorExistente = new PantallaJugadorExistente();
				frame.dispose();
				
			}
		});
		btnYaSoyJugador.setActionCommand("YaSoyJugador");
		btnYaSoyJugador.setBounds(132, 169, 171, 49);
		frame.getContentPane().add(btnYaSoyJugador);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido, btnNuevoJugador}));
	}
}
