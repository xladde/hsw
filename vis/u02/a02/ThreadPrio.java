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

    /**
     * Configuration of Thread.
     */    
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
        
        //ackermann(2,3);
        for(int i = 0; i < loops; i++) {
        //    try {
        //        Thread.sleep(sleeptime);
            System.out.println(name + ":\t" + i + "\t" + ackermann(2,5));        
        //        System.out.println(name + ":\t" + i + "\t" + getPriority()+"\n");
        //    } catch(Exception ex) {}
        }
    }

    public int ackermann(int m, int n) {
        if( m==0 ) { return n+1; }
        else if( n==0 ) 
            { return ackermann(m-1, 1); }
        else
            { return ackermann( m-1, ackermann(m, n-1) ); }
    }
}