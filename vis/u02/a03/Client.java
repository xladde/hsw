/**
 * @author t.j.
 * @version 2014-04
 */

public class Client {
    
    public static final String STD_SERVER_NAME = "127.0.0.1";
    public static final int    STD_SERVER_PORT = 8045;


    public static void main(String[] args) {
        String servername;
        int    serverport;
        if( args.length == 2 ) {
            servername = args[0];
            try {
                serverport = Integer.parseInt(args[1]);
            } catch(Exception e){ 
                servername = STD_SERVER_NAME;
                serverport = STD_SERVER_PORT;
            }
        } else {
            servername = STD_SERVER_NAME;
            serverport = STD_SERVER_PORT;
        }
        ClientThread ct = new ClientThread(servername, serverport);
        ct.run();
    }
}