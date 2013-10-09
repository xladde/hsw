/**
 * @file    ackermann.c Definiert eine Ackermann-Funktion
 * @author  t.j.
 * @version 2013-08
 *
 * @brief   Uebungsaufgaube Theoretische Informatik.
 *          Die Ackermann-Funktion wird in zwei Schleifen durchgeführt, 
 *          in der die Funktion mit den Werten <tt>a</tt> und <tt>b</tt>, 
 *          bis die <tt>MAX_M</tt> und <tt>MAX_N</tt> erreicht haben. Mit den 
 *          Standarteinstellungen wird der zunehmende Zeitbedarf zur 
 *          Berechnung sichtbar.
 */ 
#include <stdlib.h>
#include <stdio.h>

// Maximale Schleifendurchlaeufe
#define MAX_M 4
#define MAX_N 12

// definiere einen neuen (vorzeichenlosen) Typ.
typedef unsigned long long int ulong64;

// globale Hilfsvariable zur übersichtlicheren Darstellung auf dem Bildschirm. 
// Variable zählt, wie oft die A-Fkt (da rekursiv) tatsächlich aufgerufen wird.
ulong64 iteration = 0; 

/**
 * @brief   Definition der Ackermann-Funktion.
 * @param m Vorzeichenloser Integer-Wert
 * @param n Vorzeichenloser Integer-Wert
 * @return  Ergebnis der Ackermann-Funktion. Long Integer, da das Ergebnis 
 *          einen sehr großen Wert annehmen kann.
 */
ulong64 ackermann( ulong64 m, ulong64 n )
{
        ++iteration;
        if( m == 0 ) 
        { 
                return n+1;
        } else if( n == 0 )
                { return ackermann( m-1, 1 ); } 
        else
                { return ackermann( m-1, ackermann(m, n-1) ); }
} // end ackermann

/**
 * @brief  Main-Funktion mit Testroutine.
 * @return 0
 */
int main( void )
{
        ulong64 a, b;
        system( "clear");
        printf( "Running Ackermann function.\n");
        printf( "This may take a while or cause a buffer overflow.\n" );
        for( a = 0; a < MAX_M; a++ )
        {
                for( b = 0; b < MAX_N; b++ )
                {
                        printf( "(%lld, %lld)\tResult: %lld\tSteps: %lld\n", 
                                a, b, ackermann( a, b ), iteration );
                        iteration = 0; // Zaehler zurücksetzen
                }
        }
        printf( "Finished.\n" );
        return 0;
}// end main