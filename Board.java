package application;

public class Board {

	/**
	 * variables: Tiles[][] (2d array to represent the board)
	 */
	int Tiles[][];
	
	
	/**
	 * Our default constructor
	 * 
	 * This function will declare our 2d board with a nested loop 
	 * Each loop will fill the board with 0's. 0 means there is no ship there,
	 * so it is an empty board initially
	 */
	public Board() {}

	
	//Getters and setters for Tiles[][]
	public int[][] getTiles() {
		return Tiles;
	}

	public void setTiles(int[][] tiles) {
		Tiles = tiles;
	}
	

}

package application;

public class Board {
    int Tiles[][];

    public Board() {
        Tiles = new int[10][10];
        
        for(int i = 0;i<Tiles.length;i++){
            
            for(int j = 0;j<Tiles[i].length;j++){
            
                Tiles[i][j] = 0;
            }
        }
        
    }

    public int[][] getTiles() {
        return Tiles;
    }

    public void setTiles(int[][] tiles) {
        Tiles = tiles;
    }
}
