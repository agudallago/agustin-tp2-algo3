package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;


public class PantallaBienvenida extends PantallaGPSChallenge {

	private JTextField txtBienvenido;
	private JButton btnYaTengoUsuario;
	private JButton btnNuevoJugador;


	/**
	 * Constructor.
	 */

	public PantallaBienvenida() {
		super();
		initialize();
		addListeners();
	}
	
	//M�todo para agregar los listeners de los botones del Frame
		private void addListeners() {
			btnNuevoJugador.addActionListener(control.getListenerBtnJugadorNuevo());
			btnYaTengoUsuario.addActionListener(control.getListenerBtnJugadorExistente());
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
		
		btnYaTengoUsuario = new JButton("Ya tengo usuario");
		btnYaTengoUsuario.setBounds(132, 169, 171, 49);
		frame.getContentPane().add(btnYaTengoUsuario);
	}
	
	public static PantallaBienvenida getInstance(){
		if (instance == null) { 
				instance = new PantallaBienvenida(); 
				} 
		return (PantallaBienvenida) instance; 
	}
	
	/* Main de prueba*/
	/*
	public static void main(String[] args) {
		ModeloPantallas modelo = new ModeloPantallas();
		ControladorPantallas control = ControladorPantallas.getInstance();
		control.setModelo(modelo);
		PantallaBienvenida wBienvenida = new PantallaBienvenida();
		wBienvenida.setVisible(true);
		
	}*/
	
	
}
