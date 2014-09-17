package objectivelyradical.thalia.html;

import java.util.ArrayList;
import java.net.*;
import java.io.*;

import objectivelyradical.thalia.tropes.Trope;

public class TropesCrawler {
	public final static String TROPES_FILE_NAME = "tropes.thal";
	
	final String[] narrativePages = new String[] {
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AppliedPhlebotinum",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CharacterizationTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Characters",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CharactersAsDevice",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Dialogue",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Montages",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Motifs",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/NarrativeDevices",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Paratext",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Plots",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Settings",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Spectacle",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Symbolism",
	};
	final String[] genrePages = new String[] {
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ActionAdventureTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AdvertisingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AlternateHistoryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ArtTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ComedyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CrimeAndPunishmentTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DerivativeWorks",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DramaTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/EspionageTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/GameShowTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/HorrorTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LoveTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MilitaryAndWarfareTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/NewsTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ProfessionalWrestling",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/RealityTVTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SpeculativeFictionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SportsStoryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SuperheroTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TokusatsuTropes",
	};
	final String[] topicPages = new String[] {
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AbuseTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AfterlifeTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AnimalTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AnnoyanceTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AnxietyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ApathyIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/IndexOfApologies",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AuthorityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/BargainTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/BetrayalTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/BiologyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/BookishTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/BraveryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CensorshipTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CircusIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CleanlinessTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ClownTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CombatTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CriticismTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/CurrencyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DatingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DeathTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DignityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DiscordTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ADishonorableIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DistractionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DoctorIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DoorTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ThisIsYourIndexOnDrugs",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/DuelingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ElementsOfNature",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/EmotionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TheseTropesAreEqual",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ExcuseOfAnIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TheExIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/IndexFailure",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FameAndReputationTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FamilyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Fanservice",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FateAndProphecyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FlyingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FoodTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TropesForSale",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/AForgivingIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FrenemyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FriendshipTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/FurnitureTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/GamblingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/GeometryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/HealingAndCuringTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/IgnoredIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/InjuryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/IntelligenceTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LanguageTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LegacyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LocomotionSuperindex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LogicTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LoyaltyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/LuckTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MadnessTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MailAndDeliveryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MemoryTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MoneyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MoralityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/MythologyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/NationalStereotypingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TropesOfNature",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/NumberTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ObsessionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ThisIndexIsInTheWay",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/OccupationTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/PhilosophyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/APoliteIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/PoliticsTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/PovertyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/Power",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/PridefulTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ProbabilityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/PsychologyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/PragmatismTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/RecognitionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/RejectionIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ReligionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ResponsibilityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/RevengeTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/RitualsAndCeremonies",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/RoyaltyAndNobilityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SchoolTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TheSecretIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SelfishnessTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SelflessnessTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SeriesTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SexualHarassmentAndRapeTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ShapesAndSymbolsTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SilenceTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/IndexInTheSky",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SociologyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/IndexOfSolutions",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SourGrapesTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SplitPersonalityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/StealthTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/StupidityTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/SubstitutionTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TropesAboutTaboos",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TextTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ThreateningTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TimeTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TinyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ToyTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TreasureTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TruthAndLies",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/ThisIndexIsUnstoppable",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/VandalismTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/VehicleIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/VelocityIndex",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/VictoryAndDefeat",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/WalkingTropes",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/WeatherAndEnvironment",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/TropesOfWisdom",
			"http://tvtropes.org/pmwiki/pmwiki.php/Main/WorkplaceTropes",
			
	};
	
	public TropesCrawler() {
	};
	
