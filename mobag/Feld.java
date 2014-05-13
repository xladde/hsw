import lejos.geom.Point;
import lejos.nxt.LCD;
import lejos.robotics.Pose;
import java.lang.Math;

/**
 * Die Klasse Feld hält Informationen über die Position der Roboter auf dem
 * Spielfeld und den aktuellen Status des eigenen Roboters. Außerdem enthält die
 * Klasse die Bereiche in die das Feld eingeteilt ist und die Zielpunkte auf dem
 * Feld. Weiterhin stellt sie Methoden zur Positionsermittlung, Navigation zu
 * Punkten und Zielpunktbestimmung bereit.
 * 
 * @author Paul Weichbrodt, Tom Riske, Tobias Baade
 * @version 10.01.2012
 * 
 */
public class Feld {
	private ReciveThread rt;
	private static final float VERHAELTNIS = 15;
	private static final int[][] ZIEL = { { 13, 68 }, { 34, 40 }, { 58, 68 },
			{ 82, 46 }, { 103, 68 }, { 13, 36 }, { 34, 20 }, { 58, 46 },
			{ 82, 26 }, { 100, 44 }, { 13, 13 }, { 58, 15 }, { 103, 13 } };
	private static final int[][] BEREICH = { { 0, 53, 24, 80 },
			{ 24, 40, 48, 80 }, { 48, 53, 72, 80 }, { 72, 40, 96, 80 },
			{ 96, 53, 120, 80 }, { 0, 26, 24, 53 }, { 24, 0, 48, 40 },
			{ 48, 26, 72, 53 }, { 72, 0, 96, 40 }, { 96, 26, 120, 53 },
			{ 0, 0, 24, 26 }, { 48, 0, 72, 26 }, { 96, 0, 120, 26 } };
	private static int ROBOT_NR = 2;
	public static final int START = 0;
	public static final int STEHT = 1;
	public static final int FAEHRT = 2;
	public static final int RECHNET = 3;
	private Pose eigeneKoord;
	private Point gegnerKoord;
	private int status;
	private int[][] zuordnung;

	/**
	 * Erstellt neue Instanz der Klasse Feld.
	 * 
	 * @param rt
	 *            zu übergebender RecieveThread
	 */
	Feld(ReciveThread rt) {
		this.rt = rt;
		eigeneKoord = new Pose(10, 10, 0);
		gegnerKoord = new Point(110, 70);
		status = 0;
		zuordnung = new int[13][13];
		int[] zuordnung0 = { 4, 4, 4, -1, -1, 12, 12, -1, -1, -1, 12, -1, -1 };
		int[] zuordnung1 = { 10, 4, 4, 12, -1, 11, 12, 12, -1, -1, 12, 12, -1 };
		int[] zuordnung2 = { 10, 10, 0, 12, 12, 10, 10, 12, 12, 12, -1, 10, -1 };
		int[] zuordnung3 = { -1, 10, 10, 0, 12, -1, -1, 10, 10, 11, -1, 10, 10 };
		int[] zuordnung4 = { -1, -1, 10, 10, 0, -1, -1, -1, 10, 10, -1, -1, 10 };
		int[] zuordnung5 = { 4, 4, 4, -1, -1, 12, 12, 12, -1, -1, 12, 12, -1 };
		int[] zuordnung6 = { 4, 4, 4, -1, -1, 0, 12, 4, 4, -1, 0, 12, -1 };
		int[] zuordnung7 = { 10, 0, 0, 4, 12, 10, 10, 10, 12, 12, 0, 12, 4 };
		int[] zuordnung8 = { -1, -1, 0, 0, 0, -1, 0, 0, 10, 2, -1, 0, 4 };
		int[] zuordnung9 = { -1, -1, 0, 0, 0, -1, -1, 10, 10, 10, -1, 10, 10 };
		int[] zuordnung10 = { 4, 4, -1, -1, -1, 4, 12, -1, -1, -1, 12, 12, -1 };
		int[] zuordnung11 = { -1, 4, 4, 0, -1, 3, 0, 4, 4, 2, 0, 0, 4 };
		int[] zuordnung12 = { -1, -1, -1, 0, 0, -1, -1, -1, 0, 0, -1, 10, 0 };
		zuordnung[0] = zuordnung0;
		zuordnung[1] = zuordnung1;
		zuordnung[2] = zuordnung2;
		zuordnung[3] = zuordnung3;
		zuordnung[4] = zuordnung4;
		zuordnung[5] = zuordnung5;
		zuordnung[6] = zuordnung6;
		zuordnung[7] = zuordnung7;
		zuordnung[8] = zuordnung8;
		zuordnung[9] = zuordnung9;
		zuordnung[10] = zuordnung10;
		zuordnung[11] = zuordnung11;
		zuordnung[12] = zuordnung12;
	}

