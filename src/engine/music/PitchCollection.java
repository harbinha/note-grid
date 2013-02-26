   package engine.music;
	
/**
 * An enumeration of pitches with associated colors 
 *
 * @author Eric Ulrope Smith
 */
   public enum PitchCollection {
    
      C_MAJOR_PENT_EXT(	new Pitch[]
                	    {
         					Pitch.F5,
                        Pitch.D5,
                        Pitch.C5,
                        Pitch.A4,
                        Pitch.G4,
                        Pitch.E4,
                        Pitch.D4,
         					Pitch.C4	
                	    },
							 
                	new PitchColor[]
                	    {
         					PitchColor.F,
         					PitchColor.D,
         					PitchColor.C,
         					PitchColor.A,
         					PitchColor.G,
         					PitchColor.E,
         					PitchColor.D,
         					PitchColor.C
                	     }),
							  
      C_MAJOR_PENT_EXT_GIANTS(	new Pitch[]
                         	    {
         	    			Pitch.F7,
                        Pitch.D6,
                        Pitch.C6,
                        Pitch.A5,
                        Pitch.G4,
                        Pitch.E3,
                        Pitch.D2,
         	    			Pitch.C1	
                         	    },
										 
                         	new PitchColor[]
                         	    {
         	    			PitchColor.F,
         	    			PitchColor.D,
         	    			PitchColor.C,
         	    			PitchColor.A,
         	    			PitchColor.G,
         	    			PitchColor.E,
         	    			PitchColor.D,
         	    			PitchColor.C
                         	     }
      			
      );
   
    
   
      private final Pitch[] pitches;
      private final PitchColor[] colors;
    
	 
	 	/**
		 * Construct a collection of pitches and colors
		 */
      private PitchCollection(Pitch[] pitches, PitchColor[] colors)
      {
         this.pitches = pitches;
         this.colors = colors;
      
      }
    
	 	/**
		 * Get the pitches in the collection
		 * 
		 * @return Pitch[]   An array of pitches in the collection
		 */
      public Pitch[] getPitchCollection()
      {
         return pitches;
      }
    
	 	/**
		 * Get the colors in the collection
		 * 
		 * @return PitchColor[]   An array of colors in the collection
		 */
      public PitchColor[] getPitchColors()
      {
         return colors;
      }
   }
