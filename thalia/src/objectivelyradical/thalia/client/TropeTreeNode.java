package objectivelyradical.thalia.client;

import objectivelyradical.thalia.tropes.NarrativeType;
import objectivelyradical.thalia.tropes.TopicType;
import objectivelyradical.thalia.tropes.TropeType;
import objectivelyradical.thalia.tropes.GenreType;

public class TropeTreeNode {
	TropeType type;
	public TropeType getType() {
		return type;
	}
	int subtypeIndex;
	public int getSubtype() {
		return subtypeIndex;
	}
	
	public TropeTreeNode(TropeType type, int subtypeIndex) {
		this.type = type;
		this.subtypeIndex = subtypeIndex;
	}
	
	public String toString() {
		// TODO: Get this from some database of cleaned strings
		if(type == TropeType.Narrative) {
			return NarrativeType.values()[subtypeIndex].toString();
		} else if (type == TropeType.Genre) {
			return GenreType.values()[subtypeIndex].toString();
		} else if(type == TropeType.Topic) {
			return TopicType.values()[subtypeIndex].toString();
		} else {
			return "ERROR";
		}
	}
	
	public boolean equals(Object o) {
		if(o.getClass().equals(this.getClass())) {
			TropeTreeNode no = (TropeTreeNode)o;
		
			return type == no.getType() && subtypeIndex == no.getSubtype();
		}
		return false;
	}
}
