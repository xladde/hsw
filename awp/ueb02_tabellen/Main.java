/**
 * @author t.j.
 * @version 2014-04
 */

import javax.swing.*;

public class Main {

    // TEST DATA: COLUMN HEADER
    public static Object[] tableHeader = {
        "Nr.", "Name", "Country", "ZIP", "State", "City", "Street", "Number"
    };

    // TEST DATA: SIMPLE TABLE DATA
    public static Object[][] simpleTableData = {
        { 1, "Robert Schmidt", "Germany", 23966, "Mecklenburg-Western Pommerania", "Wismar", "Phillip-Mueller-Str.", "14" },
        { 2, "Gottlob Frege", "Germany", 23966, "Mecklenburg-Western Pommerania", "Wismar", "Phillip-Mueller-Str.", "14" },
        { 3, "Klaus Stoertebeker", "Germany", 23966, "Mecklenburg-Western Pommerania", "Wismar", "Phillip-Mueller-Str.", "14" },
        { 4, "Holger Jung", "Germany", "Hamburg", 20357, "Hamburg", "Glashuettenstrasse", "79" },
        { 5, "Jean-Remy von Matt", "Germany", 20357 ,"Hamburg", "Hamburg", "Glashuettenstrasse", "79" }
    };

    // TEST DATA: PLZ
    public static Integer[] plz = { 
        new Integer(23966), new Integer(20357) 
    };
    public static JComboBox plzBox = new JComboBox(plz);
    // TEST DATA: CITY
    public static String[] city = { 
        new String("Wismar"), new String("Hamburg") 
    };
    public static JComboBox cityBox = new JComboBox(city);
    
    // TEST DATA: ADVANCED TABLE DATA
    public static Object[][] advancedTableData = {
        { new Integer(1), "Robert Schmidt", "Germany", plzBox, "Mecklenburg-Western Pommerania", cityBox, "Phillip-Mueller-Str.", "14" },
        { new Integer(2), "Gottlob Frege", "Germany", plzBox, "Mecklenburg-Western Pommerania", cityBox, "Phillip-Mueller-Str.", "14" },
        { new Integer(3), "Klaus Stoertebeker", "Germany", plzBox, "Mecklenburg-Western Pommerania", cityBox, "Phillip-Mueller-Str.", "14" },
        { new Integer(4), "Holger Jung", "Germany", plzBox, "Hamburg", cityBox, "Glashuettenstrasse", "79" },
        { new Integer(5), "Jean-Remy von Matt", "Germany", plzBox,"Hamburg", cityBox, "Glashuettenstrasse", "79" }
    };

    /**
     * PROGRAM ENTRY POINT
     */
    public static void main(String[] args) {
        //new SimpleTable(tableHeader, simpleTableData);
        new AdvancedTable(tableHeader, advancedTableData);

    }    
}