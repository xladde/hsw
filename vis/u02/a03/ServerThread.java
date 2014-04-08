/**
 * @author t.j.
 * @version 2014-04
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread {
 
    private ServerSocket                server;
    private int                         counter;
    private int                         portnumber;
    private ArrayList<ConnectionThread> connections;
    private boolean                     running;


    public ServerThread(int portnumber) {
        this.portnumber = portnumber;
        try {
            server = new ServerSocket(portnumber);
        } catch(Exception e){ /* ... */ }
        this.connections = new ArrayList<ConnectionThread>();
        this.counter = 0;
    }

    /**
     *
     */
    @Override
    public void run() {
        this.running = true;
        System.out.println("***\nStarting Server on Port " + this.portnumber +". Waiting for incomming connections.\n***");
        try {
            do {
                Socket s = server.accept();
                this.connections.add( new ConnectionThread(this.counter++, s, this) );
                this.connections.get( this.connections.size()-1 ).start();
                System.out.println("New incomming Connection from "+s.getInetAddress().toString());
            } while( running );
        } catch(Exception e) { /* ... */ }
    }

    public void removeConnection( ConnectionThread ct ) {
        if( this.connections.contains( ct ) ) {
            System.out.println("Removing Client " + ct.getId());
            this.connections.remove( ct );
        }
    }

}