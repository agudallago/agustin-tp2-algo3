package algoritmos.gpschallenge.vista.pantallas;
import java.awt.EventQueue;

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

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PantallaJugadorExistente {

	private JFrame frame;
	private JTextField txtTitulo;
	private JButton btnAceptar;
	private PantallaJugadorExistente windowJugadorExistente;
	private PantallaBienvenida windowBienvenida;
	private PantallaOpciones windowOpciones;
	private String nombre;
	private Jugador jugador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJugadorExistente window = new PantallaJugadorExistente();
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
	public PantallaJugadorExistente() {
		initialize();
		windowJugadorExistente = this;
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
		txtTitulo.setText("Elija su usuario");
		txtTitulo.setBounds(10, 31, 414, 29);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO cargar jugador existente
				frame.dispose();
				windowOpciones = new PantallaOpciones(jugador); //Falta enviarle el Jugador como argumento
				
			}
		});
		btnAceptar.setActionCommand("GuardarNombre");
		btnAceptar.setBounds(138, 169, 72, 49);
		frame.getContentPane().add(btnAceptar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 89, 171, 29);
		frame.getContentPane().add(comboBox);
		//TODO cargar nombres de jugadores pre-existentes
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowBienvenida = new PantallaBienvenida();
				frame.dispose();
			}
		});
		button.setAlignmentX(0.5f);
		button.setBounds(231, 169, 72, 49);
		frame.getContentPane().add(button);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnAceptar}));
	}
}
