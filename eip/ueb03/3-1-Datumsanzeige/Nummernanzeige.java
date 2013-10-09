/**
 * @file Nummernanzeige.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

public class Nummernanzeige {

    private int limit;
    private int wert;

    public Nummernanzeige( int limit ) {
        if( limit < 0 ) { this.limit = 0 }
        else            { this.limit = limit; }
        wert = 0;
    }

    public void setLimit( int limit ) {
        if( limit < 0 ) { this.limit = 0 }
        else            { this.limit = limit; }
    }
    public int getLimit() { return this.limit; }

    public void setWert( int wert ) {
        if( wert < 0 )               { this.wert = 0 } // negativ nicht erlaubt
        else if( wert > this.limit ) { this.wert = wert - limit; } // Ueberhang
        else                         { this.wert = wert; }
    }
    public int getWert() { return this.wert; }
} // end class Nummernanzeige