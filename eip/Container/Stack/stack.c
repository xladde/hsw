#include <stdio.h>
#include <stdlib.h>

struct elem_t
{
  char* desc;
};

struct stack
{
  const unsigned _size;
  unsigned       pos;
  elem_t*        elements[];
  stack* get_instance( unsigned size )
  {
    elem_t* e[] = (elem_t*) calloc( size, sizeof(elem_t) );
    stack*  s   = (stack*) malloc( sizeof(stack) );
    s->_size    = size;
    s->pos      = 0;
    s->elements = e;
    return s;
  }
  void push( elem_t* e )
  {
    if( pos <= _size-1 && e != NULL )
      { elements[pos++] = e; }
  }
  elem_t* pop()
  {
    if( pos >= 0 ) { return elements[--pos]; }
    else { return NULL; }
  }
  elem_t* peek()
  {
    if( pos >= 0 ) { return elements[pos-1]; }
    else { return NULL; }
  }
}
