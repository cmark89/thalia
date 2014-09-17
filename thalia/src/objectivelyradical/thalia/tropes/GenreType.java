package objectivelyradical.thalia.tropes;

import java.util.HashMap;

public enum GenreType {
	   Action_Adventure,
	   Advertising,
	   Alternate_History,
	   Art,
	   Comedy,
	   Crime_and_Punishment,
	   Derivative_Works,
	   Drama,
	   Espionage,
	   Game_Show,
	   Horror,
	   Love,
	   Military_and_Warfare,
	   News,
	   Professional_Wrestling,
	   Reality_TV,
	   Speculative_Fiction,
	   Sports_Story,
	   Superhero,
	   Tokusatsu;
	   
	   private static HashMap<GenreType, String> _stringValues;
	   static 
	   {
		   _stringValues = new HashMap<GenreType, String>();
		   _stringValues.put(Action_Adventure, "Action Adventure");
		   _stringValues.put(Advertising, "Advertising");
		   _stringValues.put(Alternate_History, "Alternate History");
		   _stringValues.put(Art, "Art");
		   _stringValues.put(Comedy, "Comedy");
		   _stringValues.put(Crime_and_Punishment, "Crime and Punishment");
		   _stringValues.put(Derivative_Works, "Derivative Works");
		   _stringValues.put(Drama, "Drama");
		   _stringValues.put(Espionage, "Espionage");
		   _stringValues.put(Game_Show, "Game_Show");
		   _stringValues.put(Horror, "Horror");
		   _stringValues.put(Love, "Love");
		   _stringValues.put(Military_and_Warfare, "Military and Warfare");
		   _stringValues.put(News, "News");
		   _stringValues.put(Professional_Wrestling, "Professional Wrestling");
		   _stringValues.put(Reality_TV, "Reality TV");
		   _stringValues.put(Speculative_Fiction, "Speculative Fiction");
		   _stringValues.put(Sports_Story, "Sports Story");
		   _stringValues.put(Superhero, "Superhero");
		   _stringValues.put(Tokusatsu, "Tokusatsu");
		   
	   }
	   
	   @Override
	   public String toString() {
		   return _stringValues.get(this);
	   }
}
