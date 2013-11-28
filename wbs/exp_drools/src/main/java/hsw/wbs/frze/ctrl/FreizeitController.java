/**
 * 
 */
package hsw.wbs.frze.ctrl;

import hsw.wbs.core.ControllerIF;
import hsw.wbs.core.DroolsTools;
import hsw.wbs.frze.model.FreizeitMessage;
import hsw.wbs.frze.view.DecisionDialog;
import hsw.wbs.frze.view.FreizeitEntscheiderPanel;

import org.drools.runtime.StatefulKnowledgeSession;

/**
 * @author tj
 *
 */
public class FreizeitController implements ControllerIF{

	/**
	 * Container to store various
	 */
	FreizeitEntscheiderPanel tab;
	
	private FreizeitController() {
		tab = new FreizeitEntscheiderPanel(this);
	}
	
	public FreizeitEntscheiderPanel getFreizeitEntscheiderPanel() {
		return this.tab;
	}
	
	@Override
	public Object fireMessage(Object o, String rule) {
		FreizeitMessage message = (FreizeitMessage) o;
		try {
			DroolsTools.fireMessage(message, rule);
			DecisionDialog diag = new DecisionDialog(message.getAktionsArray());
			diag.setVisible(true);
		} catch(Throwable t ){
			System.out.println("X\tCannot fire Message\n\t"+t.getMessage());
		}
		return message;
	}

	@Override
	public Object fireMessage(Object o, StatefulKnowledgeSession session) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static FreizeitEntscheiderPanel getPreparedFreizeitPanel() {
		FreizeitController c = new FreizeitController();
		return c.getFreizeitEntscheiderPanel();
		
	}
}
