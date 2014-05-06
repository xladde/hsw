package pack1;

import javax.ejb.Remote;

/**
 *
 * @author tj
 * @version 2014-05-05
 */
@Remote
public interface ReisebueroRemote {
   
    public void createKunde(Kunde k);
    public Kunde findeKunde(Long pKey);
    
}
