/**
 * @author t.j.
 * @version 2014-04
 */

public class Stelle extends Organisationseinheit {

    /**
     * Instanzvariable, die den Personalaufwand einer Stelle speichert.
     */
    private double personalAufwand;

    /**
     * Konstruktor zur Erzeugung einer Instanz vom Typ Stelle.
     * @param bezeichnung Die Bezeiçhnung der Stelle.
     * @param personalAufwand Der Personalaufwand der Stelle.
     */
    public Stelle(String bezeichnung, double personalAufwand) { 
        super(bezeichnung);
        this.personalAufwand = personalAufwand;
    }

    /**
     * Getter fuer den Personalaufwand.
     * @return Double-Wert des aktuellen Wertes in der Instanzvariablen personalAufwand.
     */
    public double getPersonalAufwand() {
        return this.personalAufwand;
    }

    /**
     * Setter fuer den Personalaufwand.
     * @param personalAufwand neuer Wert fuer den Personalaufwand.
     */
    public void setPersonalAufwand(double personalAufwand) {
        this.personalAufwand = personalAufwand;
    }

    /**
     * Personalaufwand einer Organisationseinheit ermitteln.
     * @retun   Double-Wert des hinterlegten Personalaufwandes
     */
    @Override
    public double ermittlePersonalAufwand() { return getPersonalAufwand(); }
} // end class Stelle