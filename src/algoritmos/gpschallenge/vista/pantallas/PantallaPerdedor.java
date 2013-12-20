package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class PantallaPerdedor extends PantallaGPSChallenge{

	private JTextField txtBienvenido;
	private JTextField textFieldNombre;
	private JButton btnVolver;
	private JButton btnJugarOtraVez;

	/**
	 * Constructor
	 */
	public PantallaPerdedor() {
		initialize();
		addListeners();
	}

	public void addListeners(){
		btnVolver.addActionListener(control.getListenerBtnVolverAOpciones(this));
		btnJugarOtraVez.addActionListener(control.getListenerBtnNuevaPartida(this));
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
//		textFieldNombre.setText(jugador.getNombre());
		frame.getContentPane().add(textFieldNombre);
		
		btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(231, 275, 171, 49);
		frame.getContentPane().add(btnVolver);
		
		btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.setBounds(30, 275, 171, 49);
		frame.getContentPane().add(btnJugarOtraVez);
		
		JLabel lblGanaste = new JLabel("\u00A1 PERDISTE !");
		lblGanaste.setFont(new Font("Arial", Font.BOLD, 24));
		lblGanaste.setForeground(new Color(204, 51, 0));
		lblGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaste.setBounds(76, 68, 278, 59);
		frame.getContentPane().add(lblGanaste);
	}
}