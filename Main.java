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
	//int playerboard.shipamount = 0;
	//int computerboard.shipamount = 16;
	int AMOUNT_SHIPS=16;
	
	
	@Override
	public void start(Stage primaryStage) {
		GridPane finalcut = new GridPane();
		
		
		//Setup to start new game or continue last game
		Text instructions = new Text("You will start with 16 blocks to place on your board.\n"
				+ "Once you've placed your blocks, you may begin to attack\nyour oponent.");
		instructions.setFont(new Font("Courier New",40));
		Text instructions1 = new Text("Red=Hit");
		instructions1.setFont(new Font("Courier New",40));
		instructions1.setFill(Color.RED);
		Text instructions2 = new Text("Grey=Miss");
		instructions2.setFont(new Font("Courier New",40));
		instructions2.setFill(Color.GREY);
		
		Text wantcontinue = new Text("Would you like to load the previous session?");
		wantcontinue.setFont(new Font("Courier New",40));
		TextField yesorno = new TextField();
		Button tocontinue = new Button("Yes");
		tocontinue.setFont(new Font("Courier New",40));
		Button tonewgame = new Button("No");
		tonewgame.setFont(new Font("Courier New",40));
		HBox continuebuttons = new HBox();
		continuebuttons.getChildren().addAll(tocontinue,tonewgame);
		VBox continueoptions = new VBox();
		continueoptions.getChildren().addAll(instructions,instructions1,instructions2,wantcontinue,continuebuttons);
		
		//finalcut.add(wantcontinue, 0, 0);
		finalcut.add(continueoptions, 0, 0);
		//finalcut.add(tonewgame, 1, 1);
		
		tocontinue.setOnMouseClicked(e->{
			finalcut.getChildren().remove(continueoptions);
			playerboard.loadgame("playerboard_savefile");
			computerboard.loadgame("computerboard_savefile");
			//int playerboard.shipamount = playerboard.shipamount;
			//int computerboard.shipamount = computerboard.shipamount;
			CompPlayerEasy CPU = new CompPlayerEasy();
			CPU.takeboard(computerboard);
			CPU.boardplace(BOARD_SIZE);
			
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
					tile.setOnMouseClicked(el->{
						//Check if left click to place
						if (playerboard.shipamount < 16) {
							if (e.getButton()==MouseButton.PRIMARY) {
								Node n = (Node)el.getSource();
								Integer r1 = playergrid.getRowIndex(n);
								Integer c1 = playergrid.getColumnIndex(n);
								playerboard.getTiles()[r1][c1]=1;
								Tile mypoint = (Tile)n;
								
								//Check if the ship was already placed
								if (mypoint.mycolor == Color.CADETBLUE) {
									mypoint.changecolor(Color.LIGHTGREEN);
									playerboard.shipamount++;
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
									playerboard.shipamount--;
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
					String colstring="";//+value+colchar;
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
					
					
					tile.setOnMouseClicked(en->{
						//Player attack cycle starts
						//Check if left click to attack
							if (e.getButton()==MouseButton.PRIMARY) {
								Node n = (Node)en.getSource();
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
										computerboard.shipamount--;
									}
									
								}
								else if(computerboard.getTiles()[r1][c1]==3) {
									tile.changecolor(Color.GREY);
								}
								//Player attack cycle ends
								
								
								//CPU attack cycle starts
								
								//Choose a random index for the CPU to attack
								Random rand = new Random();
								
								int x = rand.nextInt(BOARD_SIZE);
								int y = rand.nextInt(BOARD_SIZE);
								
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
										playerboard.shipamount--;
									}
									
								}
								else if(playerboard.getTiles()[x][y]==3) {
									attackedtile.changecolor(Color.GREY);
								}
							}
							//End CPU attack cycle
							
							//add save functionality
							Button gamesaver = new Button ("Save and Exit?");
							finalcut.add(gamesaver, 1, 3);
							gamesaver.setOnMouseClicked(ef->{
								playerboard.savegame("playerboard_savefile");
								computerboard.savegame("computerboard_savefile");
								System.exit(0);
							});
							
							//Check if either player has a ship left
							if (computerboard.shipamount == 0 || playerboard.shipamount == 0) {
								finalcut.getChildren().clear();
								if (playerboard.shipamount==0) {
									Text losstext = new Text("You Lose,\nSorry!");
									losstext.setFont(new Font("Courier New",150));
									losstext.setFill(Color.RED);
									finalcut.getChildren().addAll(losstext);
								}
								else if (computerboard.shipamount==0) {
									Text wintext = new Text("Hey!\nYou won!");
									wintext.setFont(new Font("Courier New",150));
									wintext.setFill(Color.GREEN);
									finalcut.getChildren().addAll(wintext);
								}
								else {
									Text uhtext = new Text("Uh...that's weird,\nsomething broke somewhere...\nweird.");
									uhtext.setFont(new Font("Courier New",150));
									uhtext.setFill(Color.DARKSLATEGREY);
									finalcut.getChildren().addAll(uhtext);
									
								}
								//endgame();
							}
						
					});
				}
				//Move to next row
				value++;
				//Reset columns
				colchar='0';
				
				
			}
			//Board Labels
			Text playeramtships = new Text("Ship Blocks: "+playerboard.shipamount);
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
			
			//Final Gridpane holding EVERYTHING
			finalcut.add(boardgame, 1, 0);
			finalcut.add(boardlabels, 1, 1);
			finalcut.add(amtships, 1, 2);
		});
		tonewgame.setOnMouseClicked(e->{
			finalcut.getChildren().remove(continueoptions);
			playerboard.shipamount=0;
			computerboard.shipamount=16;
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
			CPU.boardplace(BOARD_SIZE);
			
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
					tile.setOnMouseClicked(el->{
						//Check if left click to place
						if (playerboard.shipamount < 16) {
							if (e.getButton()==MouseButton.PRIMARY) {
								Node n = (Node)el.getSource();
								Integer r1 = playergrid.getRowIndex(n);
								Integer c1 = playergrid.getColumnIndex(n);
								playerboard.getTiles()[r1][c1]=1;
								Tile mypoint = (Tile)n;
								
								//Check if the ship was already placed
								if (mypoint.mycolor == Color.CADETBLUE) {
									mypoint.changecolor(Color.LIGHTGREEN);
									playerboard.shipamount++;
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
									playerboard.shipamount--;
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
					String colstring="";//+value+colchar;
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
					
					
					tile.setOnMouseClicked(en->{
						//Player attack cycle starts
						//Check if left click to attack
							if (e.getButton()==MouseButton.PRIMARY) {
								Node n = (Node)en.getSource();
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
										computerboard.shipamount--;
									}
									
								}
								else if(computerboard.getTiles()[r1][c1]==3) {
									tile.changecolor(Color.GREY);
								}
								//Player attack cycle ends
								
								
								//CPU attack cycle starts
								
								//Choose a random index for the CPU to attack
								Random rand = new Random();
								
								int x = rand.nextInt(BOARD_SIZE);
								int y = rand.nextInt(BOARD_SIZE);
								
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
										playerboard.shipamount--;
									}
									
								}
								else if(playerboard.getTiles()[x][y]==3) {
									attackedtile.changecolor(Color.GREY);
								}
							}
							//End CPU attack cycle
							
							//add save functionality
							Button gamesaver = new Button ("Save and Exit?");
							finalcut.add(gamesaver, 1, 3);
							gamesaver.setOnMouseClicked(ef->{
								playerboard.savegame("playerboard_savefile");
								computerboard.savegame("computerboard_savefile");
								System.exit(0);
							});
							
							//Check if either player has a ship left
							if (computerboard.shipamount == 0 || playerboard.shipamount == 0) {
								finalcut.getChildren().clear();
								if (playerboard.shipamount==0) {
									Text losstext = new Text("You Lose,\nSorry!");
									losstext.setFont(new Font("Courier New",150));
									losstext.setFill(Color.RED);
									finalcut.getChildren().addAll(losstext);
								}
								else if (computerboard.shipamount==0) {
									Text wintext = new Text("Hey!\nYou won!");
									wintext.setFont(new Font("Courier New",150));
									wintext.setFill(Color.GREEN);
									finalcut.getChildren().addAll(wintext);
								}
								else {
									Text uhtext = new Text("Uh...that's weird,\nsomething broke somewhere...\nweird.");
									uhtext.setFont(new Font("Courier New",150));
									uhtext.setFill(Color.DARKSLATEGREY);
									finalcut.getChildren().addAll(uhtext);
									
								}
								//endgame();
							}
						
					});
				}
				//Move to next row
				value++;
				//Reset columns
				colchar='0';
				
				
			}
			//Board Labels
			Text playeramtships = new Text("Ship Blocks: "+playerboard.shipamount);
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
			
			//Final Gridpane holding EVERYTHING
			finalcut.add(boardgame, 1, 0);
			finalcut.add(boardlabels, 1, 1);
			finalcut.add(amtships, 1, 2);
		});
		
		
		
		//Trying to set up input with textfields + input button
		
	
		//Showing the scene
		Scene primaryscene = new Scene(finalcut,1600,800);
		primaryStage.setTitle("Chimp Battleship");
		primaryStage.setScene(primaryscene);
		primaryStage.show();
	}
}
