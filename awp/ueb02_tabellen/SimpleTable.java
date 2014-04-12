/**
 * @author t.j.
 * @version 2014-04
 */

import javax.swing.*;

public class SimpleTable extends JFrame {
    
    private JTable      table;
    private JScrollPane scrollPane;

    public SimpleTable(Object[] header, Object[][] data) {
        super("My Simple Table");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(640,480);
        init(header, data);
        this.setVisible(true);
    }

    private void init(Object[] header, Object[][] data) {
        this.table = new JTable(data, header);
        this.scrollPane = new JScrollPane(this.table);
        this.getContentPane().add(this.scrollPane);
    }
}