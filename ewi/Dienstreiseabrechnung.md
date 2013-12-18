# Dienstwagenabrechnung
## Aufgabenstellung
Für eine Dienstreise im Inland wurden bis Ende 2012 Verpflegungsmehraufwendungen zu folgenden Beträgen pro
Kalendertag angesetzt:
*   24 Euro bei einer Abwesenheit von 24 Stunden,
*   12 Euro bei einer Abwesenheit von weniger als 24 Stunden, aber mindestens 14 Stunden,
*   6 Euro bei einer Abwesenheit von weniger als 14 Stunden, aber mindestens 8 Stunden

(Nach Paragraph 4 Absatz 5 Satz 1 Nummer 5 Satz 2 des Einkommensteuergesetzes)

Entwickeln Sie eine problemorientierte Anton-Funktion, die aus einer Anzahl von Abwesenheitsstunden aufgrund
einer Dienstreise im Jahr 2012 die Verpflegungsmehraufwendungen in Euro ermittelt. Nutzen Sie dazu auch geeignete
Funktionen aus Arbeitsmaterial Nr. 6 (Problemorientierte Notationsbeispiele).


## Lösung
Funktion AufwandBerechnen(-> Stunden: kardinal): kardinal
Variable Ergebnis: kardinal
  Tage:     kardinal
Beginn
  Ergebnis := 0
  falls Stunden < 8
    dann 
      Ergebnis := 0
    sonst
      falls Stunden < 14
        dann
          Ergebnis := 6
        sonst
          falls Stunden < 24
            dann
              Ergebnis := 12
                sonst
                  Tage := QuotientGanz(Stunden,24)
                  Ergebnis := Produkt(Tage, 24)
                  Ergebnis := Ergebnis 
                            + AufwandBerechnen(Modulo(Tage, 24))
  setzeFunktionswert(Ergebnis)
Ende

## Alternative Lösung
by Marcus Die.

Funktion AufwandBerechnen(-> Stunden: kardinal):fließzahl
Variable Betrag: fließzahl
Beginn
  Betrag := 0.0 + Produkt(QuotientGanz(Stunden, 24), 24)
  Stunden:= Modulo(Stunden, 24)
  falls Stunden >= 14
    dann
      Betrag:= Betrag+12.0
    sonst
      falls Stunden >= 8
        dann Betrag:= Betrag + 6.0
  setzeFunktionswert(Betrag)
Ende





