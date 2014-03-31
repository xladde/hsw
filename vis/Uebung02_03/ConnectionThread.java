import java.io.*;
import java.net.*;

public class ConnectionThread implements Runnable {

    private Socket         socket;
    private BufferedReader in;
    private PrintStream    out;

    public ConnectionThread(Socket s) {
        try {
            this.socket = s;
            this.in = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
            this.out = new PrintStream(socket.getOutputStream());
            run();  
        } catch( Exception e ){}
        
    }

    public void run() {
        try {
            String str;
            do {
                str = in.readLine();
                System.out.println( "Client:\t" + str );
                out.println( "Accepted." );
                out.flush();
            } while( str.compareTo("stop") != 0 );

            /* ANNOYING OVERHEAD */
            // close connections and streams
            in.close();
            out.close();
            socket.close();
        } catch(Exception e){}
        
    }

}