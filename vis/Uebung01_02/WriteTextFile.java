/**
 * @author t.j.
 * @version 2014-03
 */
import java.io.*;

public class WriteTextFile {
    public static void main(String[] args) {
        
        PrintWriter out;
        String str = new String("3.1415926654");

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("Outputfile.txt")));

            out.println(str);

            out.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
}