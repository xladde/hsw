
/**
 * 
 * 
 * @author tj
 * @version 2013-12
 */
public class Telefonbuch
{
    private Mitarbeiter[] mitarbeiter;
    private int next;
    public static final int DEFAULT_SIZE = 50;
    
    
    /**
     * Constructor for objects of class Telefonbuch
     */
    public Telefonbuch(int size) 
    { 
        this.mitarbeiter = new Mitarbeiter[size]; 
        next = 0;
    }
    
    public Telefonbuch() 
    { 
        this(DEFAULT_SIZE); 
    }
    
    public Mitarbeiter[] getMitarbeiter() 
    { 
        return mitarbeiter; 
    }
    
    public void setMitarbeiter(Mitarbeiter[] mitarbeiter)
    {
        this.mitarbeiter = mitarbeiter;
        for(int i = 0; i < mitarbeiter.length; i++)
        {
            if(mitarbeiter[i] == null)
            {
                next = i;
                break;
            }
        }
    }
    
    public int getNext() { return next; }
    
    public boolean isEmpty() 
    {
        if(next == 0) return true;
        else return false;
    }
    
    // ----------------------------------------------------------------------------------
    
    public void addMitarbeiter(Mitarbeiter m)
    {
        if( next < mitarbeiter.length )
        {
            mitarbeiter[next++] = m;
        }
    }
    
    
    public int getIndexOfMitarbeiter(String nachname, String vorname)
    {
        int     index = -1;
        if( !isEmpty() )
        {
            for(int i = 0; i < mitarbeiter.length; i++)
            {
                if( mitarbeiter[i].getVorname().equals(vorname) &&
                    mitarbeiter[i].getNachname().equals(nachname) ) 
                {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    public String toString()
    {
        System.out.println("{");
        for(Mitarbeiter m: mitarbeiter)
        {
            System.out.println( "\t" + m.getNachname() + 
                                ", " + m.getVorname() +
                                ", " + m.getTelefonNr() +
                                ", " + m.getZimmerNr()
            );
        }
        System.out.println("}");
    }
}
