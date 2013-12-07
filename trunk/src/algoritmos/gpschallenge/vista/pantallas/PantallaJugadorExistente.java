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


public class PantallaJugadorExistente {

	private JFrame frmGpsChallenge;
	private JTextField txtTitulo;
	private JButton btnGuardar;
	private JTextField campoNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJugadorExistente window = new PantallaJugadorExistente();
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
	public PantallaJugadorExistente() {
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
		frmGpsChallenge.setBounds(100, 100, 450, 300);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpsChallenge.getContentPane().setLayout(null);
		
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
		frmGpsChallenge.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("GuardarNombre");
		btnGuardar.setBounds(132, 169, 171, 49);
		frmGpsChallenge.getContentPane().add(btnGuardar);
		
		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Arial", Font.BOLD, 12));
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setBounds(132, 102, 171, 29);
		frmGpsChallenge.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		frmGpsChallenge.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{campoNombre, btnGuardar}));
	}
}
