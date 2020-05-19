
/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.util.Random;

import javax.swing.JLabel;

/**
 * Class Animacion para los JLabel y la generacion de numeros aleatorios.
 */
public class Animacion {

	/**
	 * Permite crear animacion en un JFrame para objetos desde su posicion actual
	 * hacia una posicion elevada o hacia arriba.
	 *
	 * @param lblTexto the lbl texto.
	 * @param lblFrame the lbl frame.
	 */
	public static void toTop(JLabel lblTexto, JLabel lblFrame) {
		int yLblTexto = lblTexto.getLocation().y;
		try {
			while (lblTexto.getLocation().y > (lblFrame.getHeight() - lblTexto.getHeight())) {
				lblTexto.setLocation(lblTexto.getLocation().x, yLblTexto--);
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {}
	}

	/**
	 * Permite crear animacion en un JFrame para objetos desde su posicion actual
	 * hacia una posicion inferior o hacia abajo.
	 *
	 * @param lblTexto the lbl texto.
	 * @param lblFrame the lbl frame.
	 */
	public static void toBottom(JLabel lblTexto, JLabel lblFrame) {
		int yLblTexto = lblTexto.getLocation().y;
		try {
			while (lblTexto.getLocation().y < (lblFrame.getHeight() + lblTexto.getHeight())) {
				lblTexto.setLocation(lblTexto.getLocation().x, yLblTexto++);
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {}
	}

	/**
	 * De inicio genera un numero aleatorio comprendido entre el 0 y el 9, en caso
	 * de ser 0 el numero sera generado de nuevo, por lo que el rango de numeros
	 * generados se esta entre 1 y 9 y este sera multiplicado por 10 para aumentar
	 * el rango.
	 *
	 * @return un int Sera el numero generado de forma aleatoria mulriplicado por
	 *         10.
	 */
	public static int randomInt() {
		Random r = new Random();
		int n = 0;
		for (int i = 0; i < 1000; i++) {
			n = r.nextInt(9) + 1;
		}
		return n * 10;
	}

	/**
	 * Genera un numero aleatorio recibiendo por parametro el numero maximo que
	 * puede retornar.
	 *
	 * @param max El numero maximo que puede retornar la generacion aleatoria.
	 * @return el int retornado es el numero generado de forma aleatoria.
	 */
	public static int randomInt(int max) {
		Random r = new Random();
		return r.nextInt(max);
	}
}
