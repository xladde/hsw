/**
 * @file    QuadratischeGleichung.java ( GNU GPLv3 )
 * @author  t.j.
 * @version 2013-09
 */

/**
 * @brief   Aufgabe 1-1.
 * Oeffnen Sie BlueJ und legen Sie ein neues Projekt Projekt1 an, fuegen Sie 
 * eine neue Klasse QuadratischeGleichung ein und ersetzen Sie die Vorgaben 
 * durch das Beispiel QuadratischeGleichung. Fuehren Sie das Programm durch 
 * Aufrufen der Methode 'main' aus.
 */
public class QuadratischeGleichung {

    /**
     * @brief  Statische Methode zur Berechnung der Quadratischen Gleichung.
     * @param  p Faktor 'p'.
     * @param  q Summand 'q'.
     * @return Array mit double-Werten, das beide Ergebnisse (positiv/negativ)
     *         beinhaltet.
     */
    public static double[2] solve( double p, double q ) {
        double[] result = new double[2];

        double a = p/(double)2;
        double b = a*a;
        double c = b-q;
        double d = Math.sqrt( c );
        double e = (-1)*a;

        result[0] = e+d;
        result[1] = e-d;

        return result;
    }// end solver

    /**
     * @brief Main-Methode/Programmeinstiegspunkt.
     * @param args Liste mit Argumenten, die beim Programmstart übergeben werden.
     */
    public static void main( String[] args ) {
        // Verwendete Variablen deklarieren und/oder definieren.
        /** 
         * @brief Variable (Arary) zum Speichern des Rechenergebnisses. 
         */
        double[] result;
        /** 
         * @brief Variable (Array), die zwei Standart-Werte fuer die Rechnung definiert. 
         */
        double[] var = { 2, 3 };        
        
        // Werte bestimmen.
        // Falls die Zahl der uebergebenen Parameter beim Aufruf der Main-Methode
        // genau 2 ist, werden die Zeichenketten in Double-Werte umgewandelt.
        // Andernfalls werden zwei vorher festgelegte Werte genommen.
        if( args.length == 2 ) {
            var[0] = Double.parseDouble( args[0] ); // Typumwandlung String->double
            var[1] = Double.parseDouble( args[1] ); // Typumwandlung String->double
        } else {}

        // Berechnung durchfuehren
        result = QuadratischeGleichung.solve( var[0], var[1] );

        // Ausgabe auf dem Bildschirm
        System.out.println(
            "Das Ergebnis der Quadratischen Gleichung fuer p="
            +var[0]
            +" und q="
            +var[1]
            +" ergibt "
            +result[0]
            +" und"
            +result[1]
        );
    } // End Main
} // end class QuadratischeGleichung