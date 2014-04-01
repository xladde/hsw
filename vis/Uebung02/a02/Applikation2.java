/**
 * @author t.j.
 * @version 2014-03
 */

import java.lang.Thread;
import java.util.ArrayList;

/**
 * Testing three threads with a diffrent priority.
 */
public class Applikation2 {

    public static final int LOOPS = 5;
    public static final int SLEEP = 1000;

    public static void main(String[] args) {
        ArrayList<ThreadPrio> arr = new ArrayList<ThreadPrio>();

        // create threads
        arr.add( new ThreadPrio("T1", LOOPS, SLEEP, Thread.MAX_PRIORITY) );
        arr.add( new ThreadPrio("T2", LOOPS, SLEEP, Thread.NORM_PRIORITY) );
        arr.add( new ThreadPrio("T3", LOOPS, SLEEP, Thread.MIN_PRIORITY) );
        //arr.add( new ThreadPrio("T4", LOOPS, SLEEP, Thread.MAX_PRIORITY) );

        // run threads
        for(ThreadPrio t: arr) { 
            System.out.println("Starting Thread " + t.name + " with a priority of " + t.getPriority());
            t.start(); 
        }

    }
}