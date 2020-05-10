import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Ficheros {

	public static String[] leerFichero(String fichero) throws IOException {
		BufferedReader bw = new BufferedReader(new FileReader(fichero));
		Vector<String> vs = new Vector<String>(1, 1);

		while (bw.ready()) {
			String s = bw.readLine();
			vs.add(s);
		}
		bw.close();
		String as[] = new String[vs.size()];

		as = vs.toArray(as);

		return as;
	}

}
