/**
 * @author t.j.
 * @version 2014-04
 */

import javax.swing.*;
import javax.swing.table.*;

public class MyTableModel extends AbstractTableModel {

    private Object[] tableHeader;
    private Object[][] tableData;

    public MyTableModel(Object[] tableHeader, Object[][] tableData) {
        this.tableHeader = tableHeader;
        this.tableData = tableData;
    }

    public int getColumnCount() {
        return tableHeader.length;
    }

    public int getRowCount() {
        return tableData.length;
    }

    public String getColumnName(int col) {
        return tableHeader[col].toString();
    }

    public Object getValueAt(int row, int col) {
        return tableData[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}