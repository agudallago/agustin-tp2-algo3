package algoritmos.gpschallenge.vista.pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;


public class PantallaJugadorNuevo extends PantallaGPSChallenge {

	//private JFrame frame;
	private JTextField txtTitulo;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JTextField campoNombre;

	/**
	 * Constructor
	 */
	public PantallaJugadorNuevo() {
		super();
		initialize();
		addListeners();
	}

	//Método para agregar los listeners de los botones del Frame
	private void addListeners() {
		btnGuardar.addActionListener(control.getListenerBtnGuardar(campoNombre));
		btnVolver.addActionListener(control.getListenerBtnVolver());
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
		btnVolver.setAlignmentX(0.5f);
		btnVolver.setBounds(221, 169, 82, 49);
		frame.getContentPane().add(btnVolver);
	}
	
	public static PantallaJugadorNuevo getInstance(){
		if (instance == null) { 
				instance = new PantallaJugadorNuevo(); 
				} 
		return (PantallaJugadorNuevo) instance; 
	}
	
	public String getCampoNombre () {
		return campoNombre.getText();
	}
	
	public void keyTyped(KeyEvent e) {
        //displayInfo(e, "KEY TYPED: ");
    }
	
}