public class CountOut {
    
    public static int countOut(int elements, int offset) {
    
        int pos;
        boolean ch[] = new boolean[elements];
        
        // prepare array
        for(int i = 0; i < ch.length; i++) ch[i] = true;
        pos = -1;
        
        // c: count how many elements have been kicked out
        for(int c = 0; c < ch.length; c++) {
            for(int s = 0; s < offset; s++) {
                do {
                    pos++;
                    if(pos >= ch.length) pos = 0;
                } while(ch[pos] != true);
            }
            ch[pos] = false;
        }
        return pos+1;
    }
    
    public static void main(String[] args) {
        // Todo...
    }
}