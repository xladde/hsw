public class BinTree {

  // 1. INSTANZVARIABLEN
  private String  node;
  private BinTree left;
  private BinTree right;

  // 2. KONSTRUKTOREN(EN)
  public BinTree( String node ) {
    this.node = node;
    left = right = null;
  }

  // 3. HILFS- UND ZUGRIFFSMETHODEN
  public BinTree getLeft()              { return left; }
  public void setLeft( BinTree left )   { this.left = left; }
  public BinTree getRight()             { return right; }
  public void setRight( BinTree right ) { this.right = right; }
  public BinTree getNode()              { return node; }
  public void setNode( String node )    { this.node = node; }

  public void insert( BinTree bt ) {
    if( node.compareTo( bt.node ) >= 0 ) {
      if( right == NULL ) { right = bt; }
      else { right.insert( bt ); }
    } else {
      if( left == NULL ) { left = bt; }
      else { left.insert( bt ); }
    }
  }

  public int getDepth() {
    int ldepth, rdepth;
    if( left != NULL ) {
      ldepth = 1;
      ldepth += left.getDepth();
    } else { ldepth = 0; }
    if( right != NULL ) {
      rdepth = 1;
      rdepth += right.getDepth();
    } else { rdepth = 0; }
    if( ldepth >= rdepth ) { return ldepth; }
    else { return rdepth; }
  }

  public int size() {
    int size = 1;
    if( left != NULL ) { size += left.size(); }
    if( right != NULL ) { size += right.size(); }
    return size;
  }

  public boolean isInTree( String str ) {
    boolean inLeft;
    boolean inRight;
    if( node.compareTo( str ) == 0 ) { return true; }
    else {
      if( left != NULL ) { inLeft = left.isInTree( str ); }
      if( right != NULL ) { inRight = right.isInTree( str ); }
    }  
    if( inLeft || inRight ) { return true; }
    else { return false; }
  }
}