
package engine.devices;

/**
 * Abstract encapsulation of a Button-Grid Device.
 * 
 * A Button-Grid is a device containing a 
 * two-dimensional array of boolean values which
 * it manages with a 'press' method.  These booleans
 * are intended for use as toggles to be used to
 * trigger and manipulate output of a two-dimensional
 * nature.
 * 
 *           _ _ _ _ _ _ _ _
 *        y |_|_|_|_|_|_|_|_|  
 *        y |_|_|_|_|_|_|_|_|
 *        y |_|_|_|_|_|_|_|_|  
 *        y |_|_|_|_|_|_|_|_|
 *        y |_|_|_|_|_|_|_|_|  
 *        y |_|_|_|_|_|_|_|_|
 *        y |_|_|_|_|_|_|_|_|
 *           x x x x x x x x
 *
 */
public abstract class ButtonGrid
{
	protected 	final	boolean[][]		buttons;
	protected	int						columns,rows;
	protected	final	int[]				dimensions;
	
	/** 
	 * Default constructor 
	 */
	public	ButtonGrid()
	{
		this(8,8);
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param rows 	  The number of rows to be included in this grid
	 * @param columns   The number of columns to be included in this grid
	 */
	protected ButtonGrid(int rows, int columns)
	{
		this.columns = columns;
		this.rows = rows;
		buttons = new boolean[rows][columns];
		dimensions = new int[2];
		dimensions[0] = rows;
		dimensions[1] = columns;
		reset();
	}
	
	/**
	 * Returns the dimensions of this Button Grid
	 * as an array of two integers. Index 0 contains
	 * the number of rows, and Index 1 the number of columns.
	 * 
	 * @return 	 An array containing two integers, the number of rows
	 * 			 and the number of columns. 
	 */
	public int[] getDimensions()
	{
	    return dimensions;
	}
	
	/**
	 * Returns true if the index at row,col corresponds
	 * to a valid button in the grid.
	 * 
	 * @param row 	 		 The row in question
	 * @param col 	 		 The column in question
	 * @return boolean	 True if in, false otherwise.
	 */
	public boolean inGrid(int row, int col)
	{
	    boolean inGrid = false;
	    if(((row <= rows) && (row > 0)) && ((col <= columns) && (col > 0)))
		inGrid = true;
	    return inGrid;
	}
	
	/**
	 * This function enables one to change the value of the boolean 
	 * at grid[row][col].  Affecting the press of a button.
	 * 
	 * @param row 	 The row of the grid containing the 'button'
	 * 				 to be 'pressed'.
	 * @param col   The column of the grid containing the 'button
	 * 				 to be 'pressed'.
	 */
	public void press(int row, int col)
	{
	    if(inGrid(row,col))
	    {
		if(buttons[row - 1][col - 1])
		    buttons[row - 1][col - 1] = false;
		else
		    buttons[row - 1][col - 1] = true;
	    }
	}
	
	/**
	 * Sets all of the boolean values in the grid
	 * to false. Used by the constructor
	 * to initialize the grid.
	 */
	public void reset()
	{
	   for (int i = 0; i < rows; i++) 
	       for(int j = 0; j < columns; j++)
		   buttons[i][j] = false;
	}
}
