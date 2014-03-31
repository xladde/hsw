public class Applikation1 {
    public static void main(String[] args) {
        Konto k = new Konto(100);
        KontoThread t1 = new KontoThread("Firma", k, 1000);
        KontoThread t2 = new KontoThread("Oma", k, 50);
        KontoThread t3 = new KontoThread("Ich", k, -250);
        t1.start(); t2.start(); t3.start();
    }
}