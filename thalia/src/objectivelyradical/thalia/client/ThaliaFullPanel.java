package objectivelyradical.thalia.client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JButton;

import objectivelyradical.thalia.tropes.GenreType;
import objectivelyradical.thalia.tropes.TopicType;
import objectivelyradical.thalia.tropes.Trope;

public class ThaliaFullPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel narrativeTropePanel;
	JPanel genreTropePanel;
	JPanel topic1TropePanel;
	JPanel topic2TropePanel;
	
	GenreType genreType;
	JLabel genre;
	
	Settings currentSettings;
	
	ArrayList<Trope> currentTropes = new ArrayList<Trope>();
	
	public ThaliaFullPanel() {
		currentSettings = Settings.getInstance();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		genre = new JLabel("GENRE");
		genre.setFont(new Font("Dialog", Font.BOLD, 18));
		genre.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(genre);
		
		narrativeTropePanel = new JPanel();
		narrativeTropePanel.setBorder(new TitledBorder(null, "Narrative Tropes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(narrativeTropePanel);
		narrativeTropePanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		genreTropePanel = new JPanel();
		genreTropePanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Genre Tropes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(genreTropePanel);
		genreTropePanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		topic1TropePanel = new JPanel();
		topic1TropePanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Topic 1:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(topic1TropePanel);
		topic1TropePanel.setLayout(new GridLayout(2, 2, 0, 0));
	
		topic2TropePanel = new JPanel();
		topic2TropePanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Topic 2:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(topic2TropePanel);
		topic2TropePanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);
		
		JButton rollButton = new JButton("Roll Tropes");
		
		final JPanel thisPanel = this;
		rollButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				rollTropes();
				updatePanel();
			}
		});
		horizontalBox.add(rollButton);
		
		JButton openAllButton = new JButton("Open All in Browser");
		openAllButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				openAllTropes();
			}
		});
		horizontalBox.add(openAllButton);
	}
	
	private void updatePanel() {
		validate();
		repaint();
	}
	
	private void rollTropes() {
		
		narrativeTropePanel.removeAll();
		genreTropePanel.removeAll();
		topic1TropePanel.removeAll();
		topic2TropePanel.removeAll();
		
		currentTropes.clear();
		
		GenreType[] _genres = GenreType.values();
		
		// First, check if we have to roll a new genre or not
		if(currentSettings.getRandomizeGenre()) {
			genreType = currentSettings.getEnabledGenreTypes().get
					((int)(Math.random() * 
							currentSettings.getEnabledGenreTypes().size()));
			System.out.println("Random genre: " + genreType.toString());
		} else if(currentSettings.getChosenGenre() >= 0) {
			GenreType[] genres = GenreType.values();
			genreType = genres[currentSettings.getChosenGenre()];
			System.out.println("Preset genre: " + genreType.toString());
		}
		
		genre.setText(genreType.toString());
		
		// Roll the narrative tropes
		int size = currentSettings.getNarrativeTropes().size();
		Trope t = null;
		
		System.out.println("Roll narrative tropes.");
		for(int i = 0; i < currentSettings.getNarrativeTropeCount(); i++) {
			
			boolean valid = false;
			while(!valid) {
				t = currentSettings.getNarrativeTropes()
						.get((int)(Math.random() * size));
				if(!currentTropes.contains(t))
					valid = true;
			}
			
			currentTropes.add(t);
			
			LinkableLabel newLabel = new LinkableLabel
					("(" + t.subtypeToString() + ") " + t.getName(), t.getUrl());
			newLabel.setHorizontalAlignment(SwingConstants.CENTER);
			narrativeTropePanel.add(newLabel);			
		}
		
		System.out.println("Roll genre tropes.");
		size = currentSettings.getGenreTropes().size();
		for(int i = 0; i < currentSettings.getGenreTropeCount(); i++) {
			boolean valid = false;
			while(!valid) {
				t = currentSettings.getGenreTropes()
						.get((int)(Math.random() * size));
				if(!currentTropes.contains(t) && _genres[t.getSubtype()] == genreType)
					valid = true;
			}
			
			currentTropes.add(t);
			
			LinkableLabel newLabel = new LinkableLabel
					("(" + t.subtypeToString() + ") " + t.getName(), t.getUrl());
			newLabel.setHorizontalAlignment(SwingConstants.CENTER);
			genreTropePanel.add(newLabel);	
		}
		
		System.out.println("Roll topic tropes.");
		// Roll the two topics to use
		TopicType[] topicTypes = new TopicType[2];
		topicTypes[0] = currentSettings.getEnabledTopicTypes().get
				((int)(Math.random() * currentSettings.getEnabledTopicTypes().size()));
		topicTypes[1] = null;
		while(topicTypes[1] == null) 
		{
			topicTypes[1] = currentSettings.getEnabledTopicTypes().get
					((int)(Math.random() * currentSettings.getEnabledTopicTypes().size()));
			
			if(topicTypes[1] == topicTypes[0])
				topicTypes[1] = null;
		}
		
		// We now have our two topics.  Change the headings of those panes...
		TitledBorder border = (TitledBorder)(topic1TropePanel.getBorder());
		border.setTitle("Topic 1: " + topicTypes[0].toString());
		border = (TitledBorder)(topic2TropePanel.getBorder());
		border.setTitle("Topic 2: " + topicTypes[1].toString());
		
		// Get lists of all tropes that can match those two topics
		ArrayList<Trope> topic1Tropes = new ArrayList<Trope>();
		ArrayList<Trope> topic2Tropes = new ArrayList<Trope>();
		
		TopicType[] _types = TopicType.values();
		for(Trope tr : currentSettings.getTopicTropes()) {
			if(_types[tr.getSubtype()] == topicTypes[0])
				topic1Tropes.add(tr);
			else if(_types[tr.getSubtype()] == topicTypes[1])
				topic2Tropes.add(tr);
		}
		
		// Check for null lists, and raise an error if they occur...
		size = topic1Tropes.size();
		for(int i = 0; i < currentSettings.getTopic1TropeCount(); i++)
		{
			boolean valid = false;
			while(!valid) {
				int roll = (int)(Math.random() * size);
				System.out.println("Rolled item " + roll + " / " + size);
				t = topic1Tropes.get(roll);
				if(!currentTropes.contains(t))
					valid = true;
			}
			
			currentTropes.add(t);
			
			LinkableLabel newLabel = new LinkableLabel
					("(" + t.subtypeToString() + ") " + t.getName(), t.getUrl());
			newLabel.setHorizontalAlignment(SwingConstants.CENTER);
			topic1TropePanel.add(newLabel);	
		}
		size = topic2Tropes.size();
		for(int i = 0; i < currentSettings.getTopic2TropeCount(); i++)
		{
			boolean valid = false;
			while(!valid) {
				int roll = (int)(Math.random() * size);
				System.out.println("Rolled item " + roll + " / " + size);
				t = topic2Tropes.get(roll);
				if(!currentTropes.contains(t))
					valid = true;
			}
			
			currentTropes.add(t);
			
			LinkableLabel newLabel = new LinkableLabel
					("(" + t.subtypeToString() + ") " + t.getName(), t.getUrl());
			newLabel.setHorizontalAlignment(SwingConstants.CENTER);
			topic2TropePanel.add(newLabel);
		}
	}
	
	private void openAllTropes() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(Trope t : currentTropes) {
					try {
						Desktop.getDesktop().browse(new URI(t.getUrl()));
						Thread.sleep(1000);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			};
		});
		t.run();
	}

}
