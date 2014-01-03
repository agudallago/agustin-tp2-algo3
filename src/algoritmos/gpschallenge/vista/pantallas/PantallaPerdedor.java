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
	private JButton btnVolver;
	private JButton btnJugarOtraVez;
	private JLabel lblTitulo1;
	private JLabel lblTitulo2;
	/**
	 * Constructor
	 */
	public PantallaPerdedor() {
		super();
		initialize();
		addListeners();
	}

	public void addListeners(){
		btnVolver.addActionListener(control.getListenerBtnVolverAOpciones());
		btnJugarOtraVez.addActionListener(control.getListenerBtnNuevaPartida());
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().setLayout(null);
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
		frame.getContentPane().add(textFieldNombre);
		
		btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(231, 275, 171, 49);
		frame.getContentPane().add(btnVolver);
		
		btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.setBounds(30, 275, 171, 49);
		frame.getContentPane().add(btnJugarOtraVez);
		
		lblTitulo1 = new JLabel("\u00A1 PERDISTE !"); 
		lblTitulo1.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitulo1.setForeground(new Color(204, 51, 0));
		lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo1.setBounds(80, 50, 278, 60);
		frame.getContentPane().add(lblTitulo1);
		
		lblTitulo2 = new JLabel("Superaste el máximo de movimientos permitidos");
		lblTitulo2.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitulo2.setForeground(new Color(204, 51, 0));
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setBounds(30, 80, 400, 60);
		frame.getContentPane().add(lblTitulo2);
		
		lblMovimientos = new JLabel("");
		lblMovimientos.setFont(new Font("Arial", Font.BOLD, 12));
		lblMovimientos.setForeground(new Color(0, 0, 0));
		lblMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovimientos.setBounds(30, 100, 400, 100);
		frame.getContentPane().add(lblMovimientos);
		
	}
	
	public static PantallaPerdedor getInstance(){
		if (instance == null) { 
				instance = new PantallaPerdedor(); 
				} 
		return (PantallaPerdedor) instance; 
	}
	
	public void setLblMovimientos(int movimientos){
		String sMovimientos = new String();
		sMovimientos += Integer.toString(movimientos);
		sMovimientos += " fueron los movimientos realizados.";
		lblMovimientos.setText(sMovimientos);
	
	}
}

