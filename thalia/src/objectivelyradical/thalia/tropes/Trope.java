package objectivelyradical.thalia.tropes;

import java.io.Serializable;

public class Trope implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String url;
	
	TropeType type;
	int subtypeIndex;
	
	// Cache this for easiest casting from integers in constructor
	public static TropeType[] tropeTypeValues;
	/*
	public static NarrativeType[] narrativeTypeValues;
	public static GenreType[] genreTypeValues;
	public static TopicType[] topicTypeValues;
	*/
	
	static
	{
		tropeTypeValues = TropeType.values();
		/*
		narrativeTypeValues = NarrativeType.values();
		genreTypeValues = GenreType.values();
		topicTypeValues = TopicType.values();
		*/
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public TropeType getTropeType() {
		return type;
	}
	public void setTropType(TropeType newType) {
		type = newType;
	}
	public void setSubtype(int val) {
		subtypeIndex = val;
	}
	
	public String subtypeToString() {
		if(type == TropeType.Narrative) {
			return NarrativeType.values()[subtypeIndex].toString();
		} else if(type == TropeType.Genre) {
			return GenreType.values()[subtypeIndex].toString();
		} else if(type == TropeType.Topic) {
			return TopicType.values()[subtypeIndex].toString();
		} else {
			return "NULL SUBTYPE VALUE";
		}
	}
	
	public Trope(String name, String url, int mainType, int subtype) {
		this.name = name;
		this.url = url;
		this.type = tropeTypeValues[mainType];
		subtypeIndex = subtype;
		System.out.println("<" + type.toString() +" : " + subtypeToString() + 
				"> " + name + " (" + url + ")");
	}
	
	@Override
	public boolean equals(Object o) {
		Trope t2 = (Trope)o;
		return t2.url.equals(url);
	}
}
