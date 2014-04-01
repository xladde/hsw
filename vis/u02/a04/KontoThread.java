/**
 * @author t.j.
 * @version 2014-03
 */
public class KontoThread extends Thread {

    private String name;
    private Konto  konto;
    private double buchungsbetrag;

    public KontoThread(String name, Konto konto, double buchungsbetrag) {
        this.name = name;
        this.konto = konto;
        this.buchungsbetrag = buchungsbetrag;
    }

    public void run() {
        for(int i = 0; i<6; i++) {
            try {
                Thread.sleep(1000);
            } catch(Exception e){}
            // WICHTIG: Loesung f Ueb02-04d
            synchronized (konto){ konto.buchung( name, i, buchungsbetrag ); }
        }
    }
}