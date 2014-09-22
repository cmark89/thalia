package objectivelyradical.thalia.client;

import java.applet.AppletContext;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JLabel;

class LinkableLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String targetURL;
		
		public LinkableLabel(String text, String url) {
			setText("<html><a href=\"" + url + "\" target=\"_blank\">" + text + "</a></html>");
			targetURL = url;
			
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
						openPage();
				}
				public void mouseEntered(MouseEvent e) {
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.getDefaultCursor());
				}
			});
		}
		
		private void openPage()	{
			
			try {
				if(Settings.getInstance().isApplet()) {
					// Running on applet, so open in a new window
					//System.out.println("open in new window");
					AppletContext a = Settings.getInstance().getApplet().
							getAppletContext();
					a.showDocument(new URL(targetURL),  "_blank");
				} else {
					// Running on desktop
					URI uri = new URI(targetURL);
					Desktop.getDesktop().browse(uri);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		@Override
		public void setText(String text) {
			super.setText("<html><a href=\"" + targetURL + "\" target=\"_blank\">" + text + "</a></html>");
		}
		
		public void setText(String text, boolean overrideUrl) {
			if(overrideUrl)
				super.setText(text);
			else
				setText(text);
		}

		public void setUrl(String url) {
			targetURL = url;
		}
	}