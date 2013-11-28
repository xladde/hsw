/**
 * @file Eratosthenes.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 6-3: Das Sieb des Eratosthenes.
 * Implementieren Sie das Sieb des Eratosthenes zur Bestimmung der Primzahlen. 
 * Geben Sie sich selbst eine Obergrenze vor, bis zu der die Primzahlen 
 * ermittelt werden.
 */ 
public class Eratosthenes{ 
    
    public static boolean[] siebEratosthenes(int max) {
        boolean[] prim = new boolean[max];
        int quadrat = 0;
        int anz = 0;
        
        for(int i=0; i<max ; i++) prim[i] = true; // Alles sind Kandidaten für Primzahlen
        prim[0] = false; // 0!=prim
        prim[1] = false; // 1!=prim
        
        for(int i=1; i<max ; i++){ 
            //quadrat = quadrat + 2 * i - 1; // (i+1)*(i+1)=i*i+2*(i+1)-1
            quadrat = (i*i) + 2*(i+1) - 1;
            if (quadrat>max) break;  // Schleifenabbruch wenn i*1>n
            
            if (prim[i]) {
                for(int j=2*i;j<max;j+=i) prim[j] = false;
            }
        }
        
        return prim;
    }
    
    static void main(String[] args){ 
        
        boolean[] tst = siebEratosthenes(1000);
        
        for(int i = 0; i<tst.length; i++ ) {
            if(tst[i]) System.out.print(i+" ");
        }
        System.out.println();
    }
}
