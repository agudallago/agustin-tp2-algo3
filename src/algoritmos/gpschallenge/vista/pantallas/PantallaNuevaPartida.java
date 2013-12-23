package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class PantallaNuevaPartida extends PantallaGPSChallenge{

	private JTextField txtBienvenido;
	private JTextField textFieldNombre;
	private JButton btnVolver;
	private JButton btnJugar;	
	/**
	 * @wbp.nonvisual location=212,129
	 */
	//Radio buttons de vehículo
	private JRadioButton rdbtn4x4;
	private JRadioButton rdbtnAuto;
	private JRadioButton rdbtnMoto;
	
	//Radio buttons de Dificultad
	private JRadioButton rdbtnDificil;
	private JRadioButton rdbtnModerado;
	private JRadioButton rdbtnFacil;

	/**
	 * Constructor
	 */
	public PantallaNuevaPartida() {
		super();
		initialize();
		addListeners();
	}

	private void addListeners() {
		btnVolver.addActionListener(control.getListenerBtnVolverAOpciones());
		btnJugar.addActionListener(control.getListenerBtnJugar());
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
		txtBienvenido.setText("Nueva Partida");
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
		//TODO: textFieldNombre.setText(jugador.getNombre());
		frame.getContentPane().add(textFieldNombre);
		
		btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(245, 285, 109, 40);
		frame.getContentPane().add(btnVolver);
		
		rdbtnFacil = new JRadioButton("F\u00E1cil");
		rdbtnFacil.setBackground(Color.WHITE);
		rdbtnFacil.setBounds(90, 111, 109, 23);
		frame.getContentPane().add(rdbtnFacil);
		
		rdbtnModerado = new JRadioButton("Moderado");
		rdbtnModerado.setBackground(Color.WHITE);
		rdbtnModerado.setBounds(90, 165, 109, 23);
		frame.getContentPane().add(rdbtnModerado);
		
		rdbtnDificil = new JRadioButton("Dificil");
		rdbtnDificil.setBackground(Color.WHITE);
		rdbtnDificil.setBounds(90, 217, 109, 23);
		frame.getContentPane().add(rdbtnDificil);
		
		//Agrupo los botones de nivel de dificultad
		ButtonGroup grupoDificultad = new ButtonGroup();
		grupoDificultad.add(rdbtnFacil);
		grupoDificultad.add(rdbtnModerado);
		grupoDificultad.add(rdbtnDificil);
		
		rdbtn4x4 = new JRadioButton("4x4");
		rdbtn4x4.setBackground(Color.WHITE);
		rdbtn4x4.setBounds(245, 217, 109, 23);
		frame.getContentPane().add(rdbtn4x4);
		
		rdbtnAuto = new JRadioButton("Auto");
		rdbtnAuto.setBackground(Color.WHITE);
		rdbtnAuto.setBounds(245, 165, 109, 23);
		frame.getContentPane().add(rdbtnAuto);
		
		rdbtnMoto = new JRadioButton("Moto");
		rdbtnMoto.setBackground(Color.WHITE);
		rdbtnMoto.setBounds(245, 111, 109, 23);
		frame.getContentPane().add(rdbtnMoto);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido}));
		
		//Agrupo los botones de Tipo de Vehiculo
		ButtonGroup grupoVehiculo = new ButtonGroup();
		grupoVehiculo.add(rdbtnMoto);
		grupoVehiculo.add(rdbtnAuto);
		grupoVehiculo.add(rdbtn4x4);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setAlignmentX(0.5f);
		btnJugar.setBounds(90, 285, 109, 40);
		frame.getContentPane().add(btnJugar);
		
	}
	public static PantallaNuevaPartida getInstance(){
		if (instance == null) { 
				instance = new PantallaNuevaPartida(); 
				} 
		return (PantallaNuevaPartida) instance; 
	}
	
}
