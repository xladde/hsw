package hsw.wbs.frze;

import hsw.wbs.core.TabFrame;
import hsw.wbs.frze.ctrl.FreizeitController;

import java.awt.EventQueue;

import javax.swing.JPanel;

public class FreizeitTest {

	/**
	 * @param args
	 */
	public static void testFreizeitEntscheider() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanel[] tabs = { FreizeitController.getPreparedFreizeitPanel() };
					TabFrame frame = new TabFrame(tabs, null);
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
