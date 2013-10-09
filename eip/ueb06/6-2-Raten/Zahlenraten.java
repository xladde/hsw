/**
 * @file Zahlenraten.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 6-2_ Zahlenraten.
 * Implementieren Sie ein Zahlenraten. Der Nutzer erhält nach Eingabe einer 
 * Zahl die Antwort: Zahl zu groß, Zahl zu klein oder Hurra-Zahl geraten! 
 * Zählen Sie die notwendigen Versuche. Die zu ratende Zahl wird als 
 * Zufallszahl generiert:
 * \code
 *      z = (int) (Math.random()*100);
 * \endcode
 */
public class Zahlenraten {
    
    /**
     * Generiert eine Zufallszahl zwischen 0 und int max.
     * Die Methode endet erst, wenn die zufällige Zahl erraten wurde.
     */
    public static void zahlenRaten(int max){
        LineIO io = new LineIO();
        int rateZahl = (int) (Math.random()*max);
        int eingabe = 0;
        try{
            while((eingabe = io.readInt("Zahl eingeben: ")) != rateZahl){
                if(eingabe < rateZahl) System.out.println("\t\tZu klein.");
                else System.out.println("\t\tZu groß.");
            }
        }catch(Exception e){
            System.out.println("An Error occured.");
        }
        System.out.println("Hurra, Zahl geraten!");
    }

    public static void main(String[] args) {
        zahlenRaten( 100 );
    }

}