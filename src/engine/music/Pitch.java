   package engine.music;
/**
 * @author Eric Ulrope Smith
 *
 * This class enumerates all 88 keys of 
 * the piano, to be used with the described.auditory
 * package of professor Bernstein's multimedia system.
 * 
 * Note: The strings describing these pitches do
 * not have a duration.
 */
   public enum Pitch
   {
      A0("A ,-4,"),
      ASHARP0("A#,-4,"),
      B0("B ,-4,"),
      C1("C ,-3,"),
      CSHARP1("C#,-3,"),
      D1("D ,-3,"),
      DSHARP1("D#,-3,"),
      E1("E ,-3,"),
      F1("F ,-3,"),
      FSHARP1("F#,-3,"),
      G1("G ,-3,"),
      GSHARP1("G#,-3,"),
      A1("A ,-3,"),
      ASHARP1("A#,-3,"),
      B1("B ,-3,"),
      C2("C ,-2,"),
      CSHARP2("C#,-2,"),
      D2("D ,-2,"),
      DSHARP2("D#,-2,"),
      E2("E ,-2,"),
      F2("F ,-2,"),
      FSHARP2("F#,-2,"),
      G2("G ,-2,"),
      GSHARP2("G#,-2,"),
      A2("A ,-2,"),
      ASHARP2("A#,-2,"),
      B2("B ,-2,"),
      C3("C ,-1,"),
      CSHARP3("C#,-1,"),
      D3("D ,-1,"),
      DSHARP3("D#,-1,"),
      E3("E ,-1,"),
      F3("F ,-1,"),
      FSHARP3("F#,-1,"),
      G3("G ,-1,"),
      GSHARP3("G#,-1,"),
      A3("A ,-1,"),
      ASHARP3("A#,-1,"),
      B3("B ,-1,"),
      C4("C ,0,"), 		//middle C
      REST("R ,0,"),		//rest
      CSHARP4("C#,0,"),
      D4("D ,0,"),
      DSHARP4("D#,0,"),
      E4("E ,0,"),
      F4("F ,0,"),
      FSHARP4("F#,0,"),
      G4("G ,0,"),
      GSHARP4("G#,0,"),
      A4("A ,0,"),
      ASHARP4("A#,0,"),
      B4("B ,0,"),
      C5("C ,1,"),
      CSHARP5("C#,1,"),
      D5("D ,1,"),
      DSHARP5("D#,1,"),
      E5("E ,1,"),
      F5("F ,1,"),
      FSHARP5("F#,1,"),
      G5("G ,1,"),
      GSHARP5("G#,1,"),
      A5("A ,1,"),
      ASHARP5("A#,1,"),
      B5("B ,1,"),
      C6("C ,2,"),
      CSHARP6("C#,2,"),
      D6("D ,2,"),
      DSHARP6("D#,2,"),
      E6("E ,2,"),
      F6("F ,2,"),
      FSHARP6("F#,2,"),
      G6("G ,2,"),
      GSHARP6("G#,2,"),
      A6("A ,2,"),
      ASHARP6("A#,2,"),
      B6("B ,2,"),
      C7("C ,3,"),
      CSHARP7("C#,3,"),
      D7("D ,3,"),
      DSHARP7("D#,3,"),
      E7("E ,3,"),
      F7("F ,3,"),
      FSHARP7("F#,3,"),
      G7("G ,3,"),
      GSHARP7("G#,3,"),
      A7("A ,3,"),
      ASHARP7("A#,3,"),
      B7("B ,3,"),
      C8("C ,3,");
       
      private final String note;
    
	 /**
	  * Construct a new Pitch
	  *
	  * @param note	A string representation of the note
	  */
      private Pitch(String note)
      {
         this.note = note;
      }
    
	 /**
	  * Get a string representation of the note
	  *
	  * @return note	A string representation of the note
	  */
      public String getNote()
      {
         return note;
      }
   }
