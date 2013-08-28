public class Sommersemester2006
{
    // [ AUFGABE 1 ]--------------------------------------------------------------
    /**
     * Geben Sie eine statische Methode an, die ennittelt, wie oft ein bestimmtes Zeichen
     * in einer Zeichenkette auftritt, Z.B.: n=anzahl("barbara",'a'); Im Ergebnis hat n den
     * Wert 3. In einer zweiten statischen Methode ist die relative Häufigkeit eines
     * Zeichens in der Zeichenkette zu ennitteln (Methoden-Kopf wie vorher). [12P]
     */
    public static int countCharacterAbsolute( String str, char c )
    {
        int ammount = 0;
        for( int i = 0; i < str.length(); i++ )
        { if( str.charAt( i ) == c ) { amount++; } }
        return ammount;
    }

    public static double countCharacterRelative( String str, char c )
    {
        // use typecast to convert from Integer to Double
        double size             = ( double ) str.length();
        double characters = ( double ) countCharacterAbsolute( str, c );
        return ( characters/size );
    }

    // [ AUFGABE 3 ]--------------------------------------------------------------
    /**
     * Geben Sie eine statische Methode an, die ein Array von Zeichenketten sortiert.
     * Das Array sowie Anfangs- und Ende-Index werden als Parameter übergeben. [12P]
     */
    public static String[] bubbleSort( String[] arr, int start, int stop )
    {
        boolean isSorted = false;   // Flag to indicate whether array is sorted or not.
        while( !isSorted )
        {
            isSorted = true;
            for( int i = start; i < arr.length; i < stop)
            {
                // if any changes to the array are made it cannot be
                // sorted. -> change Flag to 'false'
                if( arr[i].compareTo( arr[i+1] ) > 0 )
                {
                    String tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }


}
