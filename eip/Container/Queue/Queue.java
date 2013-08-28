/**
 * @brief Abarbeitungsschlange.
 */
public class Queue {

  // 1. INSTANZVARIABLEN
  private Element first;  // Das erste Element in der Schlange
  private Element last;   // Das letzte Element in der Schlange

  // 2. KONSTRUKTOREN
  public Queue() {
    first = null;
    last = null;
  }

  // 3. HILFSMETHODEN
  /**
   * @brief Ein Element zur Schlange hinzufügen.
   * @param Objekt vom Typ <code>Element</code>, dass an das Ende
   *        der Schlange geschrieben wird.
   */
  public void addElement( Element elem ) {
    if( first == null ) { // falls erstmalig belegt
      first = last = elem;
    } else {
      last.setNext( elem );
      last = elem;
    }
  }

  /**
   * @brief Ein Element aus der Schlange entfernen.
   * @return Objekt vom Typ <code>Element</code>. Das erste Element
   *         (<code>first</code>) wird zurückgegeben und das zweite 
   *         Element wird zum ersten.
   */
  public Element getNext() {
    if( first != null ) { 
      Element tmp = first;
      first = first.getNext();
      return tmp;
    } else { return null; }
  }
}