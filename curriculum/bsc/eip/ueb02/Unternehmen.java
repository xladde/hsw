/**
 * @brief   Uebungsaufgabe Nr. 2-1
 * @author  t.j.
 * @version 2013-08
 *
 * Entwickeln Sie nach dem Modell der Klasse Student aus der Vorlesung eine 
 * Klasse Unternehmen mit den Merkmalen Name, Sitz (Ort), der Anzahl der 
 * Beschäftigten sowie den Jahresumsatz. Erarbeiten Sie einen Konstruktor, 
 * die Zugriffsmethoden (set-/get-) sowie eine Methode, die den Umsatz je 
 * Beschäftigten ermittelt.
 */
public class Unternehmen {

    // --------------------------------------------------- INSTANCE ATTRIBUTES
    private String  name;
    private String  sitz;
    private int     beschaeftigte;
    private double  jahresumsatz;

    // --------------------------------------------------------- INSTANCIATION
    /**
     * @brief Default Constructor.
     * @param n Name of company
     * @param s location of company.
     * @param b number of employees
     * @param j sales per year
     */
    public Unternehmen( String n, String s, int b, double j ) {
            this.name          = n;
            this.sitz          = s;
            this.beschaeftigte = b;
            this.jahresumsatz  = j;
    }

    // ----------------------------------------------------- SETTER AND GETTER 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setSitz( String sitz ) {
        this.sitz = sitz;
    }
    public String getSitz() {
        return this.sitz;
    }

    public void setBeschaeftigte( int beschaeftigte ) {
        this.beschaeftigte = beschaeftigte;
    }
    public int getBeschaeftigte() {
        return this.beschaeftigte;
    }

    public void setJahresUmsatz( double jahresumsatz ) {
        this.jahresumsatz = jahresumsatz
    }
    public double getJahresUmsatz() {
        return this.jahresumsatz;
    }

    // --------------------------------------------------------------- METHODS
    /** 
     * @brief  Jahresumsatz pro Mitarbeiter berechnen.
     * @return Double-Wert, der sich aus Umsatz/Mitarbeiter ergibt.
     */ 
    public double getJahresUmsatzProMitarbeiter() {
        // convert 'this.beschaeftigte' into value of type double
        Integer tmp_i = new Integer( this.beschaeftigte );
        double tmp_d = tmp_i.doubleValue();
        // return calculated value
        return (this.jahresumsatz/tmp_d);
    }
}