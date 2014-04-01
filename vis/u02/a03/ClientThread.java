/**
 * @author t.j.
 * @version 2014-04
 */

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {

    public static final int     DEFAULT_PORT    = 8045;
    public static final String  DEFAULT_ADDRESS = "127.0.0.1";

    private int             serverport;
    private String          serveraddress;
    private Socket          socket;
    private BufferedReader  in;
    private PrintStream     out;

    public ClientThread() { construct(DEFAULT_ADDRESS, DEFAULT_PORT); }
    public ClientThread(String serveraddress, int serverport) { construct(serveraddress, serverport); }

    private void construct(String serveraddress, int serverport) {
        this.serveraddress = serveraddress;
        this.serverport = serverport;
        try {
            socket = new Socket(serveraddress, serverport);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
        } catch(Exception e) {} 
    }

    @Override
    public void run() {
        String str = new String("stop");
         
        try {
            do {
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Message:\t");
                str = new String(console.readLine());
                out.println(str);
                out.flush();
                System.out.println( "Answer:\t" + in.readLine() );
            } while( str.compareTo("stop") != 0 );
        } catch(Exception e) { System.out.println("# CONNECTION ERROR"); }
        try {
            in.close();
            out.close();
            socket.close();
        } catch(Exception e) {
            in     = null;
            out    = null;
            socket = null;
        }
    }
}