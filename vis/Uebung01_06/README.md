### Aufgabe 1.6 Java Annotation
a.) Was ist an der folgenden Schnittstele unvorteilhaft?
```
public interface House {
    @Deprecated
    void open();
    void openFrontDoor();
    void openBackDoor();
}
```

b.) Verwenden Sie die nachfoldende Implementierung der Schnittstelle:
```
public class MyHouse implements House {
    void open()          { /*nothing*/ }
    void openFrontDoor() { /*nothing*/ }
    void openBackDoor()  { /*nothing*/ }
}
```
Wenn Sie die Klasse MyHouse kompilieren erhalten Sie eine Warnmeldung. Warum? Wie können Sie diese Meldung verhindern (zwei Möglichkeiten)?

c.) Wird der folgende Quelltext ohne Fehler kompiliert? Warum oder warum nicht? Testen Sie den Code mit beliebigem Quelltext für {...}.
```
public @interface Meal {}

@Meal("breakfast", mainDish="cereal")
@Meal("lunch", mainDish="pizza")
@Meal("dinner", mainDish="salad")
public void evaluateDiet(){}

```

d.) Definieren Sie einen Annotationstyp für eine Supportanfrage mit den Elementen id, beschreibung, bearbeiter und datum. Defaultwerte für bearbeiter soll "unbestimmt" sein, Defaultwert für datum "unbekannt".
