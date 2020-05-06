import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Seleccion implements Runnable {
	int numero_anterior = -1;
	Main a;

	public Seleccion() {
	}

	public Seleccion(Main a) {
		this.a = a;
	}

	/**
	 * Permite verificar si el numero anterior generado es el mismo que el actual,
	 * en caso de que lo sea se devolvera un True, en caso de no ser el mismo
	 * devolvera False.
	 *
	 * @param n Posicion en el array para el boton seleccionado
	 * @return true En caso de que ambos numeros sean igual, tanto el numero como el
	 *         anterior a este
	 */
	public boolean replica(int n) {
		boolean repetir = true;

		if (numero_anterior == n)
			repetir = false;

		numero_anterior = n;
		return repetir;
	}

	String direccion_fotos = "data\\images\\img_chaps\\";

	public String[] listadoFotos(String direccion_fotos) {
		File file = new File(direccion_fotos);
		String[] lista = file.list();
		return lista;
	}

	public void cuentaAtras() {
		for (int i = a.cuentaAtras; i > -1; i--) {
			try {
				Thread.sleep(1000);
				a.lblTextoCuentaAtras.setText("Seleccion en " + i);
			} catch (InterruptedException e) {
			}

		}

		try {
			Thread.sleep(1000);
			// Cambiar y quitar del layout
			a.lblTextoCuentaAtras.setText("");
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {

		String[] listado = listadoFotos(direccion_fotos);

		cuentaAtras();

		for (int i = 0; i < 25; i++) {
			int n;
			do {
				Random r = new Random();
				n = r.nextInt(listado.length);
			} while (!replica(n));

			a.lblFotos.setIcon(new ImageIcon(direccion_fotos + listado[n]));

			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
			}
		}
	}
}
