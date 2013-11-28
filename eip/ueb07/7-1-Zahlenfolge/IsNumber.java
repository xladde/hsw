/**
 * @file IsNumber.java
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 7-1: Zahlenfolge
 * Implementieren Sie eine statische Methode istEineZahl, die für einen 
 * Zeichenketten-Parameter prüft, ob er eine positive ganze Zahl enthält: 
 * Das heißt, die Zeichenkette besteht nur aus Ziffern. Das Ergebnis der 
 * Methode ist ein logischer Wert. Hier einige Eingabe-Ausgabe-Beispiele: 
 * \code
 *      istEineZahl ("2344")   -> true,  
 *      istEineZahl ("004002") -> true,  
 *      istEineZahl ("23a")    -> false,  
 *      istEineZahl ("Fuenf")  -> false. 
 * \endcode
 * Für die Arbeit mit Zeichenketten stehen u.a. folgende Methoden zur Verfügung 
 * (s. API java.lang.String):
 *      - char charAt(int i)    Zeichen an i-ter Position, z.B. z = s1.charAt(2);
 *      - int length()   Länge der Zeichenkette, z.B. anz = s1.length();
 *      - boolean equals(String s1)   Test ob Zeichenketten gleich sind: s1.equals(“tom”);
 * Eine statische Methode wird üblicherweise in einer Klasse definiert, 
 * die nur statische Methoden enthält. Das kann eine ausführbare Klasse sein, 
 * die zusätzlich zur main-Methode eine weitere Methode (statisch) enthält. 
 * Es kann aber auch eine Sammlung statischer Methoden sein, dann spricht man 
 * von einer Bibliotheksklasse. Eine derartige Klasse enthält keine 
 * Instanzvariable sowie keine Konstruktoren.
 */
public class IsNumber {

    public static boolean isNumber(String str) {
    
        boolean number = true;
        char currentCharacter;
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        for(int i = 0; i < str.length(); i++) {
            boolean isInArray = false;
            currentCharacter = str.charAt(i);
            for(char j: numbers) {
                if(j == currentCharacter) isInArray = true;
                else continue;
            }
          
            if(!isInArray){
                number = false;
                break;
            }
        }
        return number;
    }
  
    public static void main(String[] args) {
    
        for(String i:args) {
            if(isNumber(i)) {
                System.out.println(i+"\tis a number.");
            } else {
                System.out.println(i+"\tis not a number.");
            } 
        }
    }
} // end class