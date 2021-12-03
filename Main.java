package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	final int BOARD_SIZE = 10;
	Board playerboard = new Board(BOARD_SIZE);
	Board computerboard = new Board(BOARD_SIZE);
	Board dummyboard = new Board(BOARD_SIZE);
	@Override
	public void start(Stage primaryStage) {
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				playerboard.getTiles()[row][col]=0;
				computerboard.getTiles()[row][col]=0;
				dummyboard.getTiles()[row][col]=0;
			}
		}
		GridPane playergrid = new GridPane();
		GridPane compgrid = new GridPane();
		char value = 'A';
		char colchar = '0';
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				String colstring=""+value+colchar;
				Tile tile = new Tile(50,50,"");
				if (playerboard.getTiles()[row][col]==0) {
					tile.changecolor(Color.CADETBLUE);
				}
				else if(playerboard.getTiles()[row][col]==1) {
					tile.changecolor(Color.LIGHTGREEN);
				}
				else if(playerboard.getTiles()[row][col]==2) {
					tile.changecolor(Color.RED);
				}
				else if(playerboard.getTiles()[row][col]==3) {
					tile.changecolor(Color.GREY);
				}
				playergrid.add(tile, col, row);
				colchar++;
			}
			value++;
			colchar='0';
		}
		value = 'A';
		colchar='0';
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				String colstring=""+value+colchar;
				Tile tile = new Tile(50,50,colstring);
				if (computerboard.getTiles()[row][col]==0) {
					tile.changecolor(Color.CADETBLUE);
				}
				else if(computerboard.getTiles()[row][col]==1) {
					tile.changecolor(Color.LIGHTGREEN);
				}
				else if(computerboard.getTiles()[row][col]==2) {
					tile.changecolor(Color.RED);
				}
				else if(computerboard.getTiles()[row][col]==3) {
					tile.changecolor(Color.GREY);
				}
				compgrid.add(tile, col, row);
				colchar++;
			}
			value++;
			colchar='0';
		}
		//Board Labels
		Text playersboard = new Text("Player's Board");
		Text computersboard = new Text("Computer's Board");
		playersboard.setFont(new Font("Courier New",40));
		computersboard.setFont(new Font("Courier New",40));
		HBox boardlabels = new HBox(300);
		boardlabels.getChildren().addAll(playersboard,computersboard);
		
		//Actual Boards
		HBox boardgame = new HBox(30);
		boardgame.getChildren().addAll(playergrid,compgrid);
		
		//Player Attack input
		Text numinsert = new Text("Number");
		Text letinsert = new Text ("Letter");
		letinsert.setFont(new Font("Courier New",20));
		numinsert.setFont(new Font("Courier New",20));
		TextField numberinsert = new TextField();
		TextField letterinsert = new TextField();
		Button inputanswers = new Button("Input");
		VBox playerinput = new VBox();
		playerinput.getChildren().addAll(letinsert,letterinsert,numinsert,numberinsert,inputanswers);
		
		//Final Gridpane holding EVERYTHING
		GridPane finalcut = new GridPane();
		finalcut.add(playerinput,0,0);
		finalcut.add(boardgame, 1, 0);
		finalcut.add(boardlabels, 1, 1);
		
		//Showing the scene
		Scene primaryscene = new Scene(finalcut,1400,800);
		primaryStage.setTitle("Chimp Battleship");
		primaryStage.setScene(primaryscene);
		primaryStage.show();
	}
	private void consoleboard() {
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				System.out.print(playerboard.getTiles()[row][col]);
			}
			System.out.print("\n");
		}
	}
}
