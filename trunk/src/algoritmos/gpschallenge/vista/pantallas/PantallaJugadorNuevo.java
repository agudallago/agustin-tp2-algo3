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

import algoritmos.gpschallenge.modelo.juego.Esquina;
import algoritmos.gpschallenge.modelo.juego.Jugador;
import algoritmos.gpschallenge.modelo.vehiculo.Auto;
import algoritmos.gpschallenge.modelo.vehiculo.Vehiculo;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class PantallaJugadorNuevo {

	private JFrame frame;
	private JTextField txtTitulo;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JTextField campoNombre;
	private PantallaJugadorNuevo windowJugadorNuevo;
	private PantallaBienvenida windowBienvenida;
	private PantallaOpciones windowOpciones;
	private Jugador jugador;
	private String nombre;
	private Vehiculo auto = new Vehiculo(null, null);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJugadorNuevo window = new PantallaJugadorNuevo();
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
	public PantallaJugadorNuevo() {
		initialize();
		windowJugadorNuevo = this;
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
		
		txtTitulo = new JTextField();
		txtTitulo.setRequestFocusEnabled(false);
		txtTitulo.setBorder(null);
		txtTitulo.setBackground(new Color(255, 255, 255));
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setForeground(new Color(0, 102, 204));
		txtTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		txtTitulo.setEditable(false);
		txtTitulo.setText("Ingrese su nombre");
		txtTitulo.setBounds(10, 49, 414, 29);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO 
				// Guardar jugador con persistencia
				nombre = campoNombre.getText();// + "\n"; 
				jugador = new Jugador(nombre,new Vehiculo(null, null));
				windowOpciones = new PantallaOpciones(jugador);
				frame.dispose();
			}
		});
		btnGuardar.setActionCommand("GuardarNombre");
		btnGuardar.setBounds(132, 169, 82, 49);
		frame.getContentPane().add(btnGuardar);
		
		campoNombre = new JTextField();
		campoNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				campoNombre.setText("");
			}
		});
		campoNombre.setFont(new Font("Arial", Font.BOLD, 12));
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setBounds(132, 102, 171, 29);
		frame.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		campoNombre.setText("Ingrese su nombre");
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowBienvenida = new PantallaBienvenida();
				frame.dispose();
			}
		});
		btnVolver.setAlignmentX(0.5f);
		btnVolver.setBounds(221, 169, 82, 49);
		frame.getContentPane().add(btnVolver);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{campoNombre, btnGuardar}));
	}
}
