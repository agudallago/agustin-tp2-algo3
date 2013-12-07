package algoritmos.gpschallenge.vista.pantallas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class PantallaNuevaPartida {

	private JFrame frmGpsChallenge;
	private JTextField txtBienvenido;
	private JTextField textFieldNombre;
	private JButton btnVolver;
	/**
	 * @wbp.nonvisual location=212,129
	 */
	private JRadioButton rdbtn4x4;
	private JRadioButton rdbtnAuto;
	private JRadioButton rdbtnMoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaNuevaPartida window = new PantallaNuevaPartida();
					window.frmGpsChallenge.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaNuevaPartida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gaston\\JAVAworkspace\\PruebaMVC\\images\\minicooper64_2.ico"));
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setName("frameBienvenida");
		frmGpsChallenge.getContentPane().setBackground(new Color(255, 255, 255));
		frmGpsChallenge.getContentPane().setForeground(new Color(0, 0, 0));
		frmGpsChallenge.setBounds(100, 100, 450, 389);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpsChallenge.getContentPane().setLayout(null);
		
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
		frmGpsChallenge.getContentPane().add(txtBienvenido);
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
		frmGpsChallenge.getContentPane().add(textFieldNombre);
		
		btnVolver = new JButton("Volver");
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVolver.setBounds(330, 301, 89, 23);
		frmGpsChallenge.getContentPane().add(btnVolver);
		
		JRadioButton rdbtnFacil = new JRadioButton("F\u00E1cil");
		rdbtnFacil.setBounds(53, 111, 109, 23);
		frmGpsChallenge.getContentPane().add(rdbtnFacil);
		
		JRadioButton rdbtnModerado = new JRadioButton("Moderado");
		rdbtnModerado.setBounds(53, 165, 109, 23);
		frmGpsChallenge.getContentPane().add(rdbtnModerado);
		
		JRadioButton rdbtnDificil = new JRadioButton("Dificil");
		rdbtnDificil.setBounds(53, 217, 109, 23);
		frmGpsChallenge.getContentPane().add(rdbtnDificil);
		
		//Agrupo los botones de nivel de dificultad
		ButtonGroup grupoDificultad = new ButtonGroup();
		grupoDificultad.add(rdbtnFacil);
		grupoDificultad.add(rdbtnModerado);
		grupoDificultad.add(rdbtnDificil);
		
		rdbtn4x4 = new JRadioButton("4x4");
		rdbtn4x4.setBounds(245, 217, 109, 23);
		frmGpsChallenge.getContentPane().add(rdbtn4x4);
		
		rdbtnAuto = new JRadioButton("Auto");
		rdbtnAuto.setBounds(245, 165, 109, 23);
		frmGpsChallenge.getContentPane().add(rdbtnAuto);
		
		rdbtnMoto = new JRadioButton("Moto");
		rdbtnMoto.setBounds(245, 111, 109, 23);
		frmGpsChallenge.getContentPane().add(rdbtnMoto);
		frmGpsChallenge.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtBienvenido}));
		
		//Agrupo los botones de Tipo de Vehiculo
		ButtonGroup grupoVehiculo = new ButtonGroup();
		grupoVehiculo.add(rdbtnMoto);
		grupoVehiculo.add(rdbtnAuto);
		grupoVehiculo.add(rdbtn4x4);
		
	}
}
