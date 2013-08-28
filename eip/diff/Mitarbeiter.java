public class Mitarbeiter{

    private String name;
    private String raum;
    private int nummer;
    
    public Mitarbeiter(){
        name = new String();
        raum = new String();
    }
    
    public Mitarbeiter(String name, String raum, int n) {
        this.name = name;
        this.raum = raum;
        nummer = n;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRaum() {
        return raum;
    }
    
    public void setRaum(String raum) {
        this.raum = raum;
    }
    
    public int getNummer() {
        return nummer;
    }
    
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}