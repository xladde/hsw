/**
 * @author t.j.
 * @version 2014-04
 */

import javax.swing.*;
import javax.swing.table.*;

public class AdvancedTable extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;

    public AdvancedTable(Object[] tableHeader, Object[][] tableData) {
        super("My Simple Table");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(640,480);
        
        this.table = new JTable(new MyTableModel(tableHeader, tableData));
        
        JComboBox cbx = (JComboBox)tableData[0][3];
        this.table.getColumn("ZIP").setCellEditor(new DefaultCellEditor(cbx));
        this.table.getColumn("City").setCellEditor(new DefaultCellEditor(cbx));

        this.scrollPane = new JScrollPane(table);
        this.getContentPane().add(this.scrollPane);

        this.setVisible(true);
    }

}