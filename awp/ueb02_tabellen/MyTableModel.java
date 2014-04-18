/**
 * @author t.j.
 * @version 2014-02
 */

import javax.swing.table.AbstractTableModel;
import javax.swing.JComboBox;

public class MyTableModel extends AbstractTableModel {
    private Object[]    header;
    private Object[][]  data;

    public MyTableModel(Object[][] data, Object[] header) {
        this.header = header;
        this.data   = data;
    }

    @Override
    public int getColumnCount() {
            return header.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return header[col].toString();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        if((col == 4)||(col == 5)) {
            return true;
        } else { return false; }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        switch(col) {
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
        fireTableCellUpdated(row, col);
    }

}