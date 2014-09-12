package objectivelyradical.thalia.utility;

import objectivelyradical.thalia.html.TropesCrawler;


public class TropeIndexer_Launcher {
	
	public static void main (String[] args) {
		TropesCrawler spider = new TropesCrawler();
		spider.saveTropesFile();
	}
}
