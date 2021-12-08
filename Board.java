package application;
import java.io.*;
public class Board implements Serializable{
	private int Tiles[][];
	private int boardsize;
	public int shipamount;
	public String difficulty;
	public boolean shipsplaced;
	/**
	* Default Board Constructor, that creates an empty board variable
 	* for continuing games after they're saved
 	*/
	public Board() {
		
	};
	
	/**
	 * This constructor creates a board variable, and uses a nested for loop
	 * to set the 2D array for the Tiles variable, which is used to represent the entire board
	 * and "ship" placements
	 * 
	 * @param size - Sets size of board (size x size)
	 */
	public Board(int size) {
		Tiles = new int[size][size];
		boardsize=size;
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				Tiles[i][j]=0;
			}
		}
	}
	
	/**
	 * This method allows for the variables, Tiles, boardsize, shipamount, and shipsplaced to be saved to an 
	 * object file of choice filename.
	 * 
	 * @param filename - Sets the name of the file to save the board variables to
	 */
	public void savegame(String filename) {
		try {
			//Save the board 
			ObjectOutputStream savefile = new ObjectOutputStream(
					new FileOutputStream(filename+".obj"));
			savefile.writeObject(Tiles);
			savefile.writeObject(boardsize);
			savefile.writeObject(shipamount);
			savefile.writeObject(shipsplaced);
			savefile.close();
		}
		catch(Exception e){
			System.out.println("There was a problem saving the game.");
			e.printStackTrace();
		}
		
	}
	/**
	 * This method reads in from an object file, and asssigns specific pre-saved values for the variables
	 * Tiles,boardsize,shipamount, and shipsplaced. This allows for the game to be loaded up from a saved
	 * file.
	 * 
	 * 
	 * @param infile - the file to be read from in order to assign values to each of the variables in
	 * a board object
	 */
	public void loadgame(String infile) {
		try {
			ObjectInputStream loadfile = new ObjectInputStream(
					new FileInputStream(infile+".obj"));
			this.Tiles=(int[][])loadfile.readObject();
			this.boardsize=(int)loadfile.readObject();
			this.shipamount =(int)loadfile.readObject();
			this.shipsplaced =(boolean)loadfile.readObject();
			loadfile.close();
		}
		catch(Exception e){
			System.out.println("There was an issue in loading your file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method gets the Tiles variable (the 2D array that represents the board)
	 * 
	 * @return Tiles - returns the 2D array that represents the board
	 */
	public int[][] getTiles() {
		return Tiles;
	}
	
	/**
	 * This method sets the Tiles variable in a board, setting the 2D array that represents the board
	 * 
	 * @param tiles - takes in a new 2D array variable, to replace Tiles.
	 */
	public void setTiles(int[][] tiles) {
		Tiles = tiles;
	}
	
	/**
	 * This method gets the size of the board of the object.
	 * 
	 * @return boardsize - the size of the board
	 */
	public int getboardsize() {
		return boardsize;
	}
	
	/**
	 * This method checks if a space on the board's 2D array, Tiles, is filled or not
	 * 
	 * @param a - x parameter
	 * @param b - y parameter
	 * @return - returns true if the space is occupied, returns false if the space is empty, or already
	 * 			attacked and missed
	 */
	public boolean occupado(int a, int b) {
		if (Tiles[a][b]==0 || Tiles[a][b] == 3) {
			return false;
		}
		else
			return true;
	}

}
