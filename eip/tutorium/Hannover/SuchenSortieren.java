
/**
 * Beschreiben Sie hier die Klasse SuchenSortieren.
 * 
 * @author Uwe Laemmel    
 * @version 12.4.14
 */
public class SuchenSortieren {

  public static String[] bubbleSort(String[] f, int anf, int ende){
    boolean getauscht=false;

    do{
      getauscht=false;
      for(int i=anf;i<ende-1;i++){
        if(f[i].compareTo(f[i+1])>0){
          String tmp=f[i];f[i]=f[i+1];f[i+1]=tmp;
          getauscht=true;
        }
      }
    }
    while(getauscht);    
   return f;
  }

  public static String[] selectSort(String[] f, int anf, int ende){
    
    // Wiederhole die Schritte
    for(int i=anf;i<ende-1;i++){ 
      // Minimum suchen
      String minwert = f[i];
      int minpos  = i;
      for(int k=i+1 ;k<ende;k++)
        if(f[k].compareTo(minwert)<0){minwert=f[k]; minpos=k;}
      // Minimum an Anfang tauschen
      f[minpos]=f[i]; f[i]=minwert;
    }//for
    return f;
  }
  public static void ausgabe(String[] f,int anf, int ende){
    for(int i=anf;i<ende;i++) System.out.print("  "+f[i]);
    System.out.println();
  }  

  public static String[] selectSort(String[] f){
     return selectSort(f,0,f.length);
  }

  public static void main(String[] args)throws Exception{
    LineIO ea = new LineIO();
    String x;
    do{
      x=ea.readString("Bitte Wort eingeben: ");
    }
    while(x.length()>0);

    String[] a1={"tom","kai","eva","leo","pit","ina"};
    ausgabe(a1,0,a1.length);
    String[] a2= bubbleSort(a1,0,a1.length);
    ausgabe(a2,0,a1.length);
  }

} //SuchenSortieren
