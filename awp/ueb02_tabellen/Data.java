/**
 * @author t.j.
 * @version 2014-02
 */

import javax.swing.JComboBox;


public class Data {

    private static final Object[] HEADER = {
        new String("ID"), new String("Name"), new String("Street"), new String("Number"), new String("City"), new String("ZIP")
    };

    private static final String NAMES[] = {
        new String("Gottlob Frege"), new String("Klaus Stoertebeker"), new String("Max Mustermann")  
    };

    private static final String STREETS[] = {
        new String("Irgendeine-Strasse"), new String("Hauptstrasse"), new String("Nebenstrasse"), 
    };

    private static final String NUMBERS[] = {
        new String("13a"), new String("9"), new String("17")  
    };

    public static final String CITIES[] = {
        new String("Stralsund"), new String("Wismar"), new String("Schwerin")
    };

    public static final String ZIPS[] = {
        new String("18435"), new String("23966"), new String("19053"), 
    };

    public static Object[][] getData() {
        Object[][] data = new Object[NAMES.length][HEADER.length];
        for(int i = 0; i < NAMES.length; i++) {
            data[i][0] = new Integer(i);
            data[i][1] = NAMES[i];
            data[i][2] = STREETS[i];
            data[i][3] = NUMBERS[i];
            data[i][4] = CITIES[i];
            data[i][5] = ZIPS[i];
        }
        return data;
    }

    public static JComboBox getCityData() {
        return new JComboBox<String>(CITIES);
    }

    public static JComboBox getZipData() {
        return new JComboBox<String>(ZIPS);
    }

    public static Object[] getHeader() {
        return HEADER;
    }

}