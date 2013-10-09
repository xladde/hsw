public class Baugruppe extends Komponente {

  private ArrayList<Komponente> komponenten;

  public Baugruppe() {
    setBezeichnung(new String());
    setKomponenten(new ArrayList()); 
  }

  public Baugruppe(String bezeichnung) {
    setBezeichnung(bezeichnung);
    setKomponenten(new ArrayList());  
  }

  public Baugruppe(String bezeichnung, ArrayList<Komponente> k) {
    setBezeichnung(bezeichnung);
    setKomponenten(k); 
  }

  public ArrayList<Komponente> getKomponenten() { return this.komponenten; }
  public void setKomponenten(ArrayList<Komponente> k) { this.komponenten = k; }

  @Override
  public double getPreis() {
    double summe = 0;
    for(Komponente k: komponenten) { summe += k.getPreis(); }
    return summe;
  }

}