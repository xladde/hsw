/**
 * @author t.j.
 * @version 2014-03
 */

import java.lang.Thread;

public class ThreadPrio extends Thread {
    
    public String  name;
    public int     loops, sleeptime;

    /**
     * Constructor.
     * Crates an instance of 'ThreadPrio'.
     */
    public ThreadPrio(String name, int loops, int sleeptime) {
        this.name       = name;
        this.loops      = loops;
        this.sleeptime  = sleeptime;
    }

    /**
     * Constructor.
     * Crates an instance of 'ThreadPrio' with a given Priority.
     */
    public ThreadPrio(String name, int loops, int sleeptime, int prio) {
        this.name       = name;
        this.loops      = loops;
        this.sleeptime  = sleeptime;
        this.setPriority(prio);
    }
    
    /**
     * What to do on run ...
     */
    @Override
    public void run() {
        for(int i = 0; i < loops; i++) {
            try {
                Thread.sleep(sleeptime);
                System.out.println(name + ":\t" + i + "\t" + getPriority());
            } catch(InterruptedException ex) {}
        }
    }
}