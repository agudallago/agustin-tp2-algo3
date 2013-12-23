package algoritmos.gpschallenge.vista.pantallas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import algoritmos.gpschallenge.control.ControladorPantallas;
import algoritmos.gpschallenge.modelo.juego.Jugador;

import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JList;

public class PantallaPuntajes extends PantallaGPSChallenge{

	private JTextField txtBienvenido;
	private JTextField textFieldNombre;
	private JButton btnVolver;
	private Jugador jugador;
	private JList list;	
	
	/**
	 * Constructor
	 */
	public PantallaPuntajes() {
		super();
		initialize();
		addListeners();

	}

	public void addListeners(){
		btnVolver.addActionListener(control.getListenerBtnCerrar());
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
		txtBienvenido.setText("Puntajes");
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
		// TODO: textFieldNombre.setText(jugador.getNombre());
		frame.getContentPane().add(textFieldNombre);
		
		btnVolver = new JButton("Cerrar");
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(330, 301, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(72, 63, 248, 261);
		frame.getContentPane().add(list);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido}));
		
		//TODO cargar Ranking de puntajes
	}
	public static PantallaPuntajes getInstance(){
		if (instance == null) { 
				instance = new PantallaPuntajes(); 
				} 
		return (PantallaPuntajes) instance; 
	}
}
