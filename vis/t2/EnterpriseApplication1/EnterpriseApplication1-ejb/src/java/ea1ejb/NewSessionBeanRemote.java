/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea1ejb;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author wi09045
 */
@Remote
public interface NewSessionBeanRemote {
    public int addiere(int s1, int s2);
}
