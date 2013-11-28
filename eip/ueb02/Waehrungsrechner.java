/**
 * @brief   Uebungsaufgabe Nr. 2-1
 * @author  t.j.
 * @version 2013-09
 * 
 * Legen Sie ein neues Projekt Waehrung an und entwickeln Sie eine Klasse 
 * Waehrungsrechner. Ein Objekt der Klasse Waehrungsrechner ist in der Lage, 
 * Umrechnungen von Euro in eine Fremdwährung und umgekehrt vorzunehmen. 
 * Beantworten Sie dazu die folgenden Fragen:
 * >> Welches Datenfeld wird benötigt?
 * >> Welcher Datentyp ist dazu erforderlich?
 * >> Wie sieht der Konstruktor aus?
 * >> Wie wird das Datenfeld initialisiert?
 * >> Wie arbeitet die Methode zum Umrechnen?
 */
public class Waehrungsrechner {

    private String waehrung1, waehrung2;
    private double kurs;

    /**
     * @brief Default Constructor
     * @param waehrung1 Name of first currency.
     * @param waehrung2 Name of second currency.
     * @param kurs conversion factor from 'waehrung1' to 'waehrung2'.
     */
    public Waehrungsrechner( String waehrung1, 
                             String waehrung2, 
                             double kurs ) {
        this.waehrung1 = waehrung1;
        this.waehrung2 = waehrung2;
        this.kurs      = kurs;
    }

    // ----------------------------------------------------- SETTER AND GETTER
    public void setWaehrung1( String waehrung1 ) { this.waehrung1 = waehrung1; }
    public String getWaehrung1() { return this.waehrung1; }

    public void setWaehrung2( String waehrung2 ) { this.waehrung2 = waehrung2; }
    public String getWaehrung2() { return this.waehrung2; }

    public void setKurs( double kurs ) { this.kurs = kurs; }
    public double getKurs() { return this.waehrung1; }

    // --------------------------------------------------------------- METHODS
    /**
     * @brief Conversion from 'waehrung2' to 'waehrung1'.
     * @param waehrung2 Value of second currency.
     * @return Corresponding value of first currency. 
     */
    public double getWaehrung1Kurs( double waehrung2 ) {
        return ( waehrung2/kurs );
    }

    /**
     * @brief Conversion from 'waehrung1' to 'waehrung1'.
     * @param waehrung1 Value of first currency.
     * @return Corresponding value of second currency. 
     */
    public double getWaehrung2Kurs( double waehrung1 ) {
        return ( waehrung1*kurs );
    }


    /**
     * NESTED MAIN-FUNCTION
     */
    public static void main(String[] args) {
        Waehrungsrechner w1 = new Waehrungsrechner("EUR", "USD", 1.2);
        Waehrungsrechner w2 = new Waehrungsrechner("EUR", "PLN", 3.7);

        System.out.println("1 EUR sind "+w1.getWaehrung2Kurs(1)+" USD.");
        System.out.println("1 USD sind "+w1.getWaehrung1Kurs(1)+" EUR.");
        
        System.out.println("1 EUR sind "+w2.getWaehrung2Kurs(1)+" PLN.");
        System.out.println("1 PLN sind "+w2.getWaehrung1Kurs(1)+" EUR.");
    }
}