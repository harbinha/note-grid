import javax.swing.*;
        
import app.*;
        
/**
 * AudioGrid Application 
 *
 * @author  Hunter Harbin
 * @version 1.0
 */
public class   AudioGridApplication
   extends MultimediaApplication
{
    /**
     * The entry-point of the application
     *
     * @param args    The command-line arguments
     */
    public static void main(String[] args) throws Exception
    {
       SwingUtilities.invokeAndWait(
          new AudioGridApplication(args, 400, 450));
    }
        
    /**
     * Explicit Value Constructor
     *
     * @param args    The command-line arguments
     * @param width   The width of the content (in pixels)
     * @param height  The height of the content (in pixels)
     */
    public AudioGridApplication(String[] args,
                                       int width, int height)
    {
       super(args, new AudioGridApp(), width, height);
    }
}
