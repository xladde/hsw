/**
 * @author t.j.
 * @version 2014-03
 */
import java.io.*;
import java.net.*;

public class ConnectionThread extends Thread {

    private Socket         socket;
    private int            id;
    private BufferedReader in;
    private PrintStream    out;
    private ServerThread   srv;

    public ConnectionThread(int id, Socket s, ServerThread srv) {
        try {
            this.srv    = srv;
            this.id     = id;
            this.socket = s;
            this.in     = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
            this.out    = new PrintStream(socket.getOutputStream()); 
        } catch( Exception e ){

        }
        
    }

    public void run() {
        try {
            String str = new String("stop");
            do {
                str = "Client "+this.id+": ";
                str += in.readLine();
                System.out.println( str );
                out.println( "Accepted." );
                out.flush();
            } while( str.compareTo("Client "+this.id+": stop") != 0 );

            /* ANNOYING OVERHEAD */
            // close connections and streams
            in.close();
            out.close();
            socket.close();
            srv.removeConnection( this );
        } catch(Exception e){}
        
    }

}