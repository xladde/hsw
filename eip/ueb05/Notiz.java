/**
 * Klasse Notiz.
 * Notiz ist ein Objekt, dass verschiedene Attribute kapselt und so einen
 * höheren Informationsgehalt, als eine einzelne Zeichenkette besitzt.
 */
public class Notiz{
    // INSTANZVARIABLEN
    private String day, info;
    private int hour;
    
    /**
     * Default-Konstruktor. 
     * Erzeugt ein Objekt vom Typ Notiz. Instanzvariablen
     * werden mit Standard-Werten belegt.
     */
    public Notiz(){
        hour = 0;
        day = new String();
        info = new String();
    }
    
    /**
     * Konstruktor mit Übergabeparameter.
     * Erzeugt ein neues Objekt vom Typ Notiz. Instanzvariablen werden
     * mit den Werten der Übergabeparameter belegt.
     */
    public Notiz(String day, int hour, String info){
        this.day = day;
        this.hour = hour;
        this.info = info;
    }
    
    // SETTER AND GETTER
    public void setDay(String day){
        this.day = day;
    }
    
    public String getDay(){
        return this.day;
    }
    
    public void setInfo(String info){
        this.info = info;
    }
    
    public String getInfo(){
        return this.info;
    }
    
    public void setHour(int hour){
        this.hour = hour;
    }
    
    public int getHour(){
        return this.hour;
    }
    
    /**
     * ToString-Methode.
     * Die Methode gilt als "Standartkonstrukt". Jede Klasse sollte eine
     * besitzen. Sie erzeugt eine für den Anwender lesbare Zeichenkette.
     */
    public String toString(){
        return "Tag: "+this.day+" Stunde: "+this.hour+"\nInfo: "+this.info;
    }
}