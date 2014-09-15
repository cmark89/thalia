package objectivelyradical.thalia.client;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ThaliaFullPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThaliaFullPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		JLabel lblGenre = new JLabel("GENRE");
		lblGenre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGenre.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblGenre);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Narrative Tropes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("N1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N2");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("N1");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("N1");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Genre Tropes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel label = new JLabel("N1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("N2");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_1);
		
		JLabel lblN = new JLabel("N3");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblN);
		
		JLabel N4 = new JLabel("N4");
		N4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(N4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Topic 1:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel label_2 = new JLabel("N1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("N2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_3);
		
		JLabel label_10 = new JLabel("N1");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("N1");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_11);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Topic 2:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(panel_3);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel label_4 = new JLabel("N1");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("N2");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_5);
		
		JLabel label_8 = new JLabel("N1");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("N1");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_9);
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		JButton btnNewButton = new JButton("Roll Tropes");
		horizontalBox.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Open All in Browser");
		horizontalBox.add(btnNewButton_1);

	}

}
