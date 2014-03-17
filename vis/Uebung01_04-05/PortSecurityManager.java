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
    
    // lowest possible port number to compare with.
    private static final int LOW_PORT = 5000;

    /**
     *
     */
    public PortSecurityManager(int listenPort) {
        super();
        checkListen(listenPort);
    }
    
    /**
     *
     */
    @Override
    public void checkListen(int listenPort) {
        if (listenPort < LOW_PORT) {
            throw new SecurityException(
                listenPort + " is below " + LOW_PORT + " and not in valid range.");
        }
    }

    
    @Override
    public void checkAccept(String host, int port) {
        System.out.println("Willkommen " + host + ":" + port + ".\n");
    }
}
