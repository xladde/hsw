# Aufgabe Kontoauszug
## a)
```
Typ Kontoauszug = Verbund( 
    knr: ganzzahl 
    blz: ganzzahl 
    azn: ganzzahl 
    sala: fließzahl 
    sollb: Reihe[1..m] von fließzahl 
    habenb:Reihe[1..n] von fließzahl 
    saln: fließzahl  
) 
```

## b)
```
Variable k : Kontoauszug 
Aktion neuerSaldo(<-> k:Kontoauszug) 
Beginn 
    k.saln := k.sala + [k.habenb] - [k.sollb] 
Ende 
```

## c)
```
Variable k : Kontoauszug 
Funktion SummeHaben(<-> K:Kontoauszug) : fließzahl 
Variable I : ganzzahl 
Variable Rueckgabe : fließzahl 
Beginn 
    I := 0 
    Rueckgabe := 0.0 
    solange I < K.n 
    Beginn 
        Rueckgabe:= Rueckgabe + K.habenb[I] 
        I := I+1 
    Ende 
    setzeFunktionswert(Rueckgabe) 
Ende 

Funktion SummeSoll(<-> K:Kontoauszug) : fließzahl 
Variable I : ganzzahl 
Variable Rueckgabe : fließzahl 
Beginn 
    I := 0 
    Rueckgabe := 0.0 
    solange I < K.m 
    Beginn 
        Rueckgabe:= Rueckgabe + K.sollb[I] 
        I := I+1 
    Ende 
    setzeFunktionswert(Rueckgabe) 
Ende 

Aktion neuerSaldo(<-> K:Kontoauszug) 
Beginn 
    K.saln := K.sala + SummeHaben(K) - SummeSoll(K) 
Ende 
```
