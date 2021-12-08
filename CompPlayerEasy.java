package application;
import java.util.*;
public class CompPlayerEasy extends Player {
	public Board theboard; 
	
	/**
	 * This is an empty constructor, just for creating a CompPlayerEasy object
	 */
	public CompPlayerEasy(){
	}
	
	/**
	 * This method takes in a Board object, and assigns it to the CompPlayerEasy variable
	 * theboard
	 * 
	 * @param insert - the board to replace theboard variable
	 */
	public void takeboard(Board insert) {
		theboard = insert;
	}
	
	/**
	 * This method "attacks" a certain point on an enemy board, and changes the enemy board's variables 
	 * if the attack hits a "ship" point, or hits an empty spot
	 * 
	 * @param theboard - the enemy board to be attacked on
	 * @param sp1 - x variable
	 * @param sp2 - y variable
	 */
	public void attack(Board theboard,int sp1, int sp2) {
		if (theboard.occupado(sp1, sp2)==true) {
			theboard.getTiles()[sp1][sp2]=2;
		}
		else if (theboard.occupado(sp1,sp2)==false) {
			theboard.getTiles()[sp1][sp2]=3;
		}
	}
	
	/**
	 * This method sets up a pre-set board, which we used for testing to check and see if
	 * the attack functions, and visual updates, worked properly.
	 */
	public void autoboardplace() {
		for (int i=0;i<4;i++) {
			theboard.getTiles()[i][0]=1;
			theboard.getTiles()[i][1]=1;
		}
		for (int i=0;i<5;i++) {
			theboard.getTiles()[i][3]=1;
		}
		for (int i=2;i<4;i++) {
			theboard.getTiles()[i][5]=1;
		}
		for (int i=0;i<5;i++) {
			theboard.getTiles()[5][i]=1;
		}
		for (int i=1;i<3;i++) {
			theboard.getTiles()[6][i]=1;
		}
	}
	
	/**
	 * This method allows the CPU to randomly place "ship" blocks across the board
	 * 
	 * @param BOARD_SIZE - takes in the size of the board, so that it can choose any point from it
	 * @param SHIP_AMOUNT - takes in the amount of ships it has, to be able to place only that amount on the board
	 */
	public void boardplace(int BOARD_SIZE,int SHIP_AMOUNT) {
		Random rand = new Random();
		boolean isplaced = false;
		
		for (int i = 0; i <SHIP_AMOUNT; i++) {
			
			int x = rand.nextInt(BOARD_SIZE);
			int y = rand.nextInt(BOARD_SIZE);
			
			if (theboard.getTiles()[x][y] != 1) {
				theboard.getTiles()[x][y] = 1;
			}else {
				i--;
			}
			
			isplaced = false;
			
	}
	}
}