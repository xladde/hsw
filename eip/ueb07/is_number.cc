/**
 * @file is_number.cc Checks wether a string is a number or not.
 * @author tj
 * @version 2012-11-05
 */
 
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

using namespace std;

/**
 * @brief Function to parse a string for numbers.
 * 
 * ...
 * 
 * @param str. A Pointer to a sequence of characters.
 * @return a boolean value. true, if the string is a number, false if the
 * string is not a number.
 */
bool is_number(char* str)
{
    bool number = true;
    char current;
    char numbers[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    if(str != NULL) // check for valid parameter
    {
        // loop for every character in string
        for(unsigned int i = 0; i < strlen(str); i++)
        {
            bool is_in_array = false;
            current = str[i];
            
            // loop for every character in numbers-array
            for(unsigned int j = 0; j < 10; j++)
            {
                if(numbers[j] == current) // compare
                {
                    // if character is same as number: break loop and set flag
                    is_in_array = true;
                    break;
                } else continue;
            }
            
            // if character is not in numbers-array this string is not a number
            if(!is_in_array) 
            {
                number = false;
                break;
            }
        }
        return number;
    } else
    {
        return false;
    }
}

int main(int argc, char** argv)
{
    // start with '1'. Argument 0 is name of programm.
    for(int i = 1; i < argc; i++)
    {
        if(is_number(argv[i])) printf("%s\tis a Number\n", argv[i]);
        else printf("%s\tis not a Number\n", argv[i]);
    }
    exit(0);
}