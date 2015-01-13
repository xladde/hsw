
/**
 * Beschreiben Sie hier die Klasse Baum.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class Baum {
  // Instanzvariablen 
  private int inhalt;
  private Baum links;
  private Baum rechts; 

  /**
   * Konstruktor für Objekte der Klasse Baum
   */
  public Baum(Baum links, int zahl, Baum rechts) {
    this.links=links;
    this.rechts=rechts;
    inhalt=zahl;
  } //Baum

  public Baum(int zahl){this(null,zahl,null);}
  // Zugriffsmethoden get und set
  public Baum getLinks(){ return links;}
  public Baum getRechts(){ return rechts;}
  public int getInhalt(){return inhalt;}
  
  public void setLinks(Baum neu) { links=neu;}
  public void setRechts(Baum neu) { rechts=neu;}
  public void setInhalt(int zahl){inhalt=zahl;}

  public int anzahlKnoten(){
    int anz=1;
    if(getLinks()!=null)  anz = anz+getLinks().anzahlKnoten();
    if(getRechts()!=null) anz = anz+getRechts().anzahlKnoten();
    return anz;
  }
  
  public int blaetter(){
    if(getLinks()==null && getRechts()==null) return 1; // Blattknoten
    else{//kein Blatt
      int anz=0;
      if(getLinks()!=null)  anz = anz+getLinks().blaetter();
      if(getRechts()!=null) anz = anz+getRechts().blaetter();
      return anz;
     }//else
  }//blatter
  
} //Baum
