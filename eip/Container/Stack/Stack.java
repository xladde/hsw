/**
 * @brief Klasse repräsentiert einen Kellerspeicher (Stack).
 * Der Stack nimmt Elemente vom Typ <code>Object</code> auf.
 *
 */
public class Stack {

  // 1. INSTANZVARIABLEN #####################################################
  private Object  stck[]; // Datenablage für Elemente im Keller
  private int     pos;    // Position des obersten Elements im Keller

  // 2. KONSTRUKTOR(EN) ######################################################
  /**
   * @brief Stack mit Defaultgröße anlegen.
   */
  public Stack() {
    stck = new Object[64];
    pos = -1;
  }

  /**
   * @brief Stack mit benutzerdefinierter Größe anlegen.
   * @param stacksize Maximale Anzahl an zu speichernden Elementen.
   */
  public Stack( int stacksize ) {
    stck = new Object[stacksize];
    pos = -1;
  }

  // 3. ZUGRIFFSMETHODEN #####################################################
  /**
   * @brief Stack mit einem Objekt befüllen.
   * @param o Element, dass in den Stack gelegt werden soll.
   */
  public void push( Object o ) {
    if( pos < stck.len-1 ) { 
      stck[++pos] = o; 
    } else {}
  }

  /**
   * @brief Oberstes Element aus dem Stack holen.
   * @return  Das oberste Element im Stack, oder ein leerer Wert, falls der
   *          Stack keine Elemente enthält.
   */
  public Object pop() {
    if( pos >= 0 ) {        // prüfen, ob mindestens ein Element vorhanden 
      pos--;
      return stck[pos+1]; 
    } else {                // leeren Wert zurückgeben, wenn keine Elemente.
      return null;
    }
  }

  /**
   * @brief Oberstes Element im Stack anzeigen.
   * @return  Das oberste Element im Stack, oder ein leerer Wert, falls der
   *          Stack keine Elemente enthält.
   */
  public Object peek() {
   if( pos < 0 ) {      // prüfen, ob Stack leer. Wenn ja, leeren Wert zurückgeben. 
      return null; 
    } else { 
      return stck[pos]; // Wenn mind. ein Element, das oberste Objekt zurückgeben.
    } 
  }
}