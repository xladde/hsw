/**
 * @author t.j.
 * @version 2014-04
 */

public class Server {

    public static final int STD_SERVER_PORT = 8045;

    public static void main(String[] args) {
        int portnumber;
        if( args.length == 1 ) {
            try {
                portnumber = Integer.parseInt(args[0]);
            } catch(Exception e){ portnumber = STD_SERVER_PORT; }
        } else { portnumber = STD_SERVER_PORT; }
        ServerThread st = new ServerThread(portnumber);
        st.run();
    }
}