
import java.util.Random;

import javax.swing.JLabel;

public class Animation {

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

	public int randomInt() {
		Random r = new Random();
		int n;
		do {
			n = r.nextInt(10);
		} while (n == 0);

		return n * 10;
	}

	public int randomInt(int max) {
		Random r = new Random();
		return r.nextInt(max);
	}
}
