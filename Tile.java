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
	
	//Create a tile which represents each spot on the board
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
	public void changecolor(Color option) {
		border.setFill(option);
		mycolor = option;
	}
}
