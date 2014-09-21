package objectivelyradical.thalia.client;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class ThaliaApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Called when this applet is loaded into the browser.
    public void init() {
        //Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    ThaliaMainFrame frame = new ThaliaMainFrame();
                	//ThaliaFullPanel panel = new ThaliaFullPanel();
                	//add(panel);
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

}
