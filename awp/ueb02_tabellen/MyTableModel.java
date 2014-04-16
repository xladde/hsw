/**
 * @author t.j.
 * @version 2014-04
 */

import javax.swing.*;
import javax.swing.table.*;

public class MyTableModel extends AbstractTableModel {

    private Object[] tableHeader = {
        "Nr.", "Name", "Country", "ZIP", "State", "City", "Street", "Number"
    };
    public static Object[] plz = {new Integer(23966), new Integer(20357)};
    public static JComboBox<Object> plzBox = new JComboBox<Object>(plz);
    public static Object[] city = {new String("Wismar"), new String("Hamburg")};
    public static JComboBox<Object> cityBox = new JComboBox<Object>(city);

    private Object[][] tableData = {
        { new Integer(1), "Robert Schmidt", "Germany", plzBox, "Mecklenburg-Western Pommerania", cityBox, "Phillip-Mueller-Str.", "14" },
        { new Integer(2), "Gottlob Frege", "Germany", plzBox, "Mecklenburg-Western Pommerania", cityBox, "Phillip-Mueller-Str.", "14" },
        { new Integer(3), "Klaus Stoertebeker", "Germany", plzBox, "Mecklenburg-Western Pommerania", cityBox, "Phillip-Mueller-Str.", "14" },
        { new Integer(4), "Holger Jung", "Germany", plzBox, "Hamburg", cityBox, "Glashuettenstrasse", "79" },
        { new Integer(5), "Jean-Remy von Matt", "Germany", plzBox,"Hamburg", cityBox, "Glashuettenstrasse", "79" }
    };

    public MyTableModel() {
        this.tableHeader = tableHeader;
        this.tableData = tableData;
    }

    @Override
    public int getColumnCount() {
        return tableHeader.length;
    }

    @Override
    public int getRowCount() {
        return tableData.length;
    }

    @Override
    public String getColumnName(int col) {
        return tableHeader[col].toString();
    }

    @Override
    public Object getValueAt(int row, int col) {
        /*
        if(col == 3 || col == 5) {
            JComboBox cbx = (JComboBox)tableData[row][col];
            return cbx.getSelectedItem();
        } else {return tableData[row][col];}
        */
        return tableData[row][col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 3 || col == 5) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        tableData[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}