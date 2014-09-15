package objectivelyradical.thalia.client;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import javax.swing.JPanel;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import objectivelyradical.thalia.tropes.GenreType;
import objectivelyradical.thalia.tropes.NarrativeType;
import objectivelyradical.thalia.tropes.TopicType;
import objectivelyradical.thalia.tropes.TropeType;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ThaliaSettingsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Settings currentSettings;
	
	JCheckBox randomizeGenre;
	JComboBox chosenGenre;
	
	JSpinner narrativeCount;
	JSpinner genreCount;
	JSpinner topic1Count;
	JSpinner topic2Count;
	
	JButton applyButton;
	
	CheckboxTree tropeCheckTree;
	DefaultMutableTreeNode rootNode;
	DefaultMutableTreeNode narrativeNode;
	DefaultMutableTreeNode genreNode;
	DefaultMutableTreeNode topicNode;
	
	
	public ThaliaSettingsPanel() {
		// First, get the settings to use...
		
		// TODO: Don't make a new one unless we don't have a settings file
		// TODO: Get this from the main client
		currentSettings = new Settings();
		
		setLayout(new MigLayout("", "[145px][grow][][][grow][][grow]", "[45px,grow][][][][][][grow]"));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "Genre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(verticalBox, "cell 0 0");
		
		randomizeGenre = new JCheckBox("Randomize Genre");
		randomizeGenre.setSelected(currentSettings.getRandomizeGenre());
		randomizeGenre.setToolTipText("If this box is checked, the genre will be randomized from one of the enabled Genre trope categories.");
		randomizeGenre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean selected = randomizeGenre.isSelected();
				currentSettings.setRandomizeGenre(selected);
				chosenGenre.setEnabled(!selected);
				
				if(!selected) {
					currentSettings.setChosenGenre(chosenGenre.getSelectedIndex());
				}
			}
		});
		verticalBox.add(randomizeGenre);
		
		JSeparator separator = new JSeparator();
		verticalBox.add(separator);
		
		chosenGenre = new JComboBox();
		chosenGenre.setToolTipText("If Randomize Genre is disabled, you may choose from any of the available Genres here.");
		chosenGenre.setModel(new DefaultComboBoxModel(new String[] {"Action_Adventure", "Advertising", "Alternate_History", "Art", "Comedy", "Crime_and_Punishment", "Derivative_Works", "Drama", "Espionage", "Game_Show", "Horror", "Love", "Military_and_Warfare", "News", "Professional_Wrestling", "Reality_TV", "Speculative_Fiction", "Sports_Story", "Superhero", "Tokusatsu"}));
		chosenGenre.setEnabled(!currentSettings.getRandomizeGenre());
		if(!currentSettings.getRandomizeGenre() 
				&& currentSettings.getChosenGenre() >= 0) {
			chosenGenre.setSelectedIndex(currentSettings.getChosenGenre());
		}
		verticalBox.add(chosenGenre);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Enabled Tropes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(horizontalBox, "flowx,cell 1 0 6 3");
		
		JScrollPane scrollPane = new JScrollPane();
		horizontalBox.add(scrollPane);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(null, "Trope Roll Count", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(verticalBox_1, "cell 0 2");
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		JLabel lblNarrative = new JLabel("Narrative");
		horizontalBox_1.add(lblNarrative);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(30);
		horizontalBox_1.add(horizontalStrut_3);
		
		narrativeCount = new JSpinner();
		narrativeCount.setModel(new SpinnerNumberModel
				(currentSettings.getNarrativeTropeCount(), 0, 4, 1));
		horizontalBox_1.add(narrativeCount);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);
		
		JLabel lblGenre = new JLabel("Genre");
		horizontalBox_2.add(lblGenre);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(53);
		horizontalBox_2.add(horizontalStrut_2);
		
		genreCount = new JSpinner();
		genreCount.setModel(new SpinnerNumberModel
				(currentSettings.getGenreTropeCount(), 0, 4, 1));
		horizontalBox_2.add(genreCount);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		JLabel lblTopic = new JLabel("Topic 1");
		horizontalBox_3.add(lblTopic);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(47);
		horizontalBox_3.add(horizontalStrut_1);
		
		topic1Count = new JSpinner();
		topic1Count.setModel(new SpinnerNumberModel
				(currentSettings.getTopic1TropeCount(), 1, 4, 1));
		horizontalBox_3.add(topic1Count);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4);
		
		JLabel lblTopic_1 = new JLabel("Topic 2");
		horizontalBox_4.add(lblTopic_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(47);
		horizontalBox_4.add(horizontalStrut);
		
		topic2Count = new JSpinner();
		topic2Count.setModel(new SpinnerNumberModel
				(currentSettings.getTopic2TropeCount(), 0, 4, 1));
		horizontalBox_4.add(topic2Count);
		
		applyButton = new JButton("Apply");
		add(applyButton, "cell 5 4");
		//JTree tree = new JTree();
		//tree.setVisibleRowCount(10);
		
		tropeCheckTree = new CheckboxTree();
		tropeCheckTree.setVisibleRowCount(10);
		// TODO: When iterating over the enumerations, get the display name of each
		tropeCheckTree.setModel(new DefaultTreeModel(
			rootNode = new DefaultMutableTreeNode("Root") {
				{
					add(narrativeNode = new DefaultMutableTreeNode("Narrative") {
						{
							for(int i = 0; i < NarrativeType.values().length; i++) {
								add(new DefaultMutableTreeNode
										(new TropeTreeNode(TropeType.Narrative, i)));
							}
						}
					});
					add(genreNode = new DefaultMutableTreeNode("Genre") {
						{
							for(int i = 0; i < GenreType.values().length; i++) {
								add(new DefaultMutableTreeNode
										(new TropeTreeNode(TropeType.Genre, i)));
							}
						}
					});
					add(topicNode = new DefaultMutableTreeNode("Topic") {
						{
							for(int i = 0; i < TopicType.values().length; i++) {
								add(new DefaultMutableTreeNode
										(new TropeTreeNode(TropeType.Topic, i)));
							}
						}
					});
				}
			}
		));
		
		//tropeCheckTree = new CheckboxTree();
		
		
		// Make it a checkbox tree
		//TreeModel treeModel = tree.getModel();
		//tropeCheckTree.setModel(treeModel);
		tropeCheckTree.setRootVisible(false);
		
		
		
		//
		loadSelectedTropes();
		scrollPane.setViewportView(tropeCheckTree);
		repaint();
	}
	
	// Loads the settings' selected tropes into the selection tree
	private void loadSelectedTropes() {
		
		int parentIndex = 1;
		tropeCheckTree.expandAll();
		
		NarrativeType[] _narrative = NarrativeType.values();
		for(int i = 0; i < _narrative.length; i++) {
		//for(int i = 0; i < 3; i++) {
			if(currentSettings.getEnabledNarrativeTypes().contains(_narrative[i])) {				
				// Add a checkbox to the node
				System.out.println("Enable Narrative " + i);
				tropeCheckTree.getCheckingModel().addCheckingPath
					(tropeCheckTree.getPathForRow(parentIndex + i));
			}
		}
		parentIndex += _narrative.length + 1;
		
		GenreType[] _genre = GenreType.values();
		for(int i = 0; i < _genre.length; i++) {
		//for(int i = 0; i < 3; i++) {
			if(currentSettings.getEnabledGenreTypes().contains(_genre[i])) {				
				// Add a checkbox to the node
				System.out.println("Enable Genre " + i);
				tropeCheckTree.getCheckingModel().addCheckingPath
					(tropeCheckTree.getPathForRow(parentIndex + i));
			} else {
				System.out.println("Genre " + i + " illegal.");
				tropeCheckTree.getCheckingModel().removeCheckingPath
					(tropeCheckTree.getPathForRow(parentIndex + i));
			}
		}
		parentIndex += _genre.length + 1;
		
		TopicType[] _topic = TopicType.values();
		for(int i = 0; i < _topic.length; i++) {
			if(currentSettings.getEnabledTopicTypes().contains(_topic[i])) {				
				// Add a checkbox to the node
				System.out.println("Enable Genre " + i);
				tropeCheckTree.getCheckingModel().addCheckingPath
					(tropeCheckTree.getPathForRow(parentIndex + i));
			} else {
				System.out.println("Genre " + i + " illegal.");
				tropeCheckTree.getCheckingModel().removeCheckingPath
					(tropeCheckTree.getPathForRow(parentIndex + i));
			}
		}
	}
	// Saves the selection tree into the settings' selected tropes
	private void setSelectedTropes() {
		TreePath[] paths = tropeCheckTree.getCheckingModel().getCheckingPaths();
		for(TreePath t : paths) {
			TropeTreeNode node = (TropeTreeNode)t.getLastPathComponent();
			if(node.getType() == TropeType.Narrative) {
				
			} else if(node.getType() == TropeType.Genre) {
				
			} else if(node.getType() == TropeType.Topic) {
				
			}
			
		}
	}

}