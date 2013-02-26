   package engine.music;

   import java.awt.Color;

/**
 * @author Eric Ulrope Smith
 *
 * This class associates a pitch with
 * r,g, and b values, and the color they
 * create based on the frequency, starting with 
 * middle C (261.626Hz).  The frequency was
 * doubled until reaching the terahertz level 
 * (visible light) to reach these associations.
 * 
 */
   public enum PitchColor
   {
      C(0,233,35),
      CSHARP(0,148,155),
      D(5,37,255),
      DSHARP(99,0,255),
      E(103,0,237),
      F(42,0,106),
      FSHARP(62,0,0),
      G(173,0,0),
      GSHARP(255,0,0),
      A(255,129,0),
      ASHARP(196,238,0),
      B(0,255,0);
   
      private final float r,g,b;	
    
    	/**
   	 * Construct a pitch color using RGB values
   	 *
   	 * @param r	  The red value
   	 * @param g	  The green value
   	 * @param b	  The blue value
   	 */
      private PitchColor(float r, float g, float b)
      {
         this.r = r;
         this.g = g;
         this.b = b;
      }
    
    	/**
   	 * Get the pitch color
   	 *
   	 * @return Color	 A new RGB pitch color
   	 */
      public Color getColor()
      {
         return new Color(r,g,b);
      }
    
    	/**
   	 * Get the R value
   	 *
   	 * @return r 	The R value
   	 */
      public float getR()
      {
         return r;
      }
    
    	/**
   	 * Get the G value
   	 *
   	 * @return g 	The G value
   	 */
      public float getG()
      {
         return g;
      }
   	
    	/**
   	 * Get the B value
   	 *
   	 * @return b 	The B value
   	 */
      public float getB()
      {
         return b;
      }
    
   }
