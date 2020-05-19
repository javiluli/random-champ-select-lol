
/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

/**
 * Class Seleccion es la encargada de seleccionar el campeon aleatorio mediante
 * animaciones que cambian el fondo del JFrame por la imagen del campeon
 * seleccionado.
 */
public class Seleccion implements Runnable {

	/**
	 * Instancia una nueva seleccion.
	 */
	public Seleccion() {
	}

	/** Objeto de la clase Main main */
	Main main;

	/**
	 * Instancia una nueva seleccion.
	 * 
	 * @param main Objeto de la clase Main.
	 */
	public Seleccion(Main main) {
		this.main = main;
	}

	/**
	 * Numero int auxiliar.
	 */
	int n_aux = -1;

	/**
	 * Genera numeros aleatorios sin que el numero anterior sea igual que el nuevo
	 * numero generado.
	 * 
	 * Ejermplo posible: 2,3,2,4,6,4.
	 * 
	 * Ejemplo no posible: 2,2,3,4,4,5,5.
	 *
	 * @param n Posicion en el array para el boton seleccionado
	 * @return true En caso de que ambos numeros sean igual, tanto el numero como el
	 *         anterior a este.
	 */
	public boolean replica(int n) {
		boolean repetir = false;
		if (n_aux == n)
			repetir = true;
		n_aux = n;
		return repetir;
	}

	/**
	 * Lee un direcctorio y almacena en un String[] cada uno de los elementos que se
	 * encuentra en ese directorio.
	 * 
	 * En este caso recibe el directorio con las imagenes de los campeones y
	 * almacena los nombres de los campeones (que es el mismo que el del fichero con
	 * su extension de la imagen) en el Array.
	 *
	 * @param s Hace referencia al direcctorio.
	 * @return un String[] Con los nombres de los ficheros hayados en el
	 *         direcctorio.
	 */
	public String[] listadoFotos(String s) {
		File file = new File(s);
		String[] lista = file.list();
		return lista;
	}

	/**
	 * Modifica un String el cual sera recibido por parametro, dicho string es el
	 * mismo que el nombre que recibe una imagen de un campeon (incluida su
	 * extension de imagen).
	 * 
	 * <p>
	 * Cambios que se realizan.
	 * </p>
	 * <ol>
	 * <li>Desde el inicio del strin recibido hasta un punto, tanto el punto como lo
	 * que esta despues es eliminado.</li>
	 * <li>Cambia un "_" por un espacio en blanco " ".</li>
	 * <li>Cambia un "#" por un apostrofo ingles " ' ".</li>
	 * <li>Cambia un "&" por un punto ".".</li>
	 * </ol>
	 *
	 * 
	 * @param s Un String el cual se quiera modificar.
	 */
	public void textoNombreCampeon(String s) {
		// #1.
		s = s.substring(0, s.indexOf(".")).toUpperCase().trim();
		// #2.
		s = s.substring(0).replace("_", " ");
		// #3.
		s = s.substring(0).replace("#", "'");
		// #4.
		s = s.substring(0).replace("&", ".");
		main.getLblNombreChamp().setText(s);
	}

	@Override
	public void run() {
		main.setCambiarLinea(true);
		Animacion.toBottom(main.getLblNombreChamp(), main.getLblFotos());
		String[] nombreFotos = listadoFotos(main.getDIRECCION_CARPETA_FOTOS());

		if (main.isUso_fichero())
			try {
				File file = new File(main.getDireccion_fichero());
				nombreFotos = Ficheros.leerFichero(file);
			} catch (IOException e) {}

		int n = 0, m = Animacion.randomInt();
		for (int i = 0; i < m; i++) {
			do {
				n = Animacion.randomInt(nombreFotos.length);
			} while (replica(n));
			main.getLblFotos().setIcon(new ImageIcon(main.getDIRECCION_CARPETA_FOTOS() + nombreFotos[n]));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
		}
		textoNombreCampeon(nombreFotos[n]);
		main.setCambiarLinea(false);
		Animacion.toTop(main.getLblNombreChamp(), main.getLblFotos());
	}
}
