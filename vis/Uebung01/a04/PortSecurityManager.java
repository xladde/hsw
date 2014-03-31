/** 
 * @authort.j.
 * @version 2014-03
 */
public class PortSecurityManager extends SecurityManager {
    
    // lowest possible port number to compare with.
    private static final int LOW_PORT = 5000;

    /**
     * Constructor.
     * @param listenPort Integer value representing the port of the
     * incomming connection. 
     */
    public PortSecurityManager(int listenPort) {
        super();
        checkListen(listenPort);
    }
    
    /**
     * Validate connection.
     * @param listenPort Integer value representing the port of the
     * incomming connection.
     */
    @Override
    public void checkListen(int listenPort) {
        if (listenPort < LOW_PORT) {
            throw new SecurityException(
                listenPort + " is below " + LOW_PORT + " and not in valid range.");
        }
    }

    /**
     * if accepted ...
     * This method is needed for a stable handshake
     * @param host URL/IP comming in...
     * @param port Integer value representing the port of the
     * incomming connection.
     */
    @Override
    public void checkAccept(String host, int port) {
        System.out.println("Willkommen " + host + ":" + port + ".\n");
    }
}
