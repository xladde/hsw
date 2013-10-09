# HSW-Repository Wirtschaftsinformatik
: http://xladde.github.io/hsw/

## Inhalt und Umfang
Dieses Repository dient der Dokumentation der Tutorien und Seminare im Studiengang "Wirtschaftsinformatik" (B.Sc.) an der Hochschule Wismar. Nach aktuellem Stand umfasst dies folgende Module:

* Einführung in die Programmierung (WS 2012/2013)
* Anwendungsprogrammierung (SS 2013)

Weiterhin sind Dokumentationen für die folgenden Module geplant oder in Arbeit:

* Einführung in die Wirtschaftsinformatik (WS 2013/2014)
* Theoretische Informatik (WS 2012/2013)
* Künstliche Intelligenz (SS2013)
* Systemprogrammierung (WS 2012/2013)
* Mobile Agenten (Wahlpflicht)

Die Dokumentation dient lediglich der Ergänzung zur Teilnahme an den Seminaren, Vorlesungen und Tutorien. In keinem Fall ist es ein Ersatz der Lehrveranstaltungen.

## Lizenz und Urheberrecht

Alle Beispiel- und Klausuraufgaben unterliegen dem Urheberrecht der Hochschule Wismar, Fakultät für Wirtschaftswissenschaften und insbesondere den Verantwortlichen Lehrbeauftragten der jeweiligen Module. Eine Weiterverbreitung und Reproduktion - auch auszugsweise - ist nicht gestattet.

Alle Beispiele und Musterlösungen stehen unter der GNU General Public License 3.0 und dürfen frei verwendet werden. Das Wiki, sowie sämtliche extra für die Seminare und Tutorien angefertigten Paper und Dokumentationen stehen unter einer Creative Commons 3.0 (cc) by-nc-sa-Lizenz.

Eine Mitarbeit an dieser Dokumentation ist erwünscht. Vorrausgesetzt wird ein faier Umgang mit den angefertigten Softwareprodukten; mindestens nach den Maßgaben der Free Software Foundation.

## Verwendung und Konfiguration

Dieses Repository wird stetig weiterentwickelt und aktualisiert. Eine Mitarbeit der Seminarteilnehmer ist ausdrücklich erwünscht. Im folgenden werden verschiedene Möglichkeiten zum Umgang mit diesem Repository erläutert.

### Gepackte Archive

Die aktuellen Quellen sind als ZIP-Archiv, als TAR-Ball oder über die jeweilige Veranstaltung in Stud.IP erreichbar.

### Quellupdate via Git

Git ist eine freie Software zur Versionsverwaltung und speziell für die kollaborative Arbeit an Programmquelltexten entworfen. Um die Quellen aus den Seminaren und Tutorien über Git zu beziehen, muss ein Git-Client lokal auf dem Rechner installiert werden.

Clone Repository: Für das erstmalige Beziehen der Quellen wird eine Kopie des Repos benötigt. Dazu muss ein Terminal geöffnet und folgender Befehl eingegeben werden:

$ git clone https://github.com/xladde/hsw.git <target>

Pull Repository: Bei jedem lokalen Update, also dem Bezug der aktuellsten Quellversionen eines bestehenden Repos muss folgender Befehl ausgeführt werden.

$ git pull

Push Repository: Das aktualisieren der Quellen auf dem Server kann nur durch autentifizierte Benutzer und Mitarbeiter erfolgen. Wer sich an der Mitarbeit beteiligen möchte, muss sich mit dem Projektbezitzer in Verbindung setzen. Der Upload erfolgt im Wesentlichen in drei Schritten:

Hinzufügen der geänderten Dateien zur Watchlist:

$ git add <list of files>

Festlegung des Versionsstandes:

$ git commit -am <be polite and make a comment on your commit>

Upload der geänderten Dateien:

$ git push

Nach dem letzten Schritt sind der Benutzername und das Passwort zur Autentifizierung einzugeben.
