import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by msi on 19/12/2016.
 */
public class Main {
    public static void main (String args []) {
        FenetreVisualisation fenetreVisualisation = new FenetreVisualisation();

        FenetreConnexionIP fenetreConnexionIP = new FenetreConnexionIP(fenetreVisualisation);
        fenetreVisualisation.setFenetreConnexionIP(fenetreConnexionIP);

    }
}
