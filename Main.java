package application;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
			//Constants for the scene width and height, and text
			final double SCENE_WIDTH = 1000.0;
			final double SCENE_HEIGHT = 1000.0;
			
			char value = 'A';
			List<Tile> tiles = new ArrayList<>();
			for (int i = 0; i < 8; i++) {
				tiles.add(new Tile(i,0,value + "1"));
				tiles.add(new Tile(i,1,value + "2"));
				tiles.add(new Tile(i,2,value + "3"));
				tiles.add(new Tile(i,3,value + "4"));
				tiles.add(new Tile(i,4,value + "5"));
				tiles.add(new Tile(i,5,value + "6"));
				tiles.add(new Tile(i,6,value + "7"));
				tiles.add(new Tile(i,7,value + "8"));
				value++;
			}
			
			
			
			Pane root = new Pane();
			root.setPrefSize(SCENE_WIDTH,SCENE_HEIGHT);
			
			
			for (int i = 0; i < 64; i++) {
				Tile tile = tiles.get(i);
				tile.setTranslateX(60 * (i % 8));
				tile.setTranslateY(60 * (i / 8));
				root.getChildren().add(tile);
				
			}
			
			
			GridPane root2 = new GridPane();
			
			TextField alphabetinsert = new TextField();
	        TextField numberinsert = new TextField();
	        Button inputanswers = new Button("Input");
	        
	        VBox input = new VBox();
	        input.getChildren().addAll(alphabetinsert,numberinsert, inputanswers);
	        
	        
			
			root2.setAlignment(Pos.CENTER);
			root2.add(root,1,1);
			root2.add(input,0,1);
			
			Scene displaygame = new Scene(root2,SCENE_WIDTH,SCENE_HEIGHT);
			
			primaryStage.setScene(displaygame);
			primaryStage.show();
			
			//Prompt player for rules and difficulty with a new scene
			/*Text starttext = new Text(X,Y,"Welcome! Press Any Key to Start!");
			starttext.setFont(new Font("ComicSans", FONT_SIZE));
			Pane startpane = new Pane(starttext);

			Scene start = new Scene(startpane, SCENE_WIDTH,SCENE_HEIGHT);*/
			
			
			/*
			 * When we continue, display two buttons, one for each difficulty
			 */
				/*start.setOnKeyPressed(event -> {
				Text difficultytext = new Text(100,100,"Select your difficulty");
				difficultytext.setFont(new Font("ComicSans", FONT_SIZE));
				Button easy = new Button("Easy Difficulty");
				Button hard = new Button("Hard Difficulty");
				easy.setStyle("-fx-font-size: 2em; ");
				hard.setStyle("-fx-font-size: 2em; ");
				
				easy.setOnAction(value -> {
					RuleSetEasy Rules = new RuleSetEasy();
					
				});
				
				hard.setOnAction(value -> {
					RuleSetHard Rules = new RuleSetHard();
				});
				
				HBox difficultybox = new HBox(difficultytext,easy, hard);
				Scene difficulty = new Scene(difficultybox, SCENE_WIDTH,SCENE_HEIGHT);
				
				
				primaryStage.setScene(difficulty);
				primaryStage.show();
			});
			primaryStage.setScene(start);
			primaryStage.show();*/
			
			
			
				//Initialize player's board and cpu's board
		
				//prompt player to place ships on their board, and call function to auto-place CPU ships 
				
				
				
				//boolean to check if game is over
				boolean gamestate = true;
				
				
				//begin game! start a while loop that loops again and again until one player has all their ships sunk
				//while(gamestate) {
					//Display the boards 
					
					
					
					//Player attacks
					
					
					
					//Check if cpu has any ships remaining, if all ships are sunk, update gamestate to false and break the loop
					
					
					
					//update the boards
					
					
					//CPU attacks
					
					
					
					//update the boards
					
					
					
					//Check if player has any ships remaining, if all ships are sunk, update gamestate to false and break the loop
					
					
					
					//save the gamestate in our database
	//}
	}
}
