/**
 * @file Mannschaftsspiel.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

public class Mannschaftsspiel {

    private Mannschaft m1;
    private Mannschaft m2;

    class Ergebnis {
        public Mannschaft m;
        public int punktediff;
        public Ergebnis( Mannschaft m, int diff ) {
            this.m          = m;
            this.punktediff = diff;
        }
    }

    /**
     * @brief Default-Constructor.
     */
    public Mannschaftsspiel() { 
        m1 = null;
        m2 = null;
    } // end Default-Construktor

    /**
     * @brief Standard-Constructor.
     */
    public Mannschaftsspiel( Mannschaft m1, Mannschaft m2 ) {
        this.m1 = m1;
        this.m2 = m2;
    } // end STD-Constructor

    public setMannschaft1( Mannschaft m ) { this.m1 = m; }
    public getMannschaft1()               { return m1; }

    public setMannschaft2( Mannschaft m ) { this.m2 = m; }
    public getMannschaft2()               { return m2; }

    /**
     * @brief Spielalgorithmus.
     */
    private Ergebnis simuliere() { // spielalgorithmus
        Ergebnis e;
        java.util.Random schiri = new java.util.Random();
        int strenght1 = schiri.nextInt( 9 );
        int strenght2 = schiri.nextInt( 9 );
        if( strenght1 > strenght2 ) {         // mannschaft 1 gewinnt
            m1.setPunkte( m1.getPunkte()+3 );
            e = new Ergebnis( this.m1, (strenght1-strenght2) );
        } else if( strenght1 == strenght2 ) { // unentschieden
            m1.setPunkte( m1.getPunkte()+1 );
            m2.setPunkte( m2.getPunkte()+1 );
            e = new Ergebnis( null, 0 );
        } else {                              // manschafft 2 gewinnt
            m2.setPunkte( m2.getPunkte()+3 );
            e = new Ergebnis( this.m2, (strenght2-strenght1) );
        }
    }

    public void simuliereSpiel() {
        Ergebnis e = simuliere();
        System.out.println( 
            "Die Mannschaft "
            +e.m.getName()
            +" gewinnt mit einer Differenz von "
            +e.m.punktediff 
        );
    }
} // end class Mannschaftsspiel