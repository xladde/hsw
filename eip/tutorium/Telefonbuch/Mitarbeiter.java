
/**
 * 
 * 
 * @author tj 
 * @version 2013-12
 */
public class Mitarbeiter
{
    // instance variables - replace the example below with your own
    private String nachname;
    private String vorname;
    private int    telnummer;
    private int    zimmernummer;

    /**
     * Constructor for objects of class Mitarbeiter
     */
    public Mitarbeiter(String nachname, String vorname, int tn, int zn)
    {
        this.nachname = nachname;
        this.vorname = vorname;
        this.telnummer = tn;
        this.zimmernummer = zn;
    }

    public String getVorname()
    {
        return vorname;
    }
    
    public void setVorname(String var)
    {
        vorname = var;
    }
    
    public String getNachname()
    {
        return nachname;
    }
    
    public void setNachname(String var)
    {
        nachname = var;
    }
    
    public int getTelefonNr()
    {
        return telnummer;
    }
    
    public void setTelefonNr(int var)
    {
        telnummer = var;
    }
    
    public int getZimmerNr()
    {
        return zimmernummer;
    }
    
    public void setZimmerNr(int var)
    {
        zimmernummer = var;
    }
}
