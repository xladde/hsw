import java.util.HashMap;
import java.util.ArrayList;

public class KompFactory {

  private static final String[] STD_BAUTEILE = {
    "Speiche", "Pedal", "Narbe", "Felge", "Mantel", "Schlauch", "Gabel",
    "Rahmen", "Lenkstange", "Frontlicht", "Rücklicht", "Schutzblech",
    "Reflektor", "Dynamo", "Klingel"
  }; 

  private static final double[] STD_PREISE = {
    0.99, 3.45, 10.98, 12.98, 9.99, 7.99, 65.78,
    74.95, 13.95, 3.50, 3.50, 2.50,
    2.50, 7.50, 4.95
  }

  

  private HashMap<String, Double> bT;
  private HashMap<String, ArrayList<String>> bG;

  public KompFactory() {
    bT = new HashMap();
    bG = new HashMap();
  }

  public KompFactory(HashMap<String, Double> bT, HashMap<String, ArrayList<String>> bG) {
    this.bT = bT;
    this.bG = bG;
  }

  public void addBauteil(String bez, double preis) {
    bT.put(new String(bez), new Double(preis));
  }

  public Bauteil getBauteil(String bez) {
    if(bT.containsKey(bez)) {
      return new Bauteil(bez, bT.get(bez));
    } else return null;
  }

  public void removeBauteil(String bez) {
    if(bT.containsKey(bez)) { bT.remove(bez); }
  }

  public void addBaugruppe(String bez, String[] bauteile) {
    bG.put(new String(bez), new ArrayList<String>(bauteile));
  }

  public void addBaugruppe(String bez, ArrayList<String> bauteile) {
    bG.put(new String(bez), new ArrayList<String>(bauteile));
  }

  public Baugruppe getBaugruppe(String bez) {
    if(bG.containsKey(bez)) {
      ArrayList<Komponente> aL = new ArrayList();
      for(String x: bG.get(bez)) {
        if(bT.containsKey(x)) { aL.add(new Bauteil(x, bT.get(x))); }
        else if(bG.containsKey(x)) { 
          Baugruppe b = getBaugruppe(x) 
          if(b != null) { aL.add(b); } 
        }
      }
      return new Baugruppe(bez, aL);
    } else return null;
  }

  public void removeBaugruppe(String bez) {
    if(bG.containsKey(bez)) { bG.remove(bez); }
  }

}