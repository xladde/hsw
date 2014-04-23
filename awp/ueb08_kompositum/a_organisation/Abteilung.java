/**
 * @author t.j.
 * @version 2014-04
 */

import java.util.ArrayList;

public class Abteilung extends Organisationseinheit {

    private ArrayList<Organisationseinheit> orgs;

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