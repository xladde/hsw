public class Sortieren
{
  public static int linearSearch(int[] arr, int elem)
  {
    for(int index = 0; i < arr.length; i++)
    {
      if(elem == ar[index]) return index;
    }
    return -1;
  }
  
  public static int binSearch(int[] arr, int elem)
  {
    unten = 0;
    oben = arr.length-1;
    int next = (unten+oben)/2;
    while ( unten<oben && arr[next]!=elem )
    {
      if ( elem<arr[next] ) oben=next –1; else unten=next+1;
      next = ( unten+oben ) / 2;
    } //while
    if (arr[next]==gesucht) return next; 
    else return –1;
  }
  
  public static int minSearch(int[] arr)
  {
    int mindex = 0;
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i] < arr[mindex]) mindex = i;
    }
    return mindex;
  }
  
  public static int maxSearch(int[] arr)
  {
    int mindex = 0;
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i] > arr[mindex]) mindex = i;
    }
    return mindex;
  }
  
  public static int selectSort(int[] arr, int from, int to)
  {
  }
  
  public static int[] bubbleSort(int[] arr)
  {
  }
  
  public static int[] insert(int[] folge, int anf, int ende, int neu)
  {
  }
  
  public static int[] insertSort(int[] arr, int element)
  {
  }
}