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
Diese Warnung kann wie folgt verhindert werden
0. `public @interface Deprecated {}`
1. `@SuppressWarnings("deprecation") void open() {}`
2. `@Deprecated void open() {}`


----
**c.) Wird der folgende Quelltext ohne Fehler kompiliert? Warum oder warum nicht? Testen Sie den Code mit beliebigem Quelltext für {...}.**
```
public @interface Meal {}

@Meal("breakfast", mainDish="cereal")
@Meal("lunch", mainDish="pizza")
@Meal("dinner", mainDish="salad")
public void evaluateDiet(){}

```

----
**d.) Definieren Sie einen Annotationstyp für eine Supportanfrage mit den Elementen id, beschreibung, bearbeiter und datum. Defaultwerte für bearbeiter soll "unbestimmt" sein, Defaultwert für datum "unbekannt".**
