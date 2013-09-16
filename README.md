# HSW-Repository Wirtschaftsinformatik

## Inhalt und Umfang

Dieses Repository dient der Dokumentation der Tutorien und Seminare im Studiengang "Wirtschaftsinformatik" (B.Sc.) an der Hochschule Wismar. Nach aktuellem Stand umfasst dies folgende Module:

* Einführung in die Programmierung
* Anwendungsprogrammierung

Weiterhin sind Dokumentationen für die folgenden Module geplant oder in Arbeit:

* Einführung in die Wirtschaftsinformatik
* Theoretische Informatik
* Künstliche Intelligenz
* Systemprogrammierung
* Mobile Agenten (Wahlpflicht)

Die Dokumentation dient lediglich der Ergänzung zur Teilnahme an den Seminaren, Vorlesungen und Tutorien. In keinem Fall ist es ein Ersatz der Lehrveranstaltungen.

Weitere Veranstaltungen und Module dürfen gerne unter reger beteiligung ergänzt werden.

## Changelog & Verlauf

### Einführung Programmierung

* Wintersemester 2009/2010
* Wintersemester 2010/2011
* Wintersemester 2011/2012
* Wintersemester 2012/2013
* Wintersemester 2013/2014 (aktuell)

### Anwendungsprogrammierung

* Sommersemester 2011
* Sommersemester 2012
* Sommersemester 2013 (aktuell)

## Copyright & Copyleft

Alle Beispiel- und Klausuraufgaben unterliegen dem Urheberrecht der Hochschule Wismar, Fakultät für Wirtschaftswissenschaften und insbesondere den Verantwortlichen Lehrbeauftragten der jeweiligen Module. Eine Weiterverbreitung und Reproduktion - auch auszugsweise - ist nicht gestattet. &copy;HSW

Alle Beispiele und Musterlösungen stehen unter der [GNU General Public License 3.0](http://www.gnu.de/documents/gpl.de.html) und dürfen frei verwendet werden. Das Wiki, sowie sämtliche extra für die Seminare und Tutorien angefertigten Paper und Dokumentationen stehen unter einer [Creative Commons 3.0 (cc) by-nc-sa-Lizenz](http://creativecommons.org/licenses/by-nc-sa/3.0/de/).

Eine Mitarbeit an dieser Dokumentation ist erwünscht. Vorrausgesetzt wird ein faier Umgang mit den angefertigten Softwareprodukten; mindestens nach den Maßgaben der Free Software Foundation.

## To Do
An dieser Stelle wird mit nachdruck darauf hingewiesen, dass noch Unterstützer für dieses Projekt benötigt werden, die sich an den folgenden To-Do's beteiligen:
* Erstellen der Wiki-Seiten
* Abarbeitung der Aufgabenstellungen in den Modulen
* Verfassen von Erläuterungen
* Entwurf und Implementierung zu Hilfestellungen/Beispielen
* Dokumentation der Quellen

## Kontakt

<table>
    <tr>
        <td>Projektadministrator:</td>
        <td>Thomas Jonitz (t.j.)</td>
    </tr>
    <tr>
    	<td></td>
        <td>https://github.com/xladde</td>
    </tr>
    <tr>
    	<td></td>
        <td>http://open.xladde.de</td>
    </tr>
    <tr>
        <td></td>
        <td>t.jonitz [at] stud.hs-wismar.de</td>
    </tr>
    <tr>
        <td>Repository</td>
        <td>http://xladde.github.io/hsw</td>
    </tr>
    <tr>
        <td></td>
        <td>hosted on [GitHub](https://github.com/xladde/hsw)</td>
    </tr>
</table>

---
# Branching und Arbeit an den Develop-Sources
## Hintergrund und Aufbau
Für die Arbeit an den Develop-Branches zur Vorbereitung der Seminare und Tutorien wurden alle Module in separate Branches (Entwicklungszweige) ausgelagert. So sollen unabhängig der Entwicklungsstände anderer Module einfacher Updates in das System gespielt werden können.

Die Branches sind entsprechend nach den abgekürzten Modulbezeichnungen aus dem Studium mit dem Prefix ```dev-``` benannt. Zum Beispiel lautet der Branchname für das Modul 'Einführung in die Programmierung' ```dev-eip```.

## Branchübersicht
<table>
	<tr>
    	<th>Modul</th>
        <th>Bezeichnung</th>
        <th>Quickref</th>
    </tr>
	<tr>
    	<td>Einführung in die Programmierung</td>
        <td>```dev-eip```</td>
        <td>https://github.com/xladde/hsw/tree/dev-eip</td>
    </tr>
    <tr>
    	<td>Einführung in die Wirtschaftsinformatik</td>
        <td>N/A</td>
        <td>N/A</td>
    </tr>
    <tr>
    	<td>Systemprogrammierung</td>
        <td>N/A</td>
        <td>N/A</td>
    </tr>
    <tr>
    	<td>Theoretische Informatik</td>
        <td>``` dev-ti ```</td>
        <td>https://github.com/xladde/hsw/tree/dev-ti</td>
    </tr>
    <tr>
    	<td>Anwendungsprogrammierung</td>
        <td>``` dev-awp ```</td>
        <td>https://github.com/xladde/hsw/tree/dev-awp</td>
    </tr>
    <tr>
    	<td>Künstliche Intelligenz</td>
        <td>N/A</td>
        <td>N/A</td>
    </tr>
    <tr>
    	<td>Mobile Agenten</td>
        <td>N/A</td>
        <td>N/A</td>
    </tr>
    
    <tr>
    	<td>LaTeX</td>
        <td>``` dev-tex ```</td>
        <td>https://github.com/xladde/hsw/tree/dev-tex</td>
	</tr>
</table>

## Branching

Das wechseln in einen Entwicklungszweig erfolgt über den Befehl
```sh
$ git chechout <name of branch>
```
Der Hauptentwicklungszweig ist der Master: 
```sh
$ git checkout master
```

Updates werden wie gewohnt über ```$ git add```, ```$ git commit``` und ```$ git pull``` durchgeführt.
