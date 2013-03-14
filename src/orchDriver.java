import java.io.BufferedReader;
import java.io.StringReader;

import auditory.described.*;
import io.*;
/**
 * 
 */

/**
 * @author Eric Ulrope Smith
 *
 */
public class orchDriver {

    /**
     * 
     */
    public static void main(String[] args) throws Exception
    {
       Orchestra       orchestra;       
       Score           score;
       String		row;
       BufferedReader	in;
       
       
       row = "R ,0,4\nR ,0,4\nC ,0,4\nR ,0,4\n";
       in = new BufferedReader(new StringReader(row));
       
       score = new Score();
       score.setTempo(1250);
       score.setTimeSignature(4,4);
       
       score.addPart(PartFactory.createPart(in),"Violin");

       orchestra = new Orchestra(score);       
       orchestra.start();
    }

}
