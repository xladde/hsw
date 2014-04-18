/**
 * @author t.j.
 * @version 2014-02
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.AbstractTableModel;

public class MyTable {
    
    private JFrame          frame;
    private JScrollPane     scrollPane;
    private JTable          table;

    public MyTable(Object[][] data, Object[] header) {
        table = new JTable(data, header);
        constructFrame("SimpleTable");

    }

    public MyTable(MyTableModel tableModel) {
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(Data.getCityData()));
        table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(Data.getZipData()));
        constructFrame("Table with TableModel");
    }

    private JFrame constructFrame(String title) {
        frame = new JFrame(title);
        frame.setSize(640, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        //frame.pack();
        frame.setVisible(true);
        return frame;
    }


    public static void main(String[] args) {
        //new MyTable(Data.getData(), Data.getHeader());
        new MyTable(new MyTableModel( Data.getData(), Data.getHeader() ));
    }


}
