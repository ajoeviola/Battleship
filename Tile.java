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
	
	//Create a tile which represents each spot on the board
	public Tile(int r, int c, String cell) {
		//create a border for each tile
		Rectangle border = new Rectangle(60,60);
		border.setFill(Color.CADETBLUE);
		border.setStroke(Color.BLACK);
		
		row = r;
		column = c;
		
		Text cellname = new Text(cell);
		cellname.setFont(new Font("ComicSans",40));
		
		getChildren().addAll(border,cellname);
	}
}
