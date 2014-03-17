/**
 * @author t.j.
 * @version 2014-03
 */

// import classes
import java.io.*;
import java.net.*;

/**
 * Class SimpleServer acts as server in this example.
 * It opens a Socket and waits for an incomming connection.
 * If a client connects the server and the client will exchange messages.
 */
public class SimpleServer {

    // define WI identification as portnumber
    public static final int PORT_NUMBER = 8045;

    // define global Message for clients
    public static final String MESSAGE = "Hello dear client.";

    /**
     * @param args String array with commandline arguments.
     * Main method which is called on program init.
     */
    public static void main(String[] args) {

        ServerSocket        serverSocket; // server socket
        Socket              clientSocket; // socket client connects
        BufferedReader      in;           // receive from client
        PrintStream         out;          // send to client

        // Run in a try-catch-block.
        // Sockets, reading and writing objects can throw various exceptions.
        try {

            // Set security manager to validate the port number of new ServerSockets
            System.setSecurityManager(new PortSecurityManager(PORT_NUMBER));

            // opening a socket on the local sistem (server-side)
            // This socket listens on a specific port for incomming connections.
            serverSocket = new ServerSocket(PORT_NUMBER);

            // wait for a client to connect and open another socket
            clientSocket = serverSocket.accept();

            // Opening an input stream to receive messages from the client.
            // This is done by getting the clients input stream.
            in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()) );

            // Opening an output stream to send messages to the client.
            // This is done by getting the output stream of the client.
            out = new PrintStream(clientSocket.getOutputStream());

            // "Receive" message from client.
            System.out.println( "Client:\t" + in.readLine() );

            // Prepare and "send" message to the client
            out.println( MESSAGE );
            out.flush();


            // reading clients messages until client sends message "stop".
            String str;
            do {
                str = in.readLine();
                System.out.println( "Client:\t" + str );
            } while( str.compareTo("stop") != 0 );

            /* ANNOYING OVERHEAD */
            // close connections and streams
            in.close();
            out.close();
            clientSocket.close();


        } catch(IOException e) {
            // ...
        } catch(SecurityException e) {
            // ...
        } catch(IllegalArgumentException e) {
            // ...
        } catch(Exception  e) {
            // ...
        }
                   
    }    
}