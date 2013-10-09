/**
 * @file Notizbuch.java
 * @author t.j.
 * @version 2013-09
 */
import java.util.ArrayList;
import java.io.IOException;

/**
 * @brief Klasse Notizbuch.
 * Sammlung von Notizen. Man kann Notizen (interaktiv) hinzufügen, Notizen 
 * auslesen und alle Notizen auf dem Bildschrirm ausgeben.
 * Weitere sinvolle Methoden wären: Notiz entfernen, ...
 */
public class Notizbuch{
    // 1. INSTANZVARIABLEN
    private ArrayList<Notiz> nList;
    // 2. KONSTRUKTOR(EN)
    /**
     * @brief Default-Konstruktor.
     */
    public Notizbuch(){
        nList = new ArrayList<Notiz>();
    }
    
    /**
     * @brief Konstruktor.
     * Bekommt eine ArrayList übergeben. Keine Notiz!
     */
    public Notizbuch(ArrayList<Notiz> nList){
        this.nList = nList;
    }
    // 3. GETTER / SETTER
    public ArrayList<Notiz> getNList(){
        return nList;
    }
    
    public void setNList(ArrayList<Notiz> l){
        nList = l;
    }
    
    // 4. SONSTIGE METHODEN
    /**
     * @brief Hinzufügen einer Notiz
     */
    public void addNotiz(Notiz n){
        nList.add(n);
    }
    
    /**
     * @brief Auslesen einer Notiz
     */
    public Notiz getNotiz(int index){
        if(index < nList.size()){
            return nList.get(index);
        } else return null;
    }
    
    /**
     * @brief Eine neue Notiz über die Kommandozeile erzeugen und
     * der Liste hinzufügen.
     * 
     * Frage: Wie ginge es "besser"
     * Antwort: Erzeugen der Notiz vom Hinzufügen zur Liste trennen. 
     */
    public void addNewNotiz(){
        LineIO io = new LineIO();
        try {
            String day = io.readString("Tag: ");
            int hour = io.readInt("Stunde: ");
            String info = io.readString("Text: ");
            addNotiz(new Notiz(day, hour, info));
        } catch(IOException e) {
            System.out.println("There is an IOException");
           
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
    /**
     * @brief Alle Notizen in der Liste ausgeben.
     */
    public void printAll(){
        for(Notiz n: nList){
            System.out.println(n.toString());
        }
    }
}