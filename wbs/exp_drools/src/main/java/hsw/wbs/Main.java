/**
 * 
 */
package hsw.wbs;



import hsw.wbs.frze.FreizeitTest;

import java.awt.EventQueue;

/**
 * @author tj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreizeitTest.testFreizeitEntscheider();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
