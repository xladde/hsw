import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TicTacToe extends JFrame
{
    private JButton[][] felder;
    
    private boolean player;

    public TicTacToe()
    {
        super("TicTacToe");
        player = false;
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        felder = new JButton[3][3];
        setLayout( new GridLayout(3,3) ); // gibt dem fenster ein layout
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                felder[i][j] = new JButton();
                felder[i][j].addActionListener
                (
                    new ActionListener() // wartet auf Click
                    {
                        public void actionPerformed(ActionEvent evt)
                        {// todo here...
                           JButton b = (JButton) evt.getSource();
                           
                           if(b.getText().compareTo("x")!=0 && 
                                b.getText().compareTo("o")!=0)
                           {
                               if(player)
                               {
                                   player=false;
                                   b.setText("x");
                               } else
                               {
                                   player=true;
                                   b.setText("o");
                               }
                               evt.setSource(b);
                               
                               // check for winner here ...
                               
                           }
                        }
                    }
                );
                add(felder[i][j]);
            }
        }
        
        setVisible(true);
    }
}