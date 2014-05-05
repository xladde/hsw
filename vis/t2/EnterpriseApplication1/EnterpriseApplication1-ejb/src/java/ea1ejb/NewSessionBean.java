/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea1ejb;

import javax.ejb.Stateless;

/**
 *
 * @author wi09045
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote {

    @Override
    public int addiere(int s1, int s2) { return s1+s2; }

    
}
