/**
 * @author t.j.
 * @version 2014-04
 */

import java.util.ArrayList;

/**
 * @todo Getter/Setter für Instanzvariable orgs.
 * @todo Methode zum Löschen eienr Organisationseinheit aus der ArrayList
 */
public class Abteilung extends Organisationseinheit {

    /**
     * Instanzvariable speichert Organisationseinheiten, die der
     * Abteilung zugehörig sind.
     */
    private ArrayList<Organisationseinheit> orgs;

    /**
     * Konstruktor zur Erzeugung einer Instanz vom Typ Abteilung.
     * @param bezeichnung Die Bezeichnung der Abteilung.
     */
    public Abteilung(String bezeichnung) {
        super(bezeichnung);
        orgs = new ArrayList<Organisationseinheit>();
    }

    /**
     * Organisationseinheit hinzufügen.
     * @param oe Ein Objekt vom Typ Organisationseinheit.
     */
    public void addOrganisationseinheit(Organisationseinheit oe) {
        orgs.add(oe);
    }

    /**
     * Organisationseinheit auslesen.
     * @param Index der auszulesenden Organisationseinheit
     * @return Objekt vom Typ Organisationseinheit.
     * @todo Exceptions abfangen.
     */
    public Organisationseinheit getOrganisationseinheit(int index) {
        try {
            return orgs.get(index);
        } catch(Exception e) { // ArrayIndexOutOfBoundsException // NullPointerException // ...
            return null;
        }
    }

    /**
     * Personalaufwand ermitteln.
     * Iteriert durch die Liste und summiert einzelne Personalausgaben.
     * @return Double-Wert.
     */
    @Override
    public double ermittlePersonalAufwand() {
        double personalAufwand = 0;
        for(Organisationseinheit o: orgs) {
            personalAufwand += o.ermittlePersonalAufwand();
        }
        return personalAufwand;
    }

}