public class Bauteil extends Komponente {

  private double preis;

  public Bauteil() {
    setBezeichnung(new String());
    setPreis(0);
  }

  public Bauteil(String bezeichnung, double preis) {
    setBezeichnung(bezeichnung);
    setPreis(preis);
  }

  @Override
  public double getPreis() { return this.preis; }
  public void setPreis(double preis) { this.preis = preis; }
}