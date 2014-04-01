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
        configure(name, loops, sleeptime, Thread.NORM_PRIORITY);
    }

    /**
     * Constructor.
     * Crates an instance of 'ThreadPrio' with a given Priority.
     */
    public ThreadPrio(String name, int loops, int sleeptime, int prio) {
        configure(name, loops, sleeptime, prio);
    }
    
    private void configure(String name, int loops, int sleeptime, int prio) {
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