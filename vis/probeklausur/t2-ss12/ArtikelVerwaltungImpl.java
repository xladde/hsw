import java.util.*;
import javax.ejb.Stateless;
import javax.persitence.*;

@Stateless
public class ArtikelVerwaltungImpl 
    implements ArtikelVerwaltungInterface {
    
    @PersistentContext
    private EntityManager mgmt;
    
    public ArtikelVerwaltungImpl() {}
    
    @Override
    public void speichern(Lagerartikel l) {mgmt.persist(l);}
    
    @Override
    public List finde() {  
        Query q = mgmt.createQuery("select art from Lagerartikel art where art.Bestand < art.Mindestbestand");
        q.setMaxResults(10);
        q.setFirstResult(0);
        return q.getResultList();
    }
}