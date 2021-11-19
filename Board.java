
public class Board {

	/**
	 * variables: Tiles[][] (2d array to represent the board)
	 */
	private int[][] Tiles;

  /**
  * Default Constructor
  */
	Board(int[][] boardsize){
		Tiles=boardsize;
	}
	/**
	 * 
	 * @return Tiles- the tiles of the board
	 */
	public int[][] getTiles() {
		return Tiles;
	}
	
	//Getters and setters for Tiles[][]
	public int[][] getTiles() {
		return Tiles;
	}

	public void setTiles(int[][] tiles) {
		Tiles = tiles;
	}

  
}
