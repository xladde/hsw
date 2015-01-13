
/**
 * Beschreiben Sie hier die Klasse Reverse.
 * 
 * @author Uwe Laemmel    
 * @version Datum
 */
public class Reverse {
  // Instanzvariablen 

  public static Telefon[] reverse(Telefon[] arr){
    Keller st = new Keller(4);

    for(int i=0;i<arr.length;i++)st.push(arr[i]);
    
    Telefon[] temp = new Telefon[arr.length];
    for(int i=0;i<arr.length;i++){
      temp[i]=st.top();
      st.pop(); 
    }
    return temp;
  }

} //Reverse
