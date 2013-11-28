import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJFrame extends JFrame {

  private static String[] comboBoxContent = {
    "Datei auswählen", "Farbe auswählen"
  };
  private JTextArea status;

  public MyJFrame() {
    super("Menü-Beispiel");
    setSize(500,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);


    this.add(init());

    setVisible(true);
  }

  private JPanel init() {

    JPanel    base      = new JPanel();
    JMenuBar  menuBar   = new JMenuBar();
    JComboBox pullDown  = new JComboBox(comboBoxContent);
              status    = new JTextArea();

    status.setEditable(false);
    pullDown.setEditable(false);
    pullDown.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          handleDialog(evt);
        }
      }
    );


    menuBar.add(pullDown);
    base.setLayout(new BorderLayout());
    base.add(menuBar, BorderLayout.NORTH);
    base.add(status, BorderLayout.CENTER);

    return base;

  }

  public void handleDialog(ActionEvent evt) {
    JComboBox jcb = (JComboBox)evt.getSource();
    String selection = (String)jcb.getSelectedItem();

    if(selection.equals(comboBoxContent[0])) {
      JFileChooser fc = new JFileChooser();
      int exitStatus = fc.showDialog(this, "Dateiauswahl");
      if(exitStatus != JFileChooser.CANCEL_OPTION) {
        java.io.File testFile = fc.getSelectedFile();
        status.setText(status.getText()+"\nOpening: "+testFile.toString());
      }

    } else if(selection.equals(comboBoxContent[1])) {
      Color c = JColorChooser.showDialog(MyJFrame.this, "CC", Color.yellow);
      status.setText(status.getText()+"\nColor: "+c.toString());
    } else {
      status.setText(status.getText()+"\nUnknown Operation.");
    }
  }

  public static void main(String[] args) {
    new MyJFrame();
  }
}
