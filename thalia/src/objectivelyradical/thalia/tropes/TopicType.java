package objectivelyradical.thalia.tropes;

import java.util.HashMap;

public enum TopicType {
   Abuse,
   Afterlife,
   Animals,
   Annoyance,
   Anxiety,
   Apathy,
   Apologies,
   Authority,
   Bargain,
   Betrayal,
   Biology,
   Books,
   Bravery,
   Censorship,
   Circus, 
   Cleanliness,
   Clown,
   Combat,
   Criticism,
   Currency,
   Dating,
   Death,
   Dignity,
   Discord,
   Dishonor,
   Distraction,
   Doctor,
   Door,
   Drugs,
   Dueling,
   Elements_of_Nature,
   Emotion,
   Equal,
   Excuse, 
   Exes,
   Failure,
   Fame_and_Reputation,
   Family,
   Fanservice,
   Fate_and_Prophecy,
   Flying,
   Food,
   For_Sale,
   Forgiveness,
   Frenemy,
   Friendship,
   Furniture,
   Gambling,
   Geometry,
   Healing_and_Curing,
   Ignored, 
   Injury,
   Intelligence,
   Language,
   Legacy,
   Locomotion,
   Logic,
   Loyalty,
   Luck,
   Madness,
   Mail_and_Delivery,
   Memory,
   Money,
   Morality,
   Mythology,
   National_Stereotyping,
   Nature,
   Number,
   Obsession,
   Obstacles,
   Occupation,
   Philosophy,
   Politeness, 
   Politics,
   Poverty,
   Power,
   Prideful,
   Probability,
   Psychology,
   Pragmatism,
   Recognition,
   Rejection,
   Religion,
   Responsibility,
   Revenge,
   Rituals_and_Ceremonies,
   Royalty_and_Nobility,
   School,
   The_Secret, 
   Selfishness,
   Selflessness,
   Series,
   Sexual_Harassment_and_Rape,
   Shapes_and_Symbols,
   Silence,
   Sky,
   Sociology,
   Solutions,
   Sour_Grapes,
   Split_Personality,
   Stealth,
   Stupidity,
   Substitution,
   Taboos,
   Text,
   Threatening,
   Time,
   Tiny,
   Toy,
   Treasure,   
   Truth_and_Lies,
   Unstoppable,
   Vandalism,
   Vehicle,
   Velocity, 
   Victory_and_Defeat,
   Walking,
   Weather_and_Environment,
   Wisdom,
   Workplace;
   
