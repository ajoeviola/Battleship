package application;

public class Board {

	/**
	 * variables: Tiles[][] (2d array to represent the board)
	 */
	private int Tiles[][];
	private int boardsize;
	/**
	 * Our default constructor
	 * 
	 * This function will declare our 2d board with a nested loop 
	 * Each loop will fill the board with 0's. 0 means there is no ship there,
	 * so it is an empty board initially
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
		if (Tiles[a][b]==0) {
			return false;
		}
		else
			return true;
	}

}
