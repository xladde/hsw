public class QElem {
  private String node;
  private QElem next;

  public QElem() {
    node = new String();
    next = null;
  }
  
  public QElem(String n) {
    node = n;
    next = null;
  }

  public String getNode() {
    return node;
  }
  
  public void setNode(String n) {
    node = n;
  }
  
  public QElem getNext() {
    return next;
  }
  
  public void setNext(QElem e) {
    next = e;
  }
}