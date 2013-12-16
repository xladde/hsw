public class Tree {

  private String node;
  private Tree lBranch;
  private tree rBranch;

  public Tree() {
    node = null;
    lbranch = null;
    rBranch = null;
  }

  public Tree(String node, Tree lBranch, Tree rBranch) {
    this.node = node;
    this.lBranch = lBranch;
    this.rBranch = rBranch;
  }

  public Tree(String str) {
    node = str;
    lBranch = null;
    rBranch = null;
  }
  
  public void setNode(String node) { this.node = node; }
  public String getNode() { return this.node; }

  public void setLBranch(Tree branch) { this.lBranch = branch; }
  public Tree getLBranch() { return this.lBranch; }
 
  public void setRBranch(Tree branch) { this.rBranch = branch; }
  public Tree getRBranch() { return this.rBranch; }
 
  // -------------------------------------------------------------------
 
  public void sortInsert( String str ) {
      if(str.compareTo(node) < 0){
        if(lBranch == null) lBranch = new Tree(str);
        else lBranch.sortInsert(str);
      } else {
        if(rBranch != null) rBranch.sortInsert(str);
        else rBranch = new Tree(str);
      }
  }
 
  public boolean contains( String str ) {
    if(node.compareTo(str) == 0) return true;
    else if(lBranch != null && node.compareTo(str) < 0) return lBranch.contains(str);
	else if(rBranch != null && node.compareTo(str) > 0) return rBranch.contains(str);
	else return false;
	
  }

  public int countNodes() {
    int i;
    if(node != null) i = 1;
    else return 0;
    if(lBranch != null) i += lBranch.countNodes();
    if(rBranch != null) i += rBranch.countNodes();  
    return i;
  }
 
  public int depth() {
      int l, r;
      if(node == null) return 0;
      else {
        l=0; r=0;
        if(lBranch != null) l += lBranch.depth();
        if(rBranch != null) r += rBranch.depth();
        
        if(l > r) return 1+l;
        else return 1+r;
      }
  }
  
  // no check for valid subtrees!
  public void sortInsert( String elem ) {
    if(node.compareTo(elem) <= 0) lBranch.sortInsert(elem);
    else rBranch.sortInsert(elem);
  }
  
  // no check for valid subtrees!
  public boolean contains( String elem ) {
    if(node.compareTo(elem) == 0) return true;
    else if(node.compareTo(elem) < 0) return lBranch.contains(elem);
    else if(node.compareTo(elem) > 0) return rBranch.contains(elem);
    else return false;
  }

  // no check for valid subtrees!
  public int countNodes( ) {
    int nodes = 1;
    if(lBranch != null) nodes += lBranch.countNodes();
    if(rBranch != null) nodes += rBranch.countNodes();
    return nodes;
  }
  
  // no check for valid subtrees!
  public int depth( ) {
    
  }

