
public class Board {

	/**
	 * variables: Tiles[][] (2d array to represent the board)
	 */
	private int[][] Tiles;
	//getters and setters (again, build in way of creating this!)***
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
	/**
	 * 
	 * @param tiles - the tiles to be added to the board
	 */
	public void setTiles(int[][] tiles) {
		Tiles = tiles;
	}
	
}
