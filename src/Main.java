import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Main {

	private JFrame frmEleccionDeCampeon;
	JButton btnCambiar;
	JLabel lblFotos;
	JLabel lblTextoCuentaAtras;
	int n = 0, cuentaAtras = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main window = new Main();
		Seleccion seleccion = new Seleccion(window);
		Thread th = new Thread(seleccion);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frmEleccionDeCampeon.setVisible(true);
					th.start();
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
//		Seleccion l = new Seleccion();
//		String[] listado = l.listadoFotos(l.direccion_fotos);

		frmEleccionDeCampeon = new JFrame();
		frmEleccionDeCampeon.setTitle("RCS.exe");
		frmEleccionDeCampeon.setIconImage(Toolkit.getDefaultToolkit().getImage("data\\images\\img_portada\\icon.jpg"));
		frmEleccionDeCampeon.setBounds(100, 100, 276, 439);
		frmEleccionDeCampeon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEleccionDeCampeon.getContentPane().setLayout(null);

		lblTextoCuentaAtras = new JLabel("Seleccion en 5");
		lblTextoCuentaAtras.setForeground(Color.WHITE);
		lblTextoCuentaAtras.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTextoCuentaAtras.setBounds(10, 307, 240, 32);
		frmEleccionDeCampeon.getContentPane().add(lblTextoCuentaAtras);

		lblFotos = new JLabel("lblImagenesFondo");
		lblFotos.setIcon(new ImageIcon("data\\images\\img_portada\\portada.jpg"));
		lblFotos.setBounds(0, 0, 260, 400);
		frmEleccionDeCampeon.getContentPane().add(lblFotos);

//		btnCambiar = new JButton("+");
//		btnCambiar.setFont(new Font("Arial", Font.PLAIN, 20));
//		btnCambiar.setBackground(Color.BLACK);
//		btnCambiar.setForeground(Color.WHITE);
//		btnCambiar.setBounds(10, 11, 56, 42);
//		frame.getContentPane().add(btnCambiar);

//		ActionListener cambioFondo = new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				Seleccion seleccion = new Seleccion();
//				seleccion.run();
//				System.out.println("x");
//
//			}
//		};
//		btnCambiar.addActionListener(cambioFondo);
	}
}
