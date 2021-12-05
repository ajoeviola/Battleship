package application;
import java.io.*;
public class Board implements Serializable{

	/**
	 * variables: Tiles[][] (2d array to represent the board)
	 */
	private int Tiles[][];
	private int boardsize;
	public int shipamount;
	/**
	 * Our default constructor
	 * 
	 * This function will declare our 2d board with a nested loop 
	 * Each loop will fill the board with 0's. 0 means there is no ship there,
	 * so it is an empty board initially
	 */
	
	//Tharindu's only contribution
	public Board(int size) {
		Tiles = new int[size][size];
		boardsize=size;
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				Tiles[i][j]=0;
			}
		}
	}

	public void savegame(String filename) {
		try {
			//Save the board 
			ObjectOutputStream savefile = new ObjectOutputStream(
					new FileOutputStream(filename+".obj"));
			savefile.writeObject(Tiles);
			savefile.writeObject(boardsize);
			savefile.writeObject(shipamount);
			savefile.close();
		}
		catch(Exception e){
			System.out.println("There was a problem saving the game.");
			e.printStackTrace();
		}
		
	}
	public void loadgame(String infile) {
		try {
			ObjectInputStream loadfile = new ObjectInputStream(
					new FileInputStream(infile+".obj"));
			this.Tiles=(int[][])loadfile.readObject();
			this.boardsize=(int)loadfile.readObject();
			this.shipamount =(int)loadfile.readObject();
			loadfile.close();
		}
		catch(Exception e){
			System.out.println("There was an issue in loading your file.");
			e.printStackTrace();
			
		}
	}
	
	//Getters and setters for Tiles[][]
	public int[][] getTiles() {
		return Tiles;
	}

	public void setTiles(int[][] tiles) {
		Tiles = tiles;
	}
	public int getboardsize() {
		return boardsize;
	}
	public boolean occupado(int a, int b) {
		if (Tiles[a][b]==0 || Tiles[a][b] == 3) {
			return false;
		}
		else
			return true;
	}

}
