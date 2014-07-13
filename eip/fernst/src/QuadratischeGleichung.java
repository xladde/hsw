public class QuadratischeGleichung {
    public static void main(String[] args) {
        int    p  = 8;
        int    q  = 7;
        double a  = p/2.0;
        double b  = a*a;
        double c  = b - q;
        double d  = Math.sqrt(c);
        double e  =  - a;
        double x1 = e + d;
        double x2 = e - d;
        System.out.println("x1= "+x1+", x2= "+x2);
    }
}