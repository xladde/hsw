# Fragen und Theorie
##  Erläutern Sie die for-each-Schleife.
Die for-each-Schleife ermöglicht das einfache Iterieren durch eine Sammlung von Objekten. Im Gegensatz zur for-Schleife wird keine Zählvariable zur identifizierung des aktuellen Indizes genutzt, sondern das aktuelle Objekt der Sammlung. Nach einem Schleifendurchlauf wird automatisch das nächste Objekt in der Sammlung gewählt.
    
    for(<TYPE> <loopname>: <container>){
        foo(<loopname>);
        bar();
        ...
    }

Der Datentyp muss das Iterator-Konzept unterstützen. Eine for-each-Schleife über einen Integer beispielsweise ist nicht möglich. 

##  Was ist ein Iterator?
Ein Iterator ist eine art Zeiger auf ein Objekt, mit dem über die Elemente einer Liste/Sammlung iteriert wird. Dabei wandert man von Element zu Element und kann über den Iterator diekt auf dieses zugreifen. In Java ist der Iterator durch das Interface java.util.Iterator umgesetzt.