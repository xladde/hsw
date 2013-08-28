import java.util.*;

public class Telefonbuch {
    private ArrayList<Mitarbeiter> liste;

    public Telefonbuch() {
        liste = new ArrayList<Mitarbeiter>();
    }
    
    public Telefonbuch(ArrayList<Mitarbeiter> l) {
        liste = l;
    }
    
    public ArrayList<Mitarbeiter> getListe() {
        return liste;
    }
    
    public void setListe(ArrayList<Mitarbeiter> l) {
        liste = l;
    }
    
    // ------------------------------------------------
    
    public void hinzu(Mitarbeiter m) {
        liste.add(m);
    }
    
    public void hinzu(String name, String raum, int nummer) {
        Mitarbeiter m = new Mitarbeiter(name, raum, nummer);
        hinzu(m);
    }
    
    public Mitarbeiter getMitarbeiter(int index) {
        if(index < liste.size()) return liste.get(index);
        else return null;
    }
    
    public void del(int index) {
        if(index < liste.size()) liste.remove(index);
    }
    
    
    public String toString() {
        String str = "[";
        
        for(int i = 0; i < liste.size(); i++) {
            str += getMitarbeiter(i).getName() + "-";
            str += getMitarbeiter(i).getRaum() + "-";
            str += getMitarbeiter(i).getNummer() + "; ";           
        }
        str += "]";
        
        return str;
    }
    
    
    
    
}