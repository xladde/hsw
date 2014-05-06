package ea1ejb;

import javax.ejb.Stateless;

/**
 *
 * @author tj
 * @version 2014-05-06
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote {

    @Override
    public int addiere(int s1, int s2) { return s1+s2; }

    
}
