/**
 * @file ackermann.c Implements an ackermann function
 * @author t.j.
 * @version 2013-06-26
 *
 * This program implements an Ackermann function that shows
 * a fast growth of needed runtime.
 *
 * Compile:
 *      $ gcc -Wall -ggdb -o ackermann.o ackermann.c
 *
 * Usage:
 *      Run this program either with two arguments for 'm' and 'n':
 *              $ ./ackermann.o <m> <n>
 *      or without any arguments. 'm' will be 5 and 'n' will
 *      be 14 by default.
 *
 * Note:
 *      This program is very slow due to the complex
 *      recursive function. It will take a while to
 *      compute the results or, it will cause a
 *      buffer overflow (mainly the global iterator).
 *
 *      This file is also located in the 'hsw' repository.
 *              $ git clone http://code.google.com/p/xladde.hsw 
 *
 * For more information about the Ackermann function:
 *      http://en.wikipedia.org/wiki/Ackermann_function
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// define maximum nuber of loops
#define MAX_M 4
#define MAX_N 14

// some iterator to count inside loops
unsigned iteration;

/**
 * @brief Ackermann function.
 * @param m First argument.
 * @param n Second argument.
 * @return Result of calculation.
 */
unsigned ackermann( unsigned m, unsigned n )
{
    ++iteration;
    if( m==0 ) 
        { return n+1; }
    else if( n==0 ) 
        { return ackermann(m-1, 1); }
    else
        { return ackermann( m-1, ackermann(m, n-1) ); }
} // end ackermann fnc

/**
 * @brief Main function.
 */
int main( int argc, char *argv[] )
{
    unsigned a, 
             b, 
             m, 
             n, 
             result;
    float    runtime;
    clock_t  start, 
             stop;
        
    iteration = 0;
    
    // preparing values    
    if( argc == 3 )
    {
            m = (unsigned)atoi( argv[1] );
            n = (unsigned)atoi( argv[2] );
    } else
    {
        m = (unsigned)MAX_M;
            n = (unsigned)MAX_N;
    }
    
    // some output
    system( "clear" );
    printf( "Running Ackermann." );
    printf( "This may take some time or causes a buffer overflow\n" );
    
    // here starts the action    
    for( a=0; a<m; a++ )
    {
        for( b=0; b<n; b++ )
        {
            start   = clock();  // start timer
            result  = ackermann( a, b );
            stop    = clock();  // stop timer                    
            runtime = (float)(stop-start)/(float)(CLOCKS_PER_SEC);
                        
            printf( "(%u,%u)\t= %u\ttime: %.2f sec\titerations: %d\n", 
                    a, b, result, runtime, iteration );
                        
            iteration = 0;
        } // end inner for
    } // end outer for
    return EXIT_SUCCESS;
} // end main fnc
 