	/**
	 * Überprüft ob der Roboter verbunden ist und erste Koordinaten empfangen
	 * hat.
	 * 
	 * @return true wenn verbunden und Koordinaten empfangen; sonst false
	 */
	public boolean istBereit() {
		boolean result = rt.getStatus() == ReciveThread.CONNECTED
				&& rt.getCount() > 0;
		return result;
	}

	/**
	 * Wartet bis der Roboter still steht und aktualisiert dann die eigenen und
	 * gegnerischen Koordinaten.
	 */
	public void aktualisiereKoords() throws Exception {
		while (getStatus() != STEHT) {
			Thread.sleep(5);
		}
		aktualisiereEigeneKoords();
		aktualisiereGegnerKoords();
	}

	/**
	 * Aktualisiert die gegnerischen Koordinaten.
	 */
	public void aktualisiereGegnerKoords() throws Exception {
		Point p = recGegnerKoord();
		if (p.getX() != 0 && p.getY() != 80)
			gegnerKoord = p;
	}

	/**
	 * Aktualisiert die eigenen Koordinaten.
	 */
	public void aktualisiereEigeneKoords() throws Exception {
		eigeneKoord.setLocation(recEigeneKoord());
	}

	/**
	 * Aktualisiert die eigene Blickrichtung und setzt den status auf stehen.
	 */
	public void berechneNeueRichtung() {
		aktualisiereRichtung();
		setStatus(STEHT);
	}

	/**
	 * Gibt aktuelle Daten des Roboters auf dem LCD aus.
	 */
	public void anzeige() {
		LCD.clear();
		LCD.drawString(toString(), 0, 0);
	}

	/**
	 * Empfängt eigene Koordinaten des Roboters und gibt sie zurück.
	 * 
	 * @return Koordinaten des eigenen Roboters.
	 */
	public Point recEigeneKoord() {
		int x1 = rt.getX1();
		int x2 = rt.getX2();
		int y1 = rt.getY1();
		int y2 = rt.getY2();
		Point p;
		if (ROBOT_NR == 1)
			p = new Point(x1, y1);
		else
			p = new Point(x2, y2);
		return p;
	}

	/**
	 * Empfängt Koordinaten des gegnerischen Roboters und gibt sie zurück.
	 * 
	 * @return Koordinaten des gegnerischen Roboters
	 */
	public Point recGegnerKoord() {
		int x1 = rt.getX1();
		int x2 = rt.getX2();
		int y1 = rt.getY1();
		int y2 = rt.getY2();
		Point p;
		if (ROBOT_NR == 2)
			p = new Point(x1, y1);
		else
			p = new Point(x2, y2);
		return p;
	}

	/**
	 * Berechnet die Blickrichtung des eigenen Roboters aus der letzten Position
	 * und der aktuellen Position des Roboters und gibt sie zurück.
	 * 
	 * @return Bei Veränderung der Position die aktuelle Blickrichtung in Grad;
	 *         sonst 360.
	 */
	public float berechneRichtung() {
		float x1 = eigeneKoord.getX();
		float y1 = eigeneKoord.getY();
		float x2 = (float) recEigeneKoord().getX();
		float y2 = (float) recEigeneKoord().getY();
		float a;
		if ((x1 == x2) && (y1 == y2))
			return 360;
		if (x1 == x2)
			a = 90;
		else
			a = (float) Math.toDegrees(Math.atan((y2 - y1) / (x2 - x1)));
		if (x2 > x1)
			return a;
		else if (y2 >= y1)
			if (y2 > y1)
				return (180 + a);
			else if (x1 > x2)
				return 180;
			else
				return 0;
		else
			return (-180 + a);
	}

