/**
 * @brief Die Klasse bildet ein Element einer Abarbeitungsschlange ab.
 */
public class Element {


  // 1. INSTANZVARIABLEN
  private Object  node; // Der Inhalt des Elements
  private Element next; // Der Verweis auf das nächste Element in der Schlange

  // 2. KONSTRUKTORE(EN)
  public Element( Object obj ) {
    node = obj;
    next = null;
  }

  // 3. HILFSMETHODEN
  public void setNext( Object elem ) { next = elem; } 
  public Element getNext()           { return next; }
  public void setNode( Object obj )  { node = obj; }
  public Object getNode()            { return node; }
}