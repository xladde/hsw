/**
 * @file Schicksalszahl.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Schicksalszahl-Klasse
 * @todo: testen und korrigieren.
 */
public class Schicksalszahl {

    /**
     * @brief Quersumme einer Zahl.
     * Bildet rekursiv die Quersumme einer Zahl, solange bis diese einstellig ist.
     * @param number Zahl, aus der die Quersumme gebildet werden soll.
     * @return Einstellige Quersumme der Zahl 'number' und ihrer Quersummen.
     */
    public static int digitSum(int number) {
        int qs=0;
        while( number != 0 ) {
            qs += number%10;
            number = number/10;
        }
        if( qs > 9 ) { qs = quersumme(qs); }
        return qs;
    }

    /**
     * @brief Codieren eines alphanumerischen Zeichens in eine Zahl.
     * Erfolgt nach Vorgabe der Tabelle online.
     * @param letter Zu codierendes Zeichen.
     * @return Code nach Vorgabe der Tabelle.
     */
    public static int letterCode(char letter) {
        switch(letter) {
            case 'a': return 1;
            case 'b': return 2;
            case 'c': return 3;
            case 'd': return 4;
            case 'e': return 5;
            case 'f': return 6;
            case 'g': return 7;
            case 'h': return 8;
            case 'i': return 9;
            case 'j': return 1;
            case 'k': return 2;
            case 'l': return 3;
            case 'm': return 4;
            case 'n': return 5;
            case 'o': return 6;
            case 'p': return 7;
            case 'q': return 8;
            case 'r': return 9;
            case 's': return 1;
            case 't': return 2;
            case 'u': return 3;
            case 'v': return 4;
            case 'w': return 5;
            case 'x': return 6;
            case 'y': return 7;
            case 'z': return 8;
            default: // if not a default character
                try { return Integer.parseInt(letter); }
                catch(NumberFormatException nfe) { return 0; }
                catch(Exception ex)              { return 0; }
        }
    }

    /**
     * @brief errechnet die Schicksalszahl.
     * @bug UNTESTED.
     * @param name Name für die Berechnung.
     * @param date Geburtsdatum.
     * @return Schicksalszahl als Ganzzahliger Wert.
     * Methode berechnet zunächst die einstellige Quersumme aus dem Namen, 
     * dann aus dem Geburtstag und bildet aus der Summe beider die einstellige
     * Quersumme.
     */
    public static int schicksalszahl(String name, String date) {
        int c   = 0;
        int tmp = 0;
        java.util.ArrayList<int> numbers = new java.util.ArrayList<int>(); 
        // converting name
        for(int c = 0; c < name.length  (); c++) {
            if(name.at(c) != ' ') { tmp += letterCode(name.at(c)); }
            else { 
                tmp = digitSum(tmp);
                numbers.add(tmp);
            } 
        }

        // converting date
        tmp = 0;
        for(int c = 0; c < date.length  (); c++) {
            if(date.at(c) != '.') { tmp += letterCode(date.at(c)); }
        }
        tmp = digitSum(tmp);
        numbers.add(tmp);

        // compute
        tmp = 0;
        for(int i: numbers) { tmp += i; }
        return digitSum(tmp);
    }
}