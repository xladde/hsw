/**
 * 
 */
package hsw.wbs.frze.model;

/**
 * @author tj
 *
 */
public class Decision {

	/**
	 * 
	 */
	public Decision() {
		// TODO Auto-generated constructor stub
	}
	
	public static class FreizeitDecision {
		private Aktionsraum.FreizeitAktion[] aktion;
		
		public FreizeitDecision(Aktionsraum.FreizeitAktion[] aktion) {
			this.setAktion(aktion);
		}
		
		public FreizeitDecision() {
			this.setAktion(null);
		}

		public Aktionsraum.FreizeitAktion[] getAktion() {
			return aktion;
		}

		public void setAktion(Aktionsraum.FreizeitAktion[] aktion) {
			this.aktion = aktion;
		}
	}

}
