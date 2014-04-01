/**
 * @author t.j.
 * @version 2014-03
 */

import java.lang.Thread;
import java.util.Date;

public class SleepingThread extends Thread {

    public SleepingThread(){}

    public void run() {
        Date startTime = new Date();
        
        try { Thread.currentThread().sleep( (int) (1000*Math.random()) ); }
        catch(Exception ex) { /* ...Doing Nothing... */ }

        long elapsedTime = new Date().getTime() - startTime.getTime();
        System.out.println(Thread.currentThread().getName() + 
            ": I slept for "+ elapsedTime + " milliseconds.");
    }
}