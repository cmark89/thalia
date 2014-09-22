package objectivelyradical.thalia.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import objectivelyradical.thalia.tropes.Trope;

public class ThaliaQuickPanel extends JPanel {
	JLabel label_2;
	JLabel label_3;
	JLabel trope1label;
	JLabel trope2label;
	JLabel trope3label;
	LinkableLabel trope1link;
	LinkableLabel trope2link;
	LinkableLabel trope3link;	
	
	Settings currentSettings;
	private JPanel Header;
	private JLabel label_1;
	private JPanel panel;
	private JButton button;
		public ThaliaQuickPanel() {
			setLayout(new BorderLayout(0, 0));
			
			trope1link = new LinkableLabel("", "");
			trope1link.setText("");
			trope2link = new LinkableLabel("", "");
			trope2link.setText("");
			trope3link = new LinkableLabel("", "");
			trope3link.setText("");
			
			JPanel QuickMode_Main = new JPanel();
			add(QuickMode_Main);
			QuickMode_Main.setLayout(new GridLayout(3, 2, 0, 0));
			
			trope1label = new JLabel("");
			trope1label.setHorizontalAlignment(SwingConstants.CENTER);
			trope1label.setFont(new Font("Dialog", Font.BOLD, 12));
			QuickMode_Main.add(trope1label);
			QuickMode_Main.add(trope1link);
			
			trope2label = new JLabel("");
			trope2label.setHorizontalAlignment(SwingConstants.CENTER);
			trope2label.setFont(new Font("Dialog", Font.BOLD, 12));
			QuickMode_Main.add(trope2label);
			QuickMode_Main.add(trope2link);
			
			trope3label = new JLabel("");
			trope3label.setHorizontalAlignment(SwingConstants.CENTER);
			trope3label.setFont(new Font("Dialog", Font.BOLD, 12));
			QuickMode_Main.add(trope3label);
			QuickMode_Main.add(trope3link);
			
			Header = new JPanel();
			add(Header, BorderLayout.NORTH);
			
			label_1 = new JLabel("Quick Mode");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("Dialog", Font.BOLD, 20));
			Header.add(label_1);
			
			panel = new JPanel();
			add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			button = new JButton("Roll Tropes");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rollTropes();
				}
			});
			button.setFont(new Font("Dialog", Font.BOLD, 16));
			panel.add(button);
			
			currentSettings = Settings.getInstance();
		}
		
		private void rollTropes() {
			final int NUMBER_TO_ROLL = 3;
			ArrayList<Trope> rolledTropes = new ArrayList<Trope>();
			Trope t;
			int index;
			ArrayList<Trope> tropes = new ArrayList<Trope>();
			tropes.addAll(currentSettings.getNarrativeTropes());
			tropes.addAll(currentSettings.getGenreTropes());
			tropes.addAll(currentSettings.getTopicTropes());
			while(rolledTropes.size() < NUMBER_TO_ROLL) {
			index = (int)(Math.random() * tropes.size());
			if(!rolledTropes.contains(tropes.get(index))) {
			rolledTropes.add(tropes.get(index));
			}
			}
			// Now add change the 3 labels
			setLabel(trope1label, trope1link, rolledTropes.get(0));
			setLabel(trope2label, trope2link, rolledTropes.get(1));
			setLabel(trope3label, trope3link, rolledTropes.get(2));
			}
		
		private void setLabel(JLabel label, LinkableLabel link, final Trope trope) {
			label.setText("(" + trope.getTropeType().toString() + 
					" - " + trope.subtypeToString() + ")");
			
			link.setText(trope.getName());
			link.setUrl(trope.getUrl());
		}
}
