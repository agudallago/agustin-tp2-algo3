package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import algoritmos.gpschallenge.control.ControladorPantallas;
import java.awt.Toolkit;


public class PantallaBienvenida extends PantallaGPSChallenge {

	private JTextField txtBienvenido;
	private JButton btnYaSoyJugador;
	private JButton btnNuevoJugador;


	/**
	 * Constructor.
	 */

	public PantallaBienvenida(ControladorPantallas controlador) {
		this.control = controlador;
		initialize();
		addListeners();
	}
	
	//Método para agregar los listeners de los botones del Frame
		private void addListeners() {
			btnNuevoJugador.addActionListener(control.getListenerBtnJugadorNuevo(this));
			btnYaSoyJugador.addActionListener(control.getListenerBtnJugadorExistente(this));
		}

	/**
	 * Inicializa los contenidos del Frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		btnNuevoJugador = new JButton("Nuevo Jugador");
		btnNuevoJugador.setBounds(132, 109, 171, 49);
		frame.getContentPane().add(btnNuevoJugador);
		
		btnYaSoyJugador = new JButton("Ya soy Jugador");
		btnYaSoyJugador.setBounds(132, 169, 171, 49);
		frame.getContentPane().add(btnYaSoyJugador);
	}
	
}
