/**
 * @file Main.java (GNU GPL3)
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufgabe 6-1: Main-Methode.
 * Legen Sie ein Projekt mit einer Klasse an, die nur eine main-Methode 
 * enthält (ausführbare Klasse). Importieren Sie die Datei LineIO.java in das 
 * Projekt (Bearbeiten > Klasse aus Datei hinzufügen...). Nun können Zahlen 
 * und Zeichenketten leicht ein- sowie ausgegeben werden:
 *
 * \code
 *  public static void main(String[ ] args) throws Exception { 
 *      LineIO io = new LineIO(); // Ein Ein- und Ausgabe-Objekt wird erzeugt 
 *       // die Methode readInt liest nach Aufforderung eine Zahl ein! 
 *       int a = io.readInt(“Bitte eine Zahl eingeben: “);  
 *       // die Methode writeln kann Zeichenketten ausgeben 
 *       io.writeln(“Es wurde die Zahl “+a+” eingegeben!”); 
 *   }//main 
 * \endcode
 *
 * Laden Sie die Datei LineIO.java herunter (siehe Dokumente). Die Datei 
 * LineIO.zip enthält die Dokumentation.
 * Für Experten: Erzeugen Sie sich die Dokumentation selbst, in dem Sie im 
 * Kommandozeilen-Modus das javadoc-Programm aufrufen: ...>javadoc LineIO.java.
 * 
 * Lösen Sie folgende Aufgaben:
 *      1.  In der main-Methode soll eine natürliche Zahl eingelesen werden 
 *          und danach alle ihre Teiler ausgegeben werden. Verwenden Sie eine 
 *          while-Anweisung.
 *      2.  Verändern Sie die Lösung wie folgt: Erzeugen Sie ein Array von 
 *          Integer und speichern Sie alle Teiler der Zahl in das Array. 
 *          Anschließend geben Sie die Anzahl der Teiler, jeden einzelnen 
 *          Teiler und die Summe der Teiler aus.
 *      3.  In der main-Methode werden hintereinander mehrere Zahlen eingelesen. 
 *          Das Einlesen wird durch die Eingabe der Zahl –999 beendet. Es ist 
 *          die Anzahl und die Summe der eingelesenen Zahlen (Ohne –999) 
 *          anschließend auszugeben.
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
        
    public static void main(String[] args){
        int option = 0;
        LineIO io = new LineIO();
        do{
            System.out.println(
                "\n--\nTest Uebung06\n"+
                "1:\talle Teiler einer natürlichen Zahl\n"+
                "2:\tSumme aller eingelesenen Zahlen\n"+
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
                default: 
                    break;
            }
        } while(option != 0);
    }
}