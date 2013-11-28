/**
 * 
 */
package hsw.wbs.core;

import org.drools.runtime.StatefulKnowledgeSession;

/**
 * @author tj
 *
 */
public interface ControllerIF {

	public Object fireMessage(Object o, String path);
	public Object fireMessage(Object o, StatefulKnowledgeSession session);
	
}
