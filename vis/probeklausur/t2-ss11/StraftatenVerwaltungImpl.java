import java.util.*;
import javax.ejb.Stateless;
import javax.ejb.PersitentContext;
import javax.ejb.EntityManager;
import javax.persitence.Query;

@Stateless
public  class StraftatenVerwaltungImpl 
        implements StraftatenVerwaltungInterface {
    // Interface EntityManager
    @PersistentContext
    private EntityManager mgmt;
    // Konstruktor
    public StraftatenVerwaltungImpl() {}

    @Override
    public void speichereStraftat(Straftat s) {mgmt.persist(s);}
    
    @Override
    public List sucheStraftat(String tatort) {  
        Query q = mgmt.createQuery("select s from Straftat s where s.Tatort=(:var)");
        q.setParameter("var", tatort)
        q.setFirstResult(0);
        return q.getResultList();
    }
}// End SessionBean Implementation