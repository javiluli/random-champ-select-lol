/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// TODO: Auto-generated Javadoc
/**
 * The Class Social.
 */
public class Social {

	/** The github. */
	final String GITHUB = "https://github.com/javiluli";
	
	/** The codepen. */
	final String CODEPEN = "https://codepen.io/javiluli_js";

	/**
	 * Redes.
	 *
	 * @param url_web the url web
	 */
	public void redes(String url_web) {
		if (Desktop.isDesktopSupported()) {
			Desktop escritorio = Desktop.getDesktop();
			if (escritorio.isSupported(Desktop.Action.BROWSE))
				try {
					URI uir = new URI(url_web);
					escritorio.browse(uir);
				} catch (URISyntaxException | IOException e) {}
		}
	}
}
