package hsw.wbs.frze.view;

import hsw.wbs.core.Message;
import hsw.wbs.frze.ctrl.FreizeitController;
import hsw.wbs.frze.model.FreizeitMessage;
import hsw.wbs.frze.model.Zustandsraum;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;

public class FreizeitEntscheiderPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4554491812346265257L;
	private JRadioButton rdb_finanzen_viel;
	private JRadioButton rdb_finanzen_normal;
	private JRadioButton rdb_freizeit_normal;
	private JRadioButton rdb_freizeit_viel;
	private JRadioButton rdb_freizeit_wenig;
	private JCheckBox chkb_laune_indoor;
	private JRadioButton rdb_wetter_bewoelkt;
	private JCheckBox chkbx_wetter_windig;
	private JRadioButton rdb_wetter_regen;
	private JRadioButton rdb_wetter_sonnig;
	private JButton btnGo;
	private JRadioButton rdb_zeit_frueh;
	private JRadioButton rdb_zeit_mittag;
	private JRadioButton rdb_zeit_abend;
	private JRadioButton rdb_zeit_nacht;
	private JRadioButton rdb_finanzen_keine;
	private JRadioButton rdb_finanzen_wenig;
	private JCheckBox chkb_laune_outdoor;
	private JCheckBox chkb_laune_solo;
	private FreizeitController _ctrl;
	private final ButtonGroup btg_finanzen = new ButtonGroup();
	private final ButtonGroup btg_tageszeit = new ButtonGroup();
	private final ButtonGroup btg_wetter = new ButtonGroup();
	private final ButtonGroup btg_freizeit = new ButtonGroup();
	
	/**
	 * Create the panel.
	 */
	public FreizeitEntscheiderPanel(FreizeitController controller) {
		this.setName("Freizeitentscheider");
		this.setController(controller);
		
		setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][]"));
		
		JLabel lblFinanzen = new JLabel("Finanzen");
		add(lblFinanzen, "cell 0 0");
		
		JLabel lblTageszeit = new JLabel("Tageszeit");
		add(lblTageszeit, "cell 2 0");
		
		JLabel lblWitterung = new JLabel("Witterung");
		add(lblWitterung, "cell 4 0");
		
		rdb_finanzen_keine = new JRadioButton("keine");
		btg_finanzen.add(rdb_finanzen_keine);
		add(rdb_finanzen_keine, "cell 0 1");
		
		rdb_zeit_frueh = new JRadioButton("früh");
		btg_tageszeit.add(rdb_zeit_frueh);
		add(rdb_zeit_frueh, "cell 2 1");
		
		rdb_wetter_sonnig = new JRadioButton("sonnig");
		btg_wetter.add(rdb_wetter_sonnig);
		add(rdb_wetter_sonnig, "cell 4 1");
		
		rdb_finanzen_wenig = new JRadioButton("wenig");
		btg_finanzen.add(rdb_finanzen_wenig);
		add(rdb_finanzen_wenig, "cell 0 2");
		
		rdb_zeit_mittag = new JRadioButton("mittag");
		btg_tageszeit.add(rdb_zeit_mittag);
		add(rdb_zeit_mittag, "cell 2 2");
		
		rdb_wetter_bewoelkt = new JRadioButton("bewoelkt");
		btg_wetter.add(rdb_wetter_bewoelkt);
		add(rdb_wetter_bewoelkt, "cell 4 2");
		
		rdb_finanzen_normal = new JRadioButton("normal");
		btg_finanzen.add(rdb_finanzen_normal);
		add(rdb_finanzen_normal, "cell 0 3");
		
		rdb_zeit_abend = new JRadioButton("abend");
		btg_tageszeit.add(rdb_zeit_abend);
		add(rdb_zeit_abend, "cell 2 3");
		
		rdb_wetter_regen = new JRadioButton("regnerisch");
		btg_wetter.add(rdb_wetter_regen);
		add(rdb_wetter_regen, "cell 4 3");
		
		rdb_finanzen_viel = new JRadioButton("viel");
		btg_finanzen.add(rdb_finanzen_viel);
		add(rdb_finanzen_viel, "cell 0 4");
		
		rdb_zeit_nacht = new JRadioButton("nacht");
		btg_tageszeit.add(rdb_zeit_nacht);
		add(rdb_zeit_nacht, "cell 2 4");
		
		chkbx_wetter_windig = new JCheckBox("windig");
		add(chkbx_wetter_windig, "cell 4 4");
		
		JLabel lblLaune = new JLabel("Laune");
		add(lblLaune, "cell 0 6");
		
		JLabel lblFreizeit = new JLabel("Freizeit");
		add(lblFreizeit, "cell 2 6");
		
		chkb_laune_indoor = new JCheckBox("Indoor");
		add(chkb_laune_indoor, "cell 0 7");
		
		rdb_freizeit_wenig = new JRadioButton("kaum (bis 2h)");
		btg_freizeit.add(rdb_freizeit_wenig);
		add(rdb_freizeit_wenig, "cell 2 7");
		
		/**
		 * ACTION-LISTENER //////////////////////////////////////////////////
		 */
		btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FreizeitMessage msg = parsePanelState();
				if(msg != null) {
					_ctrl.fireMessage(msg, "Freizeit.drl");				
				} else System.out.println("X:\tNo Message generated");
			}
		});
		add(btnGo, "cell 4 7");
		
		chkb_laune_outdoor = new JCheckBox("Outdoor");
		add(chkb_laune_outdoor, "cell 0 8");
		
		rdb_freizeit_normal = new JRadioButton("etwas (bis 4h)");
		btg_freizeit.add(rdb_freizeit_normal);
		add(rdb_freizeit_normal, "cell 2 8");
		
		chkb_laune_solo = new JCheckBox("solo");
		add(chkb_laune_solo, "cell 0 9");
		
		rdb_freizeit_viel = new JRadioButton("viel (ab 4h)");
		btg_freizeit.add(rdb_freizeit_viel);
		add(rdb_freizeit_viel, "cell 2 9");

	}
	
	/**public void fireFreizeitMessage(FreizeitMessage message) {
		StatefulKnowledgeSession session;
		try {
			session = DroolsTools.getStatefulKnowledgeSession("Freizeit.drl");
			if(session != null) {
				session.insert(message);
				session.fireAllRules();
			} else System.out.println("X:\tCannot create Session.");
		} catch(Throwable t) {
			System.out.println("X:\tErr in FreizeitDecision getDecision(FreizeitMessage message)\n\t"+t.getMessage());
			//return null;
		}
		
	}
	 * @return the _ctrl
	 */
	public FreizeitController getController() {
		return _ctrl;
	}

	/**
	 * @param _ctrl the _ctrl to set
	 */
	public void setController(FreizeitController _ctrl) {
		this._ctrl = _ctrl;
	}
	
	public FreizeitMessage parsePanelState() {
		FreizeitMessage msg = new FreizeitMessage();
		msg.setFinanzen(this.parseFinanzenState());
		msg.setFreizeit(this.parseFreizeitState());
		msg.setLaunen(this.parseLaunenState());
		msg.setTageszeit(this.parseTageszeitState());
		msg.setWetter(this.parseWetterState());
		msg.setWindig(this.parseWindState());
		msg.setState(Message.State.FINAL);
		return msg;
	}
	
	/**
	 * 
	 * @return
	 */
	public Zustandsraum.Finanzen parseFinanzenState() {
		if(rdb_finanzen_keine.isSelected()) {
			return Zustandsraum.Finanzen.KEINE;
		} else if(rdb_finanzen_wenig.isSelected()) {
			return Zustandsraum.Finanzen.WENIG;
		} else if(rdb_finanzen_normal.isSelected()) {
			return Zustandsraum.Finanzen.NORMAL;
		} else { return Zustandsraum.Finanzen.VIEL; }
	}
	
	/**
	 * 
	 * @return
	 */
	public Zustandsraum.Freizeit parseFreizeitState() {
		if(rdb_freizeit_wenig.isSelected()) {
			return Zustandsraum.Freizeit.WENIG;
		} else if(rdb_freizeit_normal.isSelected()) {
			return Zustandsraum.Freizeit.NORMAL;
		} else { return Zustandsraum.Freizeit.VIEL; }
	}
	
	/**
	 * 
	 * @return
	 */
	public Zustandsraum.Tageszeit parseTageszeitState() {
		if(rdb_zeit_frueh.isSelected()) {
			return Zustandsraum.Tageszeit.FRUEH;
		} else if(rdb_zeit_mittag.isSelected()) {
			return Zustandsraum.Tageszeit.MITTAG;
		} else if(rdb_zeit_abend.isSelected()) {
			return Zustandsraum.Tageszeit.ABEND;
		} else { return Zustandsraum.Tageszeit.NACHT; }
	}
	
	/**
	 * 
	 * @return
	 */
	public Zustandsraum.Witterung parseWetterState() {
		if(rdb_finanzen_keine.isSelected()) {
			return Zustandsraum.Witterung.SONNIG;
		} else if(rdb_finanzen_wenig.isSelected()) {
			return Zustandsraum.Witterung.BEWOELKT;
		} else { return Zustandsraum.Witterung.REGEN; }
	}
	
	public boolean parseWindState() {
		return chkbx_wetter_windig.isSelected();
	}
	
	public ArrayList<Zustandsraum.Laune> parseLaunenState() {
		ArrayList<Zustandsraum.Laune> arr = new ArrayList<Zustandsraum.Laune>();
		if(chkb_laune_indoor.isSelected()) { arr.add(Zustandsraum.Laune.INDOOR); }
		if(chkb_laune_outdoor.isSelected()) { arr.add(Zustandsraum.Laune.OUTDOOR); }
		if(chkb_laune_solo.isSelected()) { arr.add(Zustandsraum.Laune.SOLO); }
		return arr;
	}
	
	
}
