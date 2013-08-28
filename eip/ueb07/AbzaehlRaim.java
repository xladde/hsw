/**
 * @author tj
 * @version 2012-11-05
 */
public class AbzahelReim
{
    public static void print(boolean[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print("["+ arr[i] +"]\t");
        }
        System.out.print("\n");
    }
    
    
    public static int abzaehlen(int children, int syllables)
    {
        // Array vorbereiten ...
        boolean[] ch = new boolean[children];
        for(int i = 0; i < children; i++) ch[i] = true;
        
        // startposition des zaehlens festlegen
        int pos = 0;
        int c = children;
        // abzaehlen, bis ein kind übrig bleibt...
        while(c > 0)
        {   print(ch);
            pos = 0;
            for(int s = 0; s < syllables-1; s++)
            {
                pos++; // zeige auf das nächste kind
              if(pos >= children) pos = 0; // wenn ende erreicht: beginne von vorn
              if(!ch[pos]) s--; // setze schleifenzähler zurück
            }
            // verlierer fliegt ...
            ch[pos]=false;
            // ein kind weniger
            c--;
        }
        // letzt bekannte position zurückgeben
        return pos;
    }
}
