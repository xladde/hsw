public class Rekursion
{
    public static int quersumme(int n)
    {
        int summe = 0;
        if(n < 10) summe += n;
        else summe += n%10 + quersumme(n/10);
        return summe;
    }
    
    public static long ackermann(long m, long n)
    {
        if(m == 0) 
        {
            return n+1;
        } else 
        {
            if(n == 0) return ackermann( m-1, 1 );
            else return ackermann( m-1, ackermann(m, n-1) );
        }
    }
    
    public static void hanoi (char a, char b, char c, int n)
    {
        if (n == 1)
            System.out.println("Lege die oberste Scheibe von " + 
            "Turm " + a + " auf Turm " + c + ".");
        else 
        {
            hanoi(a, c, b, n-1);
            hanoi(a, b, c, 1);
            hanoi(b, a, c, n-1);
        }
    }
}