/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea1appclient;

import ea1ejb.*;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;
/**
 *
 * @author wi09045
 */
public class Main {

    @EJB
    protected static NewSessionBeanRemote myBean;
    
    public Main(){}
    
    public static void main(String[] args) {
        
        try {
            Properties myProperties = new Properties();
            myProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            InitialContext myInitContext= new InitialContext(myProperties);
            myBean = (NewSessionBeanRemote)myInitContext.lookup("ea1ejb.NewSessionBeanRemote");
            System.out.println("Result:\t" + myBean.addiere(5,6));
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
