/**
 * @author t.j.
 * @version 2014-03
 */
@Supportanfrage(id="001", beschreibung="test")
public class SupportanfrageTest {

    public SupportanfrageTest() {

    }

    public static void main(String[] args) {
        SupportanfrageTest sat = new SupportanfrageTest();
        Class c = sat.getClass();

        @SuppressWarnings("unchecked")
        Supportanfrage sa = (Supportanfrage)c.getAnnotation(Supportanfrage.class);
        System.out.println(sa.id());
        System.out.println(sa.beschreibung());
        System.out.println(sa.bearbeiter());
        System.out.println(sa.datum());
    }
}