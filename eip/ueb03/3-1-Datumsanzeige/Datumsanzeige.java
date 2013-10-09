/**
 * @file Datumsanzeige.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 3-1.
 * Nehmen Sie sich das Projekt Uhrenanzeige zum Vorbild und entwickeln Sie 
 * eine Datumsanzeige fuer Angaben der Form: 10.09.07. 
 * Vereinfacht gehen wir davon aus, dass alle Monate 30 Tage haben und die 
 * Jahreszahl stets nur zweistellig angegeben wird. Es ist die Klasse 
 * Nummernanzeige OHNE Modifikationen zu verwenden!
 */
public class Datumsanzeige {

    private Nummernanzeige day;
    private Nummernanzeige mon;
    private Nummernanzeige yer;

    /**
     * @brief Defaul-Constructor.
     */
    public Datumsanzeige() {
        day = new Nummernanzeige( 30 );
        mon = new Nummernanzeige( 12 );
        yer = new Nummernanzeige( 99 );
    }

    // UNSAFE! May produce invalid result due to given params and calls in 'Nummernanzeige'
    public void init( int day, int mon, int year ) {
        this.day.setWert( day );
        this.mon.setWert( mon );
        this.yer.setWert( year );
    }

    /**
     * @brief Taktsignal geben.
     * Methode erhoeht den Tageswert um 1.
     */
    public void tick() {
        day.setWert( day.getWert()+1 );
        if( day.getWert() == 0 ) {              // Tageswechsel vollzogen?
            day.setWert( 1 );                   // Wertekorrektur
            mon.setWert( mon.getWert()+1 );     // Monatswert erhöhen
            if( mon.getWert() == 0 ) {          // monatswechsel vollzogen?
                mon.setWert( 1 );               // Wertekorrektur
                yer.setWert( yer.getWert()+1 );
                if( yer.getWert() == 0 ) {      // Jahreswechsel vollzogen?
                    yer.setWert( 1 );
                } else{}
            } else{}
        } else{}
    }

    /**
     * @brief  String-Repraesentation des Datums.
     * @return Objekt vom Typ 'String'.
     * Die Methode ersetzt den Anzeige-String aus dem Uhrenanzeige-Beispiel,
     * arbeitet aber gleich und liefert das selbe Ergebnis.
     */
    public String toString() {
        String str = day.getWert()+"."+mon.getWert()+"."+yer.getWert();
        return str;
    }

} // end class Datumsanzeige