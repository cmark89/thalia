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

public class ThaliaMainFrame {

	Settings settings;
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
	private ThaliaSettingsPanel Settings;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThaliaMainFrame window = new ThaliaMainFrame();
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
	public ThaliaMainFrame() {
		initialize();
		loadTropes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Thalia");
		frame.setBounds(100, 100, 500, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new ThaliaTabbedPanel());
	}
	
	private void loadTropes() {
		TropesCrawler spider = new TropesCrawler();
		tropes = spider.loadTropesFile();
		System.out.println("Tropes loaded successfully.");
	}
	
	
}
