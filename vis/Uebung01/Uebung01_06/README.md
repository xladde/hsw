### Aufgabe 1.6 Java Annotation
**a.) Was ist an der folgenden Schnittstele unvorteilhaft?**
```
public interface House {
    @Deprecated
    void open();
    void openFrontDoor();
    void openBackDoor();
}
```
Die Methode `void open();` ist als veraltet markiert. Wird die Methode implementiert, so erhält man eine Warnung beim Übersetzen. Elemente, die so markiert sind sollten nicht verwendet werden, da i.d.R. eine bessere Variante existiert.


----
**b.) Verwenden Sie die nachfoldende Implementierung der Schnittstelle:**
```
public class MyHouse implements House {
    void open()          { /*nothing*/ }
    void openFrontDoor() { /*nothing*/ }
    void openBackDoor()  { /*nothing*/ }
}
```
**Wenn Sie die Klasse MyHouse kompilieren erhalten Sie eine Warnmeldung. Warum? Wie können Sie diese Meldung verhindern (zwei Möglichkeiten)?**

Es wird eine Warnung produziert, da die Schnittstelle `void open()` als `deprecated` markiert wurde:
```
Note: MyHouse.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```
Diese Warnung kann wie folgt verhindert werden:

1. Definieren einer Schnittstelle `public @interface Deprecated {}` in einer Datei Deprecated.java,
2. Annotation `@SuppressWarnings("deprecation")` vor der Implementierung von ` void open()` oder
3. Annotation `@Deprecated` vor der Implementierung von `void open()`.


----
**c.) Wird der folgende Quelltext ohne Fehler kompiliert? Warum oder warum nicht? Testen Sie den Code mit beliebigem Quelltext für {...}.**
```
public @interface Meal {}

@Meal("breakfast", mainDish="cereal")
@Meal("lunch", mainDish="pizza")
@Meal("dinner", mainDish="salad")
public void evaluateDiet(){}

```

__`Meal.java`__
```
public @interface Meal {
    String name();
    String mainDish();
}
```

__`MealTest.java`__
```
public class MealTest {
    @Meal(name="breakfast", mainDish="cereal")
    @Meal(name="lunch", mainDish="pizza")
    @Meal(name="dinner", mainDish="salad")
    public void evaluateDiet() {}
}
```

Das Übersetzen wird fehlschlagen, da wiederholte Annotationen von Elementen nicht unterstützt werden. Diese Möglichkeit steht erst ab JDK 8 zur verfügung und soll wie folgt erzeugt werden können:

__`Meal.java`__
```
@Repeatable(MealContainer.class)
public @interface Meal {
    String name();
    String mainDish();
}
```
__`MealContainer.java`__
```
public @interface MealContainer {
    Meal[] array();
}
```

----
**d.) Definieren Sie einen Annotationstyp für eine Supportanfrage mit den Elementen id, beschreibung, bearbeiter und datum. Defaultwerte für bearbeiter soll "unbestimmt" sein, Defaultwert für datum "unbekannt".**

```
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface Supportanfrage {
    String id();
    String beschreibung();
    String bearbeiter()     default "unbekannt";
    String datum()          default "unbestimmt";
}
```

Test-Klasse:

```
@Supportanfrage(id="001", beschreibung="test")
public class SupportanfrageTest {
    public SupportanfrageTest() {}
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
```
