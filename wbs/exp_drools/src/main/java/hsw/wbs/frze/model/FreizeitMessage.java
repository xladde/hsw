/**
 * 
 */
package hsw.wbs.frze.model;

import hsw.wbs.core.Message;

import java.util.ArrayList;

/**
 * @author tj
 *
 */
public class FreizeitMessage extends Message {

	private Zustandsraum.Finanzen         finanzen;
	private Zustandsraum.Freizeit         freizeit;
	private Zustandsraum.Tageszeit        tageszeit;
	private Zustandsraum.Witterung        wetter;
	private boolean                       windig;
	private ArrayList<Zustandsraum.Laune> launen;
	
	private ArrayList<Aktionsraum.FreizeitAktion> aktionen;
	

	/**
	 * @param state
	 */
	public FreizeitMessage() {
		super();
		launen = new ArrayList<Zustandsraum.Laune>();
		aktionen = new  ArrayList<Aktionsraum.FreizeitAktion>();
		for(Aktionsraum.FreizeitAktion a: Aktionsraum.FreizeitAktion.values()) {
			if(a != null) aktionen.add(a);
		}
	}

	/**
	 * @return the finanzen
	 */
	public Zustandsraum.Finanzen getFinanzen() {
		return finanzen;
	}

	/**
	 * @param finanzen the finanzen to set
	 */
	public void setFinanzen(Zustandsraum.Finanzen finanzen) {
		this.finanzen = finanzen;
	}

	/**
	 * @return the freizeit
	 */
	public Zustandsraum.Freizeit getFreizeit() {
		return freizeit;
	}

	/**
	 * @param freizeit the freizeit to set
	 */
	public void setFreizeit(Zustandsraum.Freizeit freizeit) {
		this.freizeit = freizeit;
	}

	/**
	 * @return the tageszeit
	 */
	public Zustandsraum.Tageszeit getTageszeit() {
		return tageszeit;
	}

	/**
	 * @param tageszeit the tageszeit to set
	 */
	public void setTageszeit(Zustandsraum.Tageszeit tageszeit) {
		this.tageszeit = tageszeit;
	}

	/**
	 * @return the wetter
	 */
	public Zustandsraum.Witterung getWetter() {
		return wetter;
	}

	/**
	 * @param wetter the wetter to set
	 */
	public void setWetter(Zustandsraum.Witterung wetter) {
		this.wetter = wetter;
	}

	/**
	 * @return the launen
	 */
	public ArrayList<Zustandsraum.Laune> getLaunen() {
		return launen;
	}

	/**
	 * @param launen the launen to set
	 */
	public void setLaunen(ArrayList<Zustandsraum.Laune> launen) {
		this.launen = launen;
	}

	/**
	 * @return the windig
	 */
	public boolean isWindig() {
		return windig;
	}

	/**
	 * @param windig the windig to set
	 */
	public void setWindig(boolean windig) {
		this.windig = windig;
	}

	/**
	 * @return the aktionen
	 */
	public ArrayList<Aktionsraum.FreizeitAktion> getAktionen() {
		return aktionen;
	}

	/**
	 * @param aktionen the aktionen to set
	 */
	public void setAktionen(ArrayList<Aktionsraum.FreizeitAktion> aktionen) {
		this.aktionen = aktionen;
	}

	public Aktionsraum.FreizeitAktion[] getAktionsArray() {
		Aktionsraum.FreizeitAktion[] arr = new Aktionsraum.FreizeitAktion[this.aktionen.size()];
		return this.aktionen.toArray(arr);
	}
	
	public boolean isValid() {
		return true;
	}
	
	public boolean strike(Aktionsraum.FreizeitAktion a) {
		if(a != null && this.aktionen.contains(a)) {
			do
			{
				this.aktionen.remove(a);
			} while(this.aktionen.contains(a));
			return true;
		} else return false;
	}
	
	public void strike(Aktionsraum.FreizeitAktion[] arr) {
		if(arr != null) {
			for(Aktionsraum.FreizeitAktion a: arr) {
				strike(a);
			}
		}
	}
	
}
