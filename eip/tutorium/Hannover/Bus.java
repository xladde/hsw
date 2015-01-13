
/**
 * Beschreiben Sie hier die Klasse Bus.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class Bus extends Fahrzeug{
  // Instanzvariablen 
  private int sitze;

  /**
   * Konstruktor für Objekte der Klasse Bus
   */
  public Bus(int kz, String typ, int anz) {
    super(kz,typ);
    sitze=anz;
  } //Bus
  
  // Zugriffsmethoden get und set
  //public int getX(){ return x;}
  
  //public void setX(int neuX) { x = neuX;}
  
  public String toString(){
    return super.toString()+"  "+sitze+" Sitze";
  } 
 
} //Bus
