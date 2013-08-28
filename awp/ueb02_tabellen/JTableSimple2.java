import java.awt.*;
import javax.swing.*;

public class JTableSimple {
  /** CONTENT FOR JTABLE */
  public static int         ID   = 1;
  public static String[]    Head = {
    "ID", "Straße", "HNr", "PLZ", "Stadtteil", "Stadt", "Land"
  };
  public static Object[][]  Cont = {
    { new Integer(ID++), "1_s2", "1_s3", "1_s4", "1_s5", "1_s6", "1_s7" },
    { new Integer(ID++), "2_s2", "2_s3", "2_s4", "2_s5", "2_s6", "2_s7" },
    { new Integer(ID++), "3_s2", "3_s3", "3_s4", "3_s5", "3_s6", "3_s7" },
    { new Integer(ID++), "4_s2", "4_s3", "4_s4", "4_s5", "4_s6", "4_s7" },
    { new Integer(ID++), "5_s2", "5_s3", "5_s4", "5_s5", "5_s6", "5_s7" },
  };

  /** ELEMENTS TO USE OR DISPLAY */
  private JFrame      frame;
  private JTable      table;
  private JScrollPane bpane;
  public JTableSimple(String[] head, Object[][] content) {
    frame = new JFrame("Display a Simple Table");
    frame.setSize(500,500);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    table = new JTable(content, head);
    bpane = new JScrollPane(table);
    frame.add(bpane);

    frame.setVisible(true);
  }

  public static void main(String[] args){
    JTableSimple jts = new JTableSimple(JTableSimple.Head, JTableSimple.Cont);
  }

}