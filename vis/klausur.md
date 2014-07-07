#Teil I

##1. Grundlagen und Begriffe

	a) Skalierbarkeit ist die Fähigkeit die Leistung eines Systems durch hinzufügen oder entfernen von Ressourcen (meist linear) zu steigern, oder zu reduzieren. Zwei Aspekte: 
	1. Hardware muss aufeinander abgestimmt sein, um "Flaschenhälse" zu vermeiden
	2. Softwarearchitektur/Lastskalierbarkeit: dass ein System bei geringer, mittlerer, hoher Last keine zu große Verzögerung aufweist und die Anfragen rasch abgearbeitet werden können.
    
	b) Synchronisation: Eine Anfragesynchronisierung kann bei großen Systemen (WANs) zu Verzögerungen führen.
    
	c) 
        c.1 Transparenz vs. Offenheit: Transparenz=durchsitig/Offenheit=zugreifbar
        c.2 Replikationstransparenz: Mehrere Kopien ein und derselben Ressource können an unterschiedlichen Stellen vorkommen. Instanzen der Ressource müssen sich automatisch an Änderungen anpassen.
        c.3 Nebenläufigkeitstransparenz: Mehrere Benutzer können "gleichzeitig" auf Ressourcen und Dienste zugreifen. Das System sorgt dafür, dass exklusive Zugriffe möglich sind und ggf. Daten synchronisiert und repliziert werden. Der Nutzer denkt, er arbeitet alleine an Ressourcen.
	
	d) Socket: plattformunabhängige, standardisierte Schnittstelle/Softwaremodul als bidirektionaler "Verbindungsendpunkt" (meist auf TCP/IP-Ebene für verbindungsorientierte Kommunikation), um PC in ein Rechnernetz einzubinden, oder zwischen Prozessen eines Rechners zu kommunizieren. Eindeutig gekennzeichnet durch URI(IP/URL, inkl. Adressfamilie) und Port.

##2. Remote Procedure Calls (RPC)
