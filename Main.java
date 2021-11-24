package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		//Prompt player for rules and difficulty 

		

		//Initialize player's board and cpu's board
		
		
		
		//prompt player to place ships on their board, and call function to auto-place CPU ships 
		
		
		
		//boolean to check if game is over
		boolean gamestate = true;
		
		
		//begin game! start a while loop that loops again and again until one player has all their ships sunk
		while(gamestate) {
			//Display the boards 
			
			
			
			//Player attacks
			
			
			
			//Check if cpu has any ships remaining, if all ships are sunk, update gamestate to false and break the loop
			
			
			
			//update the boards
			
			
			//CPU attacks
			
			
			
			//update the boards
			
			
			
			//Check if player has any ships remaining, if all ships are sunk, update gamestate to false and break the loop
			
			
			
			//save the gamestate in our database
			
			
			
		}
	}
}
