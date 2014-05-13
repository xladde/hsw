package Course;

import lejos.nxt.NXTRegulatedMotor;

public class SearchThread extends Thread {
	/*
	 * Insanzvariablen
	 */
	//Motoren
	public NXTRegulatedMotor L, R;
	//Thread status
	// true  - Suche aktiv
	// false - Abbruch
	public boolean running = true;

	/*
	 * Klassenkonstanten
	 */
	//Richtung links
	public static final int DLEFT = 0;
	//Richtung rechts
	public static final int DRIGHT = 1;
	//Drehweg
	public static final int ANGLE = 360;
	//Drehgeschwindigkeit
	public static final int CURVE_SPEED = 250;

	public SearchThread(NXTRegulatedMotor l, NXTRegulatedMotor r) {
		//Instanzieren der Instanzvariablen
		
		//Zuweisen der Motoren
		this.L = l;
		this.R = r;
		//Deamon-Thread da nicht entscheidend fuer Abbruch
		this.setDaemon(true);
		
		//Kurvengeschwindigkeit setzen
		l.setSpeed(CURVE_SPEED);
		r.setSpeed(CURVE_SPEED);
	}

	/*
	 * Suche einleiten
	 * Parameter:
	 * 				keine
	 * Rückgabe:
	 * 				keine
	 */
	@Override
	public void run() {
		search();
	}

	/*
	 * Suche starten entsprechend der letzten Drehrichtung und der Anfangsdrehweite
	 * Parameter:
	 * 				keine
	 * Rückgabe:
	 * 				keine
	 */
	private void search() {
		if (BigCourse.last_dir == DLEFT)
			search(L, R, ANGLE);
		else
			search(R, L, ANGLE);
	}

	/*
	 * Drehen in entsprechende Richtung um angegebenen Drehweg
	 * Parameter:
	 * 				m1 			- ein Motor
	 * 				m2 			- der andere Motor
	 * 				tacho_count - Motordrehzahl(bisher gedreht)
	 * Rückgabe:
	 * 				keine
	 */
	private void search(NXTRegulatedMotor m1, NXTRegulatedMotor m2,
			int tacho_count) {
		// TODO Auto-generated method stub
		// Falls Suche nicht beendet werden soll
		if (!running)
			return;
		// Motoren rotieren, durch 'true' im ersten Aufruf erfolgt eine
		// gleichzeitige Rotation
		// Das negative Vorzeichen bei m2 bewirkt die entgegengesetzte Rotation
		m1.rotate(tacho_count, true);
		m2.rotate(-tacho_count);

		// Falls Suche nicht beendet werden soll
		if (!running)
			return;

		// Ändern der letzten Richtung in die sich gedreht wurde
		BigCourse.last_dir = BigCourse.last_dir == DLEFT ? DRIGHT : DLEFT;
		// Vertrauschen der Motoren -> Richtungsändert
		//Vergroessern des Drehwegs
		search(m2, m1, tacho_count + ANGLE);
	}
	

	/*
	 * Suche beeden
	 * Parameter:
	 * 				keine
	 * Rückgabe:
	 * 				keine
	 */
	public void stopSearching() {
		running = false;
	}
}
