import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main {

	private JFrame frmEleccionDeCampeon;
	JButton btnCambiar;
	JLabel lblFotos;
	JLabel lblNombreChamp;
	JComboBox comboBox;
	String direccion_fotos = "data\\images\\img_chaps\\";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main window = new Main();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frmEleccionDeCampeon.setVisible(true);
					btnRandom(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEleccionDeCampeon = new JFrame();
		frmEleccionDeCampeon.setResizable(false);
		frmEleccionDeCampeon.setTitle("RCS");
		frmEleccionDeCampeon.setIconImage(Toolkit.getDefaultToolkit().getImage("data\\images\\img_portada\\icon.jpg"));
		frmEleccionDeCampeon.setBounds(100, 100, 276, 439);
		frmEleccionDeCampeon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEleccionDeCampeon.getContentPane().setLayout(null);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" All", " Top", " Mid", " Jungle", " ADC", " Support"}));
		comboBox.setBounds(170, 11, 80, 25);
		frmEleccionDeCampeon.getContentPane().add(comboBox);

		btnCambiar = new JButton("");
		btnCambiar.setIcon(new ImageIcon(
				"C:\\Users\\javid\\eclipse-workspace\\RandomChamp\\data\\images\\img_portada\\icon_dado.png"));
		btnCambiar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCambiar.setBackground(new Color(255, 255, 255, 0));
		btnCambiar.setBounds(10, 11, 25, 25);
		frmEleccionDeCampeon.getContentPane().add(btnCambiar);

		lblNombreChamp = new JLabel("GG!");
		lblNombreChamp.setForeground(Color.WHITE);
		lblNombreChamp.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNombreChamp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreChamp.setBounds(10, 360, 240, 40);
		frmEleccionDeCampeon.getContentPane().add(lblNombreChamp);

		lblFotos = new JLabel("lblImagenesFondo");
		lblFotos.setIcon(new ImageIcon("data\\images\\img_portada\\portada.jpg"));
		lblFotos.setBounds(0, 0, 260, 400);
		frmEleccionDeCampeon.getContentPane().add(lblFotos);
	}

	public static void btnRandom(Main window) {
		ActionListener cambioFondo = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Seleccion seleccion = new Seleccion(window);
				Thread th = new Thread(seleccion);
				th.start();
			}
		};
		window.btnCambiar.addActionListener(cambioFondo);
	}
}