   private static HashMap<TopicType, String> _stringValues;
   static 
   {
	   _stringValues = new HashMap<TopicType, String>();
	   _stringValues.put(Abuse, "Abuse");
	   _stringValues.put(Afterlife, "Afterlife");
	   _stringValues.put(Animals, "Animals");
	   _stringValues.put(Annoyance, "Annoyance");
	   _stringValues.put(Anxiety, "Anxiety");
	   _stringValues.put(Apathy, "Apathy");
	   _stringValues.put(Apologies, "Apologies");
	   _stringValues.put(Authority, "Authority");
	   _stringValues.put(Bargain, "Bargaining");
	   _stringValues.put(Betrayal, "Betrayal");
	   _stringValues.put(Biology, "Biology");
	   _stringValues.put(Books, "Books");
	   _stringValues.put(Bravery, "Bravery");
	   _stringValues.put(Censorship, "Censorship");
	   _stringValues.put(Circus, "Circus");
	   _stringValues.put(Cleanliness, "Cleanliness");
	   _stringValues.put(Clown, "Clown");
	   _stringValues.put(Combat, "Combat");
	   _stringValues.put(Criticism, "Criticism");
	   _stringValues.put(Currency, "Currency");
	   _stringValues.put(Dating, "Dating");
	   _stringValues.put(Death, "Death");
	   _stringValues.put(Dignity, "Dignity");
	   _stringValues.put(Discord, "Discord");
	   _stringValues.put(Dishonor, "Dishonor");
	   _stringValues.put(Distraction, "Distraction");
	   _stringValues.put(Doctor, "Doctors");
	   _stringValues.put(Door, "Doors");
	   _stringValues.put(Drugs, "Drugs");
	   _stringValues.put(Dueling, "Dueling");
	   _stringValues.put(Elements_of_Nature, "Elements of Nature");
	   _stringValues.put(Emotion, "Emotions");
	   _stringValues.put(Equal, "Equality");
	   _stringValues.put(Excuse, "Excuses");
	   _stringValues.put(Exes, "Exes");
	   _stringValues.put(Failure, "Failure");
	   _stringValues.put(Fame_and_Reputation, "Fame and Reputation");
	   _stringValues.put(Family, "Family");
	   _stringValues.put(Fanservice, "Fanservice");
	   _stringValues.put(Fate_and_Prophecy, "Fate and Prophecy");
	   _stringValues.put(Flying, "Flying");
	   _stringValues.put(Food, "Food");
	   _stringValues.put(For_Sale, "For Sale");
	   _stringValues.put(Forgiveness, "Forgiveness");
	   _stringValues.put(Frenemy, "Frenemy");
	   _stringValues.put(Friendship, "Friendship");
	   _stringValues.put(Furniture, "Furniture");
	   _stringValues.put(Gambling, "Gambling");
	   _stringValues.put(Geometry, "Geometry");
	   _stringValues.put(Healing_and_Curing, "Healing and Curing");
	   _stringValues.put(Ignored, "Ignored");
	   _stringValues.put(Injury, "Injury");
	   _stringValues.put(Intelligence, "Intelligence");
	   _stringValues.put(Language, "Language");
	   _stringValues.put(Legacy, "Legacy");
	   _stringValues.put(Locomotion, "Locomotion");
	   _stringValues.put(Logic, "Logic");
	   _stringValues.put(Loyalty, "Loyalty");
	   _stringValues.put(Luck, "Luck");
	   _stringValues.put(Madness, "Madness");
	   _stringValues.put(Mail_and_Delivery, "Mail and Delivery");
	   _stringValues.put(Memory, "Memory");
	   _stringValues.put(Money, "Money");
	   _stringValues.put(Morality, "Morality");
	   _stringValues.put(Mythology, "Mythology");
	   _stringValues.put(National_Stereotyping, "National Stereotyping");
	   _stringValues.put(Nature, "Nature");
	   _stringValues.put(Number, "Numbers");
	   _stringValues.put(Obsession, "Obsession");
	   _stringValues.put(Obstacles, "Obstacles");
	   _stringValues.put(Occupation, "Occupation");
	   _stringValues.put(Philosophy, "Philosophy");
	   _stringValues.put(Politeness, "Politeness");
	   _stringValues.put(Politics, "Politics");
	   _stringValues.put(Poverty, "Poverty");
	   _stringValues.put(Power, "Power");
	   _stringValues.put(Prideful, "Pride");
	   _stringValues.put(Probability, "Probability");
	   _stringValues.put(Psychology, "Psychology");
	   _stringValues.put(Pragmatism, "Pragmatism");
	   _stringValues.put(Recognition, "Recognition");
	   _stringValues.put(Rejection, "Rejection");
	   _stringValues.put(Religion, "Religion");
	   _stringValues.put(Responsibility, "Responsibility");
	   _stringValues.put(Revenge, "Revenge");
	   _stringValues.put(Rituals_and_Ceremonies, "Rituals and Ceremonies");
	   _stringValues.put(Royalty_and_Nobility, "Royalty and Nobility");
	   _stringValues.put(School, "School");
	   _stringValues.put(The_Secret, "The Secret");
	   _stringValues.put(Selfishness, "Selfishness");
	   _stringValues.put(Selflessness, "Selflessness");
	   _stringValues.put(Series, "Series");
	   _stringValues.put(Sexual_Harassment_and_Rape, "Sexual Harassment and Rape");
	   _stringValues.put(Shapes_and_Symbols, "Shapes and Symbols");
	   _stringValues.put(Silence, "Silence");
	   _stringValues.put(Sky, "Sky");
	   _stringValues.put(Sociology, "Sociology");
	   _stringValues.put(Solutions, "Solutions");
	   _stringValues.put(Sour_Grapes, "Sour Grapes");
	   _stringValues.put(Split_Personality, "Split Personality");
	   _stringValues.put(Stealth, "Stealth");
	   _stringValues.put(Stupidity, "Stupidity");
	   _stringValues.put(Substitution, "Substitution");
	   _stringValues.put(Text, "Text");
	   _stringValues.put(Threatening, "Threats");
	   _stringValues.put(Time, "Time");
	   _stringValues.put(Tiny, "Tiny");
	   _stringValues.put(Toy, "Toys");
	   _stringValues.put(Treasure, "Treasure");
	   _stringValues.put(Taboos, "Taboos");
	   _stringValues.put(Truth_and_Lies, "Truth and Lies");
	   _stringValues.put(Unstoppable, "Unstoppable");
	   _stringValues.put(Vandalism, "Vandalism");
	   _stringValues.put(Vehicle, "Vehicle");
	   _stringValues.put(Velocity, "Velocity");
	   _stringValues.put(Victory_and_Defeat, "Victory and Defeat");
	   _stringValues.put(Walking, "Walking");
	   _stringValues.put(Weather_and_Environment, "Weather and Environment");
	   _stringValues.put(Wisdom, "Wisdom");
	   _stringValues.put(Workplace, "Workplace");
   }
   
   @Override
   public String toString() {
	   return _stringValues.get(this);
   }
}
