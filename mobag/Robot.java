import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.Pilot;
import lejos.robotics.navigation.TachoPilot;

/**
 * Die Klasse Robot steuert den Roboter mit Hilfe der Klasse Feld auf dem
 * Spielfeld. Sie basiert auf der im LeJOS-Paket enthalten Klasse TachoPilot und
 * ermöglicht somit die genaue Bewegung auf dem Spielfeld. Weiterhin wird ein
 * Lichtsensor verwendet der überprüft ob der Roboter auf den Spielfeldrand
 * zusteuert der durch einen Schwarzen Bereich gekennzeichnet ist.
 * 
 * @author Paul Weichbrodt, Tom Riske, Tobias Baade
 * @version 10.01.2012
 * 
 */
public class Robot {
	public static final float RADDURCHMESSER = 56;
	public static final float SPURBREITE = 130;
	public static final Motor MOTOR_L = Motor.A;
	public static final Motor MOTOR_R = Motor.B;
	public Pilot pilot;
	public Feld feld;
	public LightSensor lightSensor = new LightSensor(SensorPort.S1);
	public static final int MAX_LIGHT = 400;

	/**
	 * Erzeugt eine Instanz der Klasse Robot.
	 * 
	 * @param rt
	 *            ReciveThread
	 */
	Robot(ReciveThread rt) {
		pilot = new TachoPilot(RADDURCHMESSER, SPURBREITE, MOTOR_L, MOTOR_R);
		pilot.setMoveSpeed(900);
		pilot.setTurnSpeed(300);
		feld = new Feld(rt);
	}

	/**
	 * Fährt zu einem bestimmten Punkt auf dem Feld und beachtet mittels
	 * Lichtsensor ob er dem Rand zu nahe kommt.
	 * 
	 * @param ziel
	 *            Stelle des Zielpunktes im Zielarray.
	 */
	public void fahreZu(int ziel) throws Exception {
		feld.setStatus(Feld.FAEHRT);
		feld.anzeige();
		pilot.rotate(feld.berechneWinkel(ziel));
		while (pilot.isMoving()) {
			Thread.sleep(5);
		}
		pilot.travel(feld.berechneAbstand(ziel), true);
		while (pilot.isMoving()) {
			if (istRand()) {
				pilot.stop();
				pilot.travel(-90);
			} else
				Thread.sleep(1);
		}
		feld.setStatus(Feld.RECHNET);
		feld.anzeige();
		Thread.sleep(750);
		feld.berechneNeueRichtung();
		feld.anzeige();
		feld.aktualisiereKoords();

	}

	/**
	 * Lässt den Roboter vor dem Gegner flüchten.
	 */
	public void weglaufen() throws Exception {
		int neuesZiel = feld.neueZielNr();
		if (neuesZiel != -1)
			fahreZu(neuesZiel);
		else
			feld.aktualisiereGegnerKoords();
	}

	/**
	 * Überprüft ob der Lichtsensor über dem schwarzen Rand ist.
	 * 
	 * @return true - Lichtsensor ist über dem Rand; sonst false
	 */
	public boolean istRand() {
		boolean out = false;
		int lightValue = lightSensor.getNormalizedLightValue();
		if (lightValue <= MAX_LIGHT)
			out = true;
		else
			out = false;
		return out;
	}

}
