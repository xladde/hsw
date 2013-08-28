/**
 * @file recursion.c C-Funktionen zur Rekursion
 * @author tj
 * @version 2012-12-10
 */
#include <stdlib.h>
#include <stdio.h>

// deklarationen
unsigned int digit_sum(unsigned int n);
unsigned long int faculty(unsigned long int n);
unsigned int fibonacci(unsigned int n);
unsigned long int ackermann(unsigned long int m, unsigned long int n);

// main-funktion
int main()
{
  int a=16;
  printf("Quersumme:\t%d\n", digit_sum(a));
  printf("Fakultät:\t%d\n", faculty(a));
  printf("Fibonacci:\t%d\n", fibonacci(a));
  printf("Ackermann:\t%d\n", ackermann(3, 4));
  
}

/**
 * @brief berechnet die Quersumme einer Zahl.
 * @param n Zahl, deren Quersumme berechnet werden soll.
 * @return Quersumme von n.
 * 
 * Die Funktion prüft zunächst, ob die Zahl aus mehr als einer Ziffer besteht.
 * Ist dies der Fall, wird die letzte Ziffer über die Modulo-operation 
 * abgespalten. Darauf wird die Quersumme der restlichen Ziffern addiert.
 */
unsigned int digit_sum(unsigned int n)
{
  if( n < 10 ) return n;
  else return n%10 + digit_sum( n/10 );
}

/**
 * @brief Berechnet rekursiv die Fakultät einer Zahl n.
 * @param n Vorzeichenloser long Integer.
 * @return Vorzeichenlose Fakultät.
 * 
 * Ist die übergebene Zahl 0, so wird 1 zurückgegeben. Andernfalls
 * wird die Zahl mit der Fakultät ihrer Vorgängerzahl multipliziert.
 */
unsigned long int faculty( unsigned long int n )
{
  if( n == 0 ) return 1;
  else return n*faculty( n-1 );
}

/**
 * @brief Fibonacci-Folge berechnen
 * @param Fibonacci-folge bis n.
 * @return n-te Fibonacci-Zahl.
 */
unsigned int fibonacci( unsigned int n )
{
  if(n == 0) return 0;
  else if(n == 1) return 1;
  else return fibonacci(n-1)+fibonacci(n-2);
}

/**
 * @brief Ackermann-Funktion.
 * @param m Vorzeichenloser Integer.
 * @param n Vorzeichenloser Integer.
 * @return Vorzeichenloser Integer.
 */
unsigned long int ackermann( unsigned long int m, unsigned long int n )
{
  if( m == 0 ) return n+1;
  else if( n == 0 ) return ackermann( m-1, 1 );
  else return ackermann( m-1, ackermann(m, n-1) );
}
