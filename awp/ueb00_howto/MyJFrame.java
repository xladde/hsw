/**
 * @brief Example on how to use JFrames
 * This class creates a JFrame with a TextField and a Button.
 * If the button is clicked, the text inside the texfield is read an printed
 * to stdout.
 *
 * @author tj
 * @version 2013-03
 */

package ueb00_howto;

import javax.swing.*;       // Lib for Java Swing
import java.awt.*;          // Abstract Window Toolkit
import java.awt.event.*;    // Library for event handling

public class MyJFrame {

  private JTextField  textInput;
  private JButton     button;
  private JPanel      panel;

  public MyJFrame( String title ) {
    super( title );
    init();
  }

  private void init() {
    // 1. prepare Frame ----------------------------
    this.setSize( 500, 300 );                     // width: 500px heigth: 300px
    this.setLocationRelativeTo( null );           // Frame position center of screen
    this.defaultCloseOperation( EXIT_ON_CLOSE );  // Quit on Close

    // 2. prepare items ----------------------------
    textInput = new JTextField("enter text here");// init Textfield with default text.
    button    = new JButton( "OK" );              // init Button with text
    button.addActionListener( new ActionListener() {
        /**
         * Add listener to button.
         * Internal definition of action listener, wich runs the following method
         * if the Button with this listener is clicked.
         */
        @Override
        public void actionPerformed( ActionEvent evt ) {
          System.out.println( textInput.getText() );
        }
      } 
    );
    panel     = new JPanel();
    panel.setLayout( new GridLayout( 2, 1 ) );

    // 3. add layers (items) to frame from the top to the bottom
    panel.add( textInput );
    panel.add( button );
    frame.add( panel );


    // 4. make the frame visible
    frame.setVisible( true );
  }

}