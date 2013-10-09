/**
 * @file MailList.java
 * @author t.j.
 * @version 2013-09
 */
import java.util.ArrayList;

/**
 * @brief Aufgabe 5-1: E-Mail.
 * Entwickeln Sie möglichst ohne Hilfe aus dem Buch ein Projekt Email-Liste 
 * zum Verwalten von Email-Adressen (Sammlung). Benötigt werden die Methoden 
 * speichereEmail(String email) sowie anzahlAdressen(). Fügen Sie dann die 
 * Methoden entferneEmail(int EmailNummer), zeigeEmail(int n) sowie 
 * alleEmailsAusgeben(). Vergleichen Sie das Verhalten Ihrer Lösung mit dem 
 * Projekt Notizbuch2.
 */
public class MailList
{
    private ArrayList<Email> mList;
    
    public MailList(){
        mList = new ArrayList<Email>();
    }
    
    public void speichereEmail(Email e){
        if(e!=null) { // check if param is empty
            mList.add(e);
        }
    }
    
    /**
     * @brief Email aus der Liste entfernen.
     * @param index Index an der Stelle der auszugebeneden Emailadresse.
     */
    public void entferneEmail(int index){
        // check if param is inside elements range
        if(index < anzahlAdressen()) {
            mList.remove(index); 
        }
    }
    
    public int anzahlAdressen(){
        return mList.size();
    }
    
    /**
     * @brief Ausgabe einer Email.
     * Ersetzt die Methde 'zeigeEmail(int)'.
     * @param index Index an der Stelle der auszugebeneden Emailadresse.
     */
    public void printEmail(int index){
        // check if param is inside elements range
        if(index < anzahlAdressen()){
            System.out.println(mList.get(index).toString());
        }
    }
    
}