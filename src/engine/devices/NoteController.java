
   package engine.devices;

   import auditory.described.*;
   import java.io.*;
   import java.awt.Color;
	
	import engine.music.*;
/**
 * The Note Controller uses the basic
 * functionality of a Button Grid to manipulate
 * and output playable MIDI output.
 * 
 * The Note Controller has arrays representing
 * the X, and Y axis controls for pitch and rhythm 
 * respectively.  Pitch information is received by a 
 * PitchCollection enum found in the engine.music package.
 * Rhythm is determined by an array of integers representing
 * fractions of a whole.  Rhythm is scalable, but Pitch values
 * cannot be changed after construction.
 * 
 *           _ _ _ _ _ _ _ _
 *        F |_|_|_|_|_|_|_|_|  
 *        D |_|_|_|_|_|_|_|_|
 *        C |_|_|_|_|_|_|_|_|  
 *        A |_|_|_|_|_|_|_|_|
 *        G |_|_|_|_|_|_|_|_|  
 *        E |_|_|_|_|_|_|_|_|
 *        D |_|_|_|_|_|_|_|_|
 *        C |_|_|_|_|_|_|_|_|
 *           8 8 8 8 8 8 8 8
 * 
 *  @author Eric Ulrope Smith
 */
   public class NoteController extends ButtonGrid
   {
   	protected 	int				tempo, beatsPerMeasure, beatNote;
		protected 	int[]				durations;
      protected 	final int[]		caps;
      protected 	Pitch[]			pitches; //pitch collection
      protected	PitchColor[]	colors;
      protected	Score				score;
      protected	String			voice;
    
    /**
     *  Default constructor
     */
      public NoteController()
      {	
         this(8,8,PitchCollection.C_MAJOR_PENT_EXT_GIANTS,1250,4,4,"Synth Bass 2");
      }
   
    /**
	  * Explicit value constructor
	  *
     * @param rows		Number of rows on the grid
     * @param columns	Number of columns on the grid
	  * @param pc			The associated pitch collection
	  * @param tempo		The tempo to use
	  * @param num			Numerator for the meter
	  * @param denom		Denominator for the meter
	  * @param voice		The voice of the audio output
     */
      protected NoteController(	int rows, int columns, PitchCollection pc,
       			int tempo, int num, int denom, String voice)
      {
         super(rows, columns);
         this.pitches = pc.getPitchCollection();
      
         durations = new int[columns];
         for(int i = 0; i < durations.length; i++)
         {
            durations[i] = columns;
         }
         caps = new int[columns];
         setCaps();
         setTempo(tempo);
         setMeter(num,denom);
      
         this.voice = voice;
         this.colors = pc.getPitchColors();
      }
 
    /**
     * Set the note value of a column.
     *
     * If a column contains eighth notes (8),
     * depending on the value in the cap array for that
     * column, you may for instance, increase the duration
     * of a note to a quarter note (4) by passing -1 as 
     * the factor argument, and a half note (2) by passing -2.
     * 
     * @param column 	The column to alter
     * @param factor    The number of times a note
     * 						duration should be doubled.
     */
      public void changeDuration(int column, int factor)
      {
         int col = column-1;
         int willbe = (int)(durations[col] * (Math.pow(2, factor)));
         int is = durations[col];
      
         if(willbe >= caps[col] && willbe <= columns && durations[col] != 0)
         {
            durations[col] = willbe;
            updateDurations(is, willbe, col);
         }
      }
    




	 /** 
	  * Get all of the colors
	  *
	  * @return	Color[]	The colors associated with the grid
	  */
      public Color[] getColors()
      {
         Color[] clrs = new Color[rows];
         for(int i = 0; i < rows; i ++)
            clrs[i] = getRowColor(i);
         return clrs;
      }
		
    /** 
	  * Get the color associated with a row
	  *
	  * @param  row	The row in question
	  * @return	Color	The color associated with the given row
	  */
      public Color getRowColor(int row)
      {
         return colors[row].getColor();
      }
    
	 /**
	  * Get the Score
	  * 
	  * @return Score		The generated score
	  */
      public Score getScore()
      {
         updateScore();
         return score;
      }
		
	 /**
	  * Call to ButtonGrid's press(row,col)
	  */
      public void press(int row, int col)
      {
         super.press(row, col);
      }
		
	 /**
     * Print controller for debugging
     */
      public void print()
      {
         System.out.println();
         for(int i = 0; i < rows; i++)
         {
            System.out.print(pitches[i].getNote() + "\t");
         
            for(int j = 0; j < columns; j++)
               System.out.print(buttons[i][j] + "\t");
         
            System.out.print("\n");
         }
         System.out.print("\t");
         for(int i = 0; i < durations.length; i++)
            System.out.print(durations[i] + "\t");
         System.out.print("\n\t");
      }
		
	 /**
	  * Creates a Part from the row
	  *
	  * @param  row		The row to use
	  * @return Part		The constructed part
	  */
      protected Part rowToPart(int row)
      {
         Part part;
         BufferedReader	in;
      
         in = new BufferedReader(new StringReader(rowToString(row)));
      
         part = new Part();
      
         try
         {
            part = PartFactory.createPart(in);
         }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
				
         return part;
      }
		
	 /**
	  * Creates a string representation of the row
	  *
	  * @param row			The row to use
	  * @param return		The string representation
	  */
      public String rowToString(int row)
      {
         String	part,pitch;
      
         part = "";
         pitch = pitches[row].getNote();
      
         for(int i = 0; i < columns; i++)
         {
            if(buttons[row][i] && durations[i] != 0)
               part += pitch + Integer.toString(durations[i]) + "\n";
            else if(durations[i] != 0)
               part += Pitch.REST.getNote() + Integer.toString(durations[i]) + "\n";  
         }
         for(int i = 0; i < 8; i ++)
            part+=part;
      
         return part;	
      }
		
		
	 /**
	  * Sets the column caps
     * Supports un-dotted note values up to
     * 16th.
     */
      protected void setCaps()
      {
         double curr;
         curr = 0;
         for(int i = 0; i < columns; i++)
         {
            curr = (columns - i)/(double)columns;
            if(i == 0)
               caps[i] = 1;
            else if(curr < 1 && curr >= .5)
               caps[i] = 2;
            else if(curr < .5 && curr >=.25)
               caps[i] = 4;
            else if(curr < .25 && curr >=.125)
               caps[i] = 8;
            else
               caps[i] = 16;
         }
      }
    
	 	/**
	  * Sets the meter of the controller
	  *
	  * @param num			Numerator for the meter
	  * @param denom		Denominator for the meter
	  */
      protected void setMeter(int num, int denom)
      {
         beatsPerMeasure = num;
         beatNote = denom;
      }
		
	 /**
	  * Sets the tempo of the controller
	  *
	  * @param tempo		The tempo to use
	  */
      public void setTempo(int tempo)
      {
         this.tempo = tempo;
      }
    
	 /** 
	  * Update the buttons
	  */
      protected void updateButtons()
      {
         for (int i = 0; i < rows; i++) 
            for(int j = 0; j < columns; j++)
               if(durations[j] == 0)
                  buttons[i][j] = false;
      }
    
	 
	 /**
     * The values of the duration array represent
     * fractions of the whole, e.g.
     * 
     * durations[i] = 8; --> 1/8
     * 
     * This method ensures that the sum of these fractions
     * is 1.
     * 
     * @param was  	  The value of the previous duration
     * @param is       The value of the current duration
     * @param column   The column altered
     */
      protected void updateDurations(int was, int is, int column)
      {
         int scopeis, scopewas, i;
      
         scopeis = columns/is;
         scopewas = columns/was;
      
         if(is > was)
            for(i = column; i < (column + scopewas); i++)
            {
               if((i > (column+(scopeis-1))) && (i <= (column+(scopewas-1))))
                  durations[i] = columns;
            }
         else
            for(i = column ; i < (column + scopeis); i++)
            {
               if((i > column) && (i <= (column+(scopeis +1))))
                  durations[i] = 0;
            }
         updateButtons();
      }
        
    /**
	  * Updates the score with all the parts
	  */
      public void updateScore()
      {
         score = new Score();
         score.setTimeSignature(beatsPerMeasure,beatNote);
         score.setTempo(tempo);
         for(int i = 0; i < rows; i ++)
            score.addPart(rowToPart(i), voice);
      }
   
   }
