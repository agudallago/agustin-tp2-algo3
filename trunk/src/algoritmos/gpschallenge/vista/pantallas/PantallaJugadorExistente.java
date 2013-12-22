package algoritmos.gpschallenge.vista.pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.JComboBox;

import algoritmos.gpschallenge.control.ControladorPantallas;

public class PantallaJugadorExistente extends PantallaGPSChallenge {

	private JTextField txtTitulo;
	private JButton btnAceptar;
	private JButton btnVolver;
	JComboBox comboBox;
	
	/**
	 * Constructor
	 */
	public PantallaJugadorExistente() {
		super();
		initialize();
		addListeners();
	}

	//M�todo para agregar los listeners de los botones del Frame
	private void addListeners() {
		btnVolver.addActionListener(control.getListenerBtnVolver(this));
		btnAceptar.addActionListener(control.getListenerBtnJugadorExistente(this));
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
		btnAceptar.setBounds(132, 169, 83, 49);
		frame.getContentPane().add(btnAceptar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(132, 89, 171, 29);
		frame.getContentPane().add(comboBox);
		//TODO cargar nombres de jugadores pre-existentes
		
		btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(0.5f);
		btnVolver.setBounds(220, 169, 83, 49);
		frame.getContentPane().add(btnVolver);
	}
	
	public static PantallaJugadorExistente getInstance(){
		if (instance == null) { 
				instance = new PantallaJugadorExistente(); 
				} 
		return (PantallaJugadorExistente) instance; 
	}
	
}
