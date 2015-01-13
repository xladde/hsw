
/**
 * Beschreiben Sie hier die Klasse Keller.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class Keller {
  // Instanzvariablen 
  private Telefon[] keller;
  private int zk;

  public Keller(int max) {
    // Instanzvariable initialisieren
    keller = new Telefon[max];
    zk=0;
  } //Keller
  
  public Keller(){this(100);}

  public void push(Telefon neu){
    if(!isFull()){keller[zk]=neu;zk++;}
  }

  public Telefon top(){
    if(!isEmpty()) return keller[zk-1];
    else return null;
  }

  public void pop(){  if(!isEmpty()) zk--; }
  
  public boolean isFull(){return zk==keller.length;}
  public boolean isEmpty(){return zk==0;}
  public int depth(){return zk;}

} //Keller
