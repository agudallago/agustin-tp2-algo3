package algoritmos.gpschallenge.vista.pantallas;


import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import algoritmos.gpschallenge.modelo.juego.Jugador;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PantallaOpciones {

	private JFrame frame;
	private JTextField txtBienvenido;
	private JButton btnRecuperarPartida;
	private JButton btnPuntajes;
	private JTextField textFieldNombre;
	private JButton btnSalir;
	private PantallaPuntajes windowPuntajes;
	private PantallaBienvenida windowBienvenida;
	private PantallaNuevaPartida windowNuevaPartida; 
	private Jugador jugador;
	
	/**
	 * Constructor
	 */
	
	public PantallaOpciones(Jugador unJugador) {
		this.jugador = unJugador;
		initialize();
		frame.setVisible(true);
		
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
		txtBienvenido.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtBienvenido.setBackground(new Color(204, 204, 204));
		txtBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenido.setForeground(new Color(0, 102, 204));
		txtBienvenido.setFont(new Font("Arial", Font.BOLD, 18));
		txtBienvenido.setEditable(false);
		txtBienvenido.setText("GPS Challenge");
		txtBienvenido.setBounds(0, 0, 434, 29);
		frame.getContentPane().add(txtBienvenido);
		txtBienvenido.setColumns(10);
		
		JButton btnComenzarPartida = new JButton("Comenzar Partida");
		btnComenzarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					windowNuevaPartida = new PantallaNuevaPartida(jugador);
					frame.dispose();
			}
		});
		btnComenzarPartida.setActionCommand("ComenzarPartida");
		btnComenzarPartida.setBounds(129, 66, 171, 49);
		frame.getContentPane().add(btnComenzarPartida);
		
		btnRecuperarPartida = new JButton("Recuperar Partida");
		btnRecuperarPartida.setActionCommand("RecuperarPartida");
		btnRecuperarPartida.setBounds(129, 126, 171, 49);
		frame.getContentPane().add(btnRecuperarPartida);
		
		btnPuntajes = new JButton("Ver Puntajes");
		btnPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowPuntajes = new PantallaPuntajes(jugador);
			}
		});
		btnPuntajes.setActionCommand("VerPuntajes");
		btnPuntajes.setBounds(129, 186, 171, 49);
		frame.getContentPane().add(btnPuntajes);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setText("Nombre");
		textFieldNombre.setRequestFocusEnabled(false);
		textFieldNombre.setForeground(new Color(0, 0, 0));
		textFieldNombre.setFont(new Font("Arial", Font.BOLD, 16));
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBorder(null);
		textFieldNombre.setBackground(new Color(255, 255, 255));
		textFieldNombre.setBounds(0, 28, 131, 29);
		textFieldNombre.setText(jugador.getNombre());
		frame.getContentPane().add(textFieldNombre);
		
		btnSalir = new JButton("Volver");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowBienvenida = new PantallaBienvenida();
				frame.dispose();
			}
		});
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSalir.setBounds(335, 212, 89, 23);
		frame.getContentPane().add(btnSalir);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido, btnComenzarPartida}));
	}
}
