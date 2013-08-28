public class Main {

    public static void main(String[] args) {
    
        Telefonbuch t = new Telefonbuch();
        Mitarbeiter m1 = new Mitarbeiter("Hans", "19/212", 123456);
        Mitarbeiter m2 = new Mitarbeiter("Michael", "19/213", 432456);
        Mitarbeiter m3 = new Mitarbeiter("sad", "19/232", 12334246);
        Mitarbeiter m4 = new Mitarbeiter("blub", "19/412", 123242456);
        Mitarbeiter m5 = new Mitarbeiter("Bla", "19/211", 6754456);
        
        t.hinzu(m1);
        t.hinzu(m2);
        System.out.println(t.toString());
        t.hinzu(m3);
        t.hinzu(m4);
        t.hinzu(m5);
        t.hinzu(new Mitarbeiter());
        System.out.println(t.toString());
        
        t.del(3);        
        System.out.println(t.toString());    
    }

}