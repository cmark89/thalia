package objectivelyradical.thalia.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import objectivelyradical.thalia.html.TropesCrawler;
import objectivelyradical.thalia.tropes.Trope;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.JTabbedPane;

public class ThaliaMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	ArrayList<Trope> tropes;
	LinkableLabel trope1link;
	LinkableLabel trope2link;
	LinkableLabel trope3link;
	private JTabbedPane QuickModeTabPane;
	private JPanel QuickMode;
	private JLabel label_1;
	private JPanel QuickMode_Footer;
	private JButton button;
	private JPanel QuickMode_Main;
	private JLabel trope1label;
	private JLabel trope2label;
	private JLabel trope3label;
	private JPanel FullMode;
	private ThaliaSettings Settings;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThaliaMain window = new ThaliaMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThaliaMain() {
		initialize();
		loadTropes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Thalia");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		trope1link = new LinkableLabel("", "");
		
		trope2link = new LinkableLabel("", "");
		
		trope3link = new LinkableLabel("", "");
		
		QuickModeTabPane = new JTabbedPane(JTabbedPane.TOP);
		QuickModeTabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		frame.getContentPane().add(QuickModeTabPane, BorderLayout.CENTER);
		
		QuickMode = new JPanel();
		QuickModeTabPane.addTab("Quick Mode", null, QuickMode, "A simple mode that generates three tropes completely at random.  Ideal for flash fiction, or as a way to discover new pages on TVTropes.");
		QuickMode.setLayout(new BorderLayout(0, 0));
		
		label_1 = new JLabel("Quick Mode");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		QuickMode.add(label_1, BorderLayout.NORTH);
		
		QuickMode_Footer = new JPanel();
		QuickMode.add(QuickMode_Footer, BorderLayout.SOUTH);
		QuickMode_Footer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		button = new JButton("Roll Tropes");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rollTropes();
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		QuickMode_Footer.add(button);
		
		QuickMode_Main = new JPanel();
		QuickMode.add(QuickMode_Main, BorderLayout.CENTER);
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
		
		FullMode = new JPanel();
		QuickModeTabPane.addTab("Full Mode", null, FullMode, "Randomize genre and themes, giving multiple tropes for each.  Supports partial rerolling.");
		
		Settings = new ThaliaSettings();
		QuickModeTabPane.addTab("Settings", null, Settings, null);
	}
	
	private void loadTropes() {
		TropesCrawler spider = new TropesCrawler();
		tropes = spider.loadTropesFile();
		System.out.println("Tropes loaded successfully.");
	}
	
	private void rollTropes() {
		final int NUMBER_TO_ROLL = 3;
		ArrayList<Trope> rolledTropes = new ArrayList<Trope>();
		Trope t;
		int index;
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
	
	class LinkableLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String targetURL;
		
		public LinkableLabel(String text, String url) {
			setText("<html><a href=\"" + url + "\">" + text + "</a></html>");
			targetURL = url;
			
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(new URI(targetURL));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				public void mouseEntered(MouseEvent e) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.getDefaultCursor());
				}
			});
		}
		
		@Override
		public void setText(String text) {
			super.setText("<html><a href=\"" + targetURL + "\">" + text + "</a></html>");
		}

		public void setUrl(String url) {
			targetURL = url;
		}
	}
}
