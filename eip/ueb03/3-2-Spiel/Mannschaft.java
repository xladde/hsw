/**
 * @file Mannschaft.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

public class Mannschaft {
    private String name;
    private int    spieler; // mindestens 1
    private int    punkte;  // mindestens 0

    /**
     * @brief         Default Constructor.
     * @param name    Name der Mannschaft.
     * @param spieler Anzahl der Spieler.
     */
    public Mannschaft( String name, int spieler ) {
        this.name    = name;
        this.spieler = spieler;
    }

    public void setName( String name ) { this.name = name; }
    public String getName()            { return this.name; }

    public void setPunkte( int punkte ) {
        if( punkte < 0 ) { this.punkte = 0; }
        else { this.punkte = punkte; }
    }
    public int getPunkte() { return this.punkte; }

    public void setSpieler( int spieler ) {
        if( spieler < 1 ) { this.spieler = 1; }
        else { this.spieler = spieler; }
    }
    public int getSpieler() { return this.spieler; }
} // end class Mannschaft