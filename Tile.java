package application;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
	public int row,column;
	public Board board;
	public String cell;
	public Rectangle border = new Rectangle(60,60);
	public Color mycolor;
	
	/**
	 * This is the constructor, which creates a Tile object, which is a representation
	 * of a Rectangle, with a possible string to be displayed overtop of it. This functionality
	 * was removed later on, but originally allowed for the labeling of each tile on the
	 * enemy board (i.e. A1,A2,A3....H10 etc)
	 * 
	 * @param r - the row of the tile
	 * @param c - the column of the tile
	 * @param cell - the string to be displayed overtop the rectangle of the Tile
	 */
	public Tile(int r, int c, String cell) {
		//create a border for each tile
		border.setFill(Color.CADETBLUE);
		mycolor = Color.CADETBLUE;
		border.setStroke(Color.BLACK);
		
		row = r;
		column = c;
		
		Text cellname = new Text(cell);
		cellname.setFont(new Font("Courier New",40));
		
		getChildren().addAll(border,cellname);
	}
	
	/**
	 * This method allows for the changing of the color of the tile, which lets us display to the user
	 * if a tile contains a ship on their board, or if a tile has been hit
	 * 
	 * @param option - the color that will replace the default color of the board
	 */
	public void changecolor(Color option) {
		border.setFill(option);
		mycolor = option;
	}
}
