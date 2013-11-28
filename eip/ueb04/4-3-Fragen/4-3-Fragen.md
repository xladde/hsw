# Fragen
## Welche logischen Operatoren gibt es?

* NOT:            !  
* gleich:         ==  
* ungleich:       !=  
* größer:         >  
* kleiner:        <  
* größer-gleich:  >=  
* kleiner-gleich: <=  

## Wie werden Zeichenketten verknüpft?
Zeichenketten sind keine primitiven Datentypen (Basisdatentypen), sondern 
Datenstrukturen, was an der großen Schreibweise (String) erkannt wird. Daher
werden sie über Methoden verknüpft. Die Methode, um eine Zeichenkette an eine
andere anzufügen (Konkatenation) lautet am Beispiel:

    String a = new String( "zeichenkette1" );
    String b = new String( "zeichenkette2" );
    a.concat( b );

Zudem handelt es sich bei der Klasse 'String' um eine der wenigen Klassen, bei
denen eine Überladung des '+='-Operators zugelassen wurde. Enstprechend ist die
Anweisung

    a.concat( b );

identisch zur Anweisung

    a += b;


## Welche Ergebnisse haben di folgenden Ausdrücke: 56/8; 56%10; 6%7; 1/2; 0/6; 8/0;
In abhängigkeit des Datentyps bei der Division wird entweder ein ganzzahliges
Ergebnis (Integer), oder eine Gleitkommazahl (Double) ausgegeben. Die vorliegende
Klasse 'Ergebnisse.java' gibt die von Java festgelegte Standartausgabe der
Berechnungen aus.
