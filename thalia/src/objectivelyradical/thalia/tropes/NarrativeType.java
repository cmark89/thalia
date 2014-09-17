package objectivelyradical.thalia.tropes;

import java.util.HashMap;

public enum NarrativeType {
   Applied_Phlebotinum,
   Characterization,
   Characters,
   Characters_as_Device,
   Dialogue,
   Montages,
   Motifs,
   Narrative_Devices,
   Paratext,
   Plots,
   Settings,
   Spectacle,
   Symbolism; 
   
   private static HashMap<NarrativeType, String> _stringValues;
   static 
   {
	   _stringValues = new HashMap<NarrativeType, String>();
	   _stringValues.put(Applied_Phlebotinum, "Applied Phlebotinum");
	   _stringValues.put(Characterization, "Characterization");
	   _stringValues.put(Characters, "Characters");
	   _stringValues.put(Characters_as_Device, "Characters as Device");
	   _stringValues.put(Dialogue, "Dialogue");
	   _stringValues.put(Montages, "Montages");
	   _stringValues.put(Motifs, "Motifs");
	   _stringValues.put(Narrative_Devices, "Narrative Devices");
	   _stringValues.put(Paratext, "Paratext");
	   _stringValues.put(Plots, "Plots");
	   _stringValues.put(Settings, "Settings");
	   _stringValues.put(Spectacle, "Spectacle");
	   _stringValues.put(Symbolism, "Symbolism");
   }
   
   @Override
   public String toString() {
	   return _stringValues.get(this);
   }
}
