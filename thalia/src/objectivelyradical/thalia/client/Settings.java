package objectivelyradical.thalia.client;

import java.util.ArrayList;
import java.util.Arrays;

import objectivelyradical.thalia.html.TropesCrawler;
import objectivelyradical.thalia.tropes.GenreType;
import objectivelyradical.thalia.tropes.NarrativeType;
import objectivelyradical.thalia.tropes.TopicType;
import objectivelyradical.thalia.tropes.Trope;
import objectivelyradical.thalia.tropes.TropeType;

public class Settings {
	
	// Settings is a singleton
	private static Settings _instance;
	public static Settings getInstance() {
		if(_instance == null)
			_instance = new Settings();
		return _instance;
	}
	
	ArrayList<Trope> allTropes;
	
	// Store the categories that can be rolled
	ArrayList<NarrativeType> narrativeTypes = new ArrayList<NarrativeType>();
	ArrayList<GenreType> genreTypes = new ArrayList<GenreType>();
	ArrayList<TopicType> topicTypes = new ArrayList<TopicType>();
	{
		// All narrative types are enabled by default
		for(NarrativeType nt : NarrativeType.values())
			narrativeTypes.add(nt);
		
		// There are several excluded genres by default
		genreTypes.add(GenreType.Action_Adventure);
		genreTypes.add(GenreType.Alternate_History);
		genreTypes.add(GenreType.Comedy);
		genreTypes.add(GenreType.Crime_and_Punishment);
		genreTypes.add(GenreType.Drama);
		genreTypes.add(GenreType.Espionage);
		genreTypes.add(GenreType.Horror);
		genreTypes.add(GenreType.Love);
		genreTypes.add(GenreType.Military_and_Warfare);
		genreTypes.add(GenreType.Speculative_Fiction);
		
		// All topics are enabled by default
		for(TopicType tt : TopicType.values())
			topicTypes.add(tt);
	}
	
	// List that stores the valid tropes for each category
	ArrayList<Trope> narrativeTropes = new ArrayList<Trope>();
	ArrayList<Trope> genreTropes = new ArrayList<Trope>();
	ArrayList<Trope> topicTropes = new ArrayList<Trope>();
	public ArrayList<Trope> getNarrativeTropes() {
		return narrativeTropes;
	}
	public ArrayList<Trope> getGenreTropes() {
		return genreTropes;
	}
	public ArrayList<Trope> getTopicTropes() {
		return topicTropes;
	}
	
	boolean randomizeGenre = true;
	int chosenGenre = -1;
	TopicType topic1;
	TopicType topic2;
	int narrativeTropeCount = 2;
	int genreTropeCount = 2;
	int topicTropeCount = 3;
	
	public boolean getRandomizeGenre() {
		return randomizeGenre;
	}
	public void setRandomizeGenre(boolean val) {
		randomizeGenre = val;
	}
	public int getChosenGenre() {
		return chosenGenre;
	}
	public void setChosenGenre(int i) {
		chosenGenre = i;
	}
	public int getNarrativeTropeCount() {
		return narrativeTropeCount;
	}
	public int getGenreTropeCount() {
		return genreTropeCount;
	}
	public int getTopicTropeCount() {
		return topicTropeCount;
	}
	public void setNarrativeCount(int i) {
		narrativeTropeCount = i;
	}
	public void setGenreCount(int i) {
		genreTropeCount = i;
	}
	public void setTopicCount(int i) {
		topicTropeCount = i;
	}
	public ArrayList<NarrativeType> getEnabledNarrativeTypes() {
		return narrativeTypes;
	}
	public ArrayList<GenreType> getEnabledGenreTypes() {
		return genreTypes;
	}
	public ArrayList<TopicType> getEnabledTopicTypes() {
		return topicTypes;
	}
	
	public Settings() {
		// After initializing our arrays, we need to build the list of tropes
		TropesCrawler spider = new TropesCrawler();
		allTropes = spider.loadTropesFile();
		updateTropes();
	}
	
	private void updateTropes() {
		// Clear the trope lists
		narrativeTropes.clear();
		genreTropes.clear();
		topicTropes.clear();
		ArrayList<NarrativeType> _narrative = 
				new ArrayList<NarrativeType>(Arrays.asList(NarrativeType.values()));
		ArrayList<GenreType> _genre = 
				new ArrayList<GenreType>(Arrays.asList(GenreType.values()));
		ArrayList<TopicType> _topic = 
				new ArrayList<TopicType>(Arrays.asList(TopicType.values()));
		
		for(Trope t : allTropes) {
			TropeType type = t.getTropeType();
			if(type == TropeType.Narrative && 
					narrativeTypes.contains(_narrative.get(t.getSubtype()))) {
				narrativeTropes.add(t);
			} else if (type == TropeType.Genre && 
					genreTypes.contains(_genre.get(t.getSubtype()))) {
				genreTropes.add(t);
			} else if (type == TropeType.Topic && 
					topicTypes.contains(_topic.get(t.getSubtype()))) {
				topicTropes.add(t);
			}
		}
		
		// We now have a list containing all the tropes allowed by the settings
	}
	
	
}
