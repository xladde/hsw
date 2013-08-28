/**
 * @author
 * @version
 */

public class IsNumber{

  public static boolean isNumber(String str){
    
    boolean number = true;
    char currentCharacter;
    char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    for(int i = 0; i < str.length(); i++){
      boolean isInArray = false;
      currentCharacter = str.charAt(i);
      for(char j: numbers){
        if(j == currentCharacter) isInArray = true;
        else continue;
      }
      
      if(!isInArray){
        number = false;
        break;
      }
    
    }
    return number;
  }
  
  
  public static void main(String[] args){
    
    for(String i:args){
      if(isNumber(i)){
        System.out.println(i+"\tis a number.");
      } else {
        System.out.println(i+"\tis not a number.");
      } 
    }
  
  }

}