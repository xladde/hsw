package hsw.wbs.core;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

public class TabFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5526478895331867396L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TabFrame(JPanel[] tabs, JMenu[] m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JMenuBar menuBar = new JMenuBar();
		if(m != null) {
			for(JMenu menu: m) {
				if(menu != null) menuBar.add(menu);
			}
		}
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		for(JPanel panel: tabs) {
			tabbedPane.add(panel.getName(), panel);
		}
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
	}

}
