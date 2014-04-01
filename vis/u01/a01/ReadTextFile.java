/**
 * @author t.j.
 * @version 2014-03
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

    public static void main(String[] args) {
        
        String str = new String();
        String tmp;
        BufferedReader in;

        try {
            in = new BufferedReader(new FileReader("textdatei.txt"));

            while( (tmp = in.readLine()) != null ) {
                str += tmp;
                str += "\n";
            }

            in.close();

        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(str);

    }

}