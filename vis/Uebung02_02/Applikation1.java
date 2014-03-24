/**
 * @author t.j.
 * @version 2014-03
 */

public class Applikation1 {
    public static void main(String[] args) {
        SleepingThread t1 = new SleepingThread();
        SleepingThread t2 = new SleepingThread();
        t1.run();
        t2.run();
    }
}