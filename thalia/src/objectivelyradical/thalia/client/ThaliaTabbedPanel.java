package objectivelyradical.thalia.client;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import objectivelyradical.thalia.tropes.Trope;

public class ThaliaTabbedPanel extends JPanel {
	JTabbedPane TabPane;
	public ThaliaTabbedPanel() {
		setLayout(new BorderLayout(0, 0));
		//setBounds(0, 0, 500, 380);
		TabPane = new JTabbedPane(JTabbedPane.TOP);
		TabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(TabPane);
		
		JPanel QuickMode = new ThaliaQuickPanel();
		TabPane.addTab("Quick Mode", null, QuickMode, 
				"A simple mode that generates three tropes completely at random.  Ideal for flash fiction, or as a way to discover new pages on TVTropes.");
		
		JPanel FullMode = new ThaliaFullPanel();
		TabPane.addTab("Full Mode", null, FullMode, "Randomize genre and themes, giving multiple tropes for each.  Supports partial rerolling.");
		
		JPanel Settings = new ThaliaSettingsPanel();
		Settings.setToolTipText("");
		TabPane.addTab("Settings", null, Settings, "Modify settings for Thalia to customize your experience.");
	}

	

}