	private ArrayList<Trope> indexTropes() {
		ArrayList<Trope> allTropes = new ArrayList<Trope>();
		
		// We need to scrape each page for hyperlinks in list items
		ArrayList<Trope> newTropes = new ArrayList<Trope>();
		System.out.println("Adding narrative tropes...");
		for(int i = 0; i < narrativePages.length; i++) {
			newTropes.addAll(getTropesFromPage(narrativePages[i], 0, i));
		}
		System.out.println("Adding genre tropes...");
		for(int i = 0; i < genrePages.length; i++) {
			newTropes.addAll(getTropesFromPage(genrePages[i], 1, i));
		}
		System.out.println("Adding topic tropes...");
		for(int i = 0; i < topicPages.length; i++) {
			newTropes.addAll(getTropesFromPage(topicPages[i], 2, i));
		}
		
		// Now add all unique pages to the trope list
		for(Trope t : newTropes) {
			if(!allTropes.contains(t))
				allTropes.add(t);
		}
		System.out.println("Indexing of tropes finished!");
		System.out.println(allTropes.size() + " tropes found.");
		return allTropes;
	}
	
	private ArrayList<Trope> getTropesFromPage(String s, int mainType, int subType) {
		ArrayList<Trope> pageTropes = new ArrayList<Trope>();
		URL page = null;
		try {
			page = new URL(s);
			
			// We now need to parse the HTML
			BufferedReader in = 
					new BufferedReader(new InputStreamReader(page.openStream()));
			
			boolean reading = false;
			boolean tropesFound = false;
			String line;
			String url;
			String title;
			int startIndex;
			int endIndex;
			
			int hrCount = 0;
			while((line = in.readLine()) != null) {
				if(!reading && line.contains("<!--PageText-->"))
					reading = true;
				
				if(!reading) {
					continue;
				}
				
				// We are reading a horizontal rule
				if(line.contains("<hr />")) {
					hrCount++;
					if(hrCount >= 2) {
						// Hit too many horizontal rules; we are done with the tropes.
						break;
					}
				}
				
				// Okay, we are now reading the page.  Get all the wiki 
				// links and clone them
				
				if(line.contains("<table")) {
					// We hit a table, so break.  This is a back up in case 
					// the <hr /> tags do not parse correctly
					break;	
				}
				
				if(line.contains("<div class=") 
						&& !line.contains("<div class=\"folderlabel\"")
						&& !line.contains("</div>")) {
					// seek to the end of the div block as long as it's not on the same line
					String subline;
					while((subline = in.readLine()) != null) {
						if(subline.contains("</div>"))
							break;
					}
				}
				
				if(line.contains("<li>") && line.contains("class='twikilink'")) {
					// We've found a link to a trope page.  We now need to 
					// extract the information.
					
					// Get the index of the hyperlink
					startIndex = line.indexOf("href='", 0) + 6;
					endIndex = line.indexOf("'", startIndex);
					url = line.substring(startIndex, endIndex);
					startIndex = line.indexOf(">", endIndex);
					endIndex = line.indexOf("<", startIndex + 1);
					title = line.substring(startIndex + 1, endIndex);
					
					pageTropes.add(new Trope(title, url, mainType, subType));
				} else {
					continue;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTropes;
	}
	
	public void saveTropesFile() {
		ArrayList<Trope> tropes = indexTropes();
		try {
			FileOutputStream fos = new FileOutputStream("tropes.al");
			ObjectOutputStream ob = new ObjectOutputStream(fos);
			ob.writeObject(tropes);
			ob.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Trope> loadTropesFile() {
		ArrayList<Trope> tropes = new ArrayList<Trope>();
		try {
			FileInputStream fin = new FileInputStream("tropes.al");
			ObjectInputStream ois = new ObjectInputStream(fin);
			tropes = (ArrayList<Trope>)ois.readObject();
			ois.close();
			fin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tropes;
	}
	
	private void printAllTropes(ArrayList<Trope> tropes) {
		for(Trope t : tropes) {
			System.out.println(
					"<" + t.getTropeType().toString() + " : " + t.subtypeToString() + ">" 
					+ t.getName() + " (" + t.getUrl() + ")");
		}
	}
}
