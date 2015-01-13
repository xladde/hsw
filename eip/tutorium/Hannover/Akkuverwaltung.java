import java.util.*;
/**
 * Akkuverwaltung: Nutzung von ArrayList (oder array)
 * 
 * @author Uwe Laemmel    
 * @version Datum
 */
public class Akkuverwaltung {
  // Instanzvariablen 
  private ArrayList<Akku> akkus;

  /**
   * Konstruktor für Objekte der Klasse Akkuverwaltung
   */
  public Akkuverwaltung() {
    // Instanzvariable initialisieren
    akkus = new ArrayList<Akku>();
  } //Akkuverwaltung
  
  // Zugriffsmethoden get und set
  public int getAnzahl(){ return akkus.size();}
  
  public void hinzu(Akku neu) { akkus.add(neu);}
  
  public Akku getAkku(int i){
    if(i>=0 && i<getAnzahl()) return akkus.get(i); 
    else return null;
  }//getAkku
  
  public void ausgabe(){
  //hier irgendeine Schleife: for-each ist am einfachsten  
    for( Akku x:akkus) x.ausgabe();
  }//ausgabe
  
} //Akkuverwaltung
