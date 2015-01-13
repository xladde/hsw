import java.util.*;

/**
 * Beschreiben Sie hier die Klasse Spedition.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class Spedition {
  // Instanzvariablen 
  private ArrayList<Fahrzeug> fuhrpark;

  /**
   * Konstruktor für Objekte der Klasse Spedition
   */
  public Spedition() {
    fuhrpark=new ArrayList<Fahrzeug>();
  } //Spedition
  
  public void hinzu(Fahrzeug neu){fuhrpark.add(neu);}

  public int anzahl(){return fuhrpark.size();}

  public int suche(int kennzeichen){
    int found = -1;
    int index = 0;

    while(index<anzahl() && found == -1){
      Fahrzeug x =fuhrpark.get(index);
      if(kennzeichen == x.getKennzeichen()) 
        found = index; 
      else index++;
    }
    return found;  
  }

 } //Spedition
