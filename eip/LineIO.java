import java.io.*;
/**
 * Methoden fuer die zeilenweise Ein- und Ausgabe im CMD-Fenster
 * Die Klasse basiert auf einer Arbeit von Otto Rauh: IntIO
 *
 * -- Uwe Laemmel - Aenderungsprotokoll -------------------------
 * <ul>
 * <li>20.01.11  Umbennenung in LineIO um Verwechslung Int ~ Integer zu vermeiden
 *           Methoden der 2. Auflage endgueltig entfernt
 * <li>11.11.07  write/3: Fehler bei Ausgabe von sehr kleinen Werten behoben
 * <li>25.11.03  readChar liefert bei Eingabe von [Enter] ein Leerzeichen
 * <li>25.10.02  Ersetzen von write(double,int,int):
 *         - Beseitigung fehlerhafter Rundung (fuehrte vorher zu ':')
 *         - Zahlen&gt;10^7 bzw. &lt;10^-3 werden nun als Gleitkomma-Zahl
 *           aber korrekt ausgegeben
 * <li>08.10.02  Aufnahme der neuen Bezeichnungen aus Auflage 3:
 *          readTYPE statt promptAndReadTYPE TYPE= Int; Double; String
 * <li>04.09.02  Hinzufuegen von write und writeln fuer char, boolean, Object
 *          write(Object o) fuehrt zu Vereinfachungen in write/3
 * <li>04.09.02  Umformatierungen fuehrt zu kompakterer Darstellung
 * <li>
 * </ul>
 * @author Uwe Laemmel nach einer Idee von Otto Rauh
 * @version 25.11.2022
 */


public class LineIO {

  private BufferedReader keyb;

  /**
   * Es wird ein IO-Objekt erzeugt, an das alle Methoden gesendet werden
   */
  public LineIO() {
    keyb = new BufferedReader(new InputStreamReader(System.in));
  }//IntIO


  /**
   * Ausgabe von einer bestimmten Anzahl von Leerzeilen
   * @param noLines    Anzahl der Leezeilen, die erzeugt werden
   */
  public void emptyLines(int noLines)  { // gibt n Leerzeilen aus
    for(int i=0;i<noLines;i++) writeln();
  }

//-- Ausgabe-Methoden -------------------------------------------
  /**
   * Ausgabe eines Zeichenketten-Wertes ohne Zeilenvorschub
   * @param  string   Zeichenkette, die ausgegeben wird
   */
  public void write  (String  string) {
    System.out.print(string); System.out.flush(); 
  }

  /**
   * Ausgabe eines Zeichen-Wertes ohne Zeilenvorschub
   * @param  character   Zeichen, das ausgegeben wird
   */
  public void write  (char    character) {
    System.out.print(character);
    System.out.flush();
  }
  
  /**
   * Ausgabe eines int-Wertes ohne Zeilenvorschub
   * @param  integer   ganze Zahl, die ausgegeben wird
   */
  public void write  (int     integer) {
    System.out.print(integer); System.out.flush();
  }

  /**
   * Ausgabe eines logischen Wertes ohne Zeilenvorschub
   * @param  bool   logischer Wert, der ausgegeben wird
   */
  public void write  (boolean bool) {
    System.out.print(bool); System.out.flush();
  }

  /**
   * Ausgabe eines beliebigen Objektes ohne Zeilenvorschub
   * Das Objekt wird per toString() in eine Zeichenkette umgewandelt
   * @param  object   , Objekt, das ausgegeben wird.
   */
  public void write  (Object  object) {
    System.out.print(object.toString()); System.out.flush();
  }
  
  /**
   * Ausgabe eines Zeichenketten-Wertes mit Zeilenvorschub
   * @param  string   Zeichenkette, die ausgegeben wird
   */
  public void writeln(String  string) {write(string);writeln(); }

