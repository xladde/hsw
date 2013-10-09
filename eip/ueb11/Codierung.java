public class Codierung
{
    public static int[] binaerCode(int n)
    {
        int[] code = new int[16];
        for(int i = 0; i < 16; i++) code[i] = 0;
        
        for(int i = 15; i >= 0; i--)
        {
            code[i] = n%2;
            n = n/2;
        }
        
        return code;
    }
}