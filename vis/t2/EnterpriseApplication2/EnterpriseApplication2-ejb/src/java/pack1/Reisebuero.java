package pack1;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

/**
 *
 * @author tj
 * @version 2014-05-05
 */
@Stateless
public class Reisebuero implements ReisebueroRemote {

    @PersistenceContext
    private EntityManager manager;
    
    public Reisebuero() {}
    
    @Override
    public void createKunde(Kunde k) {
        manager.persist(k);
    }

    @Override
    public Kunde findeKunde(Long pKey) {
        return manager.find(Kunde.class, pKey);
    }

}
