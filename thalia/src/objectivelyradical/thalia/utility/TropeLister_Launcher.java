package objectivelyradical.thalia.utility;

import java.util.ArrayList;
import java.util.HashMap;

import objectivelyradical.thalia.html.TropesCrawler;
import objectivelyradical.thalia.tropes.Trope;


public class TropeLister_Launcher {
	
	public static void main (String[] args) {
		final String searchkey = "Book";
		boolean found = false;
		
		TropesCrawler spider = new TropesCrawler();
		ArrayList<Trope> tropes = spider.loadTropesFile();
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		for(Trope t : tropes) {
			String s = t.getTropeType().toString()+":"+t.subtypeToString();
			if(count.containsKey(s)) {
				int i = count.get(s);
				count.put(s, i+1);
			} else {
				count.put(s, 1);
			}
			
			if(t.getName().contains(searchkey)) {
				System.out.println(s + " -- " + t.getName());
				found = true;
			}
			if(t.subtypeToString().contains(searchkey)) {
				System.out.println(s + " -- " + t.getName());
				found = true;
			}
		}
		
		System.out.println("FINISH");
	}
}
