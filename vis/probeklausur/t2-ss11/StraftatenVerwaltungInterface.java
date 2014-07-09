import java.util.List;
import javax.ejb.Remote;

@Remote
public interface StraftatenVerwaltungInterface {
    // Speichern einer Straftat
    public void speichereStraftat(Straftat s);
    
    // finden einer Straftat durch Tatort
    public List<Straftat> sucheStraftat(String tatort);
}// End SessionBean Interface