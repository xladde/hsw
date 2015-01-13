
/**
 * Beschreiben Sie hier die Klasse Fahrzeug.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class Fahrzeug {
  // Instanzvariablen 
  private int kennzeichen;
  private String typ;

  /**
   * Konstruktor für Objekte der Klasse Fahrzeug
   */
  public Fahrzeug(int kz, String typ) {
    kennzeichen=kz;
    this.typ=typ;
  } //Fahrzeug
  
  // Zugriffsmethoden get und set
  public int getKennzeichen(){ return kennzeichen;}
  
  //public void setX(int neuX) { x = neuX;}
  public String toString(){return typ+"  "+kennzeichen;}
  
  
} //Fahrzeug
