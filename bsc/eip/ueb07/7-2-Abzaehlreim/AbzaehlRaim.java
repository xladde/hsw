/**
 * @file Abzaehlreim.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 7-2: Abzaehlreim.
 * Entwickeln Sie eine statische Methode zum Ermitteln des Siegers bei einem 
 * Abzählen. Die Methode bekommt die Informationen Kinderanzahl sowie die 
 * Anzahl der Silben des Abzählreims übergeben. Das Ergebnis ist eine Zahl, 
 * die sagt, welches Kind gewinnt (übrig bleibt). Das Abzählen beginnt immer 
 * mit dem ersten Kind. 
 * Der Aufruf der Methode abzaehlen(12,9) (12 Kinder und 9 Silben im Reim) 
 * müsste das Ergebnis 2 liefern.
 * Hinweise: Man verwende ein Array in der Methode, in dem für jedes Kind 
 * gespeichert ist, ob es noch „drin“ ist oder schon abgezählt wurde. 
 * Mit kleiner Reimanzahl (1 oder 2) lässt sich die Methode gut überprüfen. 
 * Bauen Sie ab- bzw. zuschaltbare Zwischenausgaben ein.
 */
public class AbzahelReim
{
    public static void print(boolean[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print("["+ arr[i] +"]\t");
        }
        System.out.print("\n");
    }
    
    
    public static int abzaehlen(int children, int syllables) {
        // Array vorbereiten ...
        boolean[] ch = new boolean[children];
        for(int i = 0; i < children; i++) ch[i] = true;
        
        // startposition des zaehlens festlegen
        int pos = 0;
        int c = children;
        // abzaehlen, bis ein kind übrig bleibt...
        while(c > 0) {   
            print(ch);
            pos = 0;
            for(int s = 0; s < syllables-1; s++) {
                pos++; // zeige auf das nächste kind
                if(pos >= children) {
                    pos = 0; // wenn ende erreicht: beginne von vorn
                }
                if(!ch[pos]) {
                    s--; // setze schleifenzähler zurück
                }
            }
            // verlierer fliegt ...
            ch[pos]=false;
            // ein kind weniger
            c--;
        }
        // letzt bekannte position zurückgeben
        return pos;
    }
}
