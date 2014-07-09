import java.util.*;
import javax.ejb.Remote;

@Remote
public Interface ArtikelVerwaltungInterface {

    public void speichern(Lagerartikel la);

    public ArrayList<Lagerartikel> finde();
}