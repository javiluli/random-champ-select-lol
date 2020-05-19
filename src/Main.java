
/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {
	private JFrame frame;
	private JLabel lblBackground = new JLabel();
	private JLabel lblNombreChamp = new JLabel();
	private final JButton btnCambiar = new JButton();
	private final JButton btnTop = new JButton();
	private final JButton btnMid = new JButton();
	private final JButton btnJungle = new JButton();
	private final JButton btnAdc = new JButton();
	private final JButton btnSupport = new JButton();
	private final JButton btnAll = new JButton();
	private final JButton btnGithub = new JButton();
	private final JButton btnCodepen = new JButton();

	// =================================================================
	// Rutas de los ficherosn y carpetas.
	private final String DIRECCION_CARPETA_FOTOS = "data\\images\\champs\\";
	private final String FICHERO_CHAMPS_TOP = "data\\ficheros\\top.txt";
	private final String FICHERO_CHAMPS_MID = "data\\ficheros\\mid.txt";
	private final String FICHERO_CHAMPS_JUNGLE = "data\\ficheros\\jungle.txt";
	private final String FICHERO_CHAMPS_ADC = "data\\ficheros\\adc.txt";
	private final String FICHERO_CHAMPS_SUPPORT = "data\\ficheros\\support.txt";
	private String aux_direccion_fichero;

	// =================================================================
	/*
	 * Evita la seleccion de otra linea minetras se ejecuta una seleccion, asi se
	 * evita mezclar lineas y capeones.
	 */
	private boolean cambiarLinea = false;

	/*
	 * Permite saber al programa si debe leer un fichero para generar la eleccion de
	 * campeon.
	 */
	private boolean uso_fichero = false;

	public static void main(String[] args) {
		Main window = new Main();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
					btnRandom(window);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicacion principal.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Permite la llamada a la clase Seleccion mediante el uso de un Thread que
	 * funciona a la par que el JFrame.
	 *
	 * @param main la ventana generada por JFrame
	 */
	public static void btnRandom(Main main) {
		main.btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seleccion seleccion = new Seleccion(main);
				Thread th = new Thread(seleccion);
				th.start();
			}
		});
	}

	/**
	 * Inicializacion del JFrame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Random champ selection");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("data\\images\\icons\\icon.jpg"));
		frame.setBounds(100, 100, 486, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// =================================================================
		// Label con el nombre del campeon
		getLblNombreChamp().setText("GG!");
		getLblNombreChamp().setForeground(new Color(248, 248, 255));
		getLblNombreChamp().setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		getLblNombreChamp().setHorizontalAlignment(SwingConstants.RIGHT);
		getLblNombreChamp().setBounds(230, 230, 240, 40);
		frame.getContentPane().add(getLblNombreChamp());

		// =================================================================
		// Boton para la seleccion de campeon aleatortio
		btnCambiar.setIcon(new ImageIcon("data\\images\\icons\\icon_dado.png"));
		btnCambiar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCambiar.setBackground(new Color(255, 255, 255, 0));
		btnCambiar.setBounds(10, 11, 28, 28);
		frame.getContentPane().add(btnCambiar);

		// =================================================================
		// Seleccion de campeones Top-Lines
		btnTop.setIcon(new ImageIcon("data\\images\\icons\\top.jpg"));
		btnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCambiarLinea()) {
					setUso_fichero(true);
					setDireccion_fichero(FICHERO_CHAMPS_TOP);
				}
			}
		});
		btnTop.setBounds(10, 44, 28, 28);
		frame.getContentPane().add(btnTop);

		// Seleccion de campeones Mid-Lines
		btnMid.setIcon(new ImageIcon("data\\images\\icons\\mid.jpg"));
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCambiarLinea()) {
					setUso_fichero(true);
					setDireccion_fichero(FICHERO_CHAMPS_MID);
				}
			}
		});
		btnMid.setBounds(10, 77, 28, 28);
		frame.getContentPane().add(btnMid);

		// Seleccion de campeones Jungles
		btnJungle.setIcon(new ImageIcon("data\\images\\icons\\jungler.jpg"));
		btnJungle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCambiarLinea()) {
					setUso_fichero(true);
					setDireccion_fichero(FICHERO_CHAMPS_JUNGLE);
				}
			}
		});
		btnJungle.setBounds(10, 110, 28, 28);
		frame.getContentPane().add(btnJungle);

		// Seleccion de campeones ADC-Bot
		btnAdc.setIcon(new ImageIcon("data\\images\\icons\\adc.jpg"));
		btnAdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCambiarLinea()) {
					setUso_fichero(true);
					setDireccion_fichero(FICHERO_CHAMPS_ADC);
				}
			}
		});
		btnAdc.setBounds(10, 143, 28, 28);
		frame.getContentPane().add(btnAdc);

		// Seleccion de campeones Support-Bot
		btnSupport.setIcon(new ImageIcon("data\\images\\icons\\support.jpg"));
		btnSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCambiarLinea()) {
					setUso_fichero(true);
					setDireccion_fichero(FICHERO_CHAMPS_SUPPORT);
				}
			}
		});
		btnSupport.setBounds(10, 176, 28, 28);
		frame.getContentPane().add(btnSupport);

		// Seleccion de todos los campeones
		btnAll.setIcon(new ImageIcon("data\\images\\icons\\all.jpg"));
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isCambiarLinea())
					setUso_fichero(false);
			}
		});
		btnAll.setBounds(10, 209, 28, 28);
		btnAll.setBackground(new Color(255, 255, 255, 0));
		frame.getContentPane().add(btnAll);

		// =================================================================
		// Botonoes para redes sociales

		// Boton para acceso a GitHub
		btnGithub.setIcon(new ImageIcon("data\\images\\icons\\github.jpg"));
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social.redes(Social.GITHUB);
			}
		});
		btnGithub.setBounds(405, 11, 27, 27);
		frame.getContentPane().add(btnCodepen);

		// Boton para acceso a CodePen
		btnCodepen.setIcon(new ImageIcon("data\\images\\icons\\codepen.jpg"));
		btnCodepen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social.redes(Social.CODEPEN);
			}
		});
		btnCodepen.setBounds(442, 11, 28, 28);
		frame.getContentPane().add(btnGithub);

		// =================================================================
		// Foto del campeon que aparece cuando se genera la seleccion
		getLblFotos().setIcon(new ImageIcon("data\\images\\portada\\portada.jpg"));
		getLblFotos().setBounds(0, 0, 480, 270);
		frame.getContentPane().add(getLblFotos());
	}

	public boolean isCambiarLinea() {
		return cambiarLinea;
	}

	public void setCambiarLinea(boolean cambiarLinea) {
		this.cambiarLinea = cambiarLinea;
	}

	public JLabel getLblFotos() {
		return lblBackground;
	}

	public JLabel getLblNombreChamp() {
		return lblNombreChamp;
	}

	public String getDireccion_fichero() {
		return aux_direccion_fichero;
	}

	public void setDireccion_fichero(String direccion_fichero) {
		this.aux_direccion_fichero = direccion_fichero;
	}

	public boolean isUso_fichero() {
		return uso_fichero;
	}

	public void setUso_fichero(boolean uso_fichero) {
		this.uso_fichero = uso_fichero;
	}

	public String getDIRECCION_CARPETA_FOTOS() {
		return DIRECCION_CARPETA_FOTOS;
	}
}
