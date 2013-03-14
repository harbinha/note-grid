//Java
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.geom.*;
   import javax.swing.*;
   import javax.sound.midi.*;

//Library
   import app.*;
   import io.*;
   import visual.*;
   import visual.statik.sampled.*;
   import auditory.described.*;

//AudioGrid
   import engine.devices.*;
   import engine.music.*;


/**
 * The AudioGrid App
 *
 * @author Hunter Harbin
 * @version 1.0
 */
   public class	AudioGridApp
   	extends		AbstractMultimediaApp
   	implements 	ActionListener
   {
  		private	boolean				clicked;
		private  ImageIcon[]			icons;
		private  final int 			WIDTH = 50;
		private  NoteController		grid;
		private  Orchestra			orchestra;
      private	Point[][]			origins;
      private	Score					score;
      
    /**
     * The entry point
     */
      public void init()
      {
         Container		contentPane;
      
         ResourceFinder	finder;
         JToggleButton		buttonToAdd,playToggleButton;
         ImageIcon		start,stop;
         ButtonGridAction	playToggleAction;
      
         initIcons();
         initOrigins();
         clicked = false;
      
         contentPane = (JPanel)rootPaneContainer.getContentPane();
      
         start = icons[9];
         stop = icons[10];
      
         playToggleAction = new ButtonGridAction(start,"PLAY");
      
         playToggleButton = new JToggleButton(playToggleAction);
      
         playToggleButton.setContentAreaFilled(false);
         playToggleButton.setFocusPainted(false);
         playToggleButton.setSelectedIcon(stop);
         playToggleButton.setHideActionText(true);
         playToggleButton.setOpaque(true);
         playToggleButton.setBounds(0,400,400,50);
         playToggleButton.setBackground(Color.WHITE);
         playToggleButton.addActionListener(this);
      
      	//add the buttons to grid
         for(int i = 0; i < 8; i ++)
            for(int j = 0; j < 8; j++)
            {
               buttonToAdd = createNoteButton(i,j);
               contentPane.add(buttonToAdd);
            }
      
         grid = new NoteController();
      
         contentPane.add(playToggleButton);
         contentPane.setBackground(Color.WHITE);
         contentPane.setLayout(null);
      }
      
   	/**
   	 * Creates the buttons
   	 *
   	 * @param row					Row index of the button
   	 * @param col					Column index of the button
   	 * @return JToggleButton	The button created
   	 */
      private JToggleButton createNoteButton(int row, int col)
      {
         int width = 50;
         String command = String.valueOf(row+1) + String.valueOf(col+1);
         Action action = new ButtonGridAction(icons[8],command);
         JToggleButton button = new JToggleButton(action);
      
         if(row == 0){
            button.setSelectedIcon(icons[0]);
         }
         else if(row == 1){
            button.setSelectedIcon(icons[1]);
         }
         else if(row == 2){
            button.setSelectedIcon(icons[2]);
         }
         else if(row == 3){
            button.setSelectedIcon(icons[3]);
         }
         else if(row == 4){
            button.setSelectedIcon(icons[4]);
         }
         else if(row == 5){
            button.setSelectedIcon(icons[5]);
         }
         else if(row == 6){
            button.setSelectedIcon(icons[6]);
         }
         else if(row == 7){
            button.setSelectedIcon(icons[7]);
         }
      
         button.setContentAreaFilled(false);
         button.setHideActionText(true);
         button.setOpaque(true);
         button.setBounds((int)origins[row][col].getX(), 
            (int)origins[row][col].getY(), width, width);
         button.setBackground(Color.WHITE);
         button.addActionListener(this);
        
         return button;
      }
      
   
      /**
       * Handle actionPerformed message (required by ActionListener)
       *
       * @param event   The ActionEvent that generatedt his message
       */
      public void actionPerformed(ActionEvent event)
      {
        
         
      }
      
   	/**
   	 * Sets the behaviors of the buttons on click
   	 */
      @SuppressWarnings("serial")
      class ButtonGridAction extends AbstractAction
      {
         public ButtonGridAction(Icon icon, String desc)
         {
            super(desc,icon);
            putValue(SHORT_DESCRIPTION, desc);
         }
         public void actionPerformed(ActionEvent e) 
         {
            String descriptor = (String)this.getValue(SHORT_DESCRIPTION);
            if(descriptor.equals("11"))
               grid.press(1,1); //NoteController.press(1,1)
            else if(descriptor.equals("12"))
               grid.press(1,2);
            else if(descriptor.equals("13"))
               grid.press(1,3);
            else if(descriptor.equals("14"))
               grid.press(1,4);
            else if(descriptor.equals("15"))
               grid.press(1,5);
            else if(descriptor.equals("16"))
               grid.press(1,6);
            else if(descriptor.equals("17"))
               grid.press(1,7);
            else if(descriptor.equals("18")) //last column in row
               grid.press(1,8);
            else if(descriptor.equals("21"))
               grid.press(2,1);//NoteController.press(2,1)
            else if(descriptor.equals("22"))
               grid.press(2,2);
            else if(descriptor.equals("23"))
               grid.press(2,3);
            else if(descriptor.equals("24"))
               grid.press(2,4);
            else if(descriptor.equals("25"))
               grid.press(2,5);
            else if(descriptor.equals("26"))
               grid.press(2,6);
            else if(descriptor.equals("27"))
               grid.press(2,7);
            else if(descriptor.equals("28")) //last column in row
               grid.press(2,8);
            else if(descriptor.equals("31"))
               grid.press(3,1);//NoteController.press(3,1)
            else if(descriptor.equals("32"))
               grid.press(3,2);
            else if(descriptor.equals("33"))
               grid.press(3,3);
            else if(descriptor.equals("34"))
               grid.press(3,4);
            else if(descriptor.equals("35"))
               grid.press(3,5);
            else if(descriptor.equals("36"))
               grid.press(3,6);
            else if(descriptor.equals("37"))
               grid.press(3,7);
            else if(descriptor.equals("38")) //last column in row
               grid.press(3,8);
            else if(descriptor.equals("41"))
               grid.press(4,1);//NoteController.press(4,1)
            else if(descriptor.equals("42"))
               grid.press(4,2);
            else if(descriptor.equals("43"))
               grid.press(4,3);
            else if(descriptor.equals("44"))
               grid.press(4,4);
            else if(descriptor.equals("45"))
               grid.press(4,5);
            else if(descriptor.equals("46"))
               grid.press(4,6);
            else if(descriptor.equals("47"))
               grid.press(4,7);
            else if(descriptor.equals("48")) //last column in row
               grid.press(4,8);
            else if(descriptor.equals("51"))
               grid.press(5,1);//NoteController.press(5,1)
            else if(descriptor.equals("52"))
               grid.press(5,2);
            else if(descriptor.equals("53"))
               grid.press(5,3);
            else if(descriptor.equals("54"))
               grid.press(5,4);
            else if(descriptor.equals("55"))
               grid.press(5,5);
            else if(descriptor.equals("56"))
               grid.press(5,6);
            else if(descriptor.equals("57"))
               grid.press(5,7);
            else if(descriptor.equals("58")) //last column in row
               grid.press(5,8);
            else if(descriptor.equals("61"))
               grid.press(6,1);//NoteController.press(6,1)
            else if(descriptor.equals("62"))
               grid.press(6,2);
            else if(descriptor.equals("63"))
               grid.press(6,3);
            else if(descriptor.equals("64"))
               grid.press(6,4);
            else if(descriptor.equals("65"))
               grid.press(6,5);
            else if(descriptor.equals("66"))
               grid.press(6,6);
            else if(descriptor.equals("67"))
               grid.press(6,7);
            else if(descriptor.equals("68")) //last column in row
               grid.press(6,8);
            else if(descriptor.equals("71"))
               grid.press(7,1);//NoteController.press(7,1)
            else if(descriptor.equals("72"))
               grid.press(7,2);
            else if(descriptor.equals("73"))
               grid.press(7,3);
            else if(descriptor.equals("74"))
               grid.press(7,4);
            else if(descriptor.equals("75"))
               grid.press(7,5);
            else if(descriptor.equals("76"))
               grid.press(7,6);
            else if(descriptor.equals("77"))
               grid.press(7,7);
            else if(descriptor.equals("78")) //last column in row
               grid.press(7,8);
            else if(descriptor.equals("81"))
               grid.press(8,1);//NoteController.press(8,1)
            else if(descriptor.equals("82"))
               grid.press(8,2);
            else if(descriptor.equals("83"))
               grid.press(8,3);
            else if(descriptor.equals("84"))
               grid.press(8,4);
            else if(descriptor.equals("85"))
               grid.press(8,5);
            else if(descriptor.equals("86"))
               grid.press(8,6);
            else if(descriptor.equals("87"))
               grid.press(8,7);
            else if(descriptor.equals("88")) //last column in row
               grid.press(8,8);
            else if(descriptor.equals("PLAY"))
            {
               try
               {
                  if(clicked){
                     orchestra.stop();
                     clicked = false;
                  }
                  else{
                     score = grid.getScore();
                     orchestra = new Orchestra(score);
                     orchestra.start();
                     clicked = true;
                  }
                
               }
                  catch(MidiUnavailableException mue)
                  {
                     System.out.println("MIDI unavailable!");
                  }
            }
         }
      }
   	
   	/**
   	 * Initialize the buttons from file into an array
   	 */
      private void initIcons()
      {
      /*c,d,e,g,a,c,d,f,off,start,stop*/
         String[]	paths;
         icons = new ImageIcon[11];
       
         ResourceFinder finder = ResourceFinder.createInstance(this);
      
         paths = finder.loadResourceNames("buttons.txt");
      
         for(int i=0;i < paths.length; i++) 
            icons[i] = new ImageIcon(finder.findURL(paths[i]));
      }
      
   	/**
   	 * Initialize the locations for the buttons
   	 */
      private void initOrigins()
      {
         int rows, cols,x,y;
         rows = cols = 8;
         x = y = 0;
         origins = new Point[rows][cols];
      
         for(int i = 0; i < rows; i ++)
            for(int j = 0; j < cols; j ++){
               int xx =x+(j*WIDTH);
               int yy = y+(i*WIDTH);
               origins[i][j] = new Point(xx, yy);
            }
      
      }    
      
   }
