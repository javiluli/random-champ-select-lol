
/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Class Ficheros se encarga de manipular los ficheros que almacenan informacion
 * necesaria para el programa.
 */
public class Ficheros {

	/**
	 * Lee un fichero linea por lina y almacena cada lineea en un vector que despues
	 * sera convertido en un array.
	 *
	 * @param file el fichero.
	 * @return un string[] con lo almacenado en cada linea del fichero.
	 * @throws IOException Excepciones de tipo IO.
	 */
	public static String[] leerFichero(File file) throws IOException {
		BufferedReader bw = new BufferedReader(new FileReader(file));
		Vector<String> vs = new Vector<String>(1, 1);
		while (bw.ready()) {
			String s = bw.readLine();
			vs.add(s);
		}
		bw.close();
		String as[] = new String[vs.size()];
		return as = vs.toArray(as);
	}
}
