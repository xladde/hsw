public class QuadratischeGleichung2{
    public static void main(String[] args) {
        int p     = 8;
        int q     = 7;
        double x1 = -p/2.0 + Math.sqrt((p*p)/4-q);
        double x2 = -p/2.0 - Math.sqrt((p*p)/4-q);
        System.out.println("x1= "+x1+", x2= "+x2);
    }
}