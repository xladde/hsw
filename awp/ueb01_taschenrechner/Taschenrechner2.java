/**
 * @author t.j.
 * @version 2014-03
 * AWP WI12: Taschenrechner, mit Grundrechenarten.
 */

import javax.swing.*;       // Lib for Java Swing
import java.awt.*;          // Abstract Window Toolkit
import java.awt.event.*;    // Library for event handling


public class Taschenrechner2 {
    private JButton[] numbers;
    private JButton[] operations;
    private JTextField output;

    public Taschenrechner2() extends JFrame {
        super("Einfacher Taschenrechner");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayoutManager(new GridLayout(1,1));

        /* ... */

        setVisible(true);
    }


}