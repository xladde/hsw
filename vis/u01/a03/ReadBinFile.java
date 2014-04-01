/**
 * @author t.j.
 * @version 2014-03
 */
import java.io.*;

public class ReadBinFile {
    public static void main(String[] args) {
        
        DataInputStream in;
        double data = 0;

        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.out")));

            data = in.readDouble();

            in.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(data);

    }
}