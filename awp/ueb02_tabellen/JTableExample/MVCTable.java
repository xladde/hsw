import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;


public class MVCTable extends JPanel
{  
  JTable    weinTable;
  JScrollPane   scrollPane;
  Object    weinListe[][] = {
    {"Scheurebe", new Double(21.10)},
    {"Riesling", new Double(27.50)},
    {"Weissburgunder", new Double(26.60)},
    {"Spaetburgunder", new Double(28.80)},
    {"Portugieser", new Double(22.40)}
  };
  Object    columnNames[] = {"Bestellnr.", "Rebsorte", "Abbildung", "Sektpreis/Liter", "Flaschengr.", "Verkaufte Flaschen", "Gesamtpreis", "Lieferung" };
  int       columnWidths[] = {70, 140, 70, 100, 90, 120, 130, 70};
  ImageIcon weinIcons[] = new ImageIcon[weinListe.length];
  {
    weinIcons[0] = new ImageIcon("scheurebe.gif");
    weinIcons[1] = new ImageIcon("riesling.gif");
    weinIcons[2] = new ImageIcon("weissburgunder.gif");
    weinIcons[3] = new ImageIcon("spaetburgunder.gif");
    weinIcons[4] = new ImageIcon("portugieser.gif");
  }
  
  Object  tableData[][] = {
    { new Integer(1), weinListe[0][0], weinIcons[0], weinListe[0][1], new Double(0.2), new Integer(200), new Double(0), new Boolean(true)},
    { new Integer(2), weinListe[1][0], weinIcons[1], weinListe[1][1], new Double(0.75), new Integer(500), new Double(0), new Boolean(false) },
    { new Integer(3), weinListe[2][0], weinIcons[2], weinListe[2][1], new Double(1.0), new Integer(100), new Double(1), new Boolean(false) },
    { new Integer(4), weinListe[3][0], weinIcons[3], weinListe[3][1], new Double(1.0), new Integer(800), new Double(0), new Boolean(true) },
    { new Integer(5), weinListe[4][0], weinIcons[4], weinListe[4][1], new Double(0.2), new Integer(1000), new Double(0), new Boolean(false) },
    { new Integer(6), weinListe[2][0], weinIcons[2], weinListe[2][1], new Double(0.75), new Integer(20), new Double(0), new Boolean(true) },
    { new Integer(7), weinListe[1][0], weinIcons[1], weinListe[1][1], new Double(0.2), new Integer(700), new Double(0), new Boolean(true) },
    { new Integer(8), weinListe[0][0], weinIcons[0], weinListe[0][1], new Double(1.0), new Integer(600), new Double(0), new Boolean(true) },
    { new Integer(9), weinListe[3][0], weinIcons[3], weinListe[3][1], new Double(1.0), new Integer(600), new Double(0), new Boolean(false) },
  };    

  DecimalFormat DMFormat = new DecimalFormat("#,##0.00 DM");
  DecimalFormat literFormat = new DecimalFormat("0.00 l");
  

  MVCTable(JApplet applet)
  {
    setLayout(new BorderLayout());
    
    final TableModel dataModel = new AbstractTableModel()
    {
      public int getColumnCount()
      {
        return columnNames.length;
      }

      public int getRowCount()
      {
        return tableData.length;
      }

      public Object getValueAt(int row, int col)
      {
        return tableData[row][col];
      }

      public String getColumnName(int column)
      {
        return (String)columnNames[column];
      }

      public Class getColumnClass(int c)
      {
        return getValueAt(0, c).getClass();
      }

      public boolean isCellEditable(int row, int col)
      {
        if (col==1 || col==4 || col==5 || col==7)
          return true;
        else
          return false;
      }
      
      public void setValueAt(Object aValue, int row, int column)
      {
        tableData[row][column] = aValue; 
        if (column==3 || column==4 || column==5)
        {
          double preis = (Double.valueOf(getValueAt(row, 3).toString())).doubleValue();
          double groesse = (Double.valueOf(getValueAt(row, 4).toString())).doubleValue();
          double flaschen = (Double.valueOf(getValueAt(row, 5).toString())).doubleValue();
          setValueAt(new Double(preis * groesse * flaschen), row, 6);
        }
        if (column==1)
        {
          for (int i=0; i<weinListe.length; i++)
            if (weinListe[i][0].equals(aValue))
            {
              setValueAt(weinListe[i][1], row, 3);
              setValueAt(weinIcons[i], row, 2);
            }
        }
        // geaenderten Daten werden angezeigt
        fireTableDataChanged();
      }
    };

    weinTable = new JTable(dataModel);
    scrollPane = new JScrollPane(weinTable);
    add("Center", scrollPane);
    
    // Spaltenbreiten
    for (int i=0; i<dataModel.getColumnCount(); i++)
      weinTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
    
    // Preise berechnen
    for (int i=0; i<dataModel.getRowCount(); i++)
      dataModel.setValueAt(dataModel.getValueAt(i, 1), i, 1);

    // Weinsorten
    JComboBox  weinSorte = new JComboBox();
    for (int i=0; i<weinListe.length; i++)
      weinSorte.addItem(weinListe[i][0]);
        
    // Flaschengroessen
    JComboBox flaschen = new JComboBox();
    flaschen.addItem(new Double(0.2));
    flaschen.addItem(new Double(0.75));
    flaschen.addItem(new Double(1.0));
    
    weinTable.getColumn("Rebsorte").setCellEditor(new DefaultCellEditor(weinSorte));
    weinTable.getColumn("Flaschengr.").setCellEditor(new DefaultCellEditor(flaschen));

    DefaultTableCellRenderer DMRenderer = new DefaultTableCellRenderer() {
      public void setValue(Object value)
      {
        Double d = (Double)value;
        setText(DMFormat.format(d.doubleValue()));
      }
    };
    DMRenderer.setHorizontalAlignment(JLabel.RIGHT);

    DefaultTableCellRenderer literRenderer = new DefaultTableCellRenderer() {
      public void setValue(Object value)
      {
        Double d = (Double)value;
        setText(literFormat.format(d.doubleValue()));
      }
    };
    literRenderer.setHorizontalAlignment(JLabel.RIGHT);

    weinTable.getColumn("Sektpreis/Liter").setCellRenderer(DMRenderer);
    weinTable.getColumn("Gesamtpreis").setCellRenderer(DMRenderer);
    weinTable.getColumn("Flaschengr.").setCellRenderer(literRenderer);
  }  
}