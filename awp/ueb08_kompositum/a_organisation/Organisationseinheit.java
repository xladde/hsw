/**
 * @author t.j.
 * @version 2014-04
 */

public class Organisationseinheit {

    /**
     * Instanzvariable bezeichnung.
     * Enthaelt eine Angabe zur Bezeichnung der Orga-Einheit.
     */
    private String bezeichnung;

    /**
     * Konstruktor zur Erezugung einer Instanz vom Typ Organisationseinheit.
     * @param bezeichnung Die Bezeichnung der Organisationseinheit.
     */
    public Organisationseinheit(String bezeichnung) { this.bezeichnung = bezeichnung; }

    /**
     * Default-Konstruktor zur Erezugung einer Instanz vom Typ Organisationseinheit.
     */
    public Organisationseinheit() { this.bezeichnung = null; }


    /**
     * Getter fuer die Bezeichnung.
     * @return Rückgabe der Bezeichnung als String-Objekt.
     */
    public String getBezeichnung() { return this.bezeichnung; }

    /**
     * Setter fuer die Bezeichnung.
     * @param bezeichnung String-Objekt als neue Bezeichnung der Orga-Einheit.
     */
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }

    /**
     * Personalaufwand einer Organisationseinheit ermitteln.
     * @retun   Double-Wert 0, da das Abstrahierende Objekt Organisationseinheit 
     *          ueber keinen Personalaufwand verfügt.
     */
    public double ermittlePersonalAufwand() { return 0; }
}