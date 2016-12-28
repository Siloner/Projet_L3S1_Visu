import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by msi on 20/12/2016.
 */
public class FenetreVisualisation extends JFrame{

    private LocalisationArbrePanel localisationArbrePanel;
    private TableauDonnees tableauDonnees;
    private Alerte alerte;
    private ReceptionThread receptionThread;
    private ProtocolManager protocolManager;

    public FenetreVisualisation () {
        super("Visualisation");
        this.localisationArbrePanel = new LocalisationArbrePanel();
        this.alerte = new Alerte();
        this.tableauDonnees = new TableauDonnees(this.alerte);

        this.setSize(700, 400);
        JPanel panGeneral = new JPanel();
        panGeneral.setLayout(new GridLayout(2, 2));
        JButton inscription = new JButton("Inscrir capteur(s)");
        JPanel arbrePan = new JPanel();
        arbrePan.add(localisationArbrePanel.getArbrePanel());
        arbrePan.add(inscription);
        panGeneral.add(arbrePan);

        panGeneral.add(tableauDonnees.getPanGlobal());
        panGeneral.add(alerte.getPanGlobal());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(panGeneral);

        inscription.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }

    public void setProtocolManager(ProtocolManager protocolManager) {
        this.protocolManager = protocolManager;
        this.receptionThread = new ReceptionThread(protocolManager, this.localisationArbrePanel);
        this.receptionThread.start();
    }
}
