# Git-Repository für Wirtschaftsinformatik
Das "HSW-Repository" sammelt Quelltexte und Musterlösungen für programmierrelevante Module im Studiengang Wirtschaftsinformatik (Ba/Ma) an der Hochschule Wismar.

## Inhalt und Umfang
Derzeit sind Quelltexte für folgende Module vorhanden:

* [Einführung in die Wirtschaftsinformatik](https://github.com/xladde/hsw/tree/master/ewi)
* [Einführung in die Programmierung](https://github.com/xladde/hsw/tree/master/eip)
* [Anwendungsprogrammierung](https://github.com/xladde/hsw/tree/master/awp)
* [Theoretische Informatik](https://github.com/xladde/hsw/tree/master/ti)
* [Datenbanken/Datenbanken in Unternehmen](https://github.com/xladde/hsw/tree/master/db)
* [Wissensbasierte Systeme](https://github.com/xladde/hsw/tree/master/wbs)

Weiterhin exisierte ein Verzeichnis [tex](https://github.com/xladde/hsw/tree/master/tex), dass LaTeX-Klassen für das anfertigen von Abschlussarbeiten bereitstellt.

## Hinweise zur Verwendung
Für die Vollständig- und/oder Richtigkeit der hier zur Verfügung gestellten Daten wird keine Garantie übernommen. Die Lösungen und Beispiele dienen als Ergänzung und nicht als Ersatz der Lehrveranstaltungen. Es ist erwünscht an der Vervollständigung, Strukturierung und Verbesserung dieses Repositories mitzuarbeiten.

### Daten-Download
Um das Repo lesen zu können, kann die jeweils aktuelle Version als [*.zip-file](https://github.com/xladde/hsw/zipball/master) oder als [*.tar-ball](https://github.com/xladde/hsw/tarball/master) heruntergeladen werden. Um die Versionsverwaltung zu verwenden, muss [Git](http://git-scm.com/) auf dem Entwicklungsrechner installiert sein. Für eine grafische Verwendung stehen einige Frontends für alle gängigen Betriebssysteme zur Verfügung.

Um auf der lokalen Festplatte eine Kopie (clone) des Repos zu erhalten muss folgender Befehl ausgeführt werden:
```
$ git clone https://github.com/xladde/hsw <path>/hsw
```
'```<path>```' ist dabei das Verzeichnis, in dem die Kopie erzeugt werden soll.

Ist bereits ein Clone vorhanden, so wird die jeweils aktuelle Version wie folgt bezogen:
```
$ git fetch  // sync
$ git status // check for diffrences
$ git pull   // only if status is okay!
```


### Daten-Upload
Für den Upload ist derzeit noch ein [Github](https://github.com)-Account notwendig.
```
$ git add <files to upload>
$ git commit -am "<be polite and leave a comment on your commit>"
$ git fetch  // sync
$ git status // check for diffrences
$ git push
Username: <your github username>
Passwort: <yout github password>
```
Github bietet zudem die Möglichkeit direkt von dort zu forken und eine parallele Version des Repos zu entwickeln.

## Copyright
Alle hier abgelegten, nicht anders gekennzeichneten, Daten und Quellen stehen unter einer GNU-GPL-, respektive CreativeCommons-3-Lizenz (by-nc-sa) und dürfen nach den Maßgaben frei verwendet und weitergeben werden.