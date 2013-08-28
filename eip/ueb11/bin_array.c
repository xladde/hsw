#include <stdlib.h>
#include <stdio.h>

#define TEST_NUMBER 593
#define DIGITS 16

int* to_bin(unsigned int n);

int main()
{
  int* array = to_bin(TEST_NUMBER);
  
  printf("%d is binary: ", TEST_NUMBER);
  for(int i = 0; i < DIGITS; i++) printf("%d", array[i]);
  printf("\n");
  
  // clean allocated memory!!!
  free(array);  
  return 0;
}

int* to_bin(unsigned int n)
{
  int* code = (int*) calloc(DIGITS, sizeof(int));
  for(int i=0; i<DIGITS; i++) code[i] = 0;
  
  for(int i=DIGITS-1; i >= 0; i--)
  {
    code[i] = n%2;
    n = n/2;
  }
  
  return code;
}
