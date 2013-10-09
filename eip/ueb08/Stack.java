import java.util.ArrayList;

public class Stack {
  private ArrayList<String> stack;
  
  public Stack(){
    stack = new ArrayList<String>();
  }
  
  public void push(String str) {
    stack.add(str);
  }
  
  public String pop() {
    String str = "";
    if(stack.size() > 0) {
      str = stack.get(stack.size()-1);
      stack.remove(stack.size()-1);
    }
    return str;
  }
  
  public String peek() {
    String str = "";
    if(stack.size() > 0) {
      str = stack.get(stack.size()-1);
    }
    return str;
  }
  
  public boolean isEmpty() {
    if(stack.size() == 0) return true;
    else return false;
  }
  
  public int depth() {
    return stack.size();
  }
  
  public String toString() {
    String tmp = "Stack: [";
    for(String str: stack) {
      tmp += str + ";";
    }
    tmp += "]";
    return tmp;
  }
  
  public static void main(String[] args) throws Exception {
    LineIO io = new LineIO();
    Stack stack = new Stack();
    char iC;
    do {
      io.write("p-push  o-pop  k-peek x-exit  e-IsEmpty  d-depth  l-list\n");
      iC = io.readChar("Command: ");
      if(iC == 'p') {
        String element = io.readString("\tinsert element: ");
        stack.push(element);
      } 
      if(iC == 'o') System.out.println(stack.pop());
      if(iC == 'k') System.out.println(stack.peek());
      if(iC == 'e') System.out.println(stack.isEmpty());
      if(iC == 'd') System.out.println(stack.depth());
      if(iC == 'l') System.out.println(stack.toString());      
    } while(iC != 'x');
  }
}