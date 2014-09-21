package objectivelyradical.thalia.client;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.JLabel;

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