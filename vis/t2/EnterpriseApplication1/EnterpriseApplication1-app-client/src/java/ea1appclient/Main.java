
package ea1appclient;

import ea1ejb.*;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author tj
 * @version 2014-05-06
 */
public class Main {

    @EJB
    protected static NewSessionBeanRemote myBean;
    
    public Main(){}
    
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        
        try {
            Properties myProperties = new Properties();
            myProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            InitialContext myInitContext= new InitialContext(myProperties);
            myBean = (NewSessionBeanRemote)myInitContext.lookup("ea1ejb.NewSessionBeanRemote");
            System.out.println("Result:\t" + myBean.addiere(5,6));
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
