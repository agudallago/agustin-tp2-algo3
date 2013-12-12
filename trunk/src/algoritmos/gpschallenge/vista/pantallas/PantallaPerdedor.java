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

import algoritmos.gpschallenge.modelo.juego.Jugador;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PantallaPerdedor {

	private JFrame frame;
	private JTextField txtBienvenido;
	private JTextField textFieldNombre;
	private JButton btnVolver;
	private JButton btnJugarOtraVez;

	private PantallaOpciones windowOpciones;
	private PantallaNuevaPartida windowNuevaPartida;
	private Jugador jugador;
	
	/**
	 * Constructor
	 */
	public PantallaPerdedor(Jugador unJugador) {
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
		frame.setBounds(100, 100, 450, 389);
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
		txtBienvenido.setText("Partida F\u00E1cil");
		txtBienvenido.setBounds(0, 0, 434, 29);
		frame.getContentPane().add(txtBienvenido);
		txtBienvenido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setText("#Nombre");
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
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowOpciones = new PantallaOpciones(jugador);
				frame.dispose();
			}
		});
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(231, 275, 171, 49);
		frame.getContentPane().add(btnVolver);
		
		btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowNuevaPartida = new PantallaNuevaPartida(jugador);
				frame.dispose();
			}
		});
		btnJugarOtraVez.setActionCommand("JugarOtraVez");
		btnJugarOtraVez.setBounds(30, 275, 171, 49);
		frame.getContentPane().add(btnJugarOtraVez);
		
		JLabel lblGanaste = new JLabel("\u00A1 PERDISTE !");
		lblGanaste.setFont(new Font("Arial", Font.BOLD, 24));
		lblGanaste.setForeground(new Color(204, 51, 0));
		lblGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaste.setBounds(76, 68, 278, 59);
		frame.getContentPane().add(lblGanaste);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido}));
	}
}
