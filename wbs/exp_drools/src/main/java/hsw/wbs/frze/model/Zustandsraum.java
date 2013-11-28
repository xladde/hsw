/**
 * 
 */
package hsw.wbs.frze.model;

/**
 * @author tj
 *
 */
public class Zustandsraum {

	public static enum Tageszeit {
		FRUEH, MITTAG, ABEND, NACHT
	}
	
	public static enum Freizeit {
		WENIG, NORMAL, VIEL
	}
	
	public static enum Finanzen {
		KEINE, WENIG, NORMAL, VIEL
	}
	
	public static enum Witterung {
		SONNIG, BEWOELKT, REGEN
	}
	
	public static enum Laune {
		OUTDOOR, INDOOR, SOLO
	}
}
