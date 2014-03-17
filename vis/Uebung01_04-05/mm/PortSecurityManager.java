/**
 * Verteilte Systeme, Aufgabe 1.5 Sicherheitsrichtlinie: Das Serverprogramm soll
 * mit Portnummmern kleiner 5000 nicht gestartet werden koennen. Ergaenzen Sie ihr
 * Programm mit einer entsprechenden Sicherheitsrichtlinie, die als
 * SecurityManager-Objekt geladen wird.
 * Diese Klasse erbt vom SecurityManager. 
 * Die Methoden checkListen() und checkAccept() werden ueberschrieben
 * 
 * 
 * @author Michael Mueller
 * @version 19.03.2012
 */
public class PortSecurityManager extends SecurityManager {
	/**
	 * Konstante, die die Portnummer enthaelt, mit welcher die Portnummer des
	 * Servers verglichen wird.
	 */
	private final int COMPARE_PORT = 5000;

	public PortSecurityManager(int listenPort) {
		super();
		checkListen(listenPort);
	}

	/**
	 * Die Methode prueft, ob der uebergebene Port kleiner ist als COMPARE_PORT.
	 * Wenn "ja", dann wird eine SecurityException geworfen.
	 * 
	 * @param listenPort
	 *            (int), der zu ueberpruefende Port.
	 */
	
	public void checkListen(int listenPort) {
		if (listenPort < COMPARE_PORT) {
			throw new SecurityException("Portnummer darf nicht kleiner als "
					+ COMPARE_PORT + " sein.");
		}
	}
	/**
	 * Die Methode reicht nun den Namen/IP des Rechners, welcher eine Verbindung zu dem Socket herstellt
	 * nicht mehr zu einer Ueberpruefung weiter. Folglich sind alle Rechenr berechtigt, eine Verbindung herzustellen.
	 * Dadruch muss keine Veraenderung in der Sicherheitspolice vorgenommen werden.
	 * 
	 */
	public void checkAccept(String host, int port) {
		System.out.println("\nEine Berechtigungsueberpruefung des Clients wird nicht durchgefuehrt (checkAccept).\n");
	}
}
