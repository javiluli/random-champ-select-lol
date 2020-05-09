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

public class Main {
	boolean b = false;

	private JFrame frmEleccionDeCampeon;
	JButton btnCambiar;
	JLabel lblFotos;
	JLabel lblNombreChamp;
	// =================================================================
	final String DIRECCION_ICON = "data\\images\\img_portada\\icon.jpg";
	final String DIRECCION_ICON_BTN_RANDOM = "data\\images\\img_portada\\icon_dado.png";
	final String DIRECCION_PORTADA = "data\\images\\img_portada\\portada.jpg";
	final String direccion_carpetas_fotos = "data\\images\\img_chaps\\";
	String nombre_carpeta_linea;
	// ruta por defecto
	String direccion_completa = direccion_carpetas_fotos + "all\\";;
	// ====================================
	private JButton btnTop = new JButton("");
	private JButton btnMid = new JButton("");
	private JButton btnJungle = new JButton("");
	private JButton btnAdc = new JButton("");
	private JButton btnSupport = new JButton("");
	private final JButton btnAll = new JButton("");

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
		System.out.println("asd");
		frmEleccionDeCampeon = new JFrame();
		frmEleccionDeCampeon.setResizable(false);
		frmEleccionDeCampeon.setTitle("RCS");
		frmEleccionDeCampeon.setIconImage(Toolkit.getDefaultToolkit().getImage(DIRECCION_ICON));
		frmEleccionDeCampeon.setBounds(100, 100, 266, 429);
		frmEleccionDeCampeon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEleccionDeCampeon.getContentPane().setLayout(null);
		btnTop.setIcon(new ImageIcon("data\\images\\icons\\top.jpg"));

		// =========================================================

		btnTop.setBounds(10, 47, 25, 25);
		frmEleccionDeCampeon.getContentPane().add(btnTop);
		btnTop.setToolTipText("Top line");
		btnMid.setIcon(new ImageIcon("data\\images\\icons\\mid.jpg"));

		btnMid.setBounds(10, 83, 25, 25);
		frmEleccionDeCampeon.getContentPane().add(btnMid);
		btnJungle.setIcon(new ImageIcon("images\\icons\\jungler.jpg"));

		btnJungle.setBounds(10, 119, 25, 25);
		frmEleccionDeCampeon.getContentPane().add(btnJungle);
		btnAdc.setIcon(new ImageIcon("data\\images\\icons\\adc.jpg"));

		btnAdc.setBounds(10, 155, 25, 25);
		frmEleccionDeCampeon.getContentPane().add(btnAdc);
		btnSupport.setIcon(new ImageIcon("data\\images\\icons\\support.jpg"));

		btnSupport.setBounds(10, 191, 25, 25);
		frmEleccionDeCampeon.getContentPane().add(btnSupport);
		btnAll.setIcon(new ImageIcon("data\\images\\icons\\all.jpg"));

		btnAll.setBounds(10, 227, 25, 23);
		frmEleccionDeCampeon.getContentPane().add(btnAll);

		// ===========================================================================

		btnCambiar = new JButton("");
		btnCambiar.setIcon(new ImageIcon(DIRECCION_ICON_BTN_RANDOM));
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
		lblFotos.setIcon(new ImageIcon(DIRECCION_PORTADA));
		lblFotos.setBounds(0, 0, 260, 400);
		frmEleccionDeCampeon.getContentPane().add(lblFotos);

		ActionListener change_folder_top = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (b == false) {
					nombre_carpeta_linea = "top\\";
					direccion_completa = direccion_carpetas_fotos + nombre_carpeta_linea;
				}
			}
		};
		ActionListener change_folder_mid = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (b == false) {
					nombre_carpeta_linea = "mid\\";
					direccion_completa = direccion_carpetas_fotos + nombre_carpeta_linea;
				}
			}
		};
		ActionListener change_folder_jungle = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (b == false) {
					nombre_carpeta_linea = "jungle\\";
					direccion_completa = direccion_carpetas_fotos + nombre_carpeta_linea;
				}
			}
		};
		ActionListener change_folder_adc = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (b == false) {
					nombre_carpeta_linea = "adc\\";
					direccion_completa = direccion_carpetas_fotos + nombre_carpeta_linea;
				}
			}
		};
		ActionListener change_folder_support = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (b == false) {
					nombre_carpeta_linea = "support\\";
					direccion_completa = direccion_carpetas_fotos + nombre_carpeta_linea;
				}
			}
		};

		ActionListener change_folder_all = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				nombre_carpeta_linea = "all\\";
				direccion_completa = direccion_carpetas_fotos + nombre_carpeta_linea;
			}
		};

		btnTop.addActionListener(change_folder_top);
		btnMid.addActionListener(change_folder_mid);
		btnJungle.addActionListener(change_folder_jungle);
		btnAdc.addActionListener(change_folder_adc);
		btnSupport.addActionListener(change_folder_support);
		btnAll.addActionListener(change_folder_all);
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
