/**
 * @file abzaehlreim
 * @author tj
 * @version 2012-11-05
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <math.h>

void print(int argc, bool argv[])
{   
    for(int i = 0; i < argc; i++)
    {
        printf("%s", argv[i]?"+":"-");
    }
    printf("\n");
    sleep(1);
}

int counting_out(int elements, int offset)
{
    int pos;
    bool ch[elements];
    
    // prepare array
    for(int i = 0; i < elements; i++) ch[i] = true;
    pos = -1;
    
    // c: count how many elements have been kicked out
    for(int c = 0; c < elements; c++)
    {print(elements, ch);

        for(int s = 0; s < offset; s++)
        {
            do // next valid element
            {
                pos++;
                if(pos >= elements) pos = 0;
            } while(ch[pos] != true);
        }
        ch[pos] = false;
    }
    return pos+1;
}

int main()
{
    printf("Element %d is left in array.\n", counting_out(12,9));
    return EXIT_SUCCESS;
}