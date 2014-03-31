/**
 * @author t.j.
 * @version 2014-03
 */
public class Konto {
    private double kontostand;
    public Konto(double startbetrag) {
        this.kontostand = startbetrag;
    }

    public void buchung(String name, int tNr, double betrag) {
        System.out.print(tNr + ": " +name + "\t€ " + betrag);
        System.out.print("\tVorher: "+kontostand+"\tNachher: ");
        kontostand += betrag;
        System.out.println(kontostand);
    }
}