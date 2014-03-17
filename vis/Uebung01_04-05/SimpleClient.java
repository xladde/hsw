/**
 * @author t.j.
 * @version 2014-03
 */

import java.io.*;
import java.net.*;

public class SimpleClient {
    
    // define WI identification as portnumber
    public static final int SERVER_PORT = 8045;

    // define WI identification as portnumber
    //public static final int SERVER_NAME = "rothko.wi.hs-wismar.de";
    public static final String SERVER_NAME = "127.0.0.1";

    // define global Message for clients
    public static final String MESSAGE = "Hello dear server.";

    /**
     * @param args String array with commandline arguments.
     * Main method which is called on program init.
     */
    public static void main(String[] args) {
        
        // socket for server connection
        Socket        server;

        // Input stream to read messages from server
        BufferedReader in;

        // Output stream to send messages to server
        PrintStream   out;

        // Run in a try-catch-block.
        // Sockets, reading and writing objects can throw various exceptions.
        try {
            // Open a socket to connect to a server
            // The first argument is the URL/IP-Adress formatted as a String.
            // The second argument is the server side port to connect to.
            server = new Socket(SERVER_NAME, SERVER_PORT);

            // Opening an input stream to receive messages from the client.
            // This is done by getting the clients input stream.
            in = new BufferedReader( new InputStreamReader(server.getInputStream()) );

            // Opening an output stream to send messages to the client.
            // This is done by getting the output stream of the client.
            out = new PrintStream(server.getOutputStream());

            // Prepare and "send" message to the client
            out.println( MESSAGE );
            out.flush();

            // "Receive" message from client.
            System.out.println( "Server:\t" + in.readLine() );

            // read users input and send it to server.
            // stopping if message is "stop".
            String str;
            do {
                Console console = System.console();
                str = console.readLine("Message to server: ");
                out.println(str);
                out.flush();
            } while( str.compareTo("stop") != 0 );


            /* ANNOYING OVERHEAD */
            // close connections and streams
            in.close();
            out.close();
            server.close();


        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
    }    
}