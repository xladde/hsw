/**
 * @file ackermann.c Definiert eine Ackermann-Funktion
 * @author Thomas Jonitz WI09 (114350)
 * @brief Uebungsaufgaube Theoretische Informatik.
 * Die Ackermann-Funktion wird in zwei Schleifen durchgeführt, in der
 * die Funktion mit den Werten <tt>a</tt> und <tt>b</tt>, bis die <tt>MAX_M</tt>
 * und <tt>MAX_N</tt> erreicht haben. Mit den Standarteinstellungen wird der 
 * zunehmende Zeitbedarf zur Berechnung sichtbar.
 */ 
#include <stdio.h>

// Maximale Schleifendurchlaeufe
#define MAX_M 4
#define MAX_N 5

// globale Hilfsvariable zur übersichtlicheren Darstellung auf dem Bildschirm. 
// Variable zählt, wie oft die A-Funktion (da rekursiv) tatsächlich aufgerufen wird.
unsigned long int iteration = 0; 

/**
 * @brief Definition der Ackermann-Funktion.
 * @param m Vorzeichenloser Integer-Wert
 * @param n Vorzeichenloser Integer-Wert
 * @return Ergebnis der Ackermann-Funktion. Long Integer, da das Ergebnis einen sehr
 * großen Wert annehmen kann.
 */
unsigned long int ackermann( unsigned long int m, unsigned long int n )
{
	++iteration;
	if( m == 0 ) 
	{ 
		return n+1;
	} else if( n == 0 )
	{ 
	return ackermann( m-1, 1 ); 
	} else
	{ 
		return ackermann( m-1, ackermann(m, n-1) ); 
	}
}

int main()
{
	unsigned long int a, b;
	system("clear");
	printf("Running Ackermann function.\nThis may take a while or cause a buffer overflow.\n");
	for( a = 0; a < MAX_M; a++ )
	{
		for( b = 0; b < MAX_N; b++ )
		{
			printf( "(%ld, %ld)\tResult: %ld\tSteps: %ld\n", a, b, ackermann( a, b ), iteration );
				iteration = 0; // Zähler zurücksetzen
		}
	}
	return 0;
}