	/**
	 * Aktualisiert die Blickrichtung nach einer Bewegung.
	 */
	public void aktualisiereRichtung() {
		float richtung = berechneRichtung();
		if (richtung != 360)
			eigeneKoord.setHeading(richtung);
	}

	/**
	 * Gibt die Kennziffer des aktuellen Status zurück.
	 * 
	 * @return Kennziffer des aktuellen Status.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Setzt den aktuellen Status des Roboters.
	 * 
	 * @param status
	 *            Kennziffer des Status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Berechnet den Abstand zwischen der aktuellen Position des Roboters und
	 * einem Zielpunkt.
	 * 
	 * @param ziel
	 *            Stelle des Zielpunktes im Zielarray.
	 * @return Abstand
	 */
	public float berechneAbstand(int ziel) {
		int[] zielpkt = ZIEL[ziel];
		float koordAbstand = eigeneKoord.distanceTo(new Point(zielpkt[0],
				zielpkt[1]));
		return (koordAbstand * VERHAELTNIS);
	}

	/**
	 * Berechnet den Drehwinkel des Roboters zum Zielpunkt.
	 * 
	 * @param ziel
	 *            Stelle des Zielpunktes im Zielarray.
	 * @return Drehwinkel in Grad.
	 */
	public float berechneWinkel(int ziel) {
		int[] zielpkt = ZIEL[ziel];
		float winkel = eigeneKoord.angleTo(new Point(zielpkt[0], zielpkt[1]))
				- eigeneKoord.getHeading();
		return winkel;
	}

	/**
	 * Gibt die Stelle im Array des Bereichs aus in dem der gegnerische Roboter
	 * steht.
	 * 
	 * @return Stelle des Bereichs im Bereichsarray.
	 */
	public int gegnerBereich() {
		int x = (int) gegnerKoord.getX();
		int y = (int) gegnerKoord.getY();
		int i;
		do {
			i = 0;
			for (int[] feld : BEREICH) {
				if (feld[0] <= x && feld[1] <= y && feld[2] >= x
						&& feld[3] >= y)
					break;
				else
					i++;
			}
		} while (i > 12);
		return i;
	}

	/**
	 * Gibt die Stelle im Array des Bereichs aus in dem der eigene Roboter
	 * steht.
	 * 
	 * @return Stelle des Bereichs im Bereichsarray.
	 */
	public int eigenerBereich() {
		int x = (int) eigeneKoord.getX();
		int y = (int) eigeneKoord.getY();
		int i;
		do {
			i = 0;
			for (int[] feld : BEREICH) {
				if (feld[0] <= x && feld[1] <= y && feld[2] >= x
						&& feld[3] >= y)
					break;
				else
					i++;
			}
		} while (i > 12);
		return i;
	}

	/**
	 * Ausgabe der Felddaten als String.
	 * 
	 * @return Felddaten
	 */
	public String toString() {
		String out = "";
		out += "EKoord: " + eigeneKoord.getX() + "  " + eigeneKoord.getY()
				+ "\n";
		out += "ERichtung:" + eigeneKoord.getHeading() + "\n";
		out += "EFeld:" + eigenerBereich() + "\n";
		out += "GKoord:" + gegnerKoord.getX() + "  " + gegnerKoord.getY()
				+ "\n";
		out += "GFeld:" + gegnerBereich() + "\n";
		out += "Status:" + status;
		return out;
	}

	/**
	 * Ermittelt die Stelle im Zielarray an der die nächste Zielkoordinate
	 * gespeichert ist.
	 * 
	 * @return Stelle im Zielarray; sonst -1 -> stehen bleiben
	 */
	public int neueZielNr() {
		;
		int ziel = zuordnung[gegnerBereich()][eigenerBereich()];
		return ziel;
	}
}
