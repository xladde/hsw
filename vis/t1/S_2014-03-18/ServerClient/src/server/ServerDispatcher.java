package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author tj
 */
public class ServerDispatcher {
    
    public static final int             LOW_PORT = 5000;
    
    private final ServerSocket          SOCKET;
    private final int                   PORT;
    
    private final ArrayList<ClientConnection> connections;
    
    protected boolean run_dispatcher;
    
    public ServerDispatcher(int portNumber) throws IOException {
        this.PORT = portNumber;
        
        System.setSecurityManager(new PortSecurityManager(ServerDispatcher.LOW_PORT));
        
        this.SOCKET = new ServerSocket(this.PORT);
        
        this.connections = new ArrayList<>();
        
        this.run_dispatcher = true;
        
        while(run_dispatcher) {
            Socket tmp = SOCKET.accept();
            this.connections.add(new ClientConnection(this, tmp));
            this.connections.get(this.connections.size()-1).run();
        }
        
        for(ClientConnection cc: connections) {
            System.out.println("Stopping:\t" + cc.toString());
        }
    }
    
}
