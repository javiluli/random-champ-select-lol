import java.io.File;

import javax.swing.ImageIcon;

public class Seleccion implements Runnable {
	int numero_anterior = -1;

	public Seleccion() {
	}

	Main a;

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

	public String[] listadoFotos(String direccion_fotos) {
		File file = new File(direccion_fotos);
		String[] lista = file.list();
		return lista;
	}

	public void textoNombreCampeon(String s) {
		s = s.substring(0, s.indexOf(".")).toUpperCase(); // Elimina la extension de la foto
		s = s.substring(0).replace("_", " "); // Cambia un "_" por un espacio en blanbo
		s = s.substring(0).replace("#", "'");// Cambia un "#" por un apostrofo ingles
		s = s.substring(0).replace("&", ".");// Cambia un "&" por un punto
		a.lblNombreChamp.setText(s);
	}

	@Override
	public void run() {
		System.out.println(a.b);

		a.b = true;
		Animation an = new Animation();
		an.toBottom(a.lblNombreChamp, a.lblFotos);

		try {
			int n = 0, m = an.randomInt();
			System.out.println(a.direccion_completa);
			String[] listado = listadoFotos(a.direccion_completa);

			for (int i = 0; i < m; i++) {
				n = an.randomInt(listado.length);
				a.lblFotos.setIcon(new ImageIcon(a.direccion_completa + listado[n]));
				Thread.sleep(50);
			}

			textoNombreCampeon(listado[n]);
			a.b = false;
			an.toTop(a.lblNombreChamp, a.lblFotos);
		} catch (InterruptedException ie) {
		}

	}
}
