/**
 * @file Main.java
 * @author t.j.
 * @version 2013-09
 */
import java.io.IOException;

public class Main {

    public static void testEmail(){
        Email mail1 = new Email("Max", "Mustermann", "max@ultra-gmbh.de");
        Email mail2 = new Email("Lisa", "Samplename", "ls@tuenneff.com");
        Email mail3 = new Email("Gregor", "Samsa", "kaefer@verwandlung.de");
        
        MailList list = new MailList();
        
        list.speichereEmail(mail1);
        list.speichereEmail(mail2);
        list.speichereEmail(mail3);
        
        System.out.println("Anzahl der Mailadressen: "+list.anzahlAdressen());
        for(int i = 0; i < list.anzahlAdressen(); i++){
            System.out.print(i+": ");
            list.printEmail(i);
        }
        
        list.entferneEmail(2);
        
        System.out.println("Anzahl der Mailadressen: "+list.anzahlAdressen());
        for(int i = 0; i < list.anzahlAdressen(); i++){
            System.out.print(i+": ");
            list.printEmail(i);
        }
    }
    
    public static void testNotizbuch(){
        Notizbuch nB = new Notizbuch();
        System.out.println("\nEin paar Notizen manuell erzeugen:");
        nB.addNewNotiz();
        nB.addNewNotiz();
        nB.addNewNotiz();
        
        System.out.println("\nAlle einmal ausgeben:");
        nB.printAll();
    }
        
    public static void main(String[] args){
        int option = 0;
        LineIO io = new LineIO();
        do{
            System.out.println(
                "\n--\nTest Uebung05\n"+
                "1:\tEmail und EmailList\n"+
                "2:\tNotizbuch und Notizerzeugung\n"+
                "0:\tExit\n"
            );
            try {
                option = io.readInt("Bitte Option wählen: ");
            } catch(IOException e)
            {
                System.out.println("\t\tFehler in der Eingabe.");
            }
            switch(option){
                case 1: 
                    testEmail(); 
                    break;
                case 2:
                    testNotizbuch();
                    break;
                default: 
                    break;
            }
        } while(option != 0);
        
        
    }
}