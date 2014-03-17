/**
 * @author t.j.
 * @version 2014-03
 */
import java.io.*;

public class WriteBinFile {
    public static void main(String[] args) {
        
        DataOutputStream out;
        double data = 3.1415926654;

        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.out")));

            out.writeDouble(data);

            out.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
}