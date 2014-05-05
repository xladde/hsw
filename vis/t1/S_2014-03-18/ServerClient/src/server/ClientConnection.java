package server;

import java.net.Socket;

/**
 *
 * @author tj
 */
public class ClientConnection implements Runnable {

    private final ServerDispatcher  parent;
    private final Socket            socket;
    
    public ClientConnection(ServerDispatcher parent, Socket socket) {
        this.parent = parent;
        this.socket = socket;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
