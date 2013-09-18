# Informationen zur Installation und Verwendung

## Vorraussetzungen
### Betriebssystem
* 	Alle Msuterlösungen und Beispiele wurden unter einem GNU/Linux-System (Debian Squeeze/Wheezy) erstellt. C/C++-Programme können auf Systembibliotheken zugreifen, die unter anderen betriebssystemen nicht existieren.
* 	Java-Programme und die Java-Quellen funktionieren Plattformunabhängig und sind unter Windows XP, Vista und 7 lauffähig. Ausgenommen davon sind eventuell fehlerhafte oder unvollständige Quellen 
* 	Es wurden keine Tests unter iOS durchgeführt.

### Quellverwaltung
* 	Das Repository unterliegt einer Versionsverwaltung. Speziell wird die freie Software [Git]( http://git-scm.com ) eingesetzt. Das Repository verfügt über mehrere Branches.
* 	Die zentrale Verwaltung findet über den Hostingdienst [GitHub]( https://github.com ) statt.
* 	Das Repository ist im Netz unter https://github.com/xladde/hsw oder über die Projektseite http://xladde.github.io/hsw erreichbar

### Entwicklung
* 	Für die Übersetzung der Quellen werden Compiler, respektive Interpreter/Linker/etc. für die Sprachen C/C++, Java und Python benötigt. Das Modul "Betriebssysteme" arbeitet mit einer GNU/Linux-Distribution. Ein Shell-Interpreter ist dort bereits integriert.
* 	Weitere Compiler und notwendige Softwarepakete finden sich in den jeweiligen Veranstaltungen in [Stud.IP]( http://studip.hs-wismar.de ). So zum Beispiel für "Anton und Paula".
* 	Für die Module werden folgende Entwicklungsumgebungen empfohlen:
	* 	[BlueJ]( http://www.bluej.org ) -- Einführung in die Programmierung
	* 	[NetBeans]( http://netbeans.org ) -- Anwendungsprogrammierung
    * 	[IDLE]( http://docs.python.org/2/library/idle.html ) -- Systemprogrammierung
    * 	[SWI-Prolog](http://www.swi-prolog.org/IDE.html) -- Theoretische Informatik/Künstliche Intelligenz
    * 	Einfacher Texteditor für sonstiges. Empfohlen wird [SublimeText]( http://www.sublimetext.com/ )

### Dokumentation
* 	Die Dokumentation der vorhandenen Quellen wird mit dem Dokumentationstool [Doxygen]( http://www.doxygen.org/ ) (ab v.1.7.2) anhand der Kommentare und diverset Tags in den Quelltexten erstellt. Alternativ kann für Java-Programme auch das mit dem JDK mitgelieferten Tool [JavaDoc]( http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html ) verwendet werden. 
* 	Doxygen lädt eine Konfigurationsdatei, die die zu erstellende Dokumentation beschreibt. Für die Erstellung von Grafiken und Abhängigkeitsdiagramme baut das Tool auf das Paket [Graphviz]( http://www.graphviz.org/ ) auf.
* 	Das Tool "**Dot**" ist Bestandteil der Graphviz-Bibliothek. Beim Download/bei der Installation sollte daher geprüft werden, ob das Paket bestandteil der Installation ist.

## Bezug der Quellen

Die Mitarbeit am Repository ist ausdrücklich erwünscht. Um an den Quellen mitarbeiten zu können wird ein Account bei [GitHub]( https://github.com ) benötigt.

### Allgemein
Nach der Installation von Git erfolgt der Erstbezug der Quellen über den Befehl ```git clone```
```sh
$ git clone https://github.com/xladde/hsw.git <target>
```
```<target>``` beschreibt den Pfad, in dem die Quellen abgelegt werden.

Die jeweils aktuelle Quelltextversion wird über den ```pull```-Befehl vom Server abgerufen. Vorher muss in das lokale Repository navigiert werden.
```sh
$ cd <target>
$ git pull
```

Sind alle Quellen entsprechen bearbeitet worden und soll die neue Version eingespielt werden, so erfolgt dies in drei Schritten:
1.	Hinzufügen der geänderten Dateien zur Watchlist:
	```sh
    $ git add <list of files>
    ```
2.	Festlegen des aktuellen Versionsstandes:
	```sh
    $ git commit -am "<make a comment>"
    ```
3.	Upload der neuen Version
	```sh
    $ git push
    ```
    Es erfolgt eine Aufforderung, den Benutzernamen und das Passwort einzugeben.

### Branching und verschiedene Entwicklungszweige
Git unterstützt die verteilte Entwicklung. So können vom Hauptentwicklungszweig (`master`) verschiedene Zweige abgehen, parallel entwickelt werden und u.U. wieder zusammengefügt werden. In diesem Repository ist jedes Modul in einem eigenen Zweig ausgelagert worden. Die sogenannten Branches tragen den Namenspräfix `dev-` und enden mit der kurzbetzeichnung für die Module. Nachstehende Tabelle gibt einen Überblick:
<center><table>
	<tr>
    	<th>Modul</th>
    	<th>Kurz</th>
    	<th>Branch</th>
	</tr>
    <tr>
    	<td>Einführung Programmierung</td>
    	<td>EiP</td>
    	<td><code>**dev-eip</code></td>
	</tr>
    <tr>
    	<td>Anwendungsprogrammierung</td>
    	<td>AWP</td>
    	<td><code>dev-awp</code></td>
	</tr>
    <tr>
    	<td>LaTeX</td>
    	<td>Tex</td>
    	<td><code>dev-tex</code></td>
	</tr>
</table></center>

Um den Enwticklungszweig zu ändern wird der Befehl `checkout` verwendet:
```sh
$ cd <target>
$ git status
# On branch master
Working directory clean.
$ git checkout <branch>
Switched to branch <branch>
$ 
```

`git status` sollte dabei immer genutzt werden, da es viele Informationen zum aktuellen Zustand des repositories liefert.