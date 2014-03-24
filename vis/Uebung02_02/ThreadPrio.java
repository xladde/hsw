/**
 * @author t.j.
 * @version 2014-03
 */

import java.lang.Thread;

public class ThreadPrio extends Thread {
    
    String  name;
    int     loops, sleeptime;
    
    public ThreadPrio(String name, int loops, int sleeptime) {
        this.name       = name;
        this.loops      = loops;
        this.sleeptime  = sleeptime;
    }
    
    public void run() {
        for(int i = 0; i < loops; i++) {
            try {
                Thread.sleep(sleeptime);
                System.out.println(name + " " + i);
            } catch(InterruptedException ex) {}
        }
    }
}