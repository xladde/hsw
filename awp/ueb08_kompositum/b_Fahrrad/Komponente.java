public abstract class Komponente {

  String bezeichnung;

  String getBezeichnung() { return bezeichnung; }
  void setBezeichnung(String bez) { bezeichnung = bez; }

  public abstract double getPreis();
}