  /**
   * Ausgabe eines Zeichen-Wertes mit Zeilenvorschub
   * @param  character  Zeichen, das ausgegeben wird
   */

  public void writeln(char    character) {write(character);writeln(); }
  /**
   * Ausgabe eines int-Wertes mit Zeilenvorschub
   * @param  integer  ganze Zahl, die ausgegeben wird
   */
  public void writeln(int integer) {write(integer);writeln(); }
  
  /**
   * Ausgabe eines logischen Wertes mit Zeilenvorschub
   * @param  bool   logischer Wert, der ausgegeben wird
   */
  public void writeln(boolean bool) {write(bool);writeln(); }
  
  /**
   * Ausgabe eines Objecktes mit Zeilenvorschub
   * An das Objekt wird die toString-Methode gesendet
   * @param  object   Objekt, das ausgegeben wird
   */

  public void writeln(Object  object) {write(object);writeln(); }

  /**
   * Ausgabe eines Zeilenvorschubs
   */
  public void writeln() {System.out.println(); System.out.flush();}

  /**
   * Ausgabe einer ganzen Zahl ohne Zeilenvorschub:
   * <br>schreibt die ganzez Zahl integer rechtsbuendig in insgesamt 'anzahl'
   * viele Positionen(Zeichen/Spalten)
   * <br>Es werden mehr Positionen verbraucht, wenn das angegebene Format
   * nicht reicht, die Zahl zu fassen
   * @param integer  ganze Zahl, die ausgegeben wird
   * @param anzahl  Anzahl der Spalten, die fuer die Ausgabe benutzt werden
   */
  public void write(int integer, int anzahl)
  {    String s = "" + integer;
    if (s.length()==anzahl) write(integer);
    else
      if (s.length() < anzahl) {
        for (int j=1;j<=(anzahl-s.length());j++)  // vorne
          write(" ");                              // auffuellen
        write(integer);
      }
      else write(integer);       // zu lange Zahl wird nicht beschnitten
  }//write


  /**
   * Ausgabe einer ganzen Zahl MIT Zeilenvorschub:
   * schreibt die ganzez Zahl integer rechtsbuendig in insgesamt 'anzahl'
   * viele Positionen(Zeichen/Spalten)
   * <p>Es werden mehr Positionen verbraucht, wenn das angegebene Format
   * nicht reicht, die Zahl zu fassen
   * @param integer  ganze Zahl, die ausgegeben wird
   * @param anzahl  Anzahl der Spalten, die fuer die Ausgabe benutzt werden
   */
  public void writeln(int integer, int anzahl){
    write(integer, anzahl);
    writeln();
  }
  
  /**
   * Ausgabe einer Festkommazahl ohne Zeilenvorschub:
   * schreibt die Kommazahl value rechtsbuendig in insgesamt noChar viele
   * Spalten (Zeichen/Positionen) mit noFrac Nachkommastellen;
   * verbraucht mehr Spalten, falls die angegebene Zahl der Zeichen
   * nicht ausreicht, die Zahl zu fassen
   * <p>Zur Beschraenkung von write/3 siehe API toString/1 der Klasse Double
   * @param value  ganze Zahl, die ausgegeben wird
   * @param noChar   Anzahl der Spalten, die fuer die Ausgabe benutzt werden
   * @param noFrac   Anzahl der Ziffern nach dem Komma
   */
    public void write(double value, int noChar, int noFrac) {
      boolean low=false; // Zahl < als darstellbar durch toString/1
      boolean neg=false;
      if(value<0.0) neg=true;
      if(Math.abs(value)<1.0E-3) { // bei sehr kleinen werten wird temporaer
          value = neg?value-1:value+1;      // eine 1 addiert, damit toString/1
          low=true;};          // ordentlich arbeitet
      if(noFrac>=0 && noChar>noFrac && Math.abs(value)<1.0E7 ) {
        //-- Runden durch Adddition von 5*10^-(n+1); danach abschneiden
        double kor = 0.5;                      // AnfangsKorrekturwert
        for(int i=0;i<noFrac;i++) kor = kor*0.1;
        System.out.println(kor);
        value = neg?value-kor:value+kor;       // Korrigieren
        System.out.println(value);
        String s = "" + value;
        // Falls sehr kleine (um 1 korrigierte Zahl) --> 0 einsetzen!
        if(low) if(neg) s="-0."+s.substring(3); else s="0."+s.substring(2);
        int pktpos = s.indexOf('.');
        s = s.substring(0,pktpos+noFrac+1);
        for (int j=1; j<=(noChar - s.length());j++) write(" ");
        this.write(s);
      }
      else { // Ausgabe in Gleitpunktdarstellung
        System.out.print(value); System.out.flush();
      }//else

  }//write

