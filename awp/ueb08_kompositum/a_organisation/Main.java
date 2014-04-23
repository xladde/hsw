/**
 * @author t.j.
 * @version 2014-04
 */

public class Main {
    
    public static void main(String[] args) {
        Stelle s1 = new Stelle("asdasada", 23.98);
        Stelle s2 = new Stelle("dwacycyx", 5.89);
        Stelle s3 = new Stelle("escsvrxW", 9.70);
        Stelle s4 = new Stelle("mliufohc", 10.11);
        Stelle s5 = new Stelle("cemvriow", 12.13);

        Abteilung a1 = new Abteilung("Abteilung 1");
        Abteilung a2 = new Abteilung("Abteilung 2");

        a1.addOrganisationseinheit(s1);
        a1.addOrganisationseinheit(s2);
        a1.addOrganisationseinheit(s3);

        a2.addOrganisationseinheit(s4);
        a2.addOrganisationseinheit(s5);
        a2.addOrganisationseinheit(a1);
        

        System.out.println("Gesamtaufwand:\t" + a2.ermittlePersonalAufwand());
        
    }
}