/**
 *
 * @author Javier Delgado Rodriguez
 */

import java.util.Random;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class Animation.
 */
public class Animation {

	/**
	 * To top.
	 *
	 * @param lblTexto the lbl texto
	 * @param lblFrame the lbl frame
	 */
	public void toTop(JLabel lblTexto, JLabel lblFrame) {
		int yLblTexto = lblTexto.getLocation().y;
		try {
			while (lblTexto.getLocation().y > (lblFrame.getHeight() - lblTexto.getHeight())) {
				lblTexto.setLocation(lblTexto.getLocation().x, yLblTexto--);
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * To bottom.
	 *
	 * @param lblTexto the lbl texto
	 * @param lblFrame the lbl frame
	 */
	public void toBottom(JLabel lblTexto, JLabel lblFrame) {
		int yLblTexto = lblTexto.getLocation().y;
		try {
			while (lblTexto.getLocation().y < (lblFrame.getHeight() + lblTexto.getHeight())) {
				lblTexto.setLocation(lblTexto.getLocation().x, yLblTexto++);
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Random int.
	 *
	 * @return the int
	 */
	public int randomInt() {
		Random r = new Random();
		int n;
		do {
			n = r.nextInt(10);
		} while (n == 0);

		return n * 10;
	}

	/**
	 * Random int.
	 *
	 * @param max the max
	 * @return the int
	 */
	public int randomInt(int max) {
		Random r = new Random();
		return r.nextInt(max);
	}
}
