
/**
 * Beschreiben Sie hier die Klasse LKW.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class LKW extends Fahrzeug{
  // Instanzvariablen 
  private int tonnage;

  public LKW(int kz, String typ,int tonnage) {
    super(kz,typ);
    this.tonnage=tonnage;
  } //LKW
  
  // Zugriffsmethoden get und set
  //public int getX(){ return x;}
  
  //public void setX(int neuX) { x = neuX;}
  public String toString(){
    return super.toString()+ " Zuladung "+tonnage;
  }
  
} //LKW
