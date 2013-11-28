/**
 * @file Artikel.java
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 4-1: Festlegung des Steuersatzes (Artikel-Klasse)
 * 
 * Entwickeln Sie eine Klasse Artikel mit den Merkmalen Artikelnummer und 
 * Artikelname, den Notwendigen Zugriffsmethoden und einer Methode zur 
 * Bestimmung des Steuersatzes für den Artikel. 
 * Die Bestimmung des Steuersatze erfolgt gemäß der Folie 9 aus dem Foliensatz 
 * 'Anweisungen und Datentypen'. Erstellen Sie einen Entscheidungsbaum für die
 * Bestimmung des Steuersatzes. Versuchen Sie möglichst wenige Vergleiche 
 * durchzuführen!
 */
public class Artikel {
    private String artikelname;
    private int    artieklnummer;

    /**
     * @brief Default-Constructor
     * @param na Artikelname
     * @param nr Artikelnummer
     */
    public Artikel( String na, int nr ) {
        artikelname   = na;
        artieklnummer = nr;
    }

    // SETTER AND GETTER ---
    public void setArtikelName( String na ) { this.artikelname = na; }
    public String getArtikelName() { return this.artikelname; }

    public void setArtikelNummer( String nr ) { this.artikelnummer = nr; }
    public int getArtikelNummer() { return this.artikelnummer; }

    /**
     * @brief  Ermitteln des Steuersatzes für diesen Artikel.
     * @return Steuersatz als Double zwischen 0 und 1.
     * 
     * Die Methode arbeitet mit einem Switch-Case-Vergleich und ist daher 
     * nicht konform zu der Musteraufgabe aus den Vorlesungen. 
     */
    public double getSteuersatz() {
        double steuersatz;
        switch( artikelnummer ) {
            case 1000: steuersatz = 0.07; break;
            case 1010: steuersatz = 0.07; break;
            case 1020: steuersatz = 0.07; break;
            case 1100: steuersatz = 0.19; break;
            case 2000: steuersatz = 0.07; break;
            case 3100: steuersatz = 0.07; break;
            case 3200: steuersatz = 0.19; break;
            case 4100: steuersatz = 0.00; break;
            case 4200: steuersatz = 0.00; break;
            case 5100: steuersatz = 0.19; break;
            case 5200: steuersatz = 0.19; break;
            default:   steuersatz = 0.19; break; // alle sonstigen
        }
        return steuersatz;
    }
}