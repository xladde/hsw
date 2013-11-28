package hsw.wbs.frze.view;

import hsw.wbs.frze.model.Aktionsraum;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JList;

public class DecisionDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4517892535216747439L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public DecisionDialog(Aktionsraum.FreizeitAktion[] arr) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JList<Aktionsraum.FreizeitAktion> list = 
					new JList<Aktionsraum.FreizeitAktion>(arr);
			contentPanel.add(list, "cell 0 0,grow");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
