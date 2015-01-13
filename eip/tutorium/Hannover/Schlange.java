

/**
 * Beschreiben Sie hier die Klasse Keller.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class Schlange {
  // Instanzvariablen 
  private Telefon[] kaa;
  private int zk;

  public Schlange(int max) {
    // Instanzvariable initialisieren
    kaa = new Telefon[max];
    zk=0;
  } //Keller
  
  public Schlange(){this(100);}

  public void insert(Telefon neu){
    if(!isFull()){kaa[zk]=neu;zk++;}
  }

  public Telefon first(){
    if(!isEmpty()) return kaa[0];
    else return null;
  }

  public void delete(){  
    if(!isEmpty()){ 
      for(int i=0;i<zk-1;i++) {kaa[i]=kaa[i+1];}
      zk--;
    }
  }
  
  public void delete2(){  
    if(!isEmpty()){ 
      for(int i=1;i<zk;i++) {kaa[i-1]=kaa[i];}
      zk--;
    }
  }
 
  public boolean isFull(){return zk==kaa.length;}
  public boolean isEmpty(){return zk==0;}
  public int length(){return zk;}
} //Schlange
