/**
 * @file Dreieck.java
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufg 4-2 Dreiecke (Dreiecksklasse)
 *
 * Entwickeln Sie ein Diagnose-System für Dreiecke. Die Klasse Dreieck soll 
 * als Instanzen-Variablen die drei Seitenlängen verwalten. Eine Methode 
 * bestimmt die Eigenschaft des Dreiecks. Das Ergebnis dieser Methode ist ein 
 * Wert [0..7] mit folgender Bedeutung:
 *  0   : kein Dreieck
 *  1   : rechtwinklig
 *  2   : stumpfwinklig
 *  3   : spitzwinklig
 *  4   : gleichseitig
 *  5   : rechtwinklig und gleichschenklig
 *  6   : stumpfwinklig und gleichschenklig
 *  7   : spitzwinklig und gleichschenklig
 * Für die Bestimmung der Eigenschaften sind keine trigonometrischen 
 * Funktionen notwendig! Erarbeiten Sie zuerst einen Entscheidungsbaum.
 */
public class Dreieck {
    // Instanzvariablen
    private int a;
    private int b;
    private int c;
    
    /**
     * Konstruktor
     */
    public Dreieck(int a, int b, int c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    void setA(int x) {a=x;}
    void setB(int x) {b=x;}
    void setC(int x) {c=x;}
    
    int getA() {return a;}
    int getB() {return b;}
    int getC() {return c;}
    
    
    /**
     * Pruefe, ob Dreieck.
     * Es ist ein Dreieck, wenn die Summe zweier Seiten groesser, oder 
     * gleich der dritten Seite ist.
     */
    public boolean isDreieck() {
        if((a<=b+c)||(b<=a+c)||(c<=a+b)) return true;
        else return false;
    }
    
    /**
     * Pruefe, ob das Dreieck gleichseitig ist.
     * Es ist gleichseitig, wenn alle Seiten gleich lang sind.
     */
    public boolean isGleichseitig() {
        if((a==b)&&(a==c)) return true;
        else return false;
    }
    
    /**
     * Pruefe, ob das Dreieck rechtwinklig ist.
     * Es ist rechtwinklig, wenn der Pythagoras gilt:
     * x^2 = y^2+z^2
     */
    public boolean isRechtwinklig() {
        if(((a*a+b*b)==(c*c))||((b*b+c*c)==(a*a))||((a*a+c*c)==(b*b))) return true;
        else return false;
    }
    
    /**
     * Pruefe, ob das Dreieck gleichschenklig ist.
     * Es ist gleichschenklig, wenn zwei Seiten gleich sind.
     */
    public boolean isGleichschenklig() {
        if(a==b||b==c||a==c) return true;
        else return false;
    }
    
    /**
     * Pruefe, ob das Dreieck stumpfwinklig ist.
     * Ein Dreieck ist stumpfwinklig, wenn die Summe aus den Quadraten zweier
     * Seiten kleiner als das Quadrat der uebrigen Seite ist.
     */
    public boolean isStumpfwinklig() {
        if(((a*a+b*b)<(c*c))||((b*b+c*c)<(a*a))||((a*a+c*c)<(b*b))) return true;
        else return false;
    }
    
    /**
     * Pruefe, ob das Dreieck spitzwinklig ist.
     * Ein Dreieck ist spitzwinklig, wenn die Summe aus den Quadraten zweier
     * Seiten groesser als das Quadrat der uebrigen Seite ist.
     */
    public boolean isSpitzwinklig() {
        if(((a*a+b*b)>(c*c))||((b*b+c*c)>(a*a))||((a*a+c*c)>(b*b))) return true;
        else return false;
    }
    
    /**
     * Gibt eine Integer-Repraesentation fuer das Dreieck aus.
     *      0:   kein Dreieck
     *      1:   rechtwinklig und gleichschenklig
     *      2:   stumpfwinklig und gleichschenklig
     *      3:   spitzwinklig und gleichschenklig
     *      4:   gleichseitig
     *      5:   rechtwinklig
     *      6:   stumpfwinklig
     *      7:   spitzwinklig
     * Intern werden die vorhher defineirten Methoden verwendet.
     */
    public int getCode() {
        if(!isDreieck()) return 0;
        else {
            if(isRechtwinklig()){
                if(isGleichschenklig()) return 1;
                else return 5;
            }
            if(isStumpfwinklig()){
                if(isGleichschenklig()) return 2;
                else return 6;
            }
            if(isSpitzwinklig()){
                if(isGleichschenklig()) return 3;
                else return 7;
            }
            if(isGleichseitig()) return 4;
        }
        return -1;
    }
}

