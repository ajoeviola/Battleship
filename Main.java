package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
			//Constants for the scene width and height, and text
			final double SCENE_WIDTH = 1000.0;
			final double SCENE_HEIGHT = 1000.0;
			final double X = 225.0, Y = 450.0;
			final double FONT_SIZE = 38;
			
			
			//Prompt player for rules and difficulty with a new scene
			Text starttext = new Text(X,Y,"Welcome! Press Any Key to Start!");
			starttext.setFont(new Font("ComicSans", FONT_SIZE));
			Pane startpane = new Pane(starttext);

			Scene start = new Scene(startpane, SCENE_WIDTH,SCENE_HEIGHT);
			
			
			/*
			 * When we continue, display two buttons, one for each difficulty
			 */
			start.setOnKeyPressed(event -> {
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
			primaryStage.show();
			
			
			
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
