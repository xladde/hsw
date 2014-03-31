/**
 * @author t.j.
 * @version 2014-03
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread {

    public static final int             PORT_NUMBER = 8045;  
    private ServerSocket                server;
    private int                         counter;
    private boolean                     running;
    private ArrayList<ConnectionThread> connections;

    public ServerThread() {
        try {
            server = new ServerSocket(PORT_NUMBER);
            connections = new ArrayList<ConnectionThread>();
        } catch(Exception e){}
        this.counter = 0;
        this.running = true;
    }

    public void run() {
        try {
            do {
                Socket s = server.accept();
                connections.add( new ConnectionThread(counter++, s, this) );
                connections.get( connections.size()-1 ).start();
                //if( connections.isEmpty() ) { running = false; }
            } while( running );
        } catch(Exception e) {}
    }

    public ArrayList<ConnectionThread> getConnections() {
        return this.connections;
    }

    public static void main(String[] args) {
        ServerThread st = new ServerThread();
        st.run();
    }

}