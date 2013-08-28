/**
 * @author T.J.
 * @version 2012-10-22
 */
public class Main{
    
    /**
     * Ermitteln aller Teiler einer natürlichen Zahl.
     * Die Methode wartet auf eine Nutzereingabe (Integer). 
     * In einer Schleife wird die Modulo-Operation mit dieser Zahl und
     * 1...zahl durchgeführt. Wird dabei ein Restwert von 0 Ermittelt, so 
     * ist "c" ein Teiler von "zahl" und wird in ein Array geschrieben.
     */
    public static void teilerAusgeben(){
        try{
            LineIO io = new LineIO();
            int zahl = io.readInt("Natürliche Zahl eingeben: ");
            int i = 0;
            int[] arr = new int[1];
            
            // teiler ermitteln ...
            for(int c = 1; c<zahl; c++){ //bei 1 beginnen zahl%0 niocht möglich
                
                if((zahl%c)==0){ // wenn zahl durch aktuellen Wert Rest 0 hat ...
                    
                    if(i>=arr.length){ // Array voll? -> vergrößern!
                        int[] tmp = arr;
                        arr = new int[tmp.length+1];
                        for(int it = 0; it<tmp.length; it++){
                            arr[it]=tmp[it];
                        }    
                    }// ende Arayvergrößerung
                    
                    arr[i] = c; // ... Teiler in das Array kopieren
                    i++; // auf den nächsten Index im Array zeigen
                }
            }
            
            // ausgabe ....
            System.out.println("\tAnzahl der Teiler: "+arr.length);
            System.out.print("\tTeiler: ");
            // alle Teiler nacheinander ausgeben ....
            for(int c = 0; c<arr.length; c++){
                System.out.print(arr[c]+",");
            }            
            System.out.print("\n\tSumme: ");
            // summe ermitteln ...
            int s = 0;
            for(int c = 0; c<arr.length; c++){
                s+=arr[c];
            }
            System.out.print(s+"\n");
        }catch(Exception e){ // fehlerabfrage
            System.out.println("An Error occured.");
        }
    }
    
    /**
     * Eine Folge von natürlichen Zahlen einlesen und die Summe bilden.
     * Die Eingabe wird durch die Zahl -999 abgeschlossen.
     */
    public static int summeAllerZahlen(){
        LineIO io = new LineIO();
        int eingabe = 0;
        int summe = 0;
        try{
            while((eingabe = io.readInt("Zahl eingeben: ")) != -999){
                summe += eingabe;
            }
        }catch(Exception e){
            System.out.println("An Error occured.");
        }
        System.out.println("Summe = "+summe);
        return summe;
    }
    
    /**
     * Generiert eine Zufallszahl zwischen 0 und int max.
     * Die Methode endet erst, wenn die zufällige Zahl erraten wurde.
     */
    public static void zahlenRaten(int max){
        LineIO io = new LineIO();
        int rateZahl = (int) (Math.random()*max);
        int eingabe = 0;
        try{
            while((eingabe = io.readInt("Zahl eingeben: ")) != rateZahl){
                if(eingabe < rateZahl) System.out.println("\t\tZu klein.");
                else System.out.println("\t\tZu groß.");
            }
        }catch(Exception e){
            System.out.println("An Error occured.");
        }
        System.out.println("Hurra, Zahl geraten!");
    }
    
    public static void main(String[] args){
        int option = 0;
        LineIO io = new LineIO();
        do{
            System.out.println(
                "\n--\nTest Uebung06\n"+
                "1:\talle Teiler einer natürlichen Zahl\n"+
                "2:\tSumme aller eingelesenen Zahlen\n"+
                "3:\tRaten einer Zahl.\n"+
                "0:\tExit\n"
            );
            try {
                option = io.readInt("Bitte Option wählen: ");
            } catch(Exception e)
            {
                System.out.println("\t\tFehler in der Eingabe.");
            }
            switch(option){
                case 1: 
                    teilerAusgeben(); 
                    break;
                case 2:
                    summeAllerZahlen();
                    break;
                case 3:
                    zahlenRaten(100);
                    break;
                default: 
                    break;
            }
        } while(option != 0);
    }
}