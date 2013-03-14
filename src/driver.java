/**
 * 
 */
import engine.devices.*;
import auditory.described.*;
import javax.sound.midi.*;
import java.util.*;
/**
 * @author Eric Ulrope Smith
 *
 */
public class driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

	NoteController	grid;
	Orchestra	orchestra;
	Score		score;
	
	grid = new NoteController();
	Random	generator;
	generator = new Random();

	int row, column;
	
	for(int i = 0; i < 20; i ++)
	{
	    row = generator.nextInt(9);
	    column = generator.nextInt(9);
	    
	    if(row == 0)
		row++;
	    else if(column == 0)
		column++;
	    
	    grid.press(row,column);
	    
	    
	}
	score = grid.getScore();

	
	grid.print();

	System.out.println();
	
	
	try
	{
	    orchestra = new Orchestra(score);
	    orchestra.start();
	}
	catch(MidiUnavailableException MUE)
	{
	    System.out.println("MIDI unavailable!");
	}
   }

}
