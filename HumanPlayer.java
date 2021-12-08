package application;
import java.util.*;
import javafx.scene.Node;

public class HumanPlayer extends Player {
	public Board theboard;
	
	/**
	 * This is the default empty constructor, just to create a HumanPlayer object
	 * 
	 */
	public HumanPlayer() {
	}
	
	/**
	 * This method allows the user to attack the enemy board
	 * 
	 * @param theboard - the enemy board to be attacked
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
	 * This method was used during testing to set a preset board placement, so we could see how well the
	 * CPU attack function worked
	 * 
	 * @param theboard - the board to be initialized
	 */
	public void autoboardplace(Board theboard) {
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
}
