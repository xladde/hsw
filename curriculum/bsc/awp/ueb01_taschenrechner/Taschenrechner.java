
import javax.swing.*;       // Lib for Java Swing
import java.awt.*;          // Abstract Window Toolkit
import java.awt.event.*;    // Library for event handling

public class Taschenrechner extends JFrame {

  private JButton     bPlus;
  private JButton     bMinus;
  private JButton     bMultiply;
  private JButton     bDivide;
  private JButton     bCE;
  private JTextField  tIn_1;
  private JTextField  tIn_2;
  private JTextField  tOut;

  private enum operation{plus, minus, multiply, divide, clear};

  public Taschenrechner() {
    super( "Taschenrechner" );
    init();
  }

  private void init() {
    bPlus = new JButton("+");
    bPlus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) { display(operation.plus); }
    });
    bMinus = new JButton("-");
    bMinus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) { display(operation.minus); }
    });
    bMultiply = new JButton("*");
    bMultiply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) { display(operation.multiply); }
    });
    bDivide = new JButton("/");
    bDivide.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) { display(operation.divide); }
    });
    bCE = new JButton("CE");
    bCE.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) { display(operation.clear); }
    });
    tIn_1 = new JTextField();
    tIn_2 = new JTextField();
    tOut = new JTextField();
    tOut.setEditable(false);

    this.setSize(500,300);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel base = new JPanel();
    base.setLayout(new GridLayout(4,1));
    JPanel buttonLayer = new JPanel();
    buttonLayer.setLayout(new GridLayout(1,5));
    buttonLayer.add(bPlus);
    buttonLayer.add(bMinus);
    buttonLayer.add(bMultiply);
    buttonLayer.add(bDivide);
    buttonLayer.add(bCE);
    base.add(tIn_1);
    base.add(tIn_2);
    base.add(buttonLayer);
    base.add(tOut);
    this.add(base);
    this.setVisible(true);
  }

  private void display(operation o){
    if(o == operation.clear) {
      tIn_1.setText("0");
      tIn_2.setText("0");
      tOut.setText("");      
    } else {
        double a=0, b=0;
        Double c=null;
      try {
        a = Double.parseDouble(tIn_1.getText());
        b = Double.parseDouble(tIn_2.getText());
        c = clc(a, b, o);

        if( c == null ) {
          tOut.setText("ERR");
        } else { tOut.setText(c.toString()); }
      } catch(NumberFormatException ex) {
        System.out.println("0");
      } catch(NullPointerException ex) {
        System.out.println("1");
      } catch(Exception ex) {
        System.out.println("2");
      }
        
    }
  }

  private Double clc(double a, double b, operation o) {
    Double c;
    switch(o) {
      case plus:      
        c = new Double(a+b);
        break;
      case minus:
        c = new Double(a-b);
        break;
      case multiply:  
        c = new Double(a*b);
        break;
      case divide:
        if( b != 0 ) {   
          c = new Double(a/b);
        } else { c = null; }
        break;
      default:
        c = null;
        break;
    }
    System.out.println(c.toString()); 
    return c;
  }

  public static void main(String[] args) {
    Taschenrechner t = new Taschenrechner();
  }
}