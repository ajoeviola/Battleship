package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.ObservableList;
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
import javafx.scene.Node;
import javafx.scene.input.MouseButton;

public class Main extends Application {
	
	public void endgame() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	//Universally used variables
	final int BOARD_SIZE = 10;//Setting the size of the board
	Board playerboard = new Board(BOARD_SIZE);
	Board computerboard = new Board(BOARD_SIZE);
	Board dummyboard = new Board(BOARD_SIZE);
	int playerscore = 0;
	int compscore = 0;
	int playerships = 0;
	int cpuships = 16;
	int AMOUNT_SHIPS=16;
	
	
	@Override
	public void start(Stage primaryStage) {
		GridPane finalcut = new GridPane();
		
		//Initializing the boards nested loop
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				playerboard.getTiles()[row][col]=0;
				computerboard.getTiles()[row][col]=0;
				dummyboard.getTiles()[row][col]=0;
			}
		}
		
		CompPlayerEasy CPU = new CompPlayerEasy();
		CPU.takeboard(computerboard);
		CPU.boardplace();
		
		HumanPlayer theplayer = new HumanPlayer();
		
		
		//Setting up visual representations of the 2D arrays
		GridPane playergrid = new GridPane();
		GridPane compgrid = new GridPane();
		//Initializing the player board visual
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				//Create Tile variable to put on the board
				Tile tile = new Tile(50,50,"");
				
				//Checking 2D array, to see if a ship is placed//destroyed or not
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
				playergrid.add(tile, col, row);//Add the tile to the specified space
				
				//Setup ship placement phase
				tile.setOnMouseClicked(e->{
					//Check if left click to place
					if (playerships < 16) {
						if (e.getButton()==MouseButton.PRIMARY) {
							Node n = (Node)e.getSource();
							Integer r1 = playergrid.getRowIndex(n);
							Integer c1 = playergrid.getColumnIndex(n);
							playerboard.getTiles()[r1][c1]=1;
							Tile mypoint = (Tile)n;
							
							//Check if the ship was already placed
							if (mypoint.mycolor == Color.CADETBLUE) {
								mypoint.changecolor(Color.LIGHTGREEN);
								playerships++;
							}
						}
						//Check if right click to remove
						else if(e.getButton()==MouseButton.SECONDARY) {
							Node n = (Node)e.getSource();
							Integer r1 = playergrid.getRowIndex(n);
							Integer c1 = playergrid.getColumnIndex(n);
							playerboard.getTiles()[r1][c1]=0;
							Tile mypoint = (Tile)n;
							
							//Check if the ship was not placed
							if (mypoint.mycolor == Color.LIGHTGREEN) {
								mypoint.changecolor(Color.CADETBLUE);
								playerships--;
							}
						}
					}
					
					
				});
				
			
			}
		}
		
		//Nested loop to initialize visual of computer board
		//Values to label the Computer Board for player attacks
		char value = 'A';
		char colchar = '0';
		for (int row=0;row<BOARD_SIZE;row++) {
			for (int col=0;col<BOARD_SIZE;col++) {
				//String variable to label tiles
				String colstring=""+value+colchar;
				//Tiles to spread across the board
				Tile tile = new Tile(50,50,colstring);
		
				//Checking 2D array, to see if a ship is placed//destroyed or not
				if (computerboard.getTiles()[row][col]==0) {
					tile.changecolor(Color.CADETBLUE);
				}
				else if(computerboard.getTiles()[row][col]==2) {
					tile.changecolor(Color.RED);
				}
				else if(computerboard.getTiles()[row][col]==3) {
					tile.changecolor(Color.GREY);
				}
				//Add tile to specified location on board
				compgrid.add(tile, col, row);
				//Move to next column
				colchar++;
				
				tile.setOnMouseClicked(e->{
					//Check if left click to attack
						if (e.getButton()==MouseButton.PRIMARY) {
							Node n = (Node)e.getSource();
							Integer r1 = compgrid.getRowIndex(n);
							Integer c1 = compgrid.getColumnIndex(n);
							
							//Player attacks, Tile is set to the node at the point
							theplayer.attack(computerboard,r1,c1);
							Tile mypoint = (Tile)n;
							
							//Updates ships color
							if (computerboard.getTiles()[r1][c1]==0) {
								tile.changecolor(Color.CADETBLUE);
							}
							else if(computerboard.getTiles()[r1][c1]==1) {
								tile.changecolor(Color.LIGHTGREEN);
							}
							else if(computerboard.getTiles()[r1][c1]==2) {
								if (tile.mycolor != Color.RED || tile.mycolor != Color.RED) {
									tile.changecolor(Color.RED);
									cpuships--;
								}
								
							}
							else if(computerboard.getTiles()[r1][c1]==3) {
								tile.changecolor(Color.GREY);
							}
							
							//Choose a random index for the CPU to attack
							Random rand = new Random();
							
							int x = rand.nextInt(10);
							int y = rand.nextInt(10);
							
							//Get our tile by placing all the tiles into a list
							ObservableList<Node> tiles = playergrid.getChildren();
							Node temp = null;
							
							CPU.attack(playerboard,x,y);
							
							//Retrieve the node at the correct placement 
							for (Node node : tiles) {
						        if(playergrid.getRowIndex(node) == x && playergrid.getColumnIndex(node) == y) {
						            temp = node;
						            break;
						        }
						    }
							//convert the node to a tile 
							Tile attackedtile = (Tile)temp;
							
							//Update the colors
							if (playerboard.getTiles()[x][y]==0) {
								attackedtile.changecolor(Color.CADETBLUE);
							}
							else if(playerboard.getTiles()[x][y]==1) {
								attackedtile.changecolor(Color.LIGHTGREEN);
							}
							else if(playerboard.getTiles()[x][y]==2) {
								if (attackedtile.mycolor != Color.RED || tile.mycolor != Color.GREY) {
									attackedtile.changecolor(Color.RED);
									playerships--;
								}
								
							}
							else if(playerboard.getTiles()[x][y]==3) {
								attackedtile.changecolor(Color.GREY);
							}
						}
						
						//Check if either player has a ship left
						if (cpuships == 0 || playerships == 0) {
							endgame();
						}
					
				});
			}
			//Move to next row
			value++;
			//Reset columns
			colchar='0';
			
			
		}
		//Board Labels
		Text playeramtships = new Text("Ship Blocks: "+playerships);
		Text playersboard = new Text("Player's Board");
		Text computersboard = new Text("Computer's Board");
		playersboard.setFont(new Font("Courier New",40));
		computersboard.setFont(new Font("Courier New",40));
		HBox boardlabels = new HBox(300);
		HBox amtships = new HBox(300);
		amtships.getChildren().addAll(playeramtships);
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
		finalcut.add(playerinput,0,0);
		finalcut.add(boardgame, 1, 0);
		finalcut.add(boardlabels, 1, 1);
		finalcut.add(amtships, 1, 2);
		//Trying to set up input with textfields + input button
		
		inputanswers.setOnMouseClicked(e->{
			String letinput = letterinsert.getText();
			String numinput = numberinsert.getText();
			//Text useranswer = new Text ("Your input:"+letinput+numinput);
			//finalcut.add(useranswer,1,3);
			int let = Integer.parseInt(letinput);
			int num = Integer.parseInt(numinput);
			
			theplayer.attack(computerboard, let, num);
			
			if (computerboard.getTiles()[let][num]==0) {
				//tile.changecolor(Color.CADETBLUE);
				
			}
			else if(computerboard.getTiles()[let][num]==1) {
				//tile.changecolor(Color.LIGHTGREEN);
			}
			else if(computerboard.getTiles()[let][num]==2) {
				//tile.changecolor(Color.RED);
			}
			else if(computerboard.getTiles()[let][num]==3) {
				//tile.changecolor(Color.GREY);
			}
		});
		
		//Showing the scene
		Scene primaryscene = new Scene(finalcut,1400,800);
		primaryStage.setTitle("Chimp Battleship");
		primaryStage.setScene(primaryscene);
		primaryStage.show();
	}
}
