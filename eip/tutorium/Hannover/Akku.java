
/**
 * Entwickeln Sie eine Klasse „Akku“. 
 * Für einen Akku sind die Nummer(int), die maximale Kapazität 
 * in Stunden(int) sowie der Ladezustand (in Stunden/int) zu verwalten. 
 * Gefordert sind 2 Konstruktoren, sinnvolle Zugriffsmethoden 
 * sowie jeweils eine Methode zum Akku-Laden sowie zum Akku-Nutzen. 
 * Die Methode akkuLaden nutzt einen Parameter, der die Ladezeit in Stunden
 * angibt: Hierbei erzeugt eine Stunde Laden eine Kapazität von 3 Stunden 
 * Nutzungsdauer. 
 * Der Parameter der Methode AkkuNutzen gibt an, 
 * wie lange der Akku genutzt wurde. 
 * Die Parameter sind ganzzahlige Beträge, 
 * ein negativer Akku-Ladestand ist zu verhindern. 
 * Ergänzen Sie eine Ausgabe-Methode
 * 
 * @author Uwe Laemmel    
 * @version 05.01.2015
 */
public class Akku {
  // Instanzvariablen 
  private int nr;
  private int kapazitaet;
  private int zustand;

  /**
   * Konstruktor für Objekte der Klasse Akku
   */
  public Akku(int nummer, int kapazitaet) {
    // Instanzvariable initialisieren
    nr = nummer;
    this.kapazitaet = kapazitaet;
    zustand = 0;  //oder = kapazitaet; beides möglich
  } //Akku
  
  // Zugriffsmethoden get und set
  public int getLadestand() { return zustand;}
  public int getNummer()    { return nr; }
  public int getKapazitaet(){ return kapazitaet;}
  
  public void setNummer(int neu) { nr = neu;}
  // Ladestand darf nicht mit set gesetzt werden, 
  // Kapazitaet wird nachträglich auch nicht geändert;
  // set-Methoden sind nicht notwendig, hängt von der Betrachtung ab
  
  public void akkuLaden(int std){
    zustand += 3*std;
    if(zustand>kapazitaet) zustand=kapazitaet;
  }//akkuLaden  
  
  public void akkuNutzen(int std){
    if(std<zustand) zustand -=std;
    else zustand=0;
  }//akkuNutzen
  
  public void ausgabe(){
    System.out.println(
      "Akku "+nr+", Kapazitaet "+kapazitaet+", Zustand "+zustand);
  }//ausgabe
  
} //Akku
