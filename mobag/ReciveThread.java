
import java.io.DataInputStream;
import java.io.DataOutputStream;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class ReciveThread extends Thread {

    private boolean run = true;
    private int sleeptime = 50;
    public static final int WAITING = 1;
    public static final int CONNECTED = 2;
    public static final int CLOSED = 3;
    private int status;
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;
    private String data = "0_0_0_0_";
    private int count = 0;

    @Override
    public void run() {
        this.status = ReciveThread.WAITING;
        try {
            BTConnection btc = Bluetooth.waitForConnection();
            DataInputStream dis = btc.openDataInputStream();
            DataOutputStream dos = btc.openDataOutputStream();
            this.status = ReciveThread.CONNECTED;
            while (run) {               
                this.count++;               
                byte[] inbuf = new byte[255];
                dis.read(inbuf);
                this.data = new String(inbuf);
                //lejos.nxt.Sound.playTone(1, 1);
                this.readDataString(this.data);
                dos.writeInt(99);
                dos.flush();
                Thread.sleep(sleeptime); // wait for data to drain          
              
            }
            dos.close();
            dis.close();
            this.status = ReciveThread.CLOSED;

        } catch (Exception e) {
        }

    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public String getCoordsAsString() {
     
        String rob1 = "R1(" + String.valueOf(this.x1) + "," + String.valueOf(this.y1) + ")";
        String rob2 = "\n R2(" + String.valueOf(this.x2) + "," + String.valueOf(this.y2) + ")";
        return rob1 + "\n  " + rob2 + "\n cnt:" + this.count;
    }

    public int getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public void readDataString(String tmp) {
     
        int tmp_count = 0;
        String num = "0";

        for (int i = 0; i < tmp.length(); i++) {

            if (tmp.charAt(i) != '_') {
                num += tmp.charAt(i);
            }
            if (tmp.charAt(i) == '_') {
                if (tmp_count == 0) {
                    this.x1 = Integer.valueOf(num);
                    //Main.my_x=x1;
                }
                if (tmp_count == 1) {
                    this.y1 = Integer.valueOf(num);
                    //Main.my_y=y1;
                }
                if (tmp_count == 2) {
                    this.x2 = Integer.valueOf(num);
                    //Main.en_x=x2;
                }
                if (tmp_count == 3) {
                    this.y2 = Integer.valueOf(num);
                    //Main.en_y=y2;
                }
                num = "";
                tmp_count++;
            }

        }
      

    }
    public int getCount(){
    	return count;
    }
}
