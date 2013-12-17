
/**
 * Sortieralgorithmen
 * 
 * @author t.j. 
 * @version 2013-12
 */
public class Sort
{
    /**
     * BubbleSort
     */
    public static char[] bubbleSort(char[] a1)
    {
        int n = a1.length;
        boolean swapped;
        do
        {
            swapped = false;
            for(int i = 0; i < n-2; i++)
            {
                if(a1[i] > a1[i+1])
                {
                    char buf = a1[i];
                    a1[i]    = a1[i+1];
                    a1[i+1]  = buf;
                    swapped  = true;
                }
                printArray(a1);
            }
            n--;
        } while(swapped);
        return a1;
    }
    
    /**
     * SelectSort
     */
    public static int[] selectSort(int[] a1)
    {
        return a1;
    }
    
    /**
     * InsertSort, für sortiertes Einfügen in ein Array
     */
    public static int[] insert(int[] a1, int start, int stop, int neu)
    {
        return a1;
    }
    
    
    private static void printArray(int[] a)
    {
        System.out.print("{");
        for(int i = 0; i < a.length-1; i++) 
        {
            System.out.print(a[i]);
            if(!(i == a.length-1))
                { System.out.print(","); }
        }
        System.out.print("}\n");
    }
}
