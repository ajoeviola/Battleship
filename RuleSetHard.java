package application;

public class RuleSetHard implements Rules {
	private int BOARD_SIZE=13;
	private int SHIP_AMOUNT=10;
	
	/**
	 * This is an empty basic constructor just for creation of an empty RuleSetEasy object
	 */
	public RuleSetHard() {};
	
	
	@Override
	/**
	 * This method sets up the size of the board that the game will take place on
	 * 
	 * @param bOARD_SIZE - the size of the board to replace BOARD_SIZE variable
	 */
	public void setBoardSize(int bOARD_SIZE) {
		BOARD_SIZE = bOARD_SIZE;
	}

	/**
	 * This method gets the size of the board that the game will take place on
	 *  
	 * @return BOARD_SIZE - The size of the board that the game takes place on
	 */
	public int getBOARD_SIZE() {
		return BOARD_SIZE;
	}
	
	/**
	 * This method returns the amount of ships to be used in gameplay
	 * 
	 * @return SHIP_AMOUNT - The amount of ships to be used in gameplay.
	 */
	public int getSHIP_AMOUNT() {
		return SHIP_AMOUNT;
	}
	
	/**
	 * This method sets the amount of ships to be used in gameplay
	 *  
	 * @param sHIP_AMOUNT - the amount that will replace the SHIP_AMOUNT variable
	 */
	public void setSHIP_AMOUNT(int sHIP_AMOUNT) {
		SHIP_AMOUNT = sHIP_AMOUNT;
	}
	
}
