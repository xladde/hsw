import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread implements Runnable {

    public static final int PORT_NUMBER = 8045;
    private ServerSocket server;
    public ArrayList<ConnectionThread> connections;

    public ServerThread() {
        try {
            server = new ServerSocket(PORT_NUMBER);
            connections = new ArrayList<ConnectionThread>();
        } catch(Exception e){}
    }

    public void run() {
        try {
            while( true ) {
                Socket s = server.accept();
                if( s != null ) {
                    connections.add(new ConnectionThread(s));
                    //connections.get(connections.size()-1).run();
                }
            }
        } catch(Exception e) {}
    }

    public static void main(String[] args) {
        ServerThread st = new ServerThread();
        st.run();
    }

}