  /**
   * Ausgabe einer Festkommazahl MIT Zeilenvorschub:
   * <br>schreibt die Kommazahl value rechtsbuendig in insgesamt noChar viele
   * Spalten (Zeichen/Positionen) mit noFrac Nachkommastellen;
   * verbraucht mehr Spalten, falls die angegebene Zahl der Zeichen
   * nicht ausreicht, die Zahl zu fassen
   * <p>Zur Beschraenkung von write/3 siehe API toString/1 der Klasse Double
   * @param value  ganze Zahl, die ausgegeben wird
   * @param noChar   Anzahl der Spalten, die fuer die Ausgabe benutzt werden
   * @param noFrac   Anzahl der Ziffern nach dem Komma
   */
  public void writeln(double value, int noChar, int noFrac){
    write(value,noChar,noFrac); writeln();
  }
  
//-- Eingabe-Methoden: 3. Auflage -------------------------------
//-- Methoden der 2. Auflage entfernt

 /**
  * Gibt die Aufforderung string aus und liest anschliessend einen vom
  * Benutzer eingegebene Zeichenkette ein;
  * @param  string  Zeichenkette, die ausgegeben wird
  * @return eingegebene Zeichenkette
  */
  public String readString(String string)throws IOException {
    this.write(string);
    return keyb.readLine();
  }

 /**
  * Gibt die Aufforderung string aus und liest anschliessend einen vom
  * Benutzer eingegebene ganze Zahl (int) ein;
  * @param  string   Zeichenkette, die ausgegeben wird
  * @return eingegebene Zahl, Abbruch bei fehlerhafter Eingabe
  */
  public int readInt(String string) throws IOException{
    this.write(string);
    return Integer.parseInt(keyb.readLine());
  }

 /**
  * Gibt die Aufforderung string aus und liest anschliessend ein vom
  * Benutzer eingegebenes Zeichen ein; Wird nur [Enter] gedrueckt, wird ein
  * Leerzeichen zurueck gegeben.
  * @param  string   Zeichenkette, die ausgegeben wird
  * @return eingegebenes Zeichen
  */
  public char readChar(String string)throws IOException{
    this.write(string);
    String inp =keyb.readLine();
    if (inp.length()==0) return ' '; else return inp.charAt(0);
  }//readChar

 /**
  * Gibt die Aufforderung string aus und liest anschliessend ein vom
  * Benutzer eingegebene Zahl ein;
  * @param  string   Zeichenkette, die ausgegeben wird
  * @return eingegebene Zahl
  */
  public double readDouble(String string) throws IOException {
    this.write(string);
    return Double.parseDouble(keyb.readLine());
  }//readDouble

 /**
  * Gibt die Aufforderung string aus und liest anschliessend ein vom
  * Benutzer eingegebene Zahl ein;
  * @param  string   Zeichenkette, die ausgegeben wird
  * @return eingegebene Zahl
  */
  public float readFloat(String string) throws IOException {
    this.write(string);
    return Float.parseFloat(keyb.readLine());
  }//readFloat

}//LineIO
