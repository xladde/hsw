package ea1ejb;

import javax.ejb.Remote;

/**
 *
 * @author tj
 * @version 2014-05-06
 */
@Remote
public interface NewSessionBeanRemote {
    
    public int addiere(int s1, int s2);
    
